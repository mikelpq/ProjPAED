package DataStructures.RTree;

import Model.JsonModel;
import Model.Position;
import com.sun.tools.javac.Main;

public class RTree {


    public RTree(){

    }
    public void RTreeMenu(int option, Position[] positions){
        int index;
        //index -> element to remove or search
        switch (option){
            case 1:
                //Inserir
                for (int i = 0; i < positions.length; i++) {
                    //insert(positions[i]);
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
                Nodo n1 = new Nodo(null,0,0,0, 0, null,null);
                Nodo n2 = new Nodo(null,0,0,0, 0, null,null);
                System.out.println(n1);
                System.out.println(n2);
                break;
            case 4:
                JsonModel jsonModel = new JsonModel();
                jsonModel.printMenu();
                break;
            default:
                System.out.println("[ERR] Opcio invalida");
        }
    }
}
