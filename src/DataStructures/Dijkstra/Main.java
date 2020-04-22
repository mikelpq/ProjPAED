package DataStructures.Dijkstra;

import Model.Connection;
import Model.Room;
import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int option;
        Gson gson = new Gson();

        try (Reader reader = new FileReader("./ConnectionS.json")) {
            Connection[] connections = gson.fromJson(reader, Connection[].class);
            try (Reader reader3 = new FileReader("./RoomS.json")) {
                Room[] rooms = gson.fromJson(reader3, Room[].class);
                do {
                    System.out.println("MENU - Escoge una opción:");
                    System.out.println("1. Dijkstra");
                    System.out.println("2. Salir");
                    Scanner sc = new Scanner(System.in);
                    option = sc.nextInt();
                    switch (option) {
                        case 1:
                            Room inici = new Room();
                            Room desti = new Room();
                            System.out.println("Inicio:");
                            sc = new Scanner(System.in);
                            String inicio = sc.nextLine();
                            System.out.println("Destino:");
                            sc = new Scanner(System.in);
                            String destino = sc.nextLine();
                            for (Room room: rooms){
                                if (inicio.equals(room.getRoom_name())) {
                                    inici = room;
                                }
                                if (destino.equals(room.getRoom_name())) {
                                    desti = room;
                                }
                            }
                            Dijkstra dijkstra = new Dijkstra();
                            dijkstra.setNumberOfVertices(rooms.length);
                            dijkstra.llenarListaAdjacenia(connections,rooms);
                            dijkstra.dijkstra(inici,desti);
                            //dijkstra.printSolution(desti);
                            break;
                        case 2:
                            System.out.println("Saliendo del programa...");
                            break;
                        default:
                            System.out.println("Opción incorrecta");
                            break;
                    }
                } while (option != 2);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
