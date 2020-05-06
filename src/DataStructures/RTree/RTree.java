package DataStructures.RTree;

import DataStructures.array.Array;
import Model.JsonModel;
import Model.Position;

import javax.imageio.metadata.IIOMetadataFormatImpl;

public class RTree {

    private Array<Nodo> root = new Array<>();

    public void RTreeMenu(int option, Position[] positions){
        int index;
        //index -> element to remove or search
        switch (option){
            case 1:
                //Inserir
                Array<Position> positionArray = new Array<>();

                for (int i = 0; i < positions.length; i++) {
                    insert(positions[i],positionArray);
                }
                Leaf leaf = new Leaf(null,null);
                System.out.println(leaf);
                Nodo nodo = new Nodo(null, 0,5,10,40, leaf, null);
                System.out.println(nodo);
                break;
            case 2:
                //Buscar y eliminar

                break;
            case 3:
                //Visualitzar
                for (int i = 0; i < root.size(); i++) {
                    System.out.println(root.get(i));
                }
                break;
            case 4:
                JsonModel jsonModel = new JsonModel();
                jsonModel.printMenu();
                break;
            default:
                System.out.println("[ERR] Opcio invalida");
        }
    }

    public Array<Nodo> getRoot() {
        return root;
    }

    public void setRoot(Array<Nodo> root) {
        this.root = root;
    }

    public void insert(Position position, Array<Position> arrayPosition){
        arrayPosition.add(position);
        int[] region = calculatedRegion(arrayPosition);
        Nodo nodo = new Nodo(null, region[0], region[1], region[2], region[3], null, null);
        Leaf leaf = new Leaf(nodo.getId(), arrayPosition);
        nodo.setFillsFulla(leaf);
        root.add(nodo);

    }

    private int[] calculatedRegion(Array<Position> positionArray){
        int x1 = Integer.MAX_VALUE, x2 = 0, y1= Integer.MAX_VALUE, y2=0;

        int[] posiciones = new int[4];
        for (int i = 0; i < positionArray.size(); i++) {
            Position position = (Position) positionArray.get(i);
            if (x1 > position.getX1()){
                x1 = position.getX1();
                posiciones[0] = x1;
            }
            if (x2 < position.getX2()){
                x2 = position.getX2();
                posiciones[1] = x2;
            }
            if (y1 > position.getY1()){
                y1 = position.getY1();
                posiciones[2] = y1;
            }
            if (y2 < position.getY2()){
                y2 = position.getY2();
                posiciones[3] = y2;
            }
        }
        return posiciones;
    }



}
