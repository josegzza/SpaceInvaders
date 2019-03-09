package com.zetcode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
            printWriter.println("" + (aliens.size()-(deaths))); // saves number of aliens on the txt
            for(int i = 0; i < aliens.size()-deaths; i++) {
                printWriter.println("" + aliens.get(i).getX() + "," + aliens.get(i).getY()+","+aliens.get(i).getBomb().getX()+","+aliens.get(i).getBomb().getY()); // saves aliens positions
            }
             //System.out.println("Correct write");
            printWriter.close(); // close file
        } catch (IOException ex) {
            System.out.println("COULDN'T SAVE " + ex.toString());
        }
    }
    
    /*
       public static void loadGame(Board game){
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
            game.getPlayerBar().setX(Integer.parseInt(elements[0])); //load position bar //Player position X
            game.getPlayerBar().setY(Integer.parseInt(elements[1])); //load position bar //Player position y
            
            // to read breaker status
            line = br.readLine();
            elements = line.split(",");
            game.getBreaker().setX(Integer.parseInt(elements[0])); //load position of breaker //shot position X
            game.getBreaker().setY(Integer.parseInt(elements[1])); //load position of breaker //shot position Y
                
            // read bricks status
            line = br.readLine();
            
            int contBricks = Integer.parseInt(line); //Save the size of bricks
            game.getBricks().clear(); //metodo para borrar todo los aliens
            for(int i = 0; i < contBricks; i++) { //Check brick by brick
                line = br.readLine();
                elements = line.split(","); //Save positions
                int x = Integer.parseInt(elements[0]); //load positions
                int y = Integer.parseInt(elements[1]); //load positions
                Brick brick = new Brick(x, y, game); //create bricks with the saved positions
                game.getBricks().add(brick); //add linkedlist
            }
            
            //System.out.println("Correct load");

        } catch (IOException ex) {
            Logger.getLogger(Files.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
*/
}