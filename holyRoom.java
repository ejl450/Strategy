/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg;

import static rpg.RPG.holyKey;
import static rpg.RPG.skipText;
import static rpg.southCorridor.southCorridor;

/**
 *
 * @author lynne
 */
public class holyRoom {
    public static void holyRoom(boolean skip){
        if(holyKey==false){
            System.out.println("The door is locked.\nThere is a golden cross emblem engraved in the top center of the door.");
            System.out.println("There is nothing else of interest here.");
            southCorridor(skipText);
        }
        else{
            //holy room puzzle
        }
    }
}
