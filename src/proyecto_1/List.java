/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_1;

import javax.swing.JOptionPane;

/**
 *
 * @author yunch
 */
public class List {

    private Node first;
    private Node last;
    private int size;

    public List() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    /**
     * @return the first
     */
    public Node getFirst() {
        return first;
    }

    /**
     * @param first the first to set
     */
    public void setFirst(Node first) {
        this.first = first;
    }

    /**
     * @return the last
     */
    public Node getLast() {
        return last;
    }

    /**
     * @param last the last to set
     */
    public void setLast(Node last) {
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

    public boolean isEmpty() {
        boolean empty = false;
        if (size == 0) {
            empty = true;
        }
        return empty;
    }

    public void append(int id, String name, int birth) {
        Node app = new Node(id, name, birth);
        if (!isEmpty()) {
            last.setNext(app);
            app.setPrev(last);
            this.setLast(app);
        } else {
            first = last = app;
        }
        size++;
    }

    public Node index(int indx) {
        Node aux = null;
        if (indx < size) {
            aux = first;
            for (int i = 0; i < indx; i++) {
                aux = aux.getNext();
            }
        }
        return aux;
    }

    public Node searchId(int id) {
        Node aux = first;
        Node res = null;
        for (int i = 0; i < size; i++) {
            if (aux.getId() == id) {
                res = aux;
                break;
            }
            aux = aux.getNext();
        }
        return res;
    }

    public String print() {
        String listado = "";
        Node now = first;
        while (now != null) {
            listado += now.getData() + "\n";
            now = now.getNext();
        }
        return listado;
    }

    public void appendNodo(Node nuevo) {
        Node app = new Node(nuevo.getId(),nuevo.getName(),nuevo.getBirth());
        for(int i = 0; i<nuevo.getEdges().getSize(); i++){
            app.addEdge(nuevo.getEdges().index(i).getId(), nuevo.getEdges().index(i).getName(), nuevo.getEdges().index(i).getBirth());
        }
        if (!isEmpty()) {
            last.setNext(app);
            app.setPrev(last);
            this.setLast(app);
        } else {
            first = last = app;
        }
        size++;
    }
}
