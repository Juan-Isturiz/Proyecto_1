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
    List[] adylist;
    List actors;

    public Graph(List actors) {
        this.actors = actors;
        this.size = actors.getSize();
        this.adylist = new List[size];
        for (int i = 0; i < actors.getSize(); i++) {
            List a = new List();
            a.append(actors.index(i).getId(), actors.index(i).getName(), actors.index(i).getBirth());
            for (int k = 0; k < actors.getSize(); k++) {
                for (int j = 0; j < actors.index(i).getEdges().getSize(); j++) {
                    for (int h = 0; h < actors.index(k).getEdges().getSize(); h++) {
                        Node b = actors.index(k).getEdges().searchId(actors.index(i).getEdges().index(j).getId());
                        if (b != null) {
                            if (actors.index(i).getId() != actors.index(k).getId()) {
                                if (a.searchId(actors.index(k).getId()) == null) {
                                    a.append(actors.index(k).getId(), actors.index(k).getName(), actors.index(k).getBirth());
                                }
                            }
                        }
                    }
                }
            }
            adylist[i] = a;
        }
    }

    public String printList() {
        String print = "";
        for (int i = 0; i < adylist.length; i++) {
            print += "[";
            for (int j = 0; j < adylist[i].getSize(); j++) {
                if (adylist[i].index(j) != null) {
                    print += adylist[i].index(j).getData() + "]";
                    if (adylist[i].index(j).getNext() != null) {
                        print += ", [";
                    } else {
                        print += "\n";
                    }
                }
            }
        }
        return print;
    }

}
