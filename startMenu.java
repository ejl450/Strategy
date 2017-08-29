/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg;

import java.util.Scanner;
import static rpg.RPG.gameID;
import static rpg.RPG.storedID;
import static rpg.RPG.gameArea;
import static rpg.RPG.showText;

/**
 *
 * @author lynne
 */
public class startMenu {
    
    public static int menuInput;
    public static String newID;
    public static void startMenu(){
        Scanner startReader = new Scanner(System.in);
        System.out.println("Choose a number below");
        System.out.println("-------------------------\n");
        System.out.println("1. New Game");
        System.out.println("2. Load Game");
        System.out.println("3. Quit");

        menuInput = startReader.nextInt();
        switch (menuInput){
            case 1:
                newGameMenu();
                break;
            case 2:
                loadGameMenu();
                break;
            case 3:
                System.out.println("Guten tag, fraulein");
                System.exit(0);
            default:
                        System.out.println("Invalid Option.");
                        startMenu();
                        
        }
        
    }
    
    public static void newGameMenu(){
        Scanner newReader = new Scanner(System.in);
        System.out.print("Enter an alphanumeric user ID: ");
        newID = newReader.next();
        System.out.println("Ok, you " +newID+" fam");
        gameID=newID;   
        storedID=newID;

        
        System.out.println("Initial Story");
        rpg.courtYard.courtYardMenu(showText);
    }
    
    public static void loadGameMenu(){
        Scanner newReader = new Scanner(System.in);
        System.out.print("Enter your alphanumeric user ID: ");
        newID = newReader.next();
        rpg.RPG.loadGame(newID);
        
    }
    

}
