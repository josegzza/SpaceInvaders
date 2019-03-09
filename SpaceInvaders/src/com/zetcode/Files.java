package com.zetcode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author paulina and josé
 */
public class Files {
private Board game;
    public Files(Board game){
        this.game= game;
    }
    
    //Save game
    public static void saveGame(Shot shot,Player player, ArrayList<Alien> aliens,int deaths){
        
        try {
            PrintWriter printWriter = new PrintWriter(new FileWriter("saveSI.txt")); // creates / open file
            printWriter.println("" + player.getX()+","+player.getY()); // saves player on the txt
            printWriter.println("" + shot.getX()+","+shot.getY()); // saves shot / ball
            printWriter.println("" + (aliens.size())); // saves number of aliens on the txt
            for(int i = 0; i < aliens.size(); i++) {
                printWriter.println("" + aliens.get(i).getX() + "," + aliens.get(i).getY()+","+aliens.get(i).getBomb().getX()+","+aliens.get(i).getBomb().getY()); // saves aliens positions
            }
             //System.out.println("Correct write");
            printWriter.close(); // close file
        } catch (IOException ex) {
            System.out.println("COULDN'T SAVE " + ex.toString());
        }
    }
   
       public static void loadGame(Shot shot,Player player, ArrayList<Alien> aliens,int deaths){
           
           
           FileReader fr = null;
           BufferedReader br = null;
           String line;
        try {
            // loads file where every value of the game was saved
            fr=new FileReader("saveSI.txt"); //Open file
            br = new BufferedReader(fr);
            line = br.readLine(); //Read line by line
            String[] elements = line.split(","); //Split elements with "," and save it in an array
            //Read every value in the file so it can be loaded
            //game.setScore(Integer.parseInt(br.readLine()));
            player.setX(Integer.parseInt(elements[0]));//load player position x
            player.setY(Integer.parseInt(elements[1]));//load player position y
            line = br.readLine(); //Jump line
            elements = line.split(",");
            shot.setVisible(true); //set visible shot
            shot.setX(Integer.parseInt(elements[0])); //shot position X
            shot.setY(Integer.parseInt(elements[1])); //shot position Y
            line = br.readLine(); //jump line
            int alienscounts=Integer.parseInt(line);
            aliens.clear(); //metodo para borrar todo los aliens
            for(int i = 0; i < alienscounts; i++) { //Check brick by brick
                line = br.readLine();
                elements = line.split(","); //Save positions
                int alienX = Integer.parseInt(elements[0]); //load positions
                int alienY = Integer.parseInt(elements[1]); //load positions
                int bombX =Integer.parseInt(elements[2]); //load bomb
                int bombY=Integer.parseInt(elements[3]); //load bomb
                Alien alien = new Alien(alienX,alienY,bombX,bombY);
                aliens.add(alien); //add linkedlist
            }
            //System.out.println("Correct load");
            
        } catch (IOException ex) {
            Logger.getLogger(Files.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}