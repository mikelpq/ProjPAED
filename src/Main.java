import DataStructures.RTree.Leaf;
import DataStructures.array.Array;
import Model.JsonModel;
import Model.Position;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Array<String> array = new Array<>();
        array.add("hola");
        array.add("adeu");
        array.add("torru");
        array.remove(0);
        System.out.println(array.size());
        System.out.println(array.getElements()[0]);
        System.out.println(array.toString());

        for (int i = 0; i < array.size(); i++) {
            System.out.println(array.get(i));
        }

        JsonModel jsonModel = new JsonModel();
        jsonModel.printMenu();
    }
}
