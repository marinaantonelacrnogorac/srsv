#include <stdio.h>
#include <stdlib.h>

#include "net/emcute.h"
#include "mqtt-lib.h"

#include <time.h>

#define NODE_NAME	"publisher"
#define NODE_IP		"fec0:affe::99"
#define MQTT_BROKER_IP	"fec0:affe::1"

int main (void)
{
	unsigned flags = EMCUTE_QOS_0; //bez potvrde primitka
	emcute_topic_t t; //elementi: const char *name; uint16_t id;
	char *topic = "sensor/temp";
	int rc;
	int brzina_vjetra;

	srand(time(NULL));

	rc = mqtt_init (NODE_NAME, NODE_IP, MQTT_BROKER_IP);
	if (rc != 0) {
		printf ("error: greska prilikom inicijalizacije programa\n");
		return rc;
	}

	t.name = topic;
	rc = emcute_reg (&t); //dodjela id-a za zadano ime - od brokera
	if (rc != EMCUTE_OK) {
		printf ("error: greska prilikom dohvacanja topic ID-a");
		return 1;
	}

	while (1) {
		brzina_vjetra = rand() % 71;
		printf("Brzina vjetra je %d cvorova.\n", brzina_vjetra);
		rc = emcute_pub (&t, &brzina_vjetra, sizeof(brzina_vjetra), flags);
		if (rc != EMCUTE_OK) {
			printf ("error: greska prilikom objave na temu: %s\n", topic);
		}
		sleep(500);
		
	}

	return 0;
}
