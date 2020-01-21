#include <stdio.h>
#include <stdlib.h>

#include "net/emcute.h"
#include "mqtt-lib.h"

#define NODE_NAME	"subscriber"
#define NODE_IP		"fec0:affe::98"
#define MQTT_BROKER_IP	"fec0:affe::1"

static void on_pub (const emcute_topic_t *topic, void *data, size_t len)
{
	//dobiva se kazaljka na podatke
	//posiljatelj i primatelj moraju znati format tih podataka
 	int *in = (int *) data;

	printf ("dobivena poruka za pretplatu '%s': %d\n",
		topic->name, (int) topic->id);

	if (len != 4) {
		printf ("error: primljena kriva duljina podataka\n");
		return;
	}

	printf ("Trenutna jacina vjetra je %d cvorova\n", *in);
}


static void on_pub2 (const emcute_topic_t *topic, void *data, size_t len)
{
	//dobiva se kazaljka na podatke
	//posiljatelj i primatelj moraju znati format tih podataka
 	int *in = (int *) data;

	printf ("dobivena poruka za pretplatu '%s': %d\n",
		topic->name, (int) topic->id);

	if (len != 4) {
		printf ("error: primljena kriva duljina podataka\n");
		return;
	}

	switch(*in){
		case 0:
			printf("Ne radim nista.\n");
			break;
		case 1:
			printf("Aktiviram kocnice.\n");
			break;
	}
}

int main (void)
{
	unsigned int flags = EMCUTE_QOS_0; //bez potvrde primitka
	emcute_sub_t sub_sensor, sub_control;
	char *topic_sensor = "sensor/temp";
	char *topic_control = "control/temp";
	int rc;

	rc = mqtt_init (NODE_NAME, NODE_IP, MQTT_BROKER_IP);
	if (rc != 0) {
		printf ("error: greska prilikom inicijalizacije programa\n");
		return rc;
	}

	sub_sensor.topic.name = topic_sensor; //na koji sadrzaj se pretplacuje
	sub_sensor.cb = on_pub; //koju funkciju pozvati po primitku poruke
	rc = emcute_sub (&sub_sensor, flags);
	if (rc != EMCUTE_OK) {
		printf ("error: greska prilikom pretplate na temu: %s\n", topic_sensor);
		return 1;
	}

	sub_control.topic.name = topic_control; //na koji sadrzaj se pretplacuje
	sub_control.cb = on_pub2; //koju funkciju pozvati po primitku poruke
	rc = emcute_sub (&sub_control, flags);
	if (rc != EMCUTE_OK) {
		printf ("error: greska prilikom pretplate na temu: %s\n", topic_control);
		return 1;
	}

	// Radno cekanje, s obzirom da se sav posao odvija u on_pub funkciji
	while (1) {
		//sleep(100);
		pause();
	}

	return 0;
}
