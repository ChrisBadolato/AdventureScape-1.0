/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventurescape;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 *
 * @author Chris Badolato
 */
public class FXMLDocumentController implements Initializable {
    
    
    Hero playerHero = new Hero(0,0,0,0,0,0);
    Weapon playerWeapon = new Weapon("","",0,0,0,0,0);
    Offhand playerOffhand = new Offhand("","",0,0,0,0,0);
    Helmet playerHelmet = new Helmet("","",0,0,0,0,0);
    Chest playerChest = new Chest("","",0,0,0,0,0);
    Legs playerLegs = new Legs("","",0,0,0,0,0);
    Boots playerBoots = new Boots("","",0,0,0,0,0);
    
    File newImage;
    
    
    @FXML
    private Button startButton;
    @FXML
    private CheckBox wizardCheck;
    @FXML
    private CheckBox warriorCheck;
    @FXML
    private CheckBox rangerCheck;
    
    private void handleButtonAction(ActionEvent event) {
            
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO   
    }   

    public Hero startHero(){                                     
        if(wizardCheck.isSelected() == true){
            Wizard newWizard = new Wizard(100,100,10,20,10,1);
            playerWeapon = new Weapon("Weapon","src\\gearPictures\\woodStaff.png",0,0,0,0,0);
            playerOffhand = new Offhand("Offhand","src\\gearPictures\\mageOffhand.png",0,0,0,0,0);
            playerHelmet = new Helmet("Helmet","src\\gearPictures\\mageHat.png",0,0,0,0,0);
            playerChest = new Chest("Chest","src\\gearPictures\\mageTunic.png",0,0,0,0,0);
            playerLegs = new Legs("Legs","src\\gearPictures\\magePants.png",0,0,0,0,0);
            playerBoots = new Boots("Boots","src\\gearPictures\\leatherBoots.png",0,0,0,0,0);
            return newWizard;
        }
        else if(warriorCheck.isSelected() == true){
            Warrior newWarrior = new Warrior(100,100,20,10,10,2);
            playerWeapon = new Weapon("Weapon","",0,0,0,0,0);
            playerOffhand = new Offhand("Offhand","",0,0,0,0,0);
            playerHelmet = new Helmet("Helmet","",0,0,0,0,0);
            playerChest = new Chest("Chest","",0,0,0,0,0);
            playerLegs = new Legs("Legs","",0,0,0,0,0);
            playerBoots = new Boots("Boots","",0,0,0,0,0); 
            return newWarrior;
        }
        else if(rangerCheck.isSelected() == true){
            Ranger newRanger = new Ranger(100,100,10,10,20,3);
            playerWeapon = new Weapon("Weapon","",0,0,0,0,0);
            playerOffhand = new Offhand("Offhand","",0,0,0,0,0);
            playerHelmet = new Helmet("Helmet","",0,0,0,0,0);
            playerChest = new Chest("Chest","",0,0,0,0,0);
            playerLegs = new Legs("Legs","",0,0,0,0,0);
            playerBoots = new Boots("Boots","",0,0,0,0,0);  
            return newRanger;
        }
        else{
            System.out.print("Select a Hero");
            return null;
        }        
    }

    @FXML
    private void startButton(MouseEvent event) throws IOException {
        playerHero = startHero();  
        writeHeroToFile();
        
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("adventure.fxml"));
        loader.load();            
            //loads fxml
        Parent nextMenuParent = loader.getRoot();
            //set the scene and stage from that loader.
        Scene nextMenuScene = new Scene(nextMenuParent);
        Stage nextMenuStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        nextMenuStage.setScene(nextMenuScene);
            //show the selected menu
        nextMenuStage.show();
    }
    
    public void writeHeroToFile() throws IOException{ 
        try (PrintWriter writer = new PrintWriter("src\\adventureScape\\heroGearAndStats.txt", "UTF-8")) {                       
            //print hero stats to file
            writer.println(playerHero.stamina);
            writer.println(playerHero.mana);
            writer.println(playerHero.strength);
            writer.println(playerHero.intellegence);
            writer.println(playerHero.agility);
            writer.println(playerHero.type);
            
            //Print Weapon stats to file
            writer.println(playerWeapon.name);
            writer.println(playerWeapon.imageFile);
            writer.println(playerWeapon.stamina);
            writer.println(playerWeapon.mana);
            writer.println(playerWeapon.strength);
            writer.println(playerWeapon.intellegence);
            writer.println(playerWeapon.agility);
            
            //Print Offhand stats to file
            writer.println(playerOffhand.name);
            writer.println(playerOffhand.imageFile);
            writer.println(playerOffhand.stamina);
            writer.println(playerOffhand.mana);
            writer.println(playerOffhand.strength);
            writer.println(playerOffhand.intellegence);
            writer.println(playerOffhand.agility);
                       
            //Print helmet stats to file
            writer.println(playerHelmet.name);
            writer.println(playerHelmet.imageFile);
            writer.println(playerHelmet.stamina);
            writer.println(playerHelmet.mana);
            writer.println(playerHelmet.strength);
            writer.println(playerHelmet.intellegence);
            writer.println(playerHelmet.agility);
            
            //Print chest stats to file
            writer.println(playerChest.name);
            writer.println(playerChest.imageFile);
            writer.println(playerChest.stamina);
            writer.println(playerChest.mana);
            writer.println(playerChest.strength);
            writer.println(playerChest.intellegence);
            writer.println(playerChest.agility);
            
            //print legs stats to file
            writer.println(playerLegs.name);
            writer.println(playerLegs.imageFile);
            writer.println(playerLegs.stamina);
            writer.println(playerLegs.mana);
            writer.println(playerLegs.strength);
            writer.println(playerLegs.intellegence);
            writer.println(playerLegs.agility);
            
            //print boots stats to file
            writer.println(playerBoots.name );
            writer.println(playerBoots.imageFile);
            writer.println(playerBoots.stamina);
            writer.println(playerBoots.mana);
            writer.println(playerBoots.strength);
            writer.println(playerBoots.intellegence);
            writer.println(playerBoots.agility);           
        }
    }
}    

