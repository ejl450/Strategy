/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg;

import static rpg.RPG.crudeOil;
import static rpg.RPG.garageOpen;
import static rpg.RPG.showText;
import static rpg.RPG.skipText;
import static rpg.RPG.wellDrained;
import static rpg.courtYard.userInput;
import static rpg.courtYard.userReader;
import static rpg.courtYard.courtYardMenu;
import static rpg.diningRoom.diningRoom;
import static rpg.hearthRoom.hearthRoom;
import static rpg.kitchen.kitchen;
import static rpg.mudRoom.mudRoom;
import static rpg.southCorridor.southCorridor;

/**
 *
 * @author lynne
 */
public class garage {
    public static void garage(boolean skip){
        if(skip==false){
        System.out.println("The garage is lit by two rows of four lights evenly spaced across the ceiling.\nOn the right side of the garage door there is an electronic panel.\n"
                + "Along the west side of the room are the four garage doors.\nThe eastern wall has a small metal hatch that looks like it opens downwards.\nBeyond the hatch, there is metal shelving with some "
                + "items littered over it.\nThe southern wall \n");//add a phrase to the southern wall that hints at draining the well so users will connect the well and the hatch        
        }
        
        System.out.println("Choose where to go");
                System.out.println("-------------------------\n");
                System.out.println("1. Electronic Panel");
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
                        metalShelving(showText);
                        break;
                    case 5:
                        garageSouthWall(showText);
                        break;
                    case 6:
                        mudRoom(skipText);
                        break;
                    default:
                        System.out.println("Invalid Option.");
                        garage(skipText);
                        break;
                }        
    }
    

    public static void garageDoorButtons(boolean skip){
        if(skip==false){
            System.out.println("The panel controls the garage doors. There are four buttons, each labeled with a garage door - A01, B02, C03, D04.\nAbove each label is an indicator light. "
                    + "The one above 'A01' is green. The rest are red.\n\nPush the button?\n");
            System.out.println("-------------------------\n");
            System.out.println("1. Yes");
            System.out.println("2. No");
            
            userInput = userReader.nextInt();
                switch (userInput){
                    case 1:
                        pressButton();
                        break;
                    case 2:
                        garage(skipText);
                        break;
                    default:
                        System.out.println("Invalid Option.");
                        garage(skipText);
                        break;
                }
        }
        
        
    }
    
    public static void pressButton(){
        if(garageOpen==false){
            System.out.println("Garage door 'A01' has been opened.\n");
            garageOpen=true;
            garage(skipText);
        }
        if(garageOpen==true){
            System.out.println("Garage door 'A01' has been closed.\n");
            garageOpen=false;
            garage(skipText); 
        }                
    }
    
    public static void garageDoors(boolean skip){
        if(skip==false){
            if(garageOpen==false){
                System.out.println("It's just a closed garage door. I can't open it manually.\nThere is nothing else to see here.");
                garage(skipText);                
            }
            if(garageOpen==true){
                System.out.println("It's an opening to the Courtyard.\nGo through?\n");
                System.out.println("-------------------------\n");
                System.out.println("1. Yes");
                System.out.println("2. No");
            }
            userInput = userReader.nextInt();
            switch (userInput){
                case 1:
                    courtYardMenu(showText);
                    break;
                case 2:
                    garage(skipText);
                    break;
                default:
                    System.out.println("Invalid Option.");
                    garageDoors(skipText);
                    break;
            }
        }
    }
    
    public static void garageHatch(boolean skip){
        if(skip==false){
            
        }
        
        if(wellDrained==false){
            System.out.println("The hatch opens right up but is filled to the brim with water. The top of a ladder is visible through the water.\nIf I drain it I can explore down there."
                    + "\nThere is nothing else to see here.");
            garage(skipText);
        }
        
        if(wellDrained==true){
            //Develop basement level 1
        }
        
        
    }
    
    public static void metalShelving(boolean skip){
        if(skip==false){
            //System.out.println("There are quite a few items ");
        }
        if(crudeOil==false){
            System.out.println("There is a small container of Crude Oil on the middle shelf. This could come in handy, but I'll need to mix it with something for it to be useable.");
            System.out.println("\nAdded the Crude Oil to your inventory.");
            crudeOil=true;
            garage(skipText);
        }
        if(crudeOil==true){
            System.out.println("There are various tubes and beakers scattered around the shelves. It doesn't seem like any of it will be useful.");
            garage(skipText);
        }
        
    }
    
    public static void garageSouthWall(boolean skip){
        
    }
}
