package Model;

import DataStructures.BTree.BTree;
import DataStructures.Dijkstra.Dijkstra;
import DataStructures.RTree.RTree;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import javax.swing.*;
import java.awt.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class JsonModel {

    private String jsonRoomPath = "data/RoomS.json";
    private String jsonConnectionPath = "data/ConnectionS.json";
    private String jsonMapPath = "data/dataset_MapS.json";
    private String jsonObjectPath = "data/dataset_ObjectS.json";
    private Room[] room;
    private Connection[] connection;
    private Product[] product;
    private Position[] position;
    private ArrayList<Room> rooms;
    private ArrayList<Connection> connections;
    private ArrayList<Product> products;
    private ArrayList<Position> positions;

    public JsonModel(){
        readConnections();
        readRooms();
        readMap();
        readObjects();
    }

    private void readConnections(){
        try{
            Gson gson = new Gson();
            connection = gson.fromJson(new FileReader(jsonConnectionPath), Connection[].class);
            connections = new ArrayList<>(Arrays.asList(connection));

        }catch (JsonSyntaxException jse){
            JOptionPane.showMessageDialog(
                    new Frame(),
                    jse.getMessage(),
                    "Json File Error in Connection.json",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        } catch (IOException e1){
            e1.fillInStackTrace();
        }
    }

    private void readRooms(){
        try{
            Gson gson = new Gson();
            room = gson.fromJson(new FileReader(jsonRoomPath), Room[].class);
            rooms = new ArrayList<>(Arrays.asList(room));

        }catch (JsonSyntaxException jse){
            JOptionPane.showMessageDialog(
                    new Frame(),
                    jse.getMessage(),
                    "Json File Error in Room.json",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        } catch (IOException e1){
            e1.fillInStackTrace();
        }
    }

    private void readMap(){
        try{
            Gson gson = new Gson();
            position = gson.fromJson(new FileReader(jsonMapPath), Position[].class);
            positions = new ArrayList<>(Arrays.asList(position));

        }catch (JsonSyntaxException jse){
            JOptionPane.showMessageDialog(
                    new Frame(),
                    jse.getMessage(),
                    "Json File Error in Map.json",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        } catch (IOException e1){
            e1.fillInStackTrace();
        }
    }

    private void readObjects(){
        try{
            Gson gson = new Gson();
            product = gson.fromJson(new FileReader(jsonObjectPath), Product[].class);
            products = new ArrayList<>(Arrays.asList(product));

        }catch (JsonSyntaxException jse){
            JOptionPane.showMessageDialog(
                    new Frame(),
                    jse.getMessage(),
                    "Json File Error in Object.json",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        } catch (IOException e1){
            e1.fillInStackTrace();
        }
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public ArrayList<Connection> getConnections() {
        return connections;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public ArrayList<Position> getPositions() {
        return positions;
    }

    public void getGraphDijsktra(){
        Room inici = new Room();
        Room desti = new Room();
        Scanner sc;
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
        dijkstra.setNumberOfVertices(room.length);
        dijkstra.llenarListaAdjacenia(connection,room);
        dijkstra.dijkstra(inici,desti);
    }

    public void getBTree(){
        BTree bTree = new BTree();
        int option = 0;
        Scanner sc = new Scanner(System.in);

        while (option != 3){
            System.out.println("[MENU] Quina operació desitges realitzar?");
            System.out.println("[MENU]\t 1. Inserir dataset.\n[MENU]\t 2. Buscar y eliminar element.\n[MENU]\t 3. Visualitzar arbre.");
            option = sc.nextInt();
            bTree.BtreeMenu(option, product);
        }
    }


    public void getRTree(){
        RTree rTree = new RTree();
        int option = 0;
        Scanner scanner = new Scanner(System.in);

        while (option != 4){
            System.out.println("[MENU] Quina operació desitges realitzar?");
            System.out.println("[MENU]\t 1. Inserir dataset.\n[MENU]\t 2. Buscar y eliminar element.\n[MENU]\t 3. Visualitzar arbre.\n[MENU]\t 4. Atras.");
            option = scanner.nextInt();
            rTree.RTreeMenu(option,position);
        }

    }

    public void printMenu() {
        int option = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("[MENU] Benvingut a CS:LS\n");
        while (option != 4){
            System.out.println("[MENU] Escull una estructura de dades/algorisme:");
            System.out.println("[MENU]\t 1. Dijkstra.\n[MENU]\t 2. BTree - versió 2-3.\n[MENU]\t 3. R-Tree \n[MENU]\t 4. Salir.");
            option = sc.nextInt();

            switch (option){
                case 1:
                    getGraphDijsktra();
                    break;
                case 2:
                    getBTree();
                    break;
                case 3:
                    getRTree();
                    break;
                case 4:
                    System.out.println("Saliendo del menu...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("[ERR] Opció incorrecta\n");
            }
        }
    }

}
