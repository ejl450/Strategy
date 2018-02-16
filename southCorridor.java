/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg;

import static rpg.RPG.dogs;
import static rpg.RPG.freezer;
import static rpg.RPG.showText;
import static rpg.RPG.skipText;
import static rpg.RPG.startGame;
import static rpg.courtYard.userInput;
import static rpg.courtYard.userReader;
import static rpg.diningRoom.diningRoom;
import static rpg.eastCorridor.eastCorridor;
import static rpg.hearthRoom.hearthRoom;
import static rpg.holyRoom.holyRoom;
import static rpg.shieldRoom.shieldRoom;
import static rpg.westCorridor.westCorridor;
import static rpg.kitchen.kitchen;

/**
 *
 * @author lynne
 */
public class southCorridor {
    public static void southCorridor(boolean skip){
        
        if(dogs==true && freezer==false){
         System.out.println("A window along the south wall violently shatters open. Two feral dogs have jumped through. They look vicious.\n");
         //dogs=true;
         
         System.out.println("\nChoose where to go");
                System.out.println("-------------------------\n");
                System.out.println("1. Charge through");
                System.out.println("2. Dining Room");
                System.out.println("3. Kitchen");
                System.out.println("4. Hearth Room");
                
                userInput = userReader.nextInt();
                switch (userInput){
                    case 1:
                        System.out.println("The dogs tear you to shreds, eating you alive.\nYou have died.\nRestarting game.\n");
                        startGame();
                        break;
                    case 2:
                        diningRoom(skipText);
                        break;
                    case 3:
                        kitchen(skipText);
                        break;  
                    case 4:
                        hearthRoom(skipText);
                        break;
                    default:
                        System.out.println("Invalid Option.");
                        southCorridor(skipText);
                        
                }
    
        }
        if(skip==false){
        System.out.println("\nThe corridor continues west.\nWhere the hallway meets the Western Corridor two more rooms become visible. They look like standard bedrooms. The doors are closed.");
        }
        
        System.out.println("\nChoose where to go");
                System.out.println("-------------------------\n");
                System.out.println("1. Cross Room");
                System.out.println("2. Shield Room");
                System.out.println("3. West Corridor");
                System.out.println("4. East Corridor");
                
                userInput = userReader.nextInt();
                switch (userInput){
                    case 1:
                        holyRoom(showText);
                        break;
                    case 2:
                        shieldRoom(showText);
                        break;
                    case 3:
                        westCorridor(showText);
                        break;  
                    case 4:
                        eastCorridor(skipText);
                        break;
                    default:
                        System.out.println("Invalid Option.");
                        southCorridor(skipText);
                        
                }
    }
    
}
