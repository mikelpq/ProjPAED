package Model;

import java.util.ArrayList;

public class Connection {
    private int id;
    private String connection_name;
    private ArrayList<Integer> room_connected;
    private int enemy_probability;
    private boolean visitat;

    public Connection() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getConnection_name() {
        return connection_name;
    }

    public void setConnection_name(String connection_name) {
        this.connection_name = connection_name;
    }

    public ArrayList<Integer> getRoomConnecteds() {
        return room_connected;
    }

    public void setRoomConnecteds(ArrayList<Integer> room_connected) {
        this.room_connected = room_connected;
    }

    public int getEnemy_probability() {
        return enemy_probability;
    }

    public void setEnemy_probability(int enemy_probability) {
        this.enemy_probability = enemy_probability;
    }

    public boolean isVisitat() {
        return visitat;
    }

    public void setVisitat(boolean visitat) {
        this.visitat = visitat;
    }

    @Override
    public String toString() {
        return "Connection{" +
                "id=" + id +
                ", connection_name='" + connection_name + '\'' +
                ", roomConnecteds=" + room_connected +
                ", enemy_probability=" + enemy_probability +
                '}';
    }
}
