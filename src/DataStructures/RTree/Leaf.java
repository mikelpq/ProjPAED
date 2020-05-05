package DataStructures.RTree;

import Model.Position;

import java.util.Arrays;

public class Leaf {
    private Nodo father;
    private Position[] positions;
    private int numLeaf;

    public Leaf(){
        this.positions = new Position[3];
        this.numLeaf = 0;
    }

    public Leaf(Nodo father, Position[] positions) {
        this.father = father;
        this.positions = new Position[3];
        this.positions = positions;
        this.numLeaf = 0;
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

    public int getNumLeaf() {
        return numLeaf;
    }

    public void setNumLeaf(int numLeaf) {
        this.numLeaf = numLeaf;
    }

    @Override
    public String toString() {
        return "Leaf{" +
                "father=" + father +
                ", positions=" + Arrays.toString(positions) +
                '}';
    }

    public void insertLeaf(Position position){
        if (maxLeaf()){
            positions[numLeaf] = position;
            numLeaf++;
        }else{

        }
    }

    public boolean maxLeaf(){
        return numLeaf < 3;
    }

}
