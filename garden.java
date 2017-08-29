/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg;

import static rpg.RPG.showText;
import static rpg.RPG.skipText;
import static rpg.RPG.wellDrained;
import static rpg.courtYard.userInput;
import static rpg.courtYard.userReader;
import static rpg.diningRoom.diningRoom;
import static rpg.eastCorridor.eastCorridor;
import static rpg.hearthRoom.hearthRoom;
import static rpg.kitchen.kitchen;
import static rpg.southCorridor.southCorridor;
import static rpg.westCorridor.westCorridor;

/**
 *
 * @author Chris
 */
public class garden {
    public static void garden(boolean skip){
        if(skip==false){
        System.out.println("This is the first sentence of the Garden.");
        }
        
        System.out.println("Choose where to go");
                System.out.println("-------------------------\n");
                System.out.println("1. Greenhouse");
                System.out.println("2. Well");
                System.out.println("3. Western Corridor");
                
                userInput = userReader.nextInt();
                switch (userInput){
                    case 1:
                        greenHouse(showText);
                        break;
                    case 2:
                        well(showText);
                        break;
                    case 3:
                        westCorridor(showText);
                        break;  
                    default:
                        System.out.println("Invalid Option.");
                        garden(skipText);
                }
    }
    
    public static void greenHouse(boolean skip) {
        
    }
    
    public static void well(boolean skip) {
        if(wellDrained==false){
            System.out.println("the well is full and needs to be drained later in game");
            garden(skipText);
        }
        
        else{
            //here is what happens when the well is drained
        }
    }
    
}
