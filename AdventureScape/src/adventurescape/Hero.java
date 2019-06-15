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
public class Hero {    
    int stamina;
    int mana;
    int strength;
    int intellegence;
    int agility;
        //if type = 1 Wizard
        //if type = 2 Warrior
        //if type = 3 Ranger
    int type;
    
       
    Hero(int stamina, int mana, int strength, int intellegence, int agility, int type){          
        this.stamina = stamina;           
        this.mana = mana;          
        this.strength = strength;
        this.intellegence = intellegence;
        this.agility = agility;
        this.type = type;
    }  
    
    public void setStamina(int stamina){
        this.stamina = stamina;
    }
    public void setmana(int mana){
        this.mana = mana;
    }
    public void setStrength(int strength){
        this.strength = strength;
    }
    public void setIntellegence(int intellegence){
        this.intellegence = intellegence;
    }
    public void setAgility(int agility){
        this.agility = agility;
    }
    
    public int getStamina(){
        return this.stamina;
    }
    public int getMana(){
        return this.mana;
    }
    public int getStrength(){
        return this.strength;
    }
    public int getIntellengence(){
        return this.intellegence;
    }
    public int getAgility(){
        return this.agility;
    }                   
}

class Wizard extends Hero{  
    public Wizard(int stamina, int mana, int strength, int intellegence, int agility, int type) {
        super(stamina, mana, strength, intellegence, agility, type);
    }   
}

class Warrior extends Hero{  
    public Warrior(int stamina, int mana, int strength, int intellegence, int agility, int type) {
        super(stamina, mana, strength, intellegence, agility, type);
    }  
}

class Ranger extends Hero{   
    public Ranger(int stamina, int mana, int strength, int intellegence, int agility, int type) {
        super(stamina, mana, strength, intellegence, agility, type);
    }   
}