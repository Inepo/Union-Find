public class Main {
    public static void main(String[] args) {

        UnionFind u = new UnionFind(4);
        int r = u.find(3);
        System.out.println(r);

        u.union(2,3);
        u.union(1,3);


        int t = u.find(3);
        System.out.println(t);
        u.addPeople();
        u.addPeople();
        u.isolated(2);

        for(int i =0 ; i < 5; ++i ){
            System.out.println(u.amis[i]);
        }
    }
}