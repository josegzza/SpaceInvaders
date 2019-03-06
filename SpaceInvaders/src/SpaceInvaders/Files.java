/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpaceInvaders;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author paulina
 */
public class Files {
private Game game;
    public Files(Game game){
        this.game= game;
    }
    void saveGame(){
        try {
            //Creates new file to save the game data
            FileWriter fw = new FileWriter("save.txt");
            //Saves every value of every object in the game
            //fw.write(String.valueOf(game.getScore())+"\n");
            fw.write(String.valueOf(game.getPlayerBar().getX())+"\n");
            fw.write(String.valueOf(game.getPlayerBar().getY())+"\n");
            fw.write(String.valueOf(game.getBreaker().getX())+"\n");
            fw.write(String.valueOf(game.getBreaker().getY())+"\n");
            fw.write(String.valueOf(game.getBreaker().getVelX())+"\n");
            fw.write(String.valueOf(game.getBreaker().getVelY())+"\n");
            for(int i=0; i<game.getBrickSpace(); i++){
                fw.write(String.valueOf(game.getBricks().get(i).getX()) +"\n");
                fw.write(String.valueOf(game.getBricks().get(i).getY()) +"\n");
                
                // fw.write(String.valueOf(game.getBricks().get(i).isDead()) +"\n");
            }         
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(Files.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
       void loadGame(){
        try {
            //Loads file where every value of the game was saved
            BufferedReader br = new BufferedReader(new FileReader("save.txt"));
            //Read every value in the file so it can be loaded
            //game.setScore(Integer.parseInt(br.readLine()));
            game.getPlayerBar().setX(Integer.parseInt(br.readLine()));
            game.getPlayerBar().setY(Integer.parseInt(br.readLine()));
            game.getBreaker().setX(Integer.parseInt(br.readLine()));
            game.getBreaker().setY(Integer.parseInt(br.readLine()));
            game.getBreaker().setVelX(Integer.parseInt(br.readLine()));
            game.getBreaker().setVelY(Integer.parseInt(br.readLine()));
            for(int i=0; i<game.getBrickSpace(); i++){
                game.getBricks().get(i).setX(Integer.parseInt(br.readLine()));
                game.getBricks().get(i).setY(Integer.parseInt(br.readLine()));
                // game.getBricks().get(i).remove(Boolean.parseBoolean((br.readLine())));
            }
            br.close();

        } catch (IOException ex) {
            Logger.getLogger(Files.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}