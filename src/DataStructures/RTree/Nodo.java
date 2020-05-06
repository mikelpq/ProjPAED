package DataStructures.RTree;

import DataStructures.array.Array;


public class Nodo {
    private Nodo father;
    private String id;
    private static int increment = 0;
    private int x1;
    private int x2;
    private int y1;
    private int y2;
    private int area;
    private Leaf fillsFulla;
    private Array<Nodo> fillsNodo;

    public Nodo(){
        increment++;
        this.id = "R" + increment;
    }

    public Nodo(Nodo father, int x1, int x2, int y1, int y2, Leaf fillsFulla, Array<Nodo> fillsNodo) {
        this.father = father;
        increment++;
        this.id = "R" + increment;
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        this.fillsNodo = new Array<>();
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

    public void setFillsFulla(Leaf fillsFulla) {
        this.fillsFulla = fillsFulla;
    }

    public void setFillsNodo(Array<Nodo> fillsNodo) {
        this.fillsNodo = fillsNodo;
    }

    public int getArea() {
        return area;
    }

    public void setArea() {
        this.area = calculateArea();
    }

    public Nodo getFather() {
        return father;
    }

    public String getId() {
        return id;
    }

    public static int getIncrement() {
        return increment;
    }

    public int getX1() {
        return x1;
    }

    public int getX2() {
        return x2;
    }

    public int getY1() {
        return y1;
    }

    public int getY2() {
        return y2;
    }

    public Leaf getFillsFulla() {
        return fillsFulla;
    }

    public Array<Nodo> getFillsNodo() {
        return fillsNodo;
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
                ", fillsFulla=" + fillsFulla +
                ", fillsNodo=" + fillsNodo +
                '}';
    }

}
