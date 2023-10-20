import java.util.Random;

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

        /*final int MIN = 1_000_000, MAX = 50_000_000, PAS = 1_000_000;

        Random r = new Random();
        Random random = new Random();
        for (int n = MIN; n <= MAX; n += PAS) {
            //System.out.print(n + "\t");
            UnionFind u = new UnionFind(n);
            int randomNumber = random.nextInt(n) + 1;
            long deb = System.nanoTime();
            for( int i = 0; i < randomNumber; i++){
                int hab1 = r.nextInt(n);
                int hab2 = r.nextInt(n);
                u.union(hab1,hab2);
            }
            long fin = System.nanoTime();

            System.out.println(n + "\t" + ((fin - deb) / 1e6));
        }*/

        /*final int MIN = 10_000_000, MAX = 50_000_000, PAS = 1_000_000;
        //final int MIN = 100, MAX = 1000, PAS = 100;

        Random r = new Random();
        Random r2 = new Random();
        for (int n = MIN; n <= MAX; n += PAS) {
            //System.out.print(n + "\t");
            UnionFind u = new UnionFind(n);

            long deb = System.nanoTime();
            for( int i = 0; i < r2.nextInt(n); i++){
                int hab1 = r.nextInt(n);
                int hab2 = r.nextInt(n);
                //System.out.println(hab1 +hab2);
                u.union(hab1,hab2);
            }
            long fin = System.nanoTime();
            System.out.println(n + "\t" + (fin - deb) / 1e6);
            //System.out.println(u.toString());
            //break;
        }*/



    }
}