#include <stdio.h>
#include <stdlib.h>

#include "net/emcute.h"
#include "mqtt-lib.h"

#define NODE_NAME	"control"
#define NODE_IP		"fec0:affe::97"
#define MQTT_BROKER_IP	"fec0:affe::1"

static unsigned flags = EMCUTE_QOS_0; //bez potvrde primitka
static emcute_topic_t t; //elementi: const char *name; uint16_t id;
char *topic_pub = "control/temp";

static void on_pub (const emcute_topic_t *topic, void *data, size_t len)
{
	//dobiva se kazaljka na podatke
	//posiljatelj i primatelj moraju znati format tih podataka
 	int *in = (int *) data;
	int out = *in * 10, rc;
	int mod = 0;

	printf ("dobivena poruka za pretplatu '%s': %d\n", topic->name, (int) topic->id);

	if (len != 4) {
		printf ("error: primljena kriva duljina podataka\n");
		return;
	}

	printf("Primljena jacina vjetra je %d cvorova\n", *in);
	
	if(*in > 40){
		mod = 1;
	}

	switch(mod){
		case 0:
			printf("Nije potrebna nikakva akcija\n");
			break;
		case 1:
			printf("Potrebno aktivirati kocnice\n");
			break;
	}

	
	rc = emcute_pub (&t, &out, sizeof(out), flags);
	if (rc != EMCUTE_OK) {
		printf ("error: greska prilikom objave na temu: %s\n", topic_pub);
	}


}

int main (void)
{
	emcute_sub_t subscription;
	char *topic_sub = "sensor/temp";
	int rc;

	rc = mqtt_init (NODE_NAME, NODE_IP, MQTT_BROKER_IP);
	if (rc != 0) {
		printf ("error: greska prilikom inicijalizacije programa\n");
		return rc;
	}

	t.name = topic_pub;
	rc = emcute_reg (&t); //dodjela id-a za zadano ime - od brokera
	if (rc != EMCUTE_OK) {
		printf ("error: greska prilikom dohvacanja topic ID-a");
		return 1;
	}

	subscription.topic.name = topic_sub; //na koji sadrzaj se pretplacuje
	subscription.cb = on_pub; //koju funkciju pozvati po primitku poruke
	rc = emcute_sub (&subscription, flags);
	if (rc != EMCUTE_OK) {
		printf ("error: greska prilikom pretplate na temu: %s\n", topic_sub);
		return 1;
	}

	while (1) {
		pause();
	}

	return 0;
}
