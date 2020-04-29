package DataStructures.RTree;

import java.util.Arrays;

public class Nodo {
    private Nodo father;
    private String id;
    private static int increment = 0;
    private int x1;
    private int x2;
    private int y1;
    private int y2;
    private int area;
    private Leaf[] fillsFulla;
    private Nodo[] fillsNodo;

    public Nodo(Nodo father, int x1, int x2, int y1, int y2, Leaf[] fillsFulla, Nodo[] fillsNodo) {
        this.father = father;
        increment++;
        this.id = "R" + increment;
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        this.fillsFulla = fillsFulla;
        this.fillsNodo = fillsNodo;
    }

    public void setFather(Nodo father) {
        this.father = father;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public void setFillsFulla(Leaf[] fillsFulla) {
        this.fillsFulla = fillsFulla;
    }

    public void setFillsNodo(Nodo[] fillsNodo) {
        this.fillsNodo = fillsNodo;
    }

    public int getArea() {
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
        return "Nodo{" +
                "father=" + father +
                ", id='" + id + '\'' +
                ", x1=" + x1 +
                ", x2=" + x2 +
                ", y1=" + y1 +
                ", y2=" + y2 +
                ", area=" + area +
                ", fillsFulla=" + Arrays.toString(fillsFulla) +
                ", fillsNodo=" + Arrays.toString(fillsNodo) +
                '}';
    }
}
