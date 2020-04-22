package Model;

import DataStructures.BTree.BTree;
import DataStructures.Dijkstra.Dijkstra;
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
            position = gson.fromJson(new FileReader(jsonRoomPath), Position[].class);
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
            product = gson.fromJson(new FileReader(jsonRoomPath), Product[].class);
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
        for (int i = 0; i < products.size(); i++) {
            bTree.insert(products.get(i));
        }

    }


    public void getRTree(){

    }

}
