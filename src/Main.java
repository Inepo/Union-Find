public class Main {
    public static void main(String[] args) {


        UnionFind u = new UnionFind(11);

        System.out.println(u.toString());

        /*int r = u.find(0);
        System.out.println(r);*/

        u.union(3, 10);
        System.out.println(u.toString());
        System.out.println();
        u.union(7,3);
        System.out.println(u.toString());
        System.out.println();
        u.union(4,7);
        System.out.println(u.toString());
        System.out.println();
        u.union(2,5);
        System.out.println(u.toString());
        System.out.println();
        u.union(10,4);
        System.out.println(u.toString());
        System.out.println();
        u.union(1,2);
        System.out.println(u.toString());
        System.out.println();

        System.out.println(u.find(2));
        System.out.println(u.find(10));
        System.out.println(u.find(3));
        System.out.println(u.find(8));

        u.addPeople();
        u.addPeople();
        u.addPeople();
        u.addPeople();
        u.addPeople();

        System.out.println(u.find(12));

        u.union(10,12);
        System.out.println(u.toString());
        System.out.println();
        u.union(5,12);
        System.out.println(u.toString());
        System.out.println();
        u.union(12,14);
        System.out.println(u.toString());
        System.out.println();

        System.out.println(u.find(2));

        u.isolated(12);
        System.out.println(u.toString());








        /*u.union(1,3);

        int t = u.find(3);
        System.out.println(t);

        System.out.println(u.toString());

        u.addPeople();
        u.addPeople();

        System.out.println(u.toString());*/

    }
}