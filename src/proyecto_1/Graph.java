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

    private int size;
    private List[] adylist;
    private List actors;

    public Graph(List actors) {
        this.actors = actors;
        this.size = actors.getSize();
        this.adylist = new List[size];
        for (int i = 0; i < actors.getSize(); i++) {
            List a = new List();
            a.appendNodo(actors.index(i));
            for (int k = 0; k < actors.getSize(); k++) {
                for (int j = 0; j < actors.index(i).getEdges().getSize(); j++) {
                    for (int h = 0; h < actors.index(k).getEdges().getSize(); h++) {
                        Node b = actors.index(k).getEdges().searchId(actors.index(i).getEdges().index(j).getId());
                        if (b != null) {
                            if (actors.index(i).getId() != actors.index(k).getId()) {
                                if (a.searchId(actors.index(k).getId()) == null) {
                                    a.appendNodo(actors.index(k));
                                }
                            }
                        }
                    }
                }
            }
            adylist[i] = a;
        }
        System.out.println(adylist[0].getFirst().getEdges().getSize());
       
        
    }

    public String printList() {
        String print = "";
        for (int i = 0; i < getAdylist().length; i++) {
            print += "[";
            for (int j = 0; j < getAdylist()[i].getSize(); j++) {
                if (getAdylist()[i].index(j) != null) {
                    print += getAdylist()[i].index(j).getData() + "]";
                    if (getAdylist()[i].index(j).getNext() != null) {
                        print += ", [";
                    } else {
                        print += "\n";
                    }
                }
            }
        }
        return print;
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

    /**
     * @return the adylist
     */
    public List[] getAdylist() {
        return adylist;
    }

    /**
     * @param adylist the adylist to set
     */
    public void setAdylist(List[] adylist) {
        this.adylist = adylist;
    }

    /**
     * @return the actors
     */
    public List getActors() {
        return actors;
    }

    /**
     * @param actors the actors to set
     */
    public void setActors(List actors) {
        this.actors = actors;
    }

}
