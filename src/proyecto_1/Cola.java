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
public class Cola {
    private Nodo first;
    private Nodo last;
    private int size;
    public Cola(){
        this.first = null;
        this.last = null;
        this.size= 0;
    }

    /**
     * @return the first
     */
    public Nodo getFirst() {
        return first;
    }

    /**
     * @param first the first to set
     */
    public void setFirst(Nodo first) {
        this.first = first;
    }

    /**
     * @return the last
     */
    public Nodo getLast() {
        return last;
    }

    /**
     * @param last the last to set
     */
    public void setLast(Nodo last) {
        this.last = last;
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }
    public void dequeue(){
        first = first.getNext();
    }
    public void queue(Nodo a){
        if (size != 0){
            
        }
    }
}
