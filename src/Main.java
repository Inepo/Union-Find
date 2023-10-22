import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {


        /*UnionFind u = new UnionFind(11);

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
        System.out.println();

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

        System.out.println(u.toString());*/

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
        //Test compléxité moyenne en temps de la méthode Union
        final int MIN = 1_000_000, MAX = 10_000_000, PAS = 1_000_000;

        Random r = new Random();
        Random r2 = new Random();
        for (int n = MIN; n <= MAX; n += PAS) {
            UnionFind u = new UnionFind(n);
            long temps = 0;
            //int NB = 100;
            int NB = r2.nextInt(n) + 1;
            for( int i = 0; i < NB; i++){
                int hab1 = r.nextInt(n);
                int hab2 = r.nextInt(n);
                long deb = System.nanoTime();
                u.union(hab1,hab2);
                long fin = System.nanoTime();
                temps += (fin - deb);
            }


            System.out.println(n + "\t" + ((temps/NB))/1e6);
          }*/


        /*//Test compléxité moyenne en mémoire de la méthode Union
        final int MIN = 1_000_000, MAX = 10_000_000, PAS = 1_000_000;

        Random r = new Random();
        Random r2 = new Random();
        for (int n = MIN; n <= MAX; n += PAS) {
            long temps = 0;
            //int NB = 100;
            int NB = r2.nextInt(n) + 1;
            Observer ob = new Observer(NB);
            UnionFind u = new UnionFind(n, ob);
            for( int i = 0; i < NB; i++){
                int hab1 = r.nextInt(n);
                int hab2 = r.nextInt(n);
                long deb = System.nanoTime();
                u.union(hab1,hab2);
                long fin = System.nanoTime();
                temps += (fin - deb);
            }


            System.out.println(n + "\t" + ob);
        }*/

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
    }
}