package DataStructures;

import Model.Connection;
import Model.Room;

import java.util.ArrayList;

public class Dijkstra {

    /**
     * function Dijkstra(Graph, source):
     *
     *      create vertex set Q
     *
     *      for each vertex v in Graph:
     *         dist[v] ← INFINITY
     *         prev[v] ← UNDEFINED
     *         add v to Q
     *        dist[source] ← 0
     *
     *        while Q is not empty:
     *           u ← vertex in Q with min dist[u]
     *           remove u from
     *           for each neighbor v of u:           // only v that are still in Q
     *             alt ← dist[u] + length(u, v)
     *             if alt < dist[v]:
     *                  dist[v] ← alt
     *                  prev[v] ← u
     *
     *      return dist[], prev[]
     */

    public static ArrayList<Room> findPath(ArrayList<Connection> connections, ArrayList<Room> rooms, Connection origin, Connection end){
        Boolean found = false;
        int compt = 0, nextJump = 0;
        /** array of booleans de tantes habs com hi hagi **/
        Boolean[] visited = new Boolean[rooms.size()];
        /**variable per saber quines connections s'agafen*/
        ArrayList<Connection> path = new ArrayList<>();
        /**variable per saber per quines rooms es pasen*/
        ArrayList<Room> solution = new ArrayList<>();

        path.add(origin);

        while(!found && compt < connections.size()){
            int best = Integer.MAX_VALUE;

            if (path.get(compt) == end){
                found = true;
            }

            if (best > connections.get(compt).getEnemyProb()){
                best = connections.get(compt).getEnemyProb();
                nextJump = compt;
            }

            if (compt == connections.size() - 1){
                path.add(connections.get(nextJump));
                connections.remove(nextJump);
                compt = 0;
            }


            compt++;
        }

        return solution;

    }
}
