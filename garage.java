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
public class garage {
    public static void garage(boolean skip){
        if(skip==false){
        System.out.println("The garage is lit by two rows of four lights evenly spaced across the ceiling.\nOn the right side of the garage door there are four buttons, each with a corresponding garage number.\n"
                + "Along the west side of the room are the four garage doors.\nThe eastern wall has a small metal hatch that looks like it opens downwards.\nBeyond the hatch, there is metal shelving with some "
                + "items littered over it.\nThe southern wall ");
        
        
        System.out.println("Choose where to go");
                System.out.println("-------------------------\n");
                System.out.println("1. Garage Door Buttons");
                System.out.println("2. Garage Doors");
                System.out.println("3. Hatch");
                System.out.println("4. Metal Shelving");
                System.out.println("5. Southern Wall");
                System.out.println("6. Mud Room");
                
                userInput = userReader.nextInt();
                switch (userInput){
                    case 1:
                        garageDoorButtons(showText);
                        break;
                    case 2:
                        garageDoors(showText);
                        break;
                    case 3:
                        garageHatch(showText);
                        break;  
                    case 4:
                        metalShelving(skipText);
                        break;
                    case 5:
                        hearthRoom(skipText);
                        break;
                    default:
                        System.out.println("Invalid Option.");
                        garage(skipText);
                        break;
                }
        }
    }
    

    public static void garageDoorButtons(boolean skip){
        
    }
    
    public static void garageDoors(boolean skip){
        
    }
    
    public static void garageHatch(boolean skip){
        
    }
    
    public static void metalShelving(boolean skip){
        
    }
}
