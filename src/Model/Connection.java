package Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Connection {
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("connectio_name")
    @Expose
    private String connectioName;
    @SerializedName("room_connected")
    @Expose
    private int[] roomConnected;
    @SerializedName("enemy_probability")
    @Expose
    private int enemyProb;

    public int getId() {
        return id;
    }

    public String getConnectioName() {
        return connectioName;
    }

    public int[] getRoomConnected() {
        return roomConnected;
    }

    public int getEnemyProb() {
        return enemyProb;
    }
}
