
package rpg;

import java.util.Optional;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import static rpg.RPG.CY;
import static rpg.RPG.crowBar;
import static rpg.RPG.gameArea;
import static rpg.RPG.showText;
import static rpg.RPG.skipText;
import static rpg.startMenu.loadGameMenu;
import static rpg.startMenu.menuInput;
import static rpg.startMenu.newGameMenu;

/**
 *
 * @author lynne
 */
public class courtYard {
    public static Scanner userReader = new Scanner(System.in);
    public static int userInput;
    
    
        public static void courtYardMenu(Boolean skip){
        
        gameArea=CY;
        
        try {
            Thread.sleep(3000L);
        }   catch (InterruptedException ex) {
                Logger.getLogger(courtYard.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        if(skip==false){       
            System.out.println("It's dark. There's something outside the courtyard making a low growling noise.");
            System.out.println("Straight ahead is the porch door to the house, about 50 yards.");
            System.out.println("There's a sedan on the left side of the courtyard, equidistant from the porch and the exit gate.");
            System.out.println("To the right is a four car garage.\n");
        }
        
        System.out.println("Location: "+gameArea);
        System.out.println("\nChoose where to go");
        System.out.println("-------------------------\n");
        System.out.println("1. Vehicle");
        System.out.println("2. Porch");
        System.out.println("3. Garage");
        System.out.println("4. Save Game");
        
        userInput = userReader.nextInt();
        switch (userInput){
            case 1:
                carMenu(showText);
                break;
            case 2:
                porchMenu();
                break;
            case 3:
                garageMenu();
                break;
            case 4:
                System.out.println("Saving...");
                rpg.RPG.saveGame();              
                System.out.println("Game saved!\n");
                courtYardMenu(skipText);
                break;
            default:
                System.out.println("Invalid Option.");
                courtYardMenu(skipText);
                break;
        }
        
      
 
    }
      public static void carMenu(boolean skip){
            if(rpg.RPG.carCode == false ){
                if(skip==false){
                    System.out.println("It's a Bentley. Looks pristine. There's a number pad on the driver side door. It's probably a four digit code.");
                    System.out.println("There is a small American flag embedded on the rear passenger side door. In the blue square it has only 13 stars, in a circular pattern.");
                    System.out.println("The license plate reads 'AD-AGGF'.\n");
                }
                
                System.out.println("Choose where to go");
                System.out.println("-------------------------\n");
                System.out.println("1. Enter code");
                System.out.println("2. Back to Courtyard");
                userInput = userReader.nextInt();
                switch (userInput){
                    case 1:
                        carCodeMenu();
                        break;
                    case 2:
                        courtYardMenu(skipText);
                        break;
                    default:
                        System.out.println("Invalid Option.");
                        carMenu(skipText);
                        break;
                }                       
            }
            else if(rpg.RPG.carKey==false && rpg.RPG.carCode==true){
                System.out.println("I might be able to get out of here if I can find the key to this car...\n");
                courtYardMenu(skipText);
                return;
            }
            else if(rpg.RPG.carKey==true){
                System.out.println("END GAME?");
            }
            else{
                //error checking
                courtYardMenu(skipText);
                return;
            }
        }
      
    public static void porchMenu(){
           if(rpg.RPG.porchKey == false){
               System.out.println("The porch is dimly lit by a lamp inside the house.");
               System.out.println("The screen door opens, but behind it is another door, locked.");
               System.out.println("Above the door is the phrase 'INDEPENDENCE'.");
               System.out.println("There's nothing else of interest here.\n");

               courtYardMenu(skipText);
               return;
           }
           else{
                rpg.mudRoom.mudRoom(showText);
                return;
           }
        }
    
    public static void garageMenu(){
        if(crowBar==false){
               System.out.println("There are four large garage doors. Each is marked with a letter and a its corresponding number.");
               System.out.println("From left to right they read: 'A01', 'B02', 'C03', 'D04'.\n");
               System.out.println("The garage doors are sealed shut. There are no handles on any of the doors. There is no way to get leverage to try to open them with your hands.\n");
               System.out.println("There is nothing else of interest here.\n");
               

               courtYardMenu(skipText);
               return;
        }
        else{
            System.out.println("Go into garage");
        }
    }
    
    public static void carCodeMenu(){
        
        System.out.println("Enter a code (ex: '9999'). Enter '0' to go back.");
        //error checking
        while (!userReader.hasNextInt()) 
        {        
            userReader.next(); // Read and discard offending non-int input
            System.out.println("Enter a code (ex: '9999'). Enter '0' to go back."); // Re-prompt
        }          
        userInput = userReader.nextInt();
        
        if(userInput==0){
            carMenu(skipText);
            return;
        }
        //error checking
        else if(userInput < 1000 || userInput > 9999)
        {
            System.out.println("Probably has to be a four digit code..");
            carCodeMenu();
            return;
        }       
        else if(userInput == 1776){
            System.out.println("The numberpad lit up green and the door opened!");
            System.out.println("There's a key in center console. It's pretty small, maybe for a backdoor?");
            //System.out.println("On the visor there's a garage door button. It's not working, but it looks like a  ."); 
            System.out.println("I might be able to get out of here if I can find the key to this car...");
            
            System.out.println("\nAdded the porch key to your inventory.");
            rpg.RPG.porchKey = true;
            rpg.RPG.carCode = true;
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
