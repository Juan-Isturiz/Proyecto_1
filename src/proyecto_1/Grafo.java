/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_1;

import javax.swing.JOptionPane;
import org.graphstream.graph.EdgeRejectedException;
import org.graphstream.graph.ElementNotFoundException;
import org.graphstream.graph.Graph;
import org.graphstream.graph.IdAlreadyInUseException;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;

/**
 *
 * @author yunch
 */
public class Grafo {

    private int size;
    private List[] adylist;
    private List actors;

    public Grafo(List actors) {
        this.actors = actors;
        this.size = actors.getSize();
        this.adylist = new List[size];
        for (int i = 0; i < actors.getSize(); i++) {
            List a = new List();
            a.appendNodo(actors.index(i));
            for (int k = 0; k < actors.getSize(); k++) {
                for (int j = 0; j < actors.index(i).getEdges().getSize(); j++) {
                    for (int h = 0; h < actors.index(k).getEdges().getSize(); h++) {
                        Nodo b = actors.index(k).getEdges().searchId(actors.index(i).getEdges().index(j).getId());
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

    public String busquedaActor() {
        String pelipeli = "";
        String busqueda = "Kevin Bacon";
        for (int i = 0; size > i; i++) {

            Nodo ayuda = actors.index(i);
            String ok = ayuda.getName();
            String ok2 = ok.replaceAll("^\"+|\"+$", "");
            if (ok2.equals(busqueda)) {
                List peliculas = ayuda.getEdges();
                for (int y = 0; peliculas.getSize() > y; y++) {
                    Nodo tupapa = peliculas.index(y);
                    String moviemovie = tupapa.getName();
                    pelipeli += moviemovie;
                    pelipeli += "\n";
                }

            }

        }
        return pelipeli;
    }

    public String busquedaPelicula() {
        String elenco = "";
        String busqueda = "Apollo 13";
        for (int i = 0; size > i; i++) {
            Nodo ayuda = actors.index(i);
            List peliculas = ayuda.getEdges();
            for (int y = 0; peliculas.getSize() > y; y++) {
                Nodo tupapa = peliculas.index(y);
                String moviemovie = tupapa.getName();
                String ok2 = moviemovie.replaceAll("^\"+|\"+$", "");
                if (ok2.equals(busqueda)) {
                    String cast = ayuda.getName();
                    elenco += cast;
                    elenco += "\n";
                }

            }

        }
        return elenco;
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

    public void graficoId() {
        Graph graph = new SingleGraph("Grafo");
        graph.setAutoCreate(true);
        graph.setAttribute("ui.quality");
        graph.setAttribute("ui.antialias");
        graph.setAttribute("ui.stylesheet", "node { size-mode: fit; shape: rounded-box; fill-color: white; stroke-mode: plain; padding: 3px, 2px; }edge { shape: blob; size: 3px; fill-color: #444; }");
        for (int i = 0; i < size; i++) {
            String id = String.valueOf(adylist[i].index(0).getId());
            graph.addNode(id);
        }
        for (Node node : graph) {
            node.setAttribute("ui.label", node.getId());
        }
        for (int i = 0; i < size; i++) {
            for (int j = 1; j < adylist[i].getSize(); j++) {
                int a = adylist[i].index(0).getEdges().getSize();
                for (int k = 0; k < adylist[i].index(0).getEdges().getSize(); k++) {
                    try {
                        String id = String.valueOf(adylist[i].index(j).getEdges().searchId(adylist[i].index(0).getEdges().index(k).getId()));
                        graph.addEdge(id, String.valueOf(adylist[i].index(j).getId()), String.valueOf(adylist[i].index(0).getId()));
                    } catch (EdgeRejectedException | ElementNotFoundException | IdAlreadyInUseException e) {

                    }
                }
            }
        }

        graph.display();

    }

    public void graficoName() {
        Graph graph = new SingleGraph("Grafo");
        graph.setAutoCreate(true);
        graph.setAttribute("ui.quality");
        graph.setAttribute("ui.antialias");
        graph.setAttribute("ui.stylesheet", "graph { padding: 40px; } node { text-alignment: at-right; text-padding: 3px, 2px; text-background-mode: rounded-box; text-background-color: #EB2; text-color: #222; }edge { shape: blob; size: 3px; fill-color: #444;padding: -10px, -10px; }");
        for (int i = 0; i < size; i++) {
            String id = String.valueOf(adylist[i].index(0).getName());
            graph.addNode(id);
        }
        for (Node node : graph) {
            node.setAttribute("ui.label", node.getId());
        }
        for (int i = 0; i < size; i++) {
            for (int j = 1; j < adylist[i].getSize(); j++) {
                int a = adylist[i].index(0).getEdges().getSize();
                for (int k = 0; k < adylist[i].index(0).getEdges().getSize(); k++) {
                    try {
                        String id = String.valueOf(adylist[i].index(j).getEdges().searchId(adylist[i].index(0).getEdges().index(k).getId()));
                        graph.addEdge(id, String.valueOf(adylist[i].index(j).getName()), String.valueOf(adylist[i].index(0).getName()));
                    } catch (EdgeRejectedException | ElementNotFoundException | IdAlreadyInUseException e) {

                    }
                }
            }
        }

        graph.display();

    }

    public Pila DegreesDFS(String inicio, String destino, Pila visited, Pila camino) {
        Nodo aux;
        for (int i = 0; i < size; i++) {
            if (adylist[i].index(0).getName().equals(inicio)) {
                aux = adylist[i].index(0);
                camino.pile(aux);
                if (!camino.in(destino)) {
                    for (int j = 1; j < adylist[i].getSize(); j++) {
                        if (adylist[i].index(j).getName().equals(destino)) {
                            camino.pile(adylist[i].index(j));
                            break;
                        } else if ((!camino.in(adylist[i].index(j).getName())) && !(visited.in(adylist[i].index(j).getName()))) {
                            camino = this.DegreesDFS(adylist[i].index(j).getName(), destino, visited, camino);
                        }

                    }
                    if (!camino.in(destino)) {
                        visited.pile(camino.getCima());
                        camino.depile();

                    }
                }

                break;
            }
        }
        if (camino.in(destino)) {
            for (int i = 0; i < camino.getSize(); i++) {
                if (camino.getCima().getName().equals(camino.getCima().getPrev().getName())) {
                    camino.depile();
                } else {
                    break;
                }
            }
        }
        return camino;
    }
    
}
