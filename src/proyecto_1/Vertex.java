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
public class Vertex {
    int id;
    String name;
    Edge [] edges;
    Vertex next;
    Vertex prev;
    public Vertex(String name, int id, Edge [] edges){
        this.edges = edges;
        this.name = name;
        this.id = id;
        this.next = null;
        this.prev = null;
    }
}
