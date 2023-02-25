import java.util.Scanner;

public class Game {
    Hero hero;
    Map map;
    Scanner in = new Scanner (System.in);

    public Game (Hero hero, Map map){
        this.hero = hero;
        this.map = map;
    }
    
    /*public void start(Hero hero, Map map, Dialogue inout, Scanner in){
        inout.start(in, hero);
    }*/
    
    public void fight(Hero hero, Character enemy, Dialogue inout){
        int xp_joueur = hero.get_xp();
        int xp_enemy = enemy.get_xp();
        Character fighter_1;
        Character fighter_2;
        if(xp_joueur >= xp_enemy){
            fighter_1 = hero; 
            fighter_2 = enemy;
        }
        else{ 
            fighter_1 = enemy; 
            fighter_2 = hero;   
        }    
        System.out.println("--------------------------------------------------------------------\n"+
        "Un combat vient de se lancer, "+ fighter_1.get_name() +" va commencer !\n"+
        "--------------------------------------------------------------------");
        while(hero.is_dead() != true || enemy.is_dead() != true){
            int round = 1;
            if(round / 2 == 0){
                fighter_2.attack(fighter_1);
                fighter_1.set_dead();
            }
            else{ 
                fighter_1.attack(fighter_2);
                fighter_2.set_dead();
            }
            ++round;
        }
        if(hero.is_dead() == true){
            System.out.println("Vous avez perdu: GAME OVER");
            inout.finish(in, hero, map);
        }

        else{
            System.out.println("Vous avez gagné le bombat !");
            hero.set_xp(hero.get_xp() +1);
            //retirer l'enemy de la map
        }
    }

}
