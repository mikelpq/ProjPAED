package Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Room {
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("room_name")
    @Expose
    private String room_name;
    private Boolean visited;

    public int getId() {
        return id;
    }

    public String getRoom_name() {
        return room_name;
    }

    public Boolean getVisited() {
        return visited;
    }

    public void setVisited(Boolean visited) {
        this.visited = visited;
    }

}
