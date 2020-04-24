import Model.JsonModel;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        JsonModel jsonModel = new JsonModel();

        printMenu(jsonModel);
    }

    private static void printMenu(JsonModel jsonModel) {
        int option = -1;
        Scanner sc = new Scanner(System.in);
        System.out.println("[MENU] Benvingut a CS:LS\n");
        while (option != 4){
            System.out.println("[MENU] Escull una estructura de dades/algorisme:");
            System.out.println("[MENU]\t 1. Dijkstra.\n[MENU]\t 2. BTree - versió 2-3.\n[MENU]\t 3. R-Tree \n[MENU]\t 4. Sortir");
            option = sc.nextInt();

            switch (option){
                case 1:
                    jsonModel.getGraphDijsktra();
                    break;
                case 2:
                    jsonModel.getBTree();
                    break;
                case 3:
                    jsonModel.getRTree();
                    break;
                default:
                    if (option != 4){
                        System.out.println("[ERR] Opció incorrecta\n");
                    }
            }
        }
    }


}
