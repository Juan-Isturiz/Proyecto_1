/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_1;

/**
 *
 * @author yunch
 */
public class Graph {
    int size;
    boolean [][] matrix;
    Vertex [] actors;
    public Graph(Vertex[] actors){
        this.actors = actors;
        this.size = actors.length;
        this.matrix = new boolean[size][size];
        for (int i = 0; i< actors.length; i++){
            for (int x = 0; x<actors.length; x++){
                boolean a;
                for (Edge edge1 : actors[i].edges) {
                    for (Edge edge : actors[x].edges) {
                        a = false;
                        if (edge == edge1) {
                            a = true;
                            
                        }
                        matrix[i][x] = a;
                    }
                }
            }
        }
        
        
    }
    
}
