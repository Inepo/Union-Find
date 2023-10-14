public class UnionFind {

    private int[] amis;
    private int nbHabitant;

    public UnionFind(int nbH){
        this.nbHabitant = nbH;
        this.amis = new int[this.nbHabitant];
        for(int i = 0; i < this.nbHabitant; ++i){
            this.amis[i] = i;
        }
    }

    public void union (int habitant1, int habitant2){
        int r1 = habitant1;
        int r2 = habitant2;
        while(this.amis[r1] != r1 && this.amis[r2] != r2){
            if(this.amis[r1] != r1)
                r1 = this.amis[r1];
            if(this.amis[r2] != r2)
                r2 = this.amis[r2];
        }
        this.amis[r1] = r2;
    }

    public int find (int habitant){
        int r = habitant;
        while(this.amis[r] != r){
            r = this.amis[r];
        }
        return r; // Determine le représentant de l'habitant
    }

    public void addPeople(){
        ++this.nbHabitant;
        int[] amistmp = new int[this.nbHabitant];
        amistmp = this.amis;
        /*for(int i = 0; i < this.nbHabitant - 1; ++i){
            amistmp[i] = this.amis[i];
        }*/
        this.amis = new int[this.nbHabitant];
        for(int i = 0; i < this.nbHabitant - 1; ++i){
             this.amis[i] = amistmp[i];
        }

        this.amis[this.nbHabitant-1] = this.nbHabitant-1;
    }
    public void isolated(int Habitant) {
        boolean firstOccurrenceFound = false;
        int min = 0;

        for (int i = 0; i < this.nbHabitant; ++i) {
            if (this.amis[i] == Habitant && i != Habitant) {
                if (!firstOccurrenceFound) {
                    min = i;
                    firstOccurrenceFound = true;
                }
                this.amis[i] = min;
            }
        }
    }




}
