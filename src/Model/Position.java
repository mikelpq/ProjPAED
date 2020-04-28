package Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Position {
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("X1")
    @Expose
    private int x_one;
    @SerializedName("Y1")
    @Expose
    private int y_one;
    @SerializedName("X2")
    @Expose
    private int x_two;
    @SerializedName("Y2")
    @Expose
    private int t_two;

    public Position(){

    }

}
