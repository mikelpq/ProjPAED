package DataStructures.RTree;

import Model.JsonModel;
import Model.Position;
import com.sun.tools.javac.Main;

public class RTree {

    private Nodo nodo;

    public RTree(){
        nodo = new Nodo();
    }
    public void RTreeMenu(int option, Position[] positions){
        int index;
        //index -> element to remove or search
        switch (option){
            case 1:
                //Inserir
                Leaf leaf = new Leaf();
                Nodo nodo = new Nodo();
                for (int i = 0; i < positions.length; i++) {
                    insert(positions[i], leaf, nodo);
                }
                break;
            case 2:
                //Buscar y eliminar

                break;
            case 3:
                //Visualitzar
                for (Position p : positions) {
                    System.out.println(p);
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

    public void insert(Position position, Leaf leaf, Nodo nodo){
        int num = 0;
        if (leaf.maxLeaf()){
            leaf.getPositions()[leaf.getNumLeaf()] = position;
            nodo.getFillsFulla()[num] = leaf;
            leaf.setFather(nodo);
        }else{
            num++;
        }
    }

}
