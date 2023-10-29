import java.util.Random;

public class Main {
    public static void main(String[] args) {
        /*********************** DEBUT TEST TEMPS ***********************/
        final int MIN = 2_000_000, MAX = 10_000_000, PAS = 2_000_000;
        final int MINREPTEMPS = 200_000, MAXREPTEMPS = 1_000_000, PASREPTEMPS = 200_000;


        Random r = new Random();
        int j;
        int n;
        int i;
        for (n = MIN; n <= MAX; n += PAS) {
            UnionFind u = new UnionFind(n);
            System.out.println("Pour une taille " + n + " : ");

            //Mesure de la méthode Union -> Unir des habitants
            for (i = MINREPTEMPS; i <= MAXREPTEMPS; i += PASREPTEMPS) {
                long tempsUnion = 0;
                for (j = 0; j < i; j++) {
                    int hab1 = r.nextInt(n);
                    int hab2 = r.nextInt(n);
                    long deb = System.nanoTime();
                    u.union(hab1, hab2);
                    long fin = System.nanoTime();
                    tempsUnion += (fin - deb);
                }
                System.out.println(i + " Union \t" + (tempsUnion) / 1e6 + "ms");
            }

            //Mesure de la méthode Find -> Trouver le représentant
            for (i = MINREPTEMPS; i <= MAXREPTEMPS; i += PASREPTEMPS) {
                long tempsFind = 0;
                for (j = 0; j < i; j++) {
                    int hab1 = r.nextInt(n);
                    long deb = System.nanoTime();
                    u.find(hab1);
                    long fin = System.nanoTime();
                    tempsFind += (fin - deb);
                }
                System.out.println(i + " Find \t" + (tempsFind) / 1e6 + "ms");
            }

            //Mesure de la méthode AddPeople -> Ajout d'habitant
            for (i = MINREPTEMPS; i <= MAXREPTEMPS; i += PASREPTEMPS) {
                long tempsAddpeople = 0;
                for (j = 0; j < i; j++) {
                    long deb = System.nanoTime();
                    u.addPeople();
                    long fin = System.nanoTime();
                    tempsAddpeople += (fin - deb);
                }
                System.out.println(i + " Addpeople \t" + (tempsAddpeople) / 1e6 + "ms");
            }
        }

        //Mesure de la méthode Isolated -> isolé des habitants
        final int MINISO = 100_000, MAXISO = 500_000, PASISO = 100_000;
        final int MINREPISO= 1_000, MAXREPISO = 5_000, PASREPISO = 1_000;
        for (n = MINISO; n <= MAXISO; n += PASISO) {
            long tempsIsolate = 0;
            UnionFind u = new UnionFind(n);
            System.out.println("Pour une taille " + n + " : ");
            for (i = MINREPISO; i <= MAXREPISO; i += PASREPISO) {
                for (j = 0; j < i; j++) {
                    int hab = r.nextInt(n);
                    long start = System.nanoTime();
                    u.isolated(hab);
                    long end = System.nanoTime();
                    tempsIsolate += (end - start);
                }
                System.out.println(i + " Isolate \t" + (tempsIsolate) / 1e6 + "ms");
            }
        }
        /*********************** FIN TEST TEMPS ***********************/


        /*********************** DEBUT TEST MEMOIRE ***********************/
        final int MINMEMORY = 100_000, MAXMEMORY = 500_000, PASMEMORY = 100_000;
        final int MINREP = 1_000, MAXREP = 5_000, PASREP = 1_000;

        for (n = MINMEMORY; n <= MAXMEMORY; n += PASMEMORY) {
            UnionFindOB u = new UnionFindOB(n);
            System.out.println("Pour une taille " + n + " : nombre de variable déclaré  : taille max de la pile d'appels ");

            // Test de la méthode union -> Unir des habitants
            for (i = MINREP; i <= MAXREP; i += PASREP) {
                for (j = 0; j < i; j++) {
                    int hab1 = r.nextInt(n);
                    int hab2 = r.nextInt(n);
                    u.union(hab1, hab2);
                }
                System.out.println(i + " union \t" + u + " ");
            }

            u = new UnionFindOB(n);

            // Test de la méthode find -> Trouver le représentant
            for (i = MINREP; i <= MAXREP; i += PASREP) {
                for (j = 0; j < i; j++) {
                    int habfind = r.nextInt(n);
                    u.find(habfind);
                }
                System.out.println(i + " find\t" + u + " ");
            }

            u = new UnionFindOB(n);

            // Test de la méthode addPeople -> Ajout d'habitant
            for (i = MINREP; i <= MAXREP; i += PASREP) {
                for (j = 0; j < i; j++) {
                    u.addPeople();
                }
                System.out.println(i + " addpeople\t" + u + " ");
            }

            u = new UnionFindOB(n);

            // Test de la méthode isolated -> isolé des habitants
            for (i = MINREP; i <= MAXREP; i += PASREP) {
                for (j = 0; j < i; j++) {
                    int hab = r.nextInt(n);
                    u.isolated(hab);
                }
                System.out.println(i + " isolate \t" + u + " ");
            }
        }
        /*********************** FIN TEST MEMOIRE ***********************/
    }
}