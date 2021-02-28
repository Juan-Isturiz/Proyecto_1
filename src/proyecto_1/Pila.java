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
public class Pila {

    private Nodo cima;
    private Nodo base;
    private int size;

    public Pila() {
        this.size = 0;
        this.base = null;
        this.cima = null;
    }

    public void pile(Nodo a) {
        Nodo b = new Nodo(a.getId(), a.getName(), a.getBirth());
        b.setEdges(a.getEdges());
        if (getSize() == 0) {
            setCima(b);setBase(b);
        } else {
            getCima().setNext(b);
            b.setPrev(getCima());
            this.setCima(b);
        }
        setSize(getSize() + 1);

    }

    public void depile() {
        if (getSize() != 0) {
            this.setCima(getCima().getPrev());
        }
        setSize(getSize() - 1);
    }

    /**
     * @return the cima
     */
    public Nodo getCima() {
        return cima;
    }

    /**
     * @param cima the cima to set
     */
    public void setCima(Nodo cima) {
        this.cima = cima;
    }

    /**
     * @return the base
     */
    public Nodo getBase() {
        return base;
    }

    /**
     * @param base the base to set
     */
    public void setBase(Nodo base) {
        this.base = base;
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
}
