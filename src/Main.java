import java.util.Random;

public class Main {
    public static void main(String[] args) {
/*

        final int MIN = 2_000_000, MAX = 10_000_000, PAS = 2_000_000;
        final int MIN1 = 200_000, MAX1 = 1_000_000, PAS1 = 200_000;


        Random r = new Random();
        Random r2 = new Random();
        for (int n = MIN; n <= MAX; n += PAS) {
            UnionFind u = new UnionFind(n);

            int j;


            System.out.println("Pour une taille " + n + " : ");
            //Methode Union
            for (int i = MIN1; i <= MAX1; i += PAS1) {
                long tempsUnion = 0;
                for (j = 0; j < i; j++) {
                    int hab1 = r.nextInt(n);
                    int hab2 = r.nextInt(n);
                    long deb = System.nanoTime();
                    u.union(hab1, hab2);
                    long fin = System.nanoTime();
                    tempsUnion += (fin - deb);

                }

                System.out.println(i + " Union \t" + (tempsUnion) / 1e6 + " ");
            }

            //Methode Find
            for (int i = MIN1; i <= MAX1; i += PAS1) {
                long tempsFind = 0;

                for (j = 0; j < i; j++) {
                    int hab1 = r.nextInt(n);
                    int hab2 = r.nextInt(n);
                    long deb = System.nanoTime();
                    u.find(hab1, hab2);
                    long fin = System.nanoTime();
                    tempsFind += (fin - deb);
                }

                System.out.println(i + " Find \t" + (tempsFind) / 1e6 + " ");
            }

            //Methode Addpeople
            for (int i = MIN1; i <= MAX1; i += PAS1) {
                long tempsAddpeople = 0;
                for (j = 0; j < i; j++) {
                    int hab1 = r.nextInt(n);
                    int hab2 = r.nextInt(n);
                    long deb = System.nanoTime();
                    u.addPeople(hab1, hab2);
                    long fin = System.nanoTime();
                    tempsAddpeople += (fin - deb);
                }

                System.out.println(i + " Addpeople \t" + (tempsAddpeople) / 1e6 + " ");
            }

        }

        // methode isolate

        final int MINI = 100_000, MAXI = 500_000, PASI = 100_000;
        final int MINIS = 1_000, MAXIS = 5_000, PASIS = 1_000;
        for (int n = MINI; n <= MAXI; n += PASI) {
            long tempsIsolate = 0;
            UnionFind u = new UnionFind(n);
            for (int i = MINIS; i <= MAXIS; i += PASIS) {

                for (int j = 0; j < i; j++) {
                    int hab = r.nextInt(n);
                    long start = System.nanoTime();
                    u.isolated(hab);
                    long end = System.nanoTime();
                    tempsIsolate += (end - start);
                }

                System.out.println(i + " Isolate \t" + (tempsIsolate) / 1e6 + "ms");
            }
        }

*/
        /*********************** DEBUT TEST MEMOIRE OPTIMISE ***********************/

        final int MIN = 2_000_000, MAX = 10_000_000, PAS = 2_000_000;

        final int MINREP = 200_000, MAXREP = 1_000_000, PASREP = 200_000;



        Random r = new Random();
        int j = 0;

        for (int n = MIN; n <= MAX; n += PAS) {
            Observer ob = new Observer();
            UnionFind u = new UnionFind(n, ob);
            System.out.println("Pour une taille " + n + " : nombre de variable déclaré  : taille max de la pile d'appels ");



            // Test de la méthode union -> Unir des habitants
            for (int i = MINREP; i <= MAXREP; i += PASREP) {
                for (j = 0; j < i; j++) {
                    int hab1 = r.nextInt(n);
                    int hab2 = r.nextInt(n);
                    u.union(hab1, hab2);
                }
                System.out.println(i + " union \t" + ob + " ");
            }

            ob = new Observer();
            u = new UnionFind(n, ob);

            // Test de la méthode find -> Trouver le représentant
            for (int i = MINREP; i <= MAXREP; i += PASREP) {
                for (j = 0; j < i; j++) {
                    int habfind = r.nextInt(n);
                    u.find(habfind);
                }
                System.out.println(i + " find\t" + ob + " ");
            }

            ob = new Observer();
            u = new UnionFind(n, ob);

            // Test de la méthode addPeople -> Ajout d'habitant
            for (int i = MINREP; i <= MAXREP; i += PASREP) {
                for (j = 0; j < i; j++) {
                    u.addPeople();
                }
                System.out.println(i + " addpeople\t" + ob + " ");
            }


        }

        final int MINI = 100_000, MAXI = 500_000, PASI = 100_000;

        final int MINIS = 1_000, MAXIS = 5_000, PASIS = 1_000;

        for (int n = MINI; n <= MAXI; n += PASI) {
            Observer ob = new Observer();
            UnionFind u = new UnionFind(n, ob);
            System.out.println("Pour une taille " + n + " : nombre de variable déclaré  : taille max de la pile d'appels ");

            // Test de la méthode isolated -> isolé des habitants
            for (int i = MINIS; i <= MAXIS; i += PASIS) {
                for (j = 0; j < i; j++) {
                    int hab = r.nextInt(n);
                    u.isolated(hab);
                }
                System.out.println(i + " isolate \t" + ob + " ");
            }
        }
        /*********************** FIN TEST MEMOIRE OPTIMISE ***********************/











        /*
        //Test compléxité moyenne en temps de la méthode find
        final int MIN = 1_000_000, MAX = 10_000_000, PAS = 1_000_000;

        Random r = new Random();
        Random r2 = new Random();
        for (int n = MIN; n <= MAX; n += PAS) {
            UnionFind u = new UnionFind(n);
            long temps = 0;
            //int NB = 100;
            int NB = r2.nextInt(n) + 1;
            for (int i = 0; i < NB; i++) {
                int hab1 = r.nextInt(n);
                int hab2 = r.nextInt(n);
                u.union(hab1, hab2);

            }
            for (int i = 0; i < NB; i++) {
                long deb = System.nanoTime();
                u.find(r.nextInt(n));
                long fin = System.nanoTime();
                temps += (fin - deb);
            }
            System.out.println(n + "\t" + ((temps / NB)) / 1e6);


        }*/

        /*
        //Test compléxité moyenne en mémoire de la méthode find
        final int MIN = 1_000_000, MAX = 10_000_000, PAS = 1_000_000;

        Random r = new Random();
        Random r2 = new Random();
        for (int n = MIN; n <= MAX; n += PAS) {
             int NB = r2.nextInt(n) + 1;
            Observer ob = new Observer(NB);
            UnionFind u = new UnionFind(n, ob);
            long temps = 0;
            //int NB = 100;
            for (int i = 0; i < NB; i++) {
                int hab1 = r.nextInt(n);
                int hab2 = r.nextInt(n);
                u.union(hab1, hab2);

            }
            for (int i = 0; i < NB; i++) {
                u.find(r.nextInt(n));
            }
            System.out.println(n + "\t" + ob);


        }
         
        /*
        //Test compléxité moyenne en temps de la méthode Union
        final int MIN = 2_000_000, MAX = 10_000_000, PAS = 2_000_000;
        final int MIN1 = 200_000, MAX1 = 1_000_000, PAS1 = 200_000;

        Random r = new Random();
        for (int n = MIN; n <= MAX; n += PAS) {
            UnionFind u = new UnionFind(n);
            long temps = 0;
            System.out.println("Pour une taille " + n + " : ");
            int j;
            for( int i = MIN1; i <= MAX1; i+=PAS1){
                for(j = 0; j<i; j++){
                    int hab = r.nextInt(n);
                    int hab2 = r.nextInt(n);
                    u.union(hab,hab2);
                }
                for(j = 0; j<i; j++){
                    long deb = System.nanoTime();
                    u.addPeople();
                    long fin = System.nanoTime();
                    temps += (fin - deb);
                }
                if(j < i-1)
                    System.out.print(i + "\t" + (temps)/1e6 + " ");
                else
                    System.out.println(i + "\t" + (temps)/1e6 + " ");
            }
          }
        */
            }
        }