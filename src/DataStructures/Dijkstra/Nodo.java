package DataStructures.Dijkstra;

import Model.Room;

public class Nodo {
    Room dato;
    Nodo siguiente;
    int pes;

        public Nodo(Room o, Nodo sig, int pes) {
        this.dato = o;
        this.siguiente = sig;
        this.pes = pes;
    }

    public Nodo(Room o, int pes) {
        this.dato = o;
        this.siguiente = null;
        this.pes=pes;
    }

}
