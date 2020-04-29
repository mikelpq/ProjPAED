package DataStructures.RTree;

import Model.Position;

import java.util.Arrays;

public class Leaf {
    private Nodo father;
    private Position[] positions;

    public Leaf(Nodo father, Position[] positions) {
        this.father = father;
        this.positions = new Position[3];
        this.positions = positions;
    }

    public Nodo getFather() {
        return father;
    }

    public void setFather(Nodo father) {
        this.father = father;
    }

    public Position[] getPositions() {
        return positions;
    }

    public void setPositions(Position[] positions) {
        this.positions = positions;
    }

    @Override
    public String toString() {
        return "Leaf{" +
                "father=" + father +
                ", positions=" + Arrays.toString(positions) +
                '}';
    }
}
