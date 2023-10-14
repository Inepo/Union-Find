public class Main {
    public static void main(String[] args) {

        UnionFind u = new UnionFind(4);
        int r = u.find(3);
        System.out.println(r);

        u.union(2,3);
        u.union(1,3);

        int t = u.find(1);

        u.addPeople();
        u.addPeople();
        u.addPeople();
        u.union(3,5);
    }
}