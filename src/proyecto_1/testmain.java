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
public class testmain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List b = new List();
        b.append(12,"asd",13);
        b.append(0, "yay", 0);
        b.append(123, "lmao", 2);
        b.index(0).addEdge(0, "name", 0);
        b.index(0).addEdge(1, "name", 1);
        b.index(1).addEdge(0, "name", 0);
        b.index(2).addEdge(1, "name", 1);
        Graph c= new Graph(b);
        String d =c.printList();
        System.out.println(d);
        
    }
    
}
