import java.util.Scanner;
import java.util.*;

public class Hero extends Character {
/*###########################################-ATTRIBUTS-##############################################################################################*/

    List<Object> potion_bag = new ArrayList<Object>();
    List<Object> weapon_bag = new ArrayList<Object>();
    List<Object> actefact_bag = new ArrayList<Object>();
    private Object weapon;
    private boolean hold = false;
    
/*###########################################-CONSTRUCTEUR-###########################################################################################*/

    public Hero(String name, String id, int x, int y, int attack, int defense, int pv, int xp){
        super(name, id, x,  y, attack, defense, pv, xp);
    }
    
/*###########################################-GETTER/SETTER-###########################################################################################*/

    public List<Object> get_weapon_bag(){
        return weapon_bag;
    }
    public List<Object> get_actefact_bag(){
        return actefact_bag;
    }
    public List<Object> get_potion_bag(){    
        return potion_bag;
    }
    public Object get_weapon (){
        return this.weapon;
    }
    public void set_weapon(Object new_weapon){
        this.weapon = new_weapon;
    }
    public boolean get_hold(){
        return this.hold;
    }
    public void set_hold(boolean new_hold){
        this.hold = new_hold;
    }
    
/*###########################################-METHODES-################################################################################################*/

    public void turn_up(){      // tourner en haut
		this.set_pos_y(this.get_pos_y() - 1); 
	}
	public void turn_down(){    // tourner en bas
		this.set_pos_y(this.get_pos_y() + 1);
	}
	public void turn_left(){    // tourner à gauche
        this.set_pos_x(this.get_pos_x() - 1);
	}
	public void turn_right(){   // tourner à droite
        this.set_pos_x(this.get_pos_x() + 1);
	}

    public void take_object(Object object, Chest chest){ // prendre un objet d'un coffre
        String selector = object.get_id();
        switch (selector){
            case "Potion":
                Object potion = new Object(object.get_id(), object.get_description(), object.get_power());
                chest.take();                   
                if (potion_bag.size() < 5) potion_bag.add(potion);
                else{
                    System.out.println(); 
                    System.out.println("--------------------------------------------------------------------\n"+ 
                    "Votre sac de potion est plein, vous ne pouvez plus le remplir.\n"+
                    "--------------------------------------------------------------------\n");
                    System.out.println(); 
                }
            break;

            case "Arme":
                Object weapon = new Object(object.get_id(), object.get_description(), object.get_power());
                chest.take();
                if (weapon_bag.size() < 2) weapon_bag.add(weapon);
                else{
                    System.out.println(); 
                    System.out.println("--------------------------------------------------------------------\n"+ 
                    "Votre sac d'arme est plein, vous ne pouvez plus le remplir.\n"+
                    "--------------------------------------------------------------------\n");
                    System.out.println(); 
                } 
            break;

            case "Artefact":
                Object artefact = new Object(object.get_id(), object.get_description(), object.get_power());
                chest.take();
                if (actefact_bag.size() < 3) actefact_bag.add(artefact);
                else{
                    System.out.println(); 
                    System.out.println("--------------------------------------------------------------------\n"+ 
                    "Votre sac d'artefact est plein, vous ne pouvez plus le remplir.\n"+
                    "--------------------------------------------------------------------\n");
                    System.out.println(); 
                }
                for(int i = 0; i < actefact_bag.size(); ++i){
                    if(object.get_description() == "Pierre de pouvoir : Attaque"){
                        this.set_attack(this.get_attack() + object.get_power());
                    }
                    else this.set_defense(this.get_defense() + object.get_power());
                }
            break;
            }
    }
    public void file_object(Object object, Chest chest){ // deposer un objet dans un coffre
        String selector = object.get_id();
        switch (selector){
            case "Potion":
                chest.file(object);                   
                if (potion_bag.size() > 0) potion_bag.remove(object);
                else{
                    System.out.println(); 
                    System.out.println("--------------------------------------------------------------------\n"+ 
                    "Votre sac de potion est vide, vous ne pouvez plus le vider.\n"+
                    "--------------------------------------------------------------------\n");
                    System.out.println();
                }
            break;

            case "Arme":
                chest.file(object);
                if (weapon_bag.size() > 0) weapon_bag.remove(object);
                else{
                    System.out.println(); 
                    System.out.println("--------------------------------------------------------------------\n"+ 
                    "Votre sac d'arme est vide, vous ne pouvez plus le vider.\n"+
                    "--------------------------------------------------------------------\n");
                    System.out.println();
                }            
            break;

            case "Artefact":
                chest.file(object);
                if (actefact_bag.size() > 0) actefact_bag.remove(object);
                else{
                    System.out.println(); 
                    System.out.println("--------------------------------------------------------------------\n"+ 
                    "Votre sac d'artefact est vide, vous ne pouvez plus le vider.\n"+
                    "--------------------------------------------------------------------\n");
                    System.out.println();
                }
            break;
        }
    }
    
    public void bag_view(){   //consulter son inventaire
        potion_bag_view();
        weapon_bag_view();
        actefact_bag_view();
    }
    public void potion_bag_view(){  //consulter son inventaire de potion
        int compteur = 1;
        System.out.println(); 
        System.out.println("--------------------------------------------------------------------\n"+ 
        "Votre inventaire de potion contient : ");
        for(int i = 0; i < potion_bag.size(); i++){
            System.out.println(compteur+ " : Une potion "+ potion_bag.get(i).get_description() +" de niveau "+ potion_bag.get(i).get_power());
            compteur++;
        }
        System.out.println("--------------------------------------------------------------------");
        System.out.println();
    }
    public void weapon_bag_view(){  //consulter son inventaire d'arme
        int compteur = 1;
        System.out.println(); 
        System.out.println("--------------------------------------------------------------------\n"+ 
        "Votre inventaire d'arme contient : ");
        for(int i = 0; i < weapon_bag.size(); i++){
            System.out.println(compteur+ " : Une arme "+ weapon_bag.get(i).get_description() +" de niveau "+ weapon_bag.get(i).get_power());
            compteur++;
        }
        System.out.println("--------------------------------------------------------------------");
        System.out.println();
    }
    public void actefact_bag_view(){    //consulter son inventaire d'artefact
        int compteur = 1;
        System.out.println(); 
        System.out.println("--------------------------------------------------------------------\n"+ 
        "Votre inventaire d'artefact contient : ");
        for(int i = 0; i < actefact_bag.size(); i++){
            System.out.println(compteur+ " : Un artefact "+ actefact_bag.get(i).get_description() +" de niveau "+ actefact_bag.get(i).get_power());
            compteur++;
        }
        System.out.println("--------------------------------------------------------------------");
        System.out.println();
    }
    
    public void take_potion(){  //prendre (avaler) une potion
        if(potion_bag.size() != 0) {
            potion_bag.remove(potion_bag.get(0));
            this.set_pv(get_pv() +potion_bag.get(0).get_power());
        }
        else{
            System.out.println(); 
            System.out.println("--------------------------------------------------------------------\n"+ 
            "Votre inventaire de potion est vide.\n"+
            "--------------------------------------------------------------------");
            System.out.println();
        } 
    }
    public void take_weapon(Object weapon){ //prendre une arme (dans sa main)
        if(weapon_bag.size() != 0){
            weapon_bag.remove(weapon);
            set_weapon(weapon);
            set_hold(true);
            this.set_attack(get_attack() + weapon.get_power());
        } 
        else{
            System.out.println(); 
            System.out.println("--------------------------------------------------------------------\n"+ 
            "Votre inventaire d'arme est vide.\n"+
            "--------------------------------------------------------------------");
            System.out.println();
        } 
    }
    public void change_weapon(Object new_weapon){   //changer d'arme (dans sa main)
        if(get_hold() == true){ 
            Object old_weapon = get_weapon();
            this.set_weapon(new_weapon);
            weapon_bag.add(old_weapon);
            this.take_weapon(new_weapon);
        }
        else take_weapon(new_weapon);              
    }
    
    @Override
    public void attack(Character victim){
        boolean fight_choice = false;
        Scanner in = new Scanner(System.in);
        while(!fight_choice){
            boolean validInput;
            do{
                System.out.println(); 
                System.out.println("--------------------------------------------------------------------\n"+ 
                "Que voulez vous faire ?\n"+
                "1 : Attaquer\n"+
                "2 : Prendre une potion\n"+
                "--------------------------------------------------------------------\n");
                System.out.println();
                int choice_in = in.nextInt();
                validInput = true;
                switch (choice_in){
                    case 1: 
                        fight_choice = true;
                        int new_pv = victim.get_pv() - this.get_attack() + victim.get_defense();
                        victim.set_pv(new_pv);
                    break;

                    case 2 :
                        fight_choice = true;
                        this.take_potion();
                    break;

                    default:  
                    System.out.println(); 
                    System.out.println("--------------------------------------------------------------------\n"+
                    "Je n'ai pas compris votre demande."+
                    "--------------------------------------------------------------------");
                    System.out.println(); 
                        validInput = false;
                    break;
                }
            }while (!validInput);
        }
    }
}