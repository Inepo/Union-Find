import java.util.Random;

public class Main {
    public static void main(String[] args) {

        /*
        UnionFind u = new UnionFind(11);

        System.out.println(u.toString());

        int r = u.find(0);
        System.out.println(r);

        u.union(3, 10);
        u.union(7,3);
        u.union(4,7);
        u.union(2,5);
        u.union(10,4);
        u.union(1,2);
        System.out.println(u.toString());


        System.out.println("Le représentant de 2 est : " + u.find(2));
        System.out.println("Le représentant de 10 est : " + u.find(10));
        System.out.println("Le représentant de 3 est : " +u.find(3));
        System.out.println("Le représentant de 8 est : " +u.find(8));

        u.addPeople();
        u.addPeople();
        u.addPeople();
        u.addPeople();
        u.addPeople();

        System.out.println(u.find(12));

        u.union(10,12);
        u.union(5,12);
        u.union(12,14);

        System.out.println(u.toString());

        u.isolated(3);
        System.out.println(u.toString());

        HashMap<String, String> k = new HashMap<>();

        /*UnionFind v = new UnionFind(6);
        System.out.println(v.toString());

        v.union(3,5);
        v.union(1,3);
        v.union(0,1);

        System.out.println(v.toString());

        v.find(5);

        System.out.println(v.toString());*/

        /*u.union(1,3);

        int t = u.find(3);
        System.out.println(t);

        System.out.println(u.toString());

        u.addPeople();
        u.addPeople();

        System.out.println(u.toString());*/

/*


        ///Test compléxité moyenne en temps de la méthode Union
        final int MIN = 10_000_000, MAX = 50_000_000, PAS = 10_000_000;
        final int MIN1 = 200_000, MAX1 = 1_000_000, PAS1 = 200_000;


        Random r = new Random();
        Random r2 = new Random();
        for (int n = MIN; n <= MAX; n += PAS) {
            UnionFind u = new UnionFind(n);
            long tempsUnion = 0;
            long tempsFind =0;
            //int NB = 100;
            int NB = r2.nextInt(n) + 1;
            System.out.println("Pour une taille " + n + " : ");
            int j = 0;
            for( int i = MIN1; i <= MAX1; i+=PAS1){
                for(j = 0; j<i; j++){
                    int hab1 = r.nextInt(n);
                    int hab2 = r.nextInt(n);
                    long deb = System.nanoTime();
                    u.union(hab1,hab2);
                    long fin = System.nanoTime();
                    tempsUnion += (fin - deb);

                    //MESURER FIND
                    int hab3 =  r.nextInt(n);
                    long start = System.nanoTime();
                    u.find(hab3);
                    long end = System.nanoTime();
                    tempsFind += (end - start);
                }
                /*if(j < i-1)
                    System.out.print(i + " Union \t" + (tempsUnion)/1e6 + " ");
                else
                    System.out.println(i + " Union \t" + (tempsUnion)/1e6 + " ");


                if(j < i-1)
                    System.out.print(i + " find \t" + (tempsFind)/1e6 + " ");
                else
                    System.out.println(i + " find \t" + (tempsFind)/1e6 + " ");
            }
          }*/

        /*********************** DEBUT TEST MEMOIRE OPTIMISE ***********************/
        final int MIN = 100_000, MAX = 500_000, PAS = 100_000;
        final int MINREP = 1_000, MAXREP = 5_000, PASREP = 1_000;

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

            ob = new Observer();
            u = new UnionFind(n, ob);

            // Test de la méthode isolated -> isolé des habitants
            for (int i = MINREP; i <= MAXREP; i += PASREP) {
                for (j = 0; j < i; j++) {
                    int hab = r.nextInt(n);
                    u.isolated(hab);
                }
                System.out.println(i + " isolate \t" + ob+ " ");
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