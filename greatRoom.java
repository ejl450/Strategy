/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg;

import java.util.logging.Level;
import java.util.logging.Logger;
import static rpg.RPG.GR;
import static rpg.RPG.HR;
import static rpg.RPG.gameArea;
import static rpg.RPG.showText;
import static rpg.RPG.skipText;
import static rpg.courtYard.userInput;
import static rpg.courtYard.userReader;
import static rpg.eastCorridor.eastCorridor;
import static rpg.hearthRoom.firePlace;
import static rpg.hearthRoom.hearthDesk;
import static rpg.mudRoom.mudRoom;
import static rpg.westCorridor.westCorridor;

/**
 *
 * @author lynne
 */
public class greatRoom {
    public static void greatRoom(boolean skip){
        
        try {
            Thread.sleep(3000L);
        }   catch (InterruptedException ex) {
                Logger.getLogger(courtYard.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        if(skip == false){
        System.out.println("\nIt's a great room");
        }
        gameArea=GR;
        System.out.println("\nLocation: "+gameArea+"\n");
        System.out.println("Choose where to go");
                System.out.println("-------------------------\n");
                System.out.println("1. Enclosed Porch");
                System.out.println("2. Table");
                System.out.println("3. Southern Wall");
                System.out.println("4. Western Corridor");
                System.out.println("5. Save game");
                
                userInput = userReader.nextInt();
                switch (userInput){
                    case 1:
                        //porch();
                        break;
                    case 2:
                        labTable(showText);
                        break;
                    case 3:
                        southWall(showText);
                        break;  
                    case 4:
                        westCorridor(skipText);
                        break;
                    case 5:
                        System.out.println("Saving...");
                        rpg.RPG.saveGame();
                        
                        System.out.println("Game saved!\n");
                        greatRoom(skipText);
                        break;
                    default:
                        System.out.println("Invalid Option.");
                        greatRoom(skipText);
                }
    }

    private static void labTable(boolean skip) {
        System.out.println("There is an arrangement of test tubes and beakers.");
    }
    
    private static void southWall(boolean skip) {
        System.out.println("There are three large paintings along the wall.\nAbove them is a large plaque with the phrase \"Our Happy Family\".\nThe leftmost painting is of a young adult couple. They are dressed well and smiling. Far behind them in the distance is a silhouette of a human-looking being.");
        System.out.println("The painting in the center depicts four children playing around a tire swing in a wooded area. The same silhouette sits on a branch atop a tree near the children.");
        System.out.println("The final painting is of a large two-story house on a dark day. It's difficult to see, but it looks like the silhouette is looking out of an upstairs window.");
    }
  }
