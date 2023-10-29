import java.util.ArrayList;

public class UnionFind {

    private ArrayList<Integer> amis;
    private int nbHabitant;

    private static Observer o;

    public UnionFind(int nbH, Observer ob){
        this.nbHabitant = nbH;
        this.amis = new ArrayList<>(this.nbHabitant);
        for(int i = 0; i < this.nbHabitant; ++i){
            this.amis.add(i);
        }
        o = ob;
    }

    public UnionFind(int nbH){
        this.nbHabitant = nbH;
        this.amis = new ArrayList<>(this.nbHabitant);
        for(int i = 0; i < this.nbHabitant; ++i){
            this.amis.add(i);
        }
        o = null;
    }

    public int find (int habitant) {
       o.enter();
       o.incOp();
        int r = habitant;
        while (this.amis.get(r) != r) {
            r = this.amis.get(r);
        }
        o.incOp();
        int a = habitant;
        o.incOp();
        int tmp;
        while (this.amis.get(a) != a) {
            tmp = a;
            a = this.amis.get(tmp);
            this.amis.set(tmp, r);
        }
       o.exit();
        return r;

    }

    public void union (int habitant1, int habitant2){
        o.enter();
        o.incOp();
        int rep1 = this.find(habitant1);
        o.incOp();
        int rep2 = this.find(habitant2);
            if(rep1 < rep2) this.amis.set(habitant2, rep1);
        o.exit();
    }

    public void addPeople() {
        o.enter();
        o.incOp();
        ++this.nbHabitant;
        if (this.nbHabitant > this.amis.size()) {
            this.amis.ensureCapacity(this.nbHabitant);
        }
        o.incOp();
        this.amis.add(nbHabitant - 1);
        o.exit();
    }


    public void isolated(int habitant) {
        o.enter();
        o.incOp();

        int representant = find(habitant);
        o.incOp();
        if (representant == habitant) {
            boolean foundAnotherRepresentant = false;
            o.incOp();

            for (int i = 0; i < this.nbHabitant; ++i) {
                int friend = this.amis.get(i);
                o.incOp();
                if (friend == habitant && i != habitant) {
                    if (!foundAnotherRepresentant) {
                        representant = i;
                        o.incOp();
                        foundAnotherRepresentant = true;
                        o.incOp();
                    }
                    this.amis.set(i, representant);
                    o.incOp();
                }
            }

        }

        for (int i = 0; i < this.nbHabitant; ++i) {
            if (this.amis.get(i) == habitant && i != habitant) {
                this.amis.set(i, representant);
                o.incOp();
            }
        }

        if (this.amis.get(habitant) != habitant) {
            this.amis.set(habitant, habitant);
            o.incOp();
        }
        o.exit();
    }
    public String toString (){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i = 0; i < this.nbHabitant; ++i){
            if(i != this.nbHabitant - 1) sb.append(this.amis.get(i)+", ");
            else sb.append(this.amis.get(i));
        }
        sb.append("]");
        return sb.toString();
    }

}
