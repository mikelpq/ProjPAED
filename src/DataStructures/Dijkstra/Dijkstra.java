package DataStructures.Dijkstra;

import Model.Connection;
import Model.Room;

public class Dijkstra {
    private final double DIST = 101.0;
    private int nodos;
    private double[] distancia;
    private boolean[] visitado;
    private Lista[] listaAdjacencia;
    private Room[] camins;

    public void dijkstra(Room inici, Room fi) {
        init();
        int posCami = 1;
        double acumulat = 0.0;
        double nova = 0;
        int numConnections = 1;
        distancia[inici.getId()] = 0;
        int actual = inici.getId();
        visitado[actual] = true;
        camins[0] = inici;
        while (quedanNodosPorVisitar() && !visitado[fi.getId()]) {
            for (int i = 0; i < listaAdjacencia[actual].length(); i++) {
                Nodo adj = listaAdjacencia[actual].searchNode(i);
                if (!visitado[adj.dato.getId()]) {
                    double peso = (adj.pes/100.0);
                    nova = (peso*(1-acumulat));
                    if (distancia[adj.dato.getId()] > nova) {
                        distancia[adj.dato.getId()] = nova;
                        camins[posCami] = adj.dato;
                    }
                }
            }
            actual = calcularDistanciaMesCurta(visitado, distancia);
            visitado[actual] = true;
            posCami++;
            acumulat += nova;
            numConnections++;
        }

        printSolution(camins,fi.getId());
        System.out.println("La probabilitat es: " + distancia[fi.getId()] * 100 + "%");
    }

    private static void printSolution(Room[] camins, int fin) {
        for (Room room: camins){
            if (room.getRoom_name() != (null)){
                System.out.println(room.getRoom_name());
            }
            if (room.getId() == fin){
                break;
            }
        }
    }

    public void llenarListaAdjacenia(Connection[] connection, Room[] room) {
        listaAdjacencia = new Lista[nodos];
        int i = 0;
        while (i < nodos) {
            Lista list = new Lista();
            for (int j = 0; j < connection.length; j++) {
                for (int k = 0; k < connection[j].getRoomConnecteds().size(); k++) {
                    if (i == connection[j].getRoomConnecteds().get(k)) {
                        for (int h = 0; h < connection[j].getRoomConnecteds().size(); h++) {
                            if (i != connection[j].getRoomConnecteds().get(h)) {
                                list.agregarAlFinal(room[connection[j].getRoomConnecteds().get(h)], connection[j].getEnemy_probability());
                            }
                        }
                    }
                }
            }
            int inc = 0;
            int size = list.length();
            Lista aux = new Lista();
            while (inc < size) {
                Nodo n = list.searchNode(inc);
                Room r = (Room) n.dato;
                aux.agregarAlFinal(r, n.pes);
                for (int j = 0; j < size; j++) {
                    Nodo nodeActual = list.searchNode(j);
                    Room roomActual = (Room) nodeActual.dato;
                    if (r.equals(roomActual) && n.pes > nodeActual.pes) {
                        aux.eliminarDato(r, n.pes);
                    }
                }
                inc++;
            }
            listaAdjacencia[i] = aux;
            i++;
        }
    }

    public int calcularDistanciaMesCurta(boolean[] visitado, double[] distancia) {
        double aux = Double.MAX_VALUE;
        int j = -1;
        for (int i = 0; i < distancia.length; i++) {
            if (aux > distancia[i] && !visitado[i] && distancia[i] != DIST) {
                j = i;
            }
        }
        return j;
    }


    private void init() {
        camins = new Room[nodos];
        distancia = new double[nodos];
        visitado = new boolean[nodos];
        for (int i = 0; i < this.nodos; i++) {
            this.camins[i] = new Room();
            this.distancia[i] = DIST;
            this.visitado[i] = false;
        }
    }

    public int getNumberOfVertices() {
        return nodos;
    }

    public void setNumberOfVertices(int numeroNodos) {
        this.nodos = numeroNodos;
    }

    private boolean quedanNodosPorVisitar() {
        boolean quedanPorVisitar = false;
        for (int i = 0; i < visitado.length; i++) {
            if (!visitado[i]) {
                quedanPorVisitar = true;
                break;
            }
        }
        return quedanPorVisitar;
    }
}
