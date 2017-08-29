/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg;

import static rpg.RPG.shieldKey;
import static rpg.RPG.skipText;
import static rpg.southCorridor.southCorridor;

/**
 *
 * @author lynne
 */
public class shieldRoom {
    public static void shieldRoom(boolean skip){
        if(shieldKey == false){
            System.out.println("The Shield Room, located on the western side of the corridor is the first of the two.\nThe door is locked.\nThere is a red and silver shield emblem engraved in the top center of the door.");
            System.out.println("There is nothing else of interest here.");
            southCorridor(skipText);
        }
        else{
            //shield puzzle - colors from the lab room?
        }
        
    }
}
