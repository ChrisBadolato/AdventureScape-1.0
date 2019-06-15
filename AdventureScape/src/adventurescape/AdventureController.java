/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventurescape;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

/**
 * FXML Controller class
 *
 * @author Chris Badolato
 */
public class AdventureController implements Initializable {

    Hero playerHero = new Hero(0,0,0,0,0,0);
    Weapon playerWeapon = new Weapon("","",0,0,0,0,0);
    Offhand playerOffhand = new Offhand("","",0,0,0,0,0);
    Helmet playerHelmet = new Helmet("","",0,0,0,0,0);
    Chest playerChest = new Chest("","",0,0,0,0,0);
    Legs playerLegs = new Legs("","",0,0,0,0,0);
    Boots playerBoots = new Boots("","",0,0,0,0,0);
    Enemies currentEnemy = new Enemies("",0,0,0,0,0);
    File newImage;
    
    @FXML
    private TextArea adventureText;
    @FXML
    private Button mageAttackButton;
    @FXML
    private Button meeleAttackButton;
    @FXML
    private Button rangedAttackButton;
    @FXML
    private Button nextLevelButton;
    @FXML
    private Button mainMenuButton;    
    @FXML
    private Label playerStamina;
    @FXML
    private Label playerMana;
    @FXML
    private Label playerStrength;
    @FXML
    private Label playerIntellegence;
    @FXML
    private Label playerAgility;
    @FXML
    private Label enemyStamina;
    @FXML
    private Label enemyMana;
    @FXML
    private Label enemyAgility;
    @FXML
    private Label enemyStrength;
    @FXML
    private Label enemyIntellegence;
    @FXML
    private Label enemy2Stamina;
    @FXML
    private Label enemy2Mana;
    @FXML
    private Label enemy2Strength;
    @FXML
    private Label enemy2Intellegence;
    @FXML
    private Label enemy2Agility;
    @FXML
    private ImageView imagePane;
    @FXML
    private ImageView enemyPane;
    @FXML
    private ImageView enemy2Pane;
    @FXML
    private VBox vBox;
    @FXML
    private ImageView weaponImage;
    @FXML
    private ImageView offhandImage;
    @FXML
    private ImageView helmetImage;
    @FXML
    private ImageView bootsImage;
    @FXML
    private ImageView chestImage;
    @FXML
    private ImageView pantsImage;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            // TODO
        int i = 0;
        adventureText.appendText("Hello \n");
        adventureText.appendText("Welcome");
        while( i < 10){
            adventureText.appendText(Integer.toString(i) + "\n");
            i++;
        }
        try {
            readHeroFromFile();
        } catch (IOException ex) {
            Logger.getLogger(AdventureController.class.getName()).log(Level.SEVERE, null, ex);
        }
        updateLabels();
        try {
            setImagesToScreen();
        } catch (IOException ex) {
            Logger.getLogger(AdventureController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try{
            if(playerHero.type == 1){
            newImage = new File("src\\pictures\\Wizard_guy.png");
            printImageToHeroPane(newImage);
            }
            else if(playerHero.type == 2){
            newImage = new File("src\\pictures\\Wizard_guy_1.png");
            printImageToHeroPane(newImage);
            }
            else if(playerHero.type == 3){
            newImage = new File("src\\pictures\\ogre.png");
            printImageToHeroPane(newImage);
            }
            else{
            }   
            vBox.setVisible(false);
        }
        catch(IOException e){
            System.out.print("Woops");
        }
    }    

    @FXML
    private void mageAttackButton(MouseEvent event) throws IOException {
        currentEnemy.stamina = currentEnemy.stamina - playerHero.intellegence;
        playerHero.mana = playerHero.mana - 5;    
        randmonEnemyAttack();
        updateLabels();
    }

    @FXML
    private void meeleAttackButton(MouseEvent event) throws IOException {
        currentEnemy.stamina = currentEnemy.stamina - playerHero.strength;
        playerHero.mana = playerHero.mana - 5;    
        randmonEnemyAttack();
        updateLabels();
    }

    @FXML
    private void rangedAttackButton(MouseEvent event) throws IOException {
        currentEnemy.stamina = currentEnemy.stamina - playerHero.agility;
        playerHero.mana = playerHero.mana - 5;    
        randmonEnemyAttack();
        updateLabels();
    }

    void mageEnemyAttack() throws IOException{
        playerHero.stamina = playerHero.stamina - currentEnemy.intellegence;
        currentEnemy.mana = currentEnemy.mana - 5;
        adventureText.appendText(currentEnemy.type + " attacks with a Magic attack! \n");
        gameOverCheck();
    }
    
    void meeleEnemyAttack() throws IOException{
        playerHero.stamina = playerHero.stamina - currentEnemy.strength;
        currentEnemy.mana = currentEnemy.mana - 5;
        adventureText.appendText(currentEnemy.type + " attacks with a Meele attack! \n");
        gameOverCheck();
    }
    void rangeEnemyAttack() throws IOException{
        playerHero.stamina = playerHero.stamina - currentEnemy.agility;
        currentEnemy.mana = currentEnemy.mana - 5;
        adventureText.appendText(currentEnemy.type + " attacks with a Ranged attack! \n");
        gameOverCheck();
    }
    
    void randmonEnemyAttack() throws IOException{
        Random rand = new Random();
        int randomNumber = rand.nextInt(2);
        switch (randomNumber) {
            case 0:
                mageEnemyAttack();
                break;
            case 1:
                meeleEnemyAttack();
                break;
            case 2:
                rangeEnemyAttack();
                break;
            default:
                break;
        }  
    }
    
    void gameOverCheck() throws IOException{
        if(playerHero.stamina <= 0){
             adventureText.appendText("Game Over" + "\n");
            System.out.print("You lost");
        }
        else{          
        }      
    }
    
    @FXML
    private void nextLevelButton(MouseEvent event) {
        
    }

    @FXML
    private void mainMenuButton(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("FXMLDocument.fxml"));
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

    
    public void readHeroFromFile() throws FileNotFoundException, IOException{
        try (BufferedReader reader = new BufferedReader(new FileReader("src\\adventureScape\\heroGearAndStats.txt"))) {
                //Read hero Stats (To display)
            playerHero.stamina = Integer.parseInt(reader.readLine());
            playerHero.mana = Integer.parseInt(reader.readLine());
            playerHero.strength = Integer.parseInt(reader.readLine());
            playerHero.intellegence = Integer.parseInt(reader.readLine());
            playerHero.agility = Integer.parseInt(reader.readLine());
            playerHero.type = Integer.parseInt(reader.readLine());
                //Print Weapon stats to file
            playerWeapon.name = reader.readLine();
            playerWeapon.imageFile = reader.readLine();
            playerWeapon.stamina = Integer.parseInt(reader.readLine());
            playerWeapon.mana = Integer.parseInt(reader.readLine());
            playerWeapon.strength = Integer.parseInt(reader.readLine());
            playerWeapon.intellegence = Integer.parseInt(reader.readLine());
            playerWeapon.agility = Integer.parseInt(reader.readLine());
                //Print offHand stats to file
            playerOffhand.name = reader.readLine();           
            playerOffhand.imageFile = reader.readLine();         
            playerOffhand.stamina = Integer.parseInt(reader.readLine());
            playerOffhand.mana = Integer.parseInt(reader.readLine());
            playerOffhand.strength = Integer.parseInt(reader.readLine());
            playerOffhand.intellegence = Integer.parseInt(reader.readLine());
            playerOffhand.agility = Integer.parseInt(reader.readLine());
                //Print helmet stats to file
            playerHelmet.name = reader.readLine();          
            playerHelmet.imageFile = reader.readLine();           
            playerHelmet.stamina = Integer.parseInt(reader.readLine());
            playerHelmet.mana = Integer.parseInt(reader.readLine());
            playerHelmet.strength = Integer.parseInt(reader.readLine());
            playerHelmet.intellegence = Integer.parseInt(reader.readLine());
            playerHelmet.agility = Integer.parseInt(reader.readLine());
                //Print chest stats to file
            playerChest.name = reader.readLine();          
            playerChest.imageFile = reader.readLine();           
            playerChest.stamina = Integer.parseInt(reader.readLine());
            playerChest.mana = Integer.parseInt(reader.readLine());
            playerChest.strength = Integer.parseInt(reader.readLine());
            playerChest.intellegence = Integer.parseInt(reader.readLine());
            playerChest.agility = Integer.parseInt(reader.readLine());
                //print legs stats to file
            playerLegs.name = reader.readLine();          
            playerLegs.imageFile = reader.readLine();          
            playerLegs.stamina = Integer.parseInt(reader.readLine());
            playerLegs.mana = Integer.parseInt(reader.readLine());
            playerLegs.strength = Integer.parseInt(reader.readLine());
            playerLegs.intellegence = Integer.parseInt(reader.readLine());
            playerLegs.agility = Integer.parseInt(reader.readLine());
                //print boots stats to file
            playerBoots.name = reader.readLine();           
            playerBoots.imageFile = reader.readLine();            
            playerBoots.stamina = Integer.parseInt(reader.readLine());
            playerBoots.mana = Integer.parseInt(reader.readLine());
            playerBoots.strength = Integer.parseInt(reader.readLine());
            playerBoots.intellegence = Integer.parseInt(reader.readLine());
            playerBoots.agility = Integer.parseInt(reader.readLine());
        } 

    }           
    void updateLabels(){
        if(playerHero.stamina <= 0){
            playerHero.stamina = 0;
        }
        if(playerHero.mana <= 0){
            playerHero.mana = 0;
        }
        if(currentEnemy.stamina <= 0){
            currentEnemy.stamina = 0;
        }
        if(currentEnemy.mana <= 0){
            currentEnemy.mana = 0;
        }       
        playerStamina.setText( "Stamina: " + Integer.toString(playerHero.stamina));
        playerMana.setText("Mana: " + Integer.toString(playerHero.mana));
        playerStrength.setText("Strength: " + Integer.toString(playerHero.strength));
        playerIntellegence.setText("Intellegence: " + Integer.toString(playerHero.intellegence));
        playerAgility.setText("Agility: " + Integer.toString(playerHero.agility));
        enemyStamina.setText("Stamina: " + Integer.toString(currentEnemy.stamina));
        enemyMana.setText("Mana: " + Integer.toString(currentEnemy.mana));
        enemyStrength.setText("Strength: " + Integer.toString(currentEnemy.strength));
        enemyIntellegence.setText("Intellegence: " + Integer.toString(currentEnemy.intellegence));
        enemyAgility.setText("Agility: " + Integer.toString(currentEnemy.agility));
    }
    
    void printImageToHeroPane(File imageFile) throws IOException{
        BufferedImage imageToWrite;    
        imageToWrite = ImageIO.read(imageFile);         
        WritableImage updatedImage = SwingFXUtils.toFXImage(imageToWrite, null); 
        imagePane.setImage(updatedImage);       
    }
    
    void printImageToEnemyPane(File imageFile) throws IOException{
        BufferedImage imageToWrite;
        imageToWrite = ImageIO.read(imageFile);                       
        WritableImage updatedImage = SwingFXUtils.toFXImage(imageToWrite, null);               
        enemyPane.setImage(updatedImage); 
    }
    
    void printImageToEnemy2Pane(File imageFile) throws IOException{
        BufferedImage imageToWrite;
        imageToWrite = ImageIO.read(imageFile);                       
        WritableImage updatedImage = SwingFXUtils.toFXImage(imageToWrite, null);               
        enemy2Pane.setImage(updatedImage); 
    }
    void printImageToWeaponPane(File imageFile) throws IOException{
        BufferedImage imageToWrite;
        imageToWrite = ImageIO.read(imageFile);                       
        WritableImage updatedImage = SwingFXUtils.toFXImage(imageToWrite, null);               
        weaponImage.setImage(updatedImage); 
    }
        void printImageToOffhandPane(File imageFile) throws IOException{
        BufferedImage imageToWrite;
        imageToWrite = ImageIO.read(imageFile);                       
        WritableImage updatedImage = SwingFXUtils.toFXImage(imageToWrite, null);               
        offhandImage.setImage(updatedImage); 
    }
    void printImageToChestPane(File imageFile) throws IOException{
        BufferedImage imageToWrite;
        imageToWrite = ImageIO.read(imageFile);                       
        WritableImage updatedImage = SwingFXUtils.toFXImage(imageToWrite, null);               
        chestImage.setImage(updatedImage); 
    }
    void printImageToLegsPane(File imageFile) throws IOException{
        BufferedImage imageToWrite;
        imageToWrite = ImageIO.read(imageFile);                       
        WritableImage updatedImage = SwingFXUtils.toFXImage(imageToWrite, null);               
        pantsImage.setImage(updatedImage); 
    }
    void printImageToBootsPane(File imageFile) throws IOException{
        BufferedImage imageToWrite;
        imageToWrite = ImageIO.read(imageFile);                       
        WritableImage updatedImage = SwingFXUtils.toFXImage(imageToWrite, null);               
        bootsImage.setImage(updatedImage); 
    }
    void printImageToHelmetPane(File imageFile) throws IOException{
        BufferedImage imageToWrite;
        imageToWrite = ImageIO.read(imageFile);                       
        WritableImage updatedImage = SwingFXUtils.toFXImage(imageToWrite, null);               
        helmetImage.setImage(updatedImage); 
    }
    
    void setImagesToScreen() throws IOException{
                newImage = new File(playerWeapon.imageFile);
                printImageToWeaponPane(newImage);
                newImage = new File(playerOffhand.imageFile);
                printImageToOffhandPane(newImage);
                newImage = new File(playerHelmet.imageFile);
                printImageToHelmetPane(newImage);
                newImage = new File(playerBoots.imageFile);
                printImageToBootsPane(newImage);
                newImage = new File(playerChest.imageFile);
                printImageToChestPane(newImage);
                newImage = new File(playerLegs.imageFile);
                printImageToLegsPane(newImage);
    }
    
    
    
}
