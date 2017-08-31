/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg;

import static rpg.RPG.showText;
import static rpg.RPG.skipText;
import static rpg.RPG.startGame;
import static rpg.courtYard.userInput;
import static rpg.courtYard.userReader;
import static rpg.elevator.elevator;
import static rpg.greatRoom.greatRoom;
import static rpg.southCorridor.southCorridor;

/**
 *
 * @author lynne
 */
public class westCorridor {
    public static void westCorridor(boolean skip){
        if(skip==false){
            System.out.println("You have reached the end of the western corridor.\nStraight ahead of you is an elevator. To the right, the hallway opens up to a large room.");
        }
        
        System.out.println("\nChoose where to go");
                System.out.println("-------------------------\n");
                System.out.println("1. Elevator");
                System.out.println("2. Great Room");
                System.out.println("3. South Corridor");
                
                userInput = userReader.nextInt();
                switch (userInput){
                    case 1:
                        elevator(showText);
                        break;
                    case 2:
                        greatRoom(showText);
                        break;
                    case 3:
                        southCorridor(skipText);
                        break;  
                    default:
                        System.out.println("Invalid Option.");
                        westCorridor(skipText);                        
                }
    }
}
