/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg;

import static rpg.RPG.elevatorFixed;
import static rpg.RPG.skipText;
import static rpg.westCorridor.westCorridor;

/**
 *
 * @author lynne
 */
public class elevator {
    public static void elevator(boolean skip){
        
        if(elevatorFixed==false){
        System.out.println("After pressing the elevator button, a message pops up: 'Error 303: Check Control Room for detailed message'");
        westCorridor(skipText);
        }
        else{
            //next stage
        }
    }
}
