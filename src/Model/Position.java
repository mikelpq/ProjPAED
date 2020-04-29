package Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Position {
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("X1")
    @Expose
    private int x1;
    @SerializedName("Y1")
    @Expose
    private int y1;
    @SerializedName("X2")
    @Expose
    private int x2;
    @SerializedName("Y2")
    @Expose
    private int y2;
    @SerializedName("area")
    @Expose
    private int area;

    public Position(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public double getArea() {
        return area;
    }

    public void setArea() {
        this.area = calculateArea();
    }

    private int calculateArea() {
        int base = Math.abs(x1-x2);
        int altura = Math.abs(y1-y2);
        return (base * altura) / 2;
    }

    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", x1=" + x1 +
                ", y1=" + y1 +
                ", x2=" + x2 +
                ", y2=" + y2 +
                ", area=" + area +
                '}';
    }
}
