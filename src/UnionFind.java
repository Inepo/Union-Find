import java.util.ArrayList;

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

    public int find (int habitant) {
        int r = habitant;
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
        int rep1 = this.find(habitant1);
        int rep2 = this.find(habitant2);
        //Condition pour afecter l'habitant le plus petit facilitant pour la suite les possible find
        if(rep1 < rep2) this.amis.set(habitant2, rep1);
    }

    public void addPeople() {
        ++this.nbHabitant;
        if (this.nbHabitant > this.amis.size()) {
            //Garantit une certaine taille à la liste, modifie sa capacité interne
            // afin de pouvoir ajouter un grand nombre sans crash
            this.amis.ensureCapacity(this.nbHabitant);
        }
        this.amis.add(nbHabitant - 1);
    }


    //Isole un habitant
    public void isolated(int habitant) {
        int representant = find(habitant);
        int i;
        boolean foundAnotherRepresentant = false;

        for (i = 0; i < this.nbHabitant; ++i) {
            int friend = this.amis.get(i);

            //Désigne un nouveau représentant au groupe d'amis
            if (friend == habitant && i != habitant) {
                if (!foundAnotherRepresentant) {
                    representant = i;
                    foundAnotherRepresentant = true;
                }
            }

            //Affecte le nouveau représentant dans le groupe d'amis
            if (friend == habitant && i != habitant) {
                this.amis.set(i, representant);
            }
        }

        //En cas ou l'habitant ne serait pas son propre représentant devient son propre représentant
        if (this.amis.get(habitant) != habitant) {
            this.amis.set(habitant, habitant);
        }
    }

    //Affiche le tableau
    public String toString (){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i = 0; i < this.nbHabitant; ++i){
            if(i != this.nbHabitant - 1) sb.append(this.amis.get(i) + ", ");
            else sb.append(this.amis.get(i));
        }
        sb.append("]");
        return sb.toString();
    }

}
