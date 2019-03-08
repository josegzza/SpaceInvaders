/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zetcode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author pepe_
 */
public class Files {
    String fileName="Demo.txt";
    Player player;
    public Files() {
    }
    
    public void readFile(){
        File file;
        try{
            file=new File(fileName);
            if(file.createNewFile()){
                System.out.println("Se ha creado el archivo");
            }
        } catch(IOException e){
            System.err.println("No se ha podido crear archivo");
        }
    }
    
    //Save variables on a txt
     public void saveFile() throws IOException {
                                                          
                PrintWriter fileOut = new PrintWriter(new FileWriter(fileName));
                /*for (int i = 0; i < vec.size(); i++) {

                    Puntaje x;
                    x = (Puntaje) vec.get(i);
                    fileOut.println(x.toString());
                }*/
                //fileOut.println("prueba01");
                fileOut.println("1000");
                System.out.println("Correct write");
                fileOut.close();
     }
     public void loadFile(Player player) throws IOException {
                                                          
                BufferedReader fileIn;
                try {
                        fileIn = new BufferedReader(new FileReader(fileName));
                } catch (FileNotFoundException e){
                        //File puntos = new File(fileName);
                        //PrintWriter fileOut = new PrintWriter(puntos);
                        //fileOut.println("100,demo");
                        //fileOut.close();
                        fileIn = new BufferedReader(new FileReader(fileName));
                }
                String dato = fileIn.readLine();
                
                while(dato != null) {  
                                                        
                      /*arr = dato.split(",");
                      int num = (Integer.parseInt(arr[0]));
                      String nom = arr[1];
                      vec.add(new Puntaje(nom,num));*/
                      int num = Integer.parseInt(dato);
                      System.out.println(dato);
                      player.setX(num);
                      dato = fileIn.readLine();
                }
                fileIn.close();
        }

}