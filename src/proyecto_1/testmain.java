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
        System.setProperty("org.graphstream.ui", "swing");
        DataManage ass = new DataManage();
        Grafo grafo = ass.readCSV();
        grafo.graficoName();
        Pila prueba = grafo.DegreesDFS("\"Kevin Bacon\"", "\"Chris Sarandon\"", new Pila(), new Pila());
        String a = prueba.getCima().getName();
        
        System.out.println(prueba.getSize());
    }
}
