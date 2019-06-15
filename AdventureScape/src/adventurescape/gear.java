/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventurescape;

/**
 *
 * @author Chris Badolato
 */
public class gear {
 
    String name;
    String imageFile;
    int stamina;
    int mana;
    int strength;
    int intellegence;
    int agility;
    
    gear (String name, String imageFile, int stamina, int mana, int strength, int intellegence, int agility){
        this.name = name;
        this.imageFile = imageFile;
        this.stamina = stamina;
        this.mana = mana;
        this.strength = strength;
        this.intellegence = intellegence;
        this.agility = agility;
    }  
} 

class Weapon extends gear{
    public Weapon(String name, String imageFile, int stamina, int mana, int strength, int intellegence, int agility) {
        super(name, imageFile, stamina, mana, strength, intellegence, agility);
    }   
}

class Offhand extends gear{
    public Offhand(String name, String imageFile, int stamina, int mana, int strength, int intellegence, int agility) {
        super(name, imageFile, stamina, mana, strength, intellegence, agility);
    }   
}

class Helmet extends gear{
    public Helmet(String name, String imageFile, int stamina, int mana, int strength, int intellegence, int agility) {
        super(name, imageFile, stamina, mana, strength, intellegence, agility);
    }   
}

class Chest extends gear{
    public Chest(String name, String imageFile, int stamina, int mana, int strength, int intellegence, int agility) {
        super(name, imageFile, stamina, mana, strength, intellegence, agility);
    }   
}

class Legs extends gear{
    public Legs(String name, String imageFile, int stamina, int mana, int strength, int intellegence, int agility) {
        super(name, imageFile, stamina, mana, strength, intellegence, agility);
    }   
}

class Boots extends gear{
    public Boots(String name, String imageFile, int stamina, int mana, int strength, int intellegence, int agility) {
        super(name, imageFile, stamina, mana, strength, intellegence, agility);
    }   
}


