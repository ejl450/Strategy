/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static rpg.RPG.Cu;
import static rpg.RPG.Al;
import static rpg.RPG.Au;
import static rpg.RPG.Zn;
import static rpg.RPG.Sn;
import static rpg.RPG.Ni;
import static rpg.RPG.Mg;
import static rpg.RPG.Fe;
import static rpg.RPG.K;
import static rpg.RPG.LR;
import static rpg.RPG.dogs;
import static rpg.RPG.gameArea;
import static rpg.RPG.hammerKey;
import static rpg.RPG.showText;
import static rpg.RPG.skipText;
import static rpg.courtYard.userInput;
import static rpg.courtYard.userReader;
import static rpg.eastCorridor.eastCorridor;
import static rpg.kitchen.freezer;
import static rpg.RPG.metalArray;
import static rpg.RPG.metalArrayMelting;
import static rpg.RPG.metalArrayText;


/**
 *
 * @author lynne
 */
public class kitchen {
    
    private static boolean freezer; //set to true after staying in the freezer being chased by dogs
    //upper and lower bounds of furnace
    private static int highestTemp, lowestTemp;

    public static void kitchen(boolean skip){
        
        gameArea=K;
        if(dogs==true){
        //alternate text to go to empty freezer    
        }
        
        if(skip==false){
            System.out.println("Location: "+gameArea);
            System.out.println("\nThe kitchen is surprisingly bare.\nThe only things lying around are some plastic cups, paper towels, and an empty dish rack.");
            System.out.println("On the northeast corner of the kitchen is a large metal door. It looks like a walk-in freezer.\nIn the center of the south wall is an open doorway.");
        }
            System.out.println("\nChoose where to go");
                System.out.println("-------------------------\n");
                System.out.println("1. Walk-in freezer");
                System.out.println("2. Open doorway");
                System.out.println("3. Eastern corridor");
                userInput = userReader.nextInt();
                switch (userInput){
                    case 1:
                        freezer(showText);
                        break;
                    case 2:
                        labRoom(showText);
                        break;
                    case 3:
                        eastCorridor(skipText);
                        break;
                    default:
                        System.out.println("Invalid Option.");
                        kitchen(skipText);
                }
            
            
        
    }
    public static void freezer(boolean skip){
            if(freezer==true){
                System.out.println("I will not go back in there again.");
                kitchen(skipText);                               
            }else if(dogs==true){
                System.out.println("You forcefully tug the freezer door open and shove yourself inside.\nThe scent of the rotting meat hits you like a truck.");
                System.out.println("The dogs are scratching and jumping at the freezer door from the outside, but it seems like you are safe for now.");
                System.out.println("The putrid rotting meat is too much, you violently throw up and pass out.");
                freezer=true;
                dogs=false;
                
                try {
            Thread.sleep(1000L);
            System.out.println("\n...");
            Thread.sleep(1000L);
            System.out.println("...");
            Thread.sleep(1000L);
            System.out.println("...");
        }   catch (InterruptedException ex) {
                Logger.getLogger(courtYard.class.getName()).log(Level.SEVERE, null, ex);
            }                
                System.out.println("An unknown amount of time passes.");
                System.out.println("Outside of the freezer is quiet. The dogs seem to be gone.\n You open the door into the kitchen. The area is clear.");
                
                kitchen(skipText);
                
            }
            else{
                System.out.println("The freezer door is suctioned shut. With a hard tug, it busts open. Immediately, the smell is nauseating. It's rotting meat.\nYou slam the door shut and walk away.");
                kitchen(skipText); 
            }
        }
    
    public static void labRoom(boolean skip){
        gameArea=LR;
        System.out.println("Location: "+gameArea+"\n");
        if(skip==false){
            //create the hammer key
        System.out.println("It's a relatively small room. It looks like a lab.\nThere is a strong metallic smell emanating from the room.\nThere are various devices and metals on a table at the southern end of the room.");
        }            
        System.out.println("\nChoose where to go");
        System.out.println("-------------------------\n");
        System.out.println("1. Lab Table");
        System.out.println("2. Kitchen");
        userInput = userReader.nextInt();
        switch(userInput){
            
            case 1:
                //Fix this section - moving away from crucible key mix
                //labTable(showText);
                break;
            case 2:
                kitchen(showText);
                break;
            default:
                System.out.println("Invalid Option.");
                labRoom(skipText);        
        }
    }
   
   /* 
    public static void labTable(boolean skip){
        //Switches to true if a metal is chosen at the lab table, lets the user go to the crucible
        Boolean goToCrucible = false;
        
        if(hammerKey==true){
            System.out.println("There's only one key mold here. I don't think I need to use the lab table again.");
            labRoom(skipText);
            return;
        }
        
        

        if(skip==false && hammerKey == false){
        System.out.println("On the left side of the table, there are various metals laid out and labeled in a row. To the right of that is a crucible, an electric furnace, and a metal mold of a key");
        System.out.println("There is a note hanging above the wall, it reads: \n\"1. Put the metals in the crucible\n2. Put the crucible into the furnace, then set the furnace to the correct temperature\n3. Pour the liquid metal into the mold.\"");
        System.out.println("\nHere are the metals, followed by their melting point, from left to right:\n1. Copper (1983 ºF)\n2. Aluminium (1220 ºF)\n3. Gold (1945 ºF)\n4. Zinc (787 ºF)\n5. Tin (449 ºF)\n6. Nickel (2647 ºF)\n7. Magnesium (1200 ºF)\n8. Iron (2100 ºF)");
        System.out.println("Choose which metal to put into the crucible (Choose 1 - 8). Enter '0' to go back. Enter '9' to put the crucible into the furnace.");
        }
        
        //error checking and going back to previous room
        while (!userReader.hasNextInt()) 
        {        
            userReader.next(); // Read and discard offending non-int input
            System.out.println("Choice WAS NOT recorded (Choose from 1 - 8). Enter '0' to go back. Enter '9' to put the crucible into the furnace."); // Re-prompt
        }
        userInput = userReader.nextInt();
        if(userInput==0){
            //set all metals back to false
            for(int k =0;k<=7;k++){
                metalArray[k]=false;
            }
            System.out.println("All metals have been placed back on the table");
            labRoom(skipText);
            return;
        }
        if(userInput > 9 || userInput < 1){
            System.out.println("Choice WAS NOT recorded. (Choose from 1 - 8). Enter '0' to go back. Enter '9' to put the crucible into the furnace.");
            labTable(skipText);
            return;
        }
        //evaluate whether or not to go to crucibleFurnace
        if(userInput == 9){
            //1. Copper 2. Aluminium 3. Gold 4. Zinc 5. Tin 6. Nickel 7. Magnesium 8. Iron
            //check to see if all of the array values are null. If they are, get user to go back to input a metal
            for(int i =0; i<=metalArray.length-1;i++){
                if(metalArray[i]==true){
                    goToCrucible=true;
                }
            }
            
            if(goToCrucible==true){
                
                crucibleFurnace(showText);
                return;
            }
            else{
                System.out.println("No metals selected, choice WAS NOT recorded. (Choose from 1 - 8). Enter '0' to go back. Enter '9' to put the crucible into the furnace.");
                labTable(skipText);
                return;
            }
        }
        else{
            //set the metal to true
            int metalChoice = userInput-1;
            metalArray[metalChoice]=true;
            System.out.println("Choice WAS recorded. Choose which metal to put into the crucible (Choose 1 - 8). Enter '0' to go back. Enter '9' to put the crucible into the furnace.");
            labTable(skipText);
            return;
        }
        
        
    }
    public static void crucibleFurnace(boolean skip){
        //integer array to store the melting temps of the metals
        
        List<Integer> meltingTemps = new ArrayList<Integer>();
        if(skip==false){
            
            //print out selected metals
            System.out.println("The crucible contains (Metal, Melting Point ºF): ");
            for(int j = 0;j<=metalArray.length-1;j++){
                if(metalArray[j]==true){
                    meltingTemps.add(metalArrayMelting[j]);
                    System.out.println(metalArrayText[j]+", "+metalArrayMelting[j]);
                }
            }

            //must set the furnace with a 40 degree range of the highest melting point of the collected metals
            highestTemp = Collections.max(meltingTemps)+20;
            lowestTemp = Collections.max(meltingTemps)-20;
            System.out.println("Enter a temperature (1-3000 ºF). Enter '0' to go back.");
        }
        
        
        //error checking
        while (!userReader.hasNextInt()) 
        {        
            userReader.next(); // Read and discard offending non-int input
            System.out.print("Enter a temperature (1-3000 ºF). Enter '0' to go back."); // Re-prompt
        }          
        userInput = userReader.nextInt();
        
        if(userInput==0){
            labTable(skipText);
            return;
        }
        //error checking
        else if(userInput < 0 || userInput > 3000)
        {
            System.out.println("The temperature selected is outside the range of the machine. Enter a temperature (1-3000 ºF). Enter '0' to go back.");
            crucibleFurnace(skipText);
            return;
        }       
        else if(userInput >= lowestTemp || userInput <= highestTemp){
            
            //metals melt properly, but must make sure that the correct metals are chosen
            labRoom(skipText);
            return;
    }
        else{
            //doesnt work
            System.out.println("asdasd");
            labTable(showText);
            return;
        }        
        
        
    }
    */
    
}
