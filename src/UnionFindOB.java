import java.util.ArrayList;

public class UnionFindOB {
    private static class Observer {
        private int countOp = 0;
        private int stackSize = 0;
        private int maxStackSize = 0;

        // pour compter les opérations élémentaires (addition, multiplication) et de déclaration de variabme
        private void incOp() {
            ++countOp;
        }

        // pour compter la profondeur maximale de la pile d'appels en cas de récursion
        private void enter() {
            ++stackSize;
            maxStackSize = Math.max(maxStackSize, stackSize);
        }
        private void exit() {
            --stackSize;
        }

    }

    private ArrayList<Integer> amis;
    private int nbHabitant;
    private static Observer o;

    public UnionFindOB(int nbH){
        this.nbHabitant = nbH;
        this.amis = new ArrayList<>(this.nbHabitant);
        for(int i = 0; i < this.nbHabitant; ++i){
            this.amis.add(i);
        }
        o = new Observer();
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
        //Condition pour afecter l'habitant le plus petit facilitant pour la suite les possible find
        if(rep1 < rep2) this.amis.set(habitant2, rep1);
        o.exit();
    }

    public void addPeople() {
        o.enter();
        ++this.nbHabitant;
        if (this.nbHabitant > this.amis.size()) {
            //Garantit une certaine taille à la liste, modifie sa capacité interne
            // afin de pouvoir ajouter un grand nombre sans crash
            this.amis.ensureCapacity(this.nbHabitant);
        }
        this.amis.add(nbHabitant - 1);
        o.exit();
    }


    public void isolated(int habitant) {
        o.enter();
        o.incOp();
        int representant = find(habitant);
        o.incOp();
        int i;
        o.incOp();
        boolean foundAnotherRepresentant = false;
        o.incOp();
        int friend;

        for (i = 0; i < this.nbHabitant; ++i) {
            friend = this.amis.get(i);
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
        o.exit();
    }
    public String toString (){
        return (o.countOp+ "\t" + o.maxStackSize);
    }

}
