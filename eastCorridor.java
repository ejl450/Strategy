/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg;

import static rpg.RPG.showText;
import static rpg.RPG.skipText;
import static rpg.courtYard.userInput;
import static rpg.courtYard.userReader;
import static rpg.diningRoom.diningRoom;
import static rpg.hearthRoom.hearthRoom;
import static rpg.kitchen.kitchen;
import static rpg.southCorridor.southCorridor;

/**
 *
 * @author lynne
 */
public class eastCorridor {
    public static void eastCorridor(boolean skip){
        if(skip==false){
        System.out.println("The hallway continues south for a bit.\nEventually, two rooms become visible. \nOn the east wall is a Kitchen, and southeast is a Dining Room.\nThe hallway continues to the west.");
        }
        
        System.out.println("Choose where to go");
                System.out.println("-------------------------\n");
                System.out.println("1. Kitchen");
                System.out.println("2. Dining Room");
                System.out.println("3. Southern Corridor");
                System.out.println("4. Hearth Room");
                
                userInput = userReader.nextInt();
                switch (userInput){
                    case 1:
                        kitchen(showText);
                        break;
                    case 2:
                        diningRoom(showText);
                        break;
                    case 3:
                        southCorridor(showText);
                        break;  
                    case 4:
                        hearthRoom(skipText);
                        break;
                    default:
                        System.out.println("Invalid Option.");
                        eastCorridor(skipText);
                }
    }
    
}
