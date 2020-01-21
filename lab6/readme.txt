Sustav koristi:

    jednog brokera
    jedan čvor koji samo šalje podatke
    jedan čvor koji samo prima podatke (preko pretplate brokeru)
    jedan čvor koji i prima i šalje podatke (šalje po potrebi, nakon "obrade" primljenih.

Ideja je da sustav mjeri jacinu vjetra, i ako je brzina veca od 40 cvorova, tj. ako puse jak olujan vjetar, sustav aktivira kocnice u vjetrenjaci.

Publisher: Simulacija senzora koji mjeri jacinu vjetra.
Subscriber: Prima izmjerenu velicinu, prikazuje ju, te, od contolera dobiva informaciju da li ce aktivirati kocnice ili ne.
Control: Prima izmjerenu velicinu, prikazuje ju, te odlucuje da li ce se kocnice aktivirati, i tu odluku salje subscriberu.
