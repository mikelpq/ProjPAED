package DataStructures.RTree;

import DataStructures.array.Array;
import Model.Position;

public class Leaf {
    private String idFather;
    private Array<Position> positions;

    public Leaf(){
        this.positions = new Array<>();
    }

    public Leaf(String idFather, Array<Position> positions) {
        if (positions == null){
            this.positions = new Array<>();
        }
        this.idFather = idFather;
        this.positions = positions;
    }

    public String getIdFather() {
        return idFather;
    }

    public void setIdFather(String idFather) {
        this.idFather = idFather;
    }

    public Array<Position> getPositions() {
        return positions;
    }

    public void setPositions(Array<Position> positions) {
        this.positions = positions;
    }

    @Override
    public String toString() {
        return "Leaf{" +
                "father=" + idFather +
                ", positions=" + positions +
                '}';
    }
}
