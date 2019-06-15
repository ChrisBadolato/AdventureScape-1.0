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
public class Enemies {
    String type;
    int stamina;
    int mana;
    int strength;
    int intellegence;
    int agility;
    
    Enemies(String type, int stamina, int mana, int strength, int intellegence, int agility){
        this.type = type;
        if(stamina <= 0){
            this.stamina = 0;
        }
        else{
            this.stamina = stamina;
        }
        if(mana <= 0){
            this.mana = 0;
        }
        else{
            this.mana = mana;
        } 
        this.strength = strength;
        this.intellegence = intellegence;
        this.agility = agility;
    }  
        
}

class DarkMage extends Enemies{  
    public DarkMage(String type, int stamina, int mana, int strength, int intellegence, int agility) {
        super(type,stamina, mana, strength, intellegence, agility);
    }   
}

class Boss extends Enemies{
    public Boss(String type,int stamina, int mana, int strength, int intellegence, int agility){
        super(type, stamina, mana, strength, intellegence, agility);
    }
}

class finalBoss extends Enemies{
    public finalBoss(String type,int stamina, int mana, int strength, int intellegence, int agility){
        super(type, stamina, mana, strength, intellegence, agility);
    }
}

class ogre extends Enemies{
    public ogre(String type,int stamina, int mana, int strength, int intellegence, int agility){
        super(type, stamina, mana, strength, intellegence, agility);
    }
}

