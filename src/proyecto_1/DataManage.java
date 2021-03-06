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
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author yunch
 */
public class DataManage {

    public DataManage() {

    }

    public Grafo readCSV() {
        String doc;
        doc = "Test Packages\\movies.csv";
        String act = "";
        String mov = "";
        String star = "";
        List movies = new List();
        List actors = new List();
        String line;
        /**
         * File docu = new File(doc);*
         */
        File docu;
        JFileChooser select = new JFileChooser();
        select.setCurrentDirectory(new File("Test Packages"));
        select.setDialogTitle("Seleccione el archivo con la información de las películas...");
        if (select.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            docu = select.getSelectedFile();
            try {
                if (!docu.exists()) {
                    docu.createNewFile();
                } else {
                    FileReader fr = new FileReader(docu);
                    BufferedReader br = new BufferedReader(fr);
                    while ((line = br.readLine()) != null) {
                        if (!line.isEmpty()) {
                            mov += line + "\n";

                        }
                    }
                    if (!"".equals(mov)) {
                        String[] movi = mov.split("\n");
                        for (String movi1 : movi) {
                            if (!movi1.equals("id,title,year")) {
                                String[] data = movi1.split(",");
                                movies.append(Integer.parseInt(data[0]), data[1], Integer.parseInt(data[2]));
                            }
                        }
                        fr.close();
                        br.close();

                    }
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error while reading");
            }
        }
        select = new JFileChooser();
        select.setCurrentDirectory(new File("Test Packages"));
        select.setDialogTitle("Seleccione el archivo con la información de los actores...");
        if (select.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            docu = select.getSelectedFile();
            try {
                if (!docu.exists()) {
                    docu.createNewFile();
                } else {
                    BufferedReader br;
                    try (FileReader fr = new FileReader(docu)) {
                        br = new BufferedReader(fr);
                        while ((line = br.readLine()) != null) {
                            if (!line.isEmpty()) {
                                act += line + "\n";

                            }
                        }
                        if (!"".equals(act)) {
                            String[] acto = act.split("\n");
                            for (String acto1 : acto) {
                                if (!acto1.equals("id,name,birth")) {
                                    String[] data = acto1.split(",");
                                    actors.append(Integer.parseInt(data[0]), data[1], Integer.parseInt(data[2]));
                                }
                            }
                        }
                    }
                    br.close();

                }
            } catch (IOException | NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error while reading");
            }
        }
        select = new JFileChooser();
        select.setCurrentDirectory(new File("Test Packages"));
        select.setDialogTitle("Seleccione el archivo con la información la participación de actores en películas...");
        if (select.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            docu = select.getSelectedFile();
        try {
            if (!docu.exists()) {
                docu.createNewFile();
            } else {
                BufferedReader br;
                try (FileReader fr = new FileReader(docu)) {
                    br = new BufferedReader(fr);
                    while ((line = br.readLine()) != null) {
                        if (!line.isEmpty()) {
                            star += line + "\n";

                        }
                    }
                    if (!"".equals(star)) {
                        String[] str = star.split("\n");
                        for (String str1 : str) {
                            if (!str1.equals("person_id,movie_id")) {
                                String[] data = str1.split(",");
                                Nodo starring = actors.searchId(Integer.parseInt(data[0]));
                                String[] peli = (movies.searchId(Integer.parseInt(data[1]))).getData().split(", ");
                                starring.addEdge(Integer.parseInt(peli[0]), peli[1], Integer.parseInt(peli[2]));
                            }
                        }
                    }
                }
                br.close();

            }
        } catch (IOException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error while reading");
        }
        }
        Grafo grafo = new Grafo(actors);
        return grafo;
    }

}
