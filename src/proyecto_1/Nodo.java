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
public class Nodo {
    private int id;
    private String name;
    private int birth;
    private List edges;
    private Nodo next;
    private Nodo prev;
    public Nodo(int id,String name,int year){
        this.name = name;
        this.id = id;
        this.birth = year;
        this.next = null;
        this.prev= null;
        this.edges = new List();
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the birth
     */
    public int getBirth() {
        return birth;
    }

    /**
     * @param birth the birth to set
     */
    public void setBirth(int birth) {
        this.birth = birth;
    }

    /**
     * @return the edges
     */
    public List getEdges() {
        return edges;
    }
    public void setEdges(List edges){
        this.edges = edges;
    }

    /**
     * @return the next
     */
    public Nodo getNext() {
        return next;
    }

    /**
     * @param next the next to set
     */
    public void setNext(Nodo next) {
        this.next = next;
    }

    /**
     * @return the prev
     */
    public Nodo getPrev() {
        return prev;
    }

    /**
     * @param prev the prev to set
     */
    public void setPrev(Nodo prev) {
        this.prev = prev;
    }
    public void addEdge(int id, String name,int birth){
        edges.append(id, name, birth);
    }
    public String getData(){
        String a = id+", "+name+", "+birth;
        return a;
    }
}
