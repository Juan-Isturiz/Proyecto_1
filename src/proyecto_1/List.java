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

    private Nodo first;
    private Nodo last;
    private int size;

    public List() {
        this.first = null;
        this.last = null;
        this.size = 0;
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

    public boolean isEmpty() {
        boolean empty = false;
        if (size == 0) {
            empty = true;
        }
        return empty;
    }

    public void append(int id, String name, int birth) {
        Nodo app = new Nodo(id, name, birth);
        if (!isEmpty()) {
            last.setNext(app);
            app.setPrev(last);
            this.setLast(app);
        } else {
            first = last = app;
        }
        size++;
    }

    public Nodo index(int indx) {
        Nodo aux = null;
        if (indx < size) {
            aux = first;
            for (int i = 0; i < indx; i++) {
                aux = aux.getNext();
            }
        }
        return aux;
    }

    public Nodo searchId(int id) {
        Nodo aux = first;
        Nodo res = null;
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
        Nodo now = first;
        while (now != null) {
            listado += now.getData() + "\n";
            now = now.getNext();
        }
        return listado;
    }

    public void appendNodo(Nodo nuevo) {
        Nodo app = new Nodo(nuevo.getId(),nuevo.getName(),nuevo.getBirth());
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
    public int findId(int id) {
        Nodo aux = first;
        Nodo res = null;
        for (int i = 0; i < size; i++) {
            if (aux.getId() == id) {
                res = aux;
                break;
            }
            aux = aux.getNext();
        }
        return res.getId();
    }
}
