/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg;


import static rpg.RPG.DR;
import static rpg.RPG.dogs;
import static rpg.RPG.showText;
import static rpg.RPG.skipText;
import static rpg.RPG.startGame;
import static rpg.courtYard.userInput;
import static rpg.courtYard.userReader;
import static rpg.eastCorridor.eastCorridor;


/**
 *
 * @author lynne
 */
public class diningRoom {
    public static int i=0;//counts how many switches were flipped
    public static int[] switchArray = new int[6]; //records switches
    private static boolean switches;
    private static String gameArea;
    public static void diningRoom(Boolean skip){
        gameArea=DR;
        
        if(dogs==true){
            System.out.println("This is a dead end.\nThe dogs quickly catch up to you and tear you to shreds, eating you alive.\nYou have died.\nRestarting game.\n");
            startGame();                       
        }
        if(skip==false){
            System.out.println("There is a large dinner table in the center of the room.\nOn the southern end of the wall there is a series of switches.");
        }
        System.out.println("\nLocation: "+gameArea);
        System.out.println("\nChoose where to go");
        System.out.println("-------------------------\n");
        System.out.println("1. Switches");
        System.out.println("2. Hallway");

        
        userInput = userReader.nextInt();
        switch (userInput){
            case 1:
                switches(showText);
                break;
            case 2:
                eastCorridor(skipText);
                break;
            default:
                System.out.println("Invalid Option.");
                diningRoom(skipText);
        }       
    }
    //Enter a series of numbers sequentially, ,
    public static void switches(Boolean skip){
        
        if(switches==true){
            System.out.println("The switches remain flipped up.\nThere is nothing else of interest here.");
            diningRoom(skipText);
        }
        
        
        //six switches, this order: FIRST THIRD FIFTH SECOND SIXTH FOURTH
        if(skip==false && switches == false){
        System.out.println("There are six switches lined up along the wall. \nEach is in the downward 'off' position.\nFlip which switch up? (Choose 1 - 6). Enter '0' to go back.");
        }
        
        //error checking and going back to previous room
        while (!userReader.hasNextInt()) 
        {        
            userReader.next(); // Read and discard offending non-int input
            System.out.println("Choice WAS NOT recorded (Choose from 1 - 6). Enter '0' to go back."); // Re-prompt
        }
        userInput = userReader.nextInt();
        if(userInput==0){
            diningRoom(skipText);
        }
        else if(userInput > 6 || userInput < 1){
            System.out.println("Choice WAS NOT recorded. (Choose from 1 - 6). Enter '0' to go back.");
            switches(skip);
        }        
        
        //add 1 to array size until we hit size 5, record one more input and then we have our sixth switch
        switchArray[i]=userInput;
        if(i<=4){
        
            i++;
        System.out.println("Choice WAS recorded. Choose next digit (from 1 - 6). ");
        switches(skipText);
                
        }
        else{
            System.out.print("You entered: ");
            for(int j = 0; j<=switchArray.length-1;j++){
                System.out.print(switchArray[j]+" ");
                
            }
            if(switchArray[0]==1 && switchArray[1]==3 && switchArray[2]==5 && switchArray[3]==2 && switchArray[4]==6 && switchArray[5]==4){
                System.out.println("\nThat was correct. The wall opens up above the switches. There's something in there.\nIt's a key with a red and silver shield emblem at the base.");
                
                System.out.println("\nShield Key added to inventory.");
                switches=true;
                rpg.RPG.shieldKey=true;                
                diningRoom(skipText);
            }
            else{
                System.out.println("\nThe switches all flip down in unison. Must have been the wrong order.");
                i=0;
                switches(skipText);
                
            }
        }
        
        
        
    }
}
