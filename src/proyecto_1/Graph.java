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
    List [] adylist;
    List actors;
    public Graph(List actors){
        this.actors = actors;
        this.size = actors.getSize();
        this.adylist = new List[size];
        for (int i = 0; i< actors.getSize(); i++){
            List a = new List();
            a.append(actors.index(i).getId(),actors.index(i).getName(),actors.index(i).getBirth());
            for (int j = 0; j < actors.index(i).getEdges().getSize(); j++){
                
            }
            adylist[i] = a;
            
        }
        
        
    }
    
}
