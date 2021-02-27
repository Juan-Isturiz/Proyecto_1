/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author yunch
 */
public class DataManage {
    public DataManage(){
        
    }
    public Graph readCSV(){
        String doc;
        doc = "Test Packages\\movies.csv";
        String act = "";
        String mov = "";
        String star = "";
        List movies = new List();
        List actors= new List();
        String line;
        File docu = new File(doc);
        try{
            if (!docu.exists()){
                docu.createNewFile();
            } else{
                FileReader fr = new FileReader(docu);
                BufferedReader br = new BufferedReader(fr);
                while ((line = br.readLine())!= null){
                    if (!line.isEmpty()){
                        mov += line + "\n";
                        
                    }
                }
                if(!"".equals(mov)){
                    String[] movi = mov.split("\n");
                    for (int i = 0; i<movi.length;i++){
                        if (!movi[i].equals("id,title,year")){
                            String [] data = movi[i].split(",");
                            movies.append( Integer.parseInt(data[0]),data[1],Integer.parseInt(data[2]));
                        }
                        
                    }
                fr.close();
                br.close();
                
                }
            }
            }catch(IOException e){
            JOptionPane.showMessageDialog(null, "Error while reading");
            }
            doc ="Test Packages\\people.csv";
            docu = new File(doc);
        try{
            if (!docu.exists()){
                docu.createNewFile();
            } else{
                FileReader fr = new FileReader(docu);
                BufferedReader br = new BufferedReader(fr);
                while ((line = br.readLine())!= null){
                    if (!line.isEmpty()){
                        act += line + "\n";
                        
                    }
                }
                if(!"".equals(act)){
                    String[] acto = act.split("\n");
                    for (int i = 0; i<acto.length;i++){
                        if (!acto[i].equals("id,name,birth")){
                            String [] data = acto[i].split(",");
                            actors.append(Integer.parseInt(data[0]),data[1],Integer.parseInt(data[2]));
                        }
                        
                    }
                }
                fr.close();
                br.close();
            
        }
        }catch(IOException | NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Error while reading");
        }
        doc ="Test Packages\\stars.csv";
            docu = new File(doc);
        try{
            if (!docu.exists()){
                docu.createNewFile();
            } else{
                FileReader fr = new FileReader(docu);
                BufferedReader br = new BufferedReader(fr);
                while ((line = br.readLine())!= null){
                    if (!line.isEmpty()){
                        star += line + "\n";
                        
                    }
                }
                if(!"".equals(star)){
                    String[] str = star.split("\n");
                    for (int i = 0; i<str.length;i++){
                        if (!str[i].equals("person_id,movie_id") && !str[i].equals(null)){
                            String [] data = str[i].split(",");
                            Node starring = actors.searchId(Integer.parseInt(data[0]));
                            String []peli = (movies.searchId(Integer.parseInt(data[1]))).getData().split(", ");
                            starring.addEdge(Integer.parseInt(peli[0]), peli[1],Integer.parseInt(peli[2]));
                        }
                        
                    }
                }
                fr.close();
                br.close();
            
        }
        }catch(IOException | NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Error while reading");
        }
        Graph grafo = new Graph(actors);
        return grafo;
        }
    
}
