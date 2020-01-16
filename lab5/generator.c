  
#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <sys/mman.h>
#include <sys/wait.h>
#include <mqueue.h>
#include <fcntl.h>

struct key_shared {
	pthread_mutex_t m;
	int id;
};

struct shared {
	int id;
	int broj;
	int zadatci[30];
};


#define SK_NAME  "/SRSV_LAB5"  /* created in /dev/shm/ */
#define SM_SIZE  sizeof (struct shared)
#define SK_SIZE  sizeof (struct key_shared)


#define NAZIV_REDA	"/MSGQ_LAB5"
#define MAX_PORUKA_U_REDU 10
#define MAX_VELICINA_PORUKE 14



int main ( int argc,char *argv[] )
{
	int id, tmp, i, j, br_poslova, trajanje, r, policy;
	struct shared *x;
	struct key_shared *key;
	mqd_t opisnik_reda;		//tip za red poruka
	struct mq_attr attr;	//opis reda poruka
	char *msg_ptr;
	size_t msg_len;
	unsigned msg_prio = 10;
	struct sched_param prio;
	
	policy = SCHED_RR;
	
	prio.sched_priority = 50;

	if ( pthread_setschedparam ( pthread_self(), policy,  &prio ) ) {
		perror ( "Error: pthread_setschedparam (root permission?)" );
		exit (1);
	}
	
	if(argc == 3){
		br_poslova = atoi(argv[1]);
		trajanje = atoi(argv[2]);
	}
	else{
		printf("Missing arguments!\n");
		return 0;
	}

	
	//stvaranje objekta zajdednickog spremnika
	id = shm_open ( SK_NAME, O_CREAT | O_RDWR, 00600 );
	if ( id == -1 || ftruncate ( id, SK_SIZE ) == -1) {
		perror ( "shm_open/ftruncate" );
		exit(1);
	}
	key = mmap ( NULL, SK_SIZE, PROT_READ | PROT_WRITE, MAP_SHARED, id, 0 );
	if ( key == (void *) -1) {
		perror ( "mmap" );
		exit(1);
	}
	close ( id );

	//zakljucavanje zajednickog  spreminka
	pthread_mutex_lock(&key->m);
	key->id += br_poslova;
	//otljucavanje
	pthread_mutex_unlock(&key->m);
	
	attr.mq_flags = 0;
	attr.mq_maxmsg = MAX_PORUKA_U_REDU;
	attr.mq_msgsize = MAX_VELICINA_PORUKE;
	
	srand(time(NULL));
	
	for(i = (key->id - br_poslova); i < key->id; i++){
		msg_ptr = (char *) malloc(MAX_VELICINA_PORUKE * sizeof(char));
		sprintf(msg_ptr, "/SRSV_LAB5-%d", i);
		
		id = shm_open (msg_ptr , O_CREAT | O_RDWR, 00600 );
		if ( id == -1 || ftruncate ( id, SM_SIZE ) == -1) {
			perror ( "shm_open/ftruncate" );
			exit(1);
		}
		x = mmap ( NULL, SM_SIZE, PROT_READ | PROT_WRITE, MAP_SHARED, id, 0 );
		if ( x == (void *) -1) {
			perror ( "mmap" );
			exit(1);
		}
		close ( id );
		
		r = rand() % trajanje;
		r++;
		
		x->id = i;
		x->broj = r;
		
		for(j = 0; j < r; j++){
			x->zadatci[j] = rand() % 1000 + 1;
		}
		
		opisnik_reda = mq_open ( NAZIV_REDA, O_WRONLY | O_CREAT, 00600, &attr );
		if ( opisnik_reda == (mqd_t) -1 ) {
			perror ( "producer:mq_open" );
			return -1;
		}
		if ( mq_send ( opisnik_reda, msg_ptr, MAX_VELICINA_PORUKE, msg_prio ) ) {
			perror ( "mq_send" );
			return -1;
		}
		
		printf ( "G: posao %d %d %s [ ", i, r, msg_ptr );
		for(j = 0; j < r; j++){
			printf( "%d ", x->zadatci[j] );
		}
		printf( "]\n" );
		
		sleep(1);
	}
}
