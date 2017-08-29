/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg;

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

/**
 *
 * @author lynne
 */
public class RPG {
    //saved data
    public static String storedID,storedArea;
        //courtyard keys
        public static boolean carCode = false, porchKey = false, carKey = false, crowBar=false;
        
        //hearthroom keys
        public static boolean lighter=false;
        
        //kitchen keys
        public static boolean freezer=false;
        
        //east corridor keys
        public static boolean switches=false;//diningroom
        
        //south corridor keys
        public static boolean dogs=false;
        
        //west corridor keys (subject to change one to hammerKey 2.22.17)
        public static boolean shieldKey=false; public static boolean holyKey=false;
        
        //elevator keys
        public static boolean elevatorFixed=false;
        
        //Kitchen lab key and metals 1. Copper 2. Aluminium 3. Gold 4. Zinc 5. Tin 6. Nickel 7. Magnesium 8. Iron
        public static boolean hammerKey=false;
        public static boolean Cu=false, Al = false, Au = false, Zn = false, Sn = false, Ni = false, Mg = false, Fe = false;
        public static int CuMelt=1983, AlMelt = 1220, AuMelt = 1945, ZnMelt = 787, SnMelt = 449, NiMelt = 2647, MgMelt = 1200, FeMelt = 2100;
        public static String CuText="Copper", AlText = "Aluminium", AuText="Gold", ZnText = "Zinc", SnText="Tin", NiText="Nickel", MgText="Magnesium", FeText="Iron";
        public static Boolean[] metalArray = new Boolean[] {Cu, Al, Au, Zn, Sn, Ni, Mg, Fe};
        public static String[] metalArrayText = new String[] {CuText, AlText, AuText, ZnText, SnText, NiText, MgText, FeText};
        public static int[] metalArrayMelting = new int[] {CuMelt, AlMelt, AuMelt, ZnMelt, SnMelt, NiMelt, MgMelt, FeMelt};
        
        
    
    //live data
    public static String gameID,gameArea;
    public static Boolean skipText=true,showText=false;
    
    //game areas
    public static String CY = "Courtyard", MR = "Mud room", HR ="Hearth Room", DR = "Dining Room", GR = "Great Room", K = "Kitchen", LR="Lab Room";
    


    static void startGame(){

        System.out.println("eRPG v0.1");
        rpg.startMenu.startMenu();

    }
    
    static void loadGame(String ID){
        Properties prop = new Properties();
	InputStream input = null;

	try {
                input = new FileInputStream("config.properties");

		// load a properties file
             
		prop.load(input);

		// get the property value and print it out
           
		if (ID.equals(prop.getProperty("playerID"))){
            
                gameID = prop.getProperty("playerID");
                gameArea = prop.getProperty("gameArea");
                carCode = Boolean.valueOf(prop.getProperty("carCode"));
                carKey = Boolean.valueOf(prop.getProperty("carKey"));
                porchKey = Boolean.valueOf(prop.getProperty("porchKey"));
                crowBar = Boolean.valueOf(prop.getProperty("crowBar"));
                lighter = Boolean.valueOf(prop.getProperty("lighter"));
                switches = Boolean.valueOf(prop.getProperty("switches"));
                dogs = Boolean.valueOf(prop.getProperty("dogs"));
                shieldKey = Boolean.valueOf(prop.getProperty("shieldKey"));
                holyKey = Boolean.valueOf(prop.getProperty("holyKey"));
                freezer = Boolean.valueOf(prop.getProperty("freezer"));
                elevatorFixed = Boolean.valueOf(prop.getProperty("elevatorFixed"));
                }
                else{
                    System.out.println("ID not recognized, try again");
                    startGame();
                }
                //If statements here to put user at last save area
                if(gameArea.equals(CY)){
                rpg.courtYard.courtYardMenu(showText);
                }else if(gameArea.equals(HR)){
                    rpg.hearthRoom.hearthRoom(showText);
                }
                else{
                    System.out.println("Game area not found, loading Courtyard");
                    rpg.courtYard.courtYardMenu(showText);
                }
                
                
                


	} catch (IOException ex) {
		ex.printStackTrace();
	} finally {
		if (input != null) {
			try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
    }
    
    static void saveGame(){
        Properties eProperties = new Properties();
        OutputStream eOutput = null;
        
        try {

		eOutput = new FileOutputStream("config.properties");

		// set the properties value
		eProperties.setProperty("playerID", storedID);
                eProperties.setProperty("gameArea", gameArea);
                eProperties.setProperty("porchKey", String.valueOf(porchKey));
                eProperties.setProperty("carKey", String.valueOf(carKey));
                eProperties.setProperty("carCode", String.valueOf(carCode));
                eProperties.setProperty("crowBar", String.valueOf(crowBar));
                eProperties.setProperty("lighter", String.valueOf(lighter));
                eProperties.setProperty("switches", String.valueOf(switches));
                eProperties.setProperty("dogs", String.valueOf(dogs));
                eProperties.setProperty("holyKey", String.valueOf(holyKey));
                eProperties.setProperty("shieldKey", String.valueOf(shieldKey));
                eProperties.setProperty("freezer", String.valueOf(freezer));
                eProperties.setProperty("elevatorFixed", String.valueOf(elevatorFixed));
		// save properties to project root folder
		eProperties.store(eOutput, null);

	} catch (IOException io) {
		io.printStackTrace();
	} finally {
		if (eOutput != null) {
			try {
				eOutput.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
        
  }

        
        
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        startGame();
    }
    
}
