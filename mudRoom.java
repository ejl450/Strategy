/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg;

import java.util.logging.Level;
import java.util.logging.Logger;
import static rpg.RPG.HR;
import static rpg.RPG.MR;
import static rpg.RPG.crowBar;
import static rpg.RPG.gameArea;
import static rpg.RPG.lighter;
import static rpg.RPG.saveGame;
import static rpg.RPG.showText;
import static rpg.RPG.skipText;
import static rpg.courtYard.carCodeMenu;
import static rpg.courtYard.userInput;
import static rpg.courtYard.courtYardMenu;
import static rpg.courtYard.userReader;
import static rpg.hearthRoom.hearthRoom;
import static rpg.kitchen.kitchen;

/**
 *
 * @author lynne
 */
public class mudRoom {
    public static void mudRoom(boolean skip){
        gameArea=MR;
        if(skip==false){
        System.out.println("The key slides in and the door quietly glides open.");
        System.out.println("I'm in a mud room. There are shoes and jackets hung along the wall.");
        System.out.println("To my left is a large open room. To the right is a dark corridor.\n");        
        }
        System.out.println("Location: "+gameArea+"\n");
        try {
            Thread.sleep(3000L);
        }   catch (InterruptedException ex) {
                Logger.getLogger(courtYard.class.getName()).log(Level.SEVERE, null, ex);
            }
        System.out.println("Choose where to go");
                System.out.println("-------------------------\n");
                System.out.println("1. Dark corridor");
                System.out.println("2. Large open room");
                System.out.println("3. Courtyard");
                
                userInput = userReader.nextInt();
                switch (userInput){
                    case 1:
                        garageDoor(showText);
                        break;
                    case 2:
                        hearthRoom(showText);
                        break;
                    case 3:
                        courtYardMenu(skipText);
                        break;
                    default:
                        System.out.println("Invalid Option.");
                        mudRoom(skipText);
                        break;
                        
                }                       
    }
    public static void garageDoor(boolean skip){
        if(skip == false){
            System.out.println("The corridor leads to a standard sized metal door.");
            System.out.println("There is a number pad to the right of the door knob.");
            System.out.println("The upper center of the door reads \"Our Happy Family\"");
            
             System.out.println("Choose where to go");
                System.out.println("-------------------------\n");
                System.out.println("1. Enter code");
                System.out.println("2. Back to Mud Room");
                
                userInput = userReader.nextInt();
                switch (userInput){
                    case 1:
                        garageDoorCodeMenu(showText);
                        break;
                    case 2:
                       mudRoom(showText);
                        break;
                    default:
                        System.out.println("Invalid Option.");
                        garageDoor(skipText);
                        
                }          
        }
        else{
            //garage door opens 
        }
    }
       public static void garageDoorCodeMenu(boolean skip){
        
        System.out.println("Enter a code (ex: '999'). Enter '0' to go back.");
        //error checking
        while (!userReader.hasNextInt()) 
        {        
            userReader.next(); // Read and discard offending non-int input
            System.out.print("Enter a code (ex: '999'). Enter '0' to go back."); // Re-prompt
        }          
        userInput = userReader.nextInt();
        
        if(userInput==0){
            garageDoor(skipText);
            return;
        }
        //error checking
        else if(userInput < 100 || userInput > 999)
        {
            System.out.println("The numberpad lit up red. The code didn't work.\n");
            carCodeMenu();
            return;
        }       
        else if(userInput == 351){
            //Code is 3 5 1 => figure this out from the paintings in the great room
            System.out.println("The numberpad lit up green and the door opened!");

            courtYardMenu(skipText);
            return;
    }
        else{
            System.out.println("The numberpad lit up red. The code didn't work.\n");
            carCodeMenu();
            return;
        }
        
        
    }
} 

    
   
