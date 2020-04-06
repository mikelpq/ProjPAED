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
            System.out.println("[MENU] Escull una opció:");
            System.out.println("[MENU]\t 1. Trobar millor camí.\n[MENU]\t 2. Buscar producte de la tenda.\n[MENU]\t 3. Buscar element per posició");
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
