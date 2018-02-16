/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg;

import java.util.logging.Level;
import java.util.logging.Logger;
import static rpg.RPG.HR;
import static rpg.RPG.gameArea;
import static rpg.RPG.lighter;
import static rpg.RPG.showText;
import static rpg.RPG.skipText;
import static rpg.courtYard.userInput;
import static rpg.courtYard.userReader;
import static rpg.diningRoom.diningRoom;
import static rpg.eastCorridor.eastCorridor;
import static rpg.kitchen.kitchen;
import static rpg.mudRoom.mudRoom;

/**
 *
 * @author lynne
 */
public class hearthRoom {
        public static void hearthRoom(Boolean skip){
        try {
            Thread.sleep(3000L);
        }   catch (InterruptedException ex) {
                Logger.getLogger(courtYard.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        if(skip == false){
        System.out.println("\nIt's a large Hearth room. There's a fireplace on the north side wall.");       
        System.out.println("Along the west wall is a desk with a type writer on it.");
        System.out.println("To the south is a hallway.");
        }
        gameArea=HR;
        System.out.println("\nLocation: "+gameArea+"\n");
        System.out.println("Choose where to go");
                System.out.println("-------------------------\n");
                System.out.println("1. Fireplace");
                System.out.println("2. Desk");
                System.out.println("3. Eastern Corridor");
                System.out.println("4. Mud room");
                System.out.println("5. Save game");
                
                userInput = userReader.nextInt();
                switch (userInput){
                    case 1:
                        firePlace();
                        break;
                    case 2:
                        hearthDesk();
                        break;
                    case 3:
                        eastCorridor(showText);
                        break;  
                    case 4:
                        mudRoom(skipText);
                        break;
                    case 5:
                        System.out.println("Saving...");
                        rpg.RPG.saveGame();
                        
                        System.out.println("Game saved!\n");
                        hearthRoom(skipText);
                        break;
                    default:
                        System.out.println("Invalid Option.");
                        hearthRoom(skipText);
                }
    }
    
    public static void firePlace(){
        if(lighter==false){
            System.out.println("The fireplace hasn't been used recently, but it does have wood in it.");
            System.out.println("Above it is a large black plaque. It's blank.");
            System.out.println("There is nothing else of interest here");
            hearthRoom(skipText);
        }else{
            System.out.println("I lit the fire.\n The plaque has changed. It now reads 'SVEFG GUVEQ SVSGU FRPBAQ FVKGU SBHEGU'.");
            hearthRoom(skipText);
        }
    }
    
    public static void hearthDesk(){//six switches, this order: FIRST THIRD FIFTH SECOND SIXTH FOURTH
        //System.out.println("The desk has a typewriter on it.\nThe typewriter has a piece of paper in its slot. It has a single line of text. It reads 'SVEFG GUVEQ SVSGU FRPBAQ FVKGU SBHEGU'");//ROT13 encrypted text
        System.out.println("The desk has a typewriter on it.\nThe typewriter has a piece of paper in its slot with the following written on it:");
        System.out.println("ENCRYPTION 101 - Substitution Ciphers\nROT13 - A cipher that replaces a letter with the letter 13 places after it in the alphabet.\n" +
"Keyword Substitution - Choose a keyword and remove all spaces and repeated letters in it. Then replace the start of the alphabet with the keyword and the end of the cipher alphabet is the rest"
                + "of the alphabet without repeating letters in the keyword.");
        System.out.println("There is nothing else of interest here");
        hearthRoom(skipText);
        
    }
    
}
