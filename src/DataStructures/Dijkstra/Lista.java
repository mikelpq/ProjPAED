package DataStructures.Dijkstra;

import Model.Room;

public class Lista {
    Nodo inicio;
    Nodo fin;
    int count = 0;

    public Lista() {
        this.inicio = null;
        this.inicio = null;
    }

    public boolean isEmpty() {
        return inicio == null;
    }

    public void agregarAlInicio(Room o, int pes) {
        count++;
        if (isEmpty()) {
            inicio = new Nodo(o,inicio,pes);
            fin = inicio;
        } else {
            inicio = new Nodo(o,inicio,pes);
        }
    }

    public void agregarAlFinal (Room o, int pes) {
        count++;
        if (isEmpty()) {
            inicio = new Nodo(o,pes);
            fin = inicio;
        } else {
            fin.siguiente = new Nodo(o,pes);
            fin = fin.siguiente;
        }
    }

    public void eliminarDato(Room o, int pes) {
        if (!isEmpty()) {
            if (inicio == fin && (inicio.dato.equals(o) && inicio.pes == pes)) {
                inicio=fin=null;
            } else if (inicio.dato.equals(o) && inicio.pes == pes) {
                inicio = inicio.siguiente;
            } else if (fin.dato.equals(o) && fin.pes == pes) {
                Nodo temporal = inicio;
                while (temporal.siguiente != fin) {
                    temporal = temporal.siguiente;
                }
                fin = temporal;
                fin.siguiente = null;
            }
            else {
                Nodo anterior, temporal;
                anterior = inicio;
                temporal = inicio.siguiente;
                while (temporal != null && !temporal.dato.equals(o) && temporal.pes != pes) {
                    anterior = anterior.siguiente;
                    temporal = temporal.siguiente;
                }
                if (temporal != null) {
                    anterior.siguiente = temporal.siguiente;
                    if (temporal == fin) {
                        fin = anterior;
                    }
                }
            }
        }
        count--;
    }

    public int length() {
        return count;
    }


    public Nodo searchNode (int i) {
        Nodo targetNode = null;
        Nodo currentNode = this.inicio;
        int count = 0;
        while(currentNode != null && count < i) {
            currentNode = currentNode.siguiente;
            count++;
        }
        if (currentNode != null) {
            targetNode = currentNode;
        }
        return targetNode;
    }

    public void mostrarLista() {
        Nodo aux = inicio;
        while (aux != null) {
            System.out.print("[" + aux.dato + " " + aux.pes + "] --> ");
            aux = aux.siguiente;
        }
    }
}
