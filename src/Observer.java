public class Observer {
    private int countOp = 0;
    private int stackSize = 0;
    private int maxStackSize = 0;



    // pour compter les opérations élémentaires (addition, multiplication) et de déclaration de variabme
    public void incOp() {
        ++countOp;
    }

    // pour compter la profondeur maximale de la pile d'appels en cas de récursion
    public void enter() {
        ++stackSize;
        maxStackSize = Math.max(maxStackSize, stackSize);
    }
    public void exit() {
        --stackSize;
    }

    // pour afficher
    @Override
    public String toString() {
        return (countOp+ "\t" + maxStackSize);
    }


}
