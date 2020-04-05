package Model;

import DataStructures.Dijkstra;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import javax.swing.*;
import java.awt.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

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

    public void getGraphDijsktra(){
        ArrayList<Room> path = new ArrayList<>();
        Connection origin, end;

        ArrayList<Connection> auxConnections = new ArrayList<>(connections);

        for (int i = 0; i < connections.size(); i++) {
            origin = connections.get(i);
            for (int j = 0; j < connections.size(); j++) {
                end = connections.get(j);
                path = Dijkstra.findPath(auxConnections, rooms, origin, end);
                displayPaths(path, origin, end);
            }
        }


    }

    private void displayPaths(ArrayList<Room> path, Connection origin, Connection end) {
        System.out.println("Origin " + origin);
        for (int i = 0; i < path.size(); i++) {
            System.out.println(" -> " + path.get(i).getRoom_name());
        }
        System.out.println(" -> " + end);
    }
}
