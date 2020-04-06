package Utilities;

import Model.Connection;
import Model.Room;

import java.util.ArrayList;

public class Printing {
    public static void displayPaths(ArrayList<Room> path, Connection origin, Connection end) {
        System.out.println("Origin " + origin.getId());
        for (int i = 0; i < path.size(); i++) {
            System.out.println(" -> " + path.get(i).getRoom_name());
        }
        System.out.println(" -> " + end.getId());
    }


}
