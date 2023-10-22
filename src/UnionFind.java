import java.util.ArrayList;
import java.util.List;

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
       /* o.enter();
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
        return r;*/

        o.enter();
        o.incOp();
        int r = habitant;
        o.incOp();
        int tmp;
        while (this.amis.get(r) != r){
            tmp = r;
            r = this.amis.get(r);
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

    public void addPeople(){
        ++this.nbHabitant;
        this.amis.add(nbHabitant - 1);
    }

    public void isolated(int habitant) {
        int representant = this.find(habitant);

        if(this.amis.get(habitant) != habitant) this.amis.set(habitant, habitant);

        for (int i = 0; i < this.nbHabitant; ++i) {
            if (this.amis.get(i) == habitant && i != habitant) {
                this.amis.set(i, representant);
            }
        }
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
