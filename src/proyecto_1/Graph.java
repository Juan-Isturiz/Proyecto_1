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
    public String busquedaActor(){
    String pelipeli = "";
    String busqueda = "Kevin Bacon"; 
    for(int i = 0; size > i; i++)         
    {        
    
    Node ayuda = actors.index(i);
    String ok = ayuda.getName();
    String ok2 = ok.replaceAll("^\"+|\"+$", "");
    if (ok2.equals(busqueda)){
    List peliculas = ayuda.getEdges();
    for(int y = 0; peliculas.getSize() > y; y++){
        Node tupapa = peliculas.index(y);
        String moviemovie  = tupapa.getName();
        pelipeli += moviemovie;
        pelipeli += "\n";     
    } 
        
   }
    
  }
      return pelipeli;
}
public String busquedaPelicula(){
    String elenco = "";
    String busqueda = "Apollo 13";
    for(int i = 0; size > i; i++)         
    {
    Node ayuda = actors.index(i);    
    List peliculas = ayuda.getEdges();    
    for(int y = 0; peliculas.getSize() > y; y++){
        Node tupapa = peliculas.index(y);
        String moviemovie  = tupapa.getName();
        String ok2 = moviemovie.replaceAll("^\"+|\"+$", "");
        if (ok2.equals(busqueda)){
            String cast = ayuda.getName();
            elenco += cast;
            elenco += "\n";
        }
     
    }
    
}
        return elenco;
}

}
