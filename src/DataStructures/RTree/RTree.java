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
