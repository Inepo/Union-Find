import java.util.ArrayList;
import java.util.List;

public class UnionFind {

    private ArrayList<Integer> amis;
    private int nbHabitant;

    public UnionFind(int nbH){
        this.nbHabitant = nbH;
        this.amis = new ArrayList<>(this.nbHabitant);
        for(int i = 0; i < this.nbHabitant; ++i){
            this.amis.add(i);
        }
    }
    public void verifhabitant(int habitant){
        if (habitant < 0 || habitant >= amis.size()) {
            throw new IllegalArgumentException("L'habitant n° " + habitant + " n'a pas été trouvé");
        }
    }

    public int find (int habitant) {
        int r = habitant;
        verifhabitant(habitant);
        while (this.amis.get(r) != r) {
            r = this.amis.get(r);
        }
        int a = habitant;
        int tmp;
        while (this.amis.get(a) != a) {
            tmp = a;
            a = this.amis.get(tmp);
            this.amis.set(tmp, r);
        }
        return r;
    }

    public void union (int habitant1, int habitant2){
        verifhabitant(habitant1);
        verifhabitant(habitant2);
        int rep1 = this.find(habitant1);
        int rep2 = this.find(habitant2);
        if(rep1 != rep2){
            if(rep1 < rep2) this.amis.set(habitant2, rep1);
            else this.amis.set(habitant1, rep2);
        }
    }

    public void addPeople(){
        ++this.nbHabitant;
        this.amis.add(nbHabitant - 1);
    }

    public void isolated(int habitant) {
        verifhabitant(habitant);
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
