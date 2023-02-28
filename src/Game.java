import java.util.Scanner;
import java.util.*;

public class Game {
/*###########################################-ATTRIBUTS-##############################################################################################*/
    
    private Hero hero; 
    private Character boss;
    private Character enemy_1;
    private Character enemy_2;
    private Character enemy_3;
    private List<Character> enemyList = new ArrayList<Character>();

    private Chest chest_1;
    private Chest chest_2; 
    private Chest chest_3; 
    private Chest chest_4; 
    private Chest chest_5;
    private List<Chest> chestList = new ArrayList<Chest>(); 

    private Object arme_1;
    private Object artefact_1; 
    private Object artefact_2;
    private Object potion_1;
    private Object potion_2;

    private Scanner in;
    private Dialogue inout;
    private Map map;
    private boolean gameOver = false;

/*###########################################-CONSTRUCTEUR-###########################################################################################*/

    public Game(Hero hero, Character boss, Character enemy_1, Character enemy_2, Character enemy_3, 
            List<Character> enemyList, Chest chest_1,Chest chest_2, Chest chest_3, Chest chest_4, 
            Chest chest_5, List<Chest> chestList, Object arme_1, Object artefact_1, Object artefact_2, 
            Object potion_1, Object potion_2, Scanner in, Dialogue inout, Map map){
        this.hero = hero;
        this.boss = boss;
        this.enemy_1 = enemy_1;
        this.enemy_2 = enemy_2;
        this.enemy_3 = enemy_3;
        this.enemyList = enemyList;
        this.chest_1 = chest_1;
        this.chest_2 = chest_2;
        this.chest_3 = chest_3;
        this.chest_4 = chest_4;
        this.chest_5 = chest_5;
        this.chestList = chestList;
        this.arme_1 = arme_1;
        this.artefact_1 = artefact_1;
        this.artefact_2 = artefact_2;
        this.potion_1 = potion_1;
        this.potion_2 = potion_2;
        this.in = in;
        this.inout = inout;
        this.map = map;
    }

/*###########################################-GETTER/SETTER-###########################################################################################*/

    public Hero getHero() {
        return hero;
    }
    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public Character getBoss() {
        return boss;
    }
    public void setBoss(Character boss) {
        this.boss = boss;
    }

    public Character getEnemy_1() {
        return enemy_1;
    }
    public void setEnemy_1(Character enemy_1) {
        this.enemy_1 = enemy_1;
    }

    public Character getEnemy_2() {
        return enemy_2;
    }
    public void setEnemy_2(Character enemy_2) {
        this.enemy_2 = enemy_2;
    }

    public Character getEnemy_3() {
        return enemy_3;
    }
    public void setEnemy_3(Character enemy_3) {
        this.enemy_3 = enemy_3;
    }

    public List<Character> getEnemyList() {
        return enemyList;
    }
    public void setEnemyList(List<Character> enemyList) {
        this.enemyList = enemyList;
    }

    public Chest getChest_1() {
        return chest_1;
    }
    public void setChest_1(Chest chest_1) {
        this.chest_1 = chest_1;
    }

    public Chest getChest_2() {
        return chest_2;
    }
    public void setChest_2(Chest chest_2) {
        this.chest_2 = chest_2;
    }

    public Chest getChest_3() {
        return chest_3;
    }
    public void setChest_3(Chest chest_3) {
        this.chest_3 = chest_3;
    }

    public Chest getChest_4() {
        return chest_4;
    }
    public void setChest_4(Chest chest_4) {
        this.chest_4 = chest_4;
    }

    public Chest getChest_5() {
        return chest_5;
    }
    public void setChest_5(Chest chest_5) {
        this.chest_5 = chest_5;
    }

    public List<Chest> getChestList() {
        return chestList;
    }
    public void setChestList(List<Chest> chestList) {
        this.chestList = chestList;
    }

    public Object getArme_1() {
        return arme_1;
    }
    public void setArme_1(Object arme_1) {
        this.arme_1 = arme_1;
    }

    public Object getArtefact_1() {
        return artefact_1;
    }
    public void setArtefact_1(Object artefact_1) {
        this.artefact_1 = artefact_1;
    }

    public Object getArtefact_2() {
        return artefact_2;
    }
    public void setArtefact_2(Object artefact_2) {
        this.artefact_2 = artefact_2;
    }

    public Object getPotion_1() {
        return potion_1;
    }
    public void setPotion_1(Object potion_1) {
        this.potion_1 = potion_1;
    }

    public Object getPotion_2() {
        return potion_2;
    }
    public void setPotion_2(Object potion_2) {
        this.potion_2 = potion_2;
    }

    public Scanner getIn() {
        return in;
    }
    public void setIn(Scanner in) {
        this.in = in;
    }

    public Dialogue getInout() {
        return inout;
    }
    public void setInout(Dialogue inout) {
        this.inout = inout;
    }

    public Map getMap() {
        return map;
    }
    public void setMap(Map map) {
        this.map = map;
    }

    public boolean getGameOver(){
        return gameOver;
    }
    public void setGameOver(boolean gameOver){
        this.gameOver = gameOver;
    }
    
/*###########################################-METHODES-################################################################################################*/

    public void start_game(){
        inout.start(in, hero);
        while(gameOver == false){
            inout.player_choice(in, hero, this);
        }
        inout.finish();
    }   

    public Character which_enemy(int x, int y, List<Character> list_enemy){
        Character enemy = new Character(null, null, x, y, y, y, y, x);
        for(int i = 0; i < list_enemy.size(); ++i){
            if(list_enemy.get(i).get_pos_x() == x && list_enemy.get(i).get_pos_y() == y){
                enemy.set_name(list_enemy.get(i).get_name());
                enemy.set_id(list_enemy.get(i).get_id());
                enemy.set_pos_x(list_enemy.get(i).get_pos_x());
                enemy.set_pos_y(list_enemy.get(i).get_pos_y());
                enemy.set_attack(list_enemy.get(i).get_attack());
                enemy.set_defense(list_enemy.get(i).get_defense());
                enemy.set_pv(list_enemy.get(i).get_pv());
                enemy.set_xp(list_enemy.get(i).get_xp());
            } 
        }
        return enemy;
    }
    public Chest which_chest(int x, int y, List<Chest> list_chest){
        Chest chest = new Chest(x, y);
        for(int i = 0; i < list_chest.size(); ++i){
            if(list_chest.get(i).get_pos_x() == x && list_chest.get(i).get_pos_y() == y){
                chest.set_state_content(list_chest.get(i).get_state_content());
                chest.set_pos_x(list_chest.get(i).get_pos_x());
                chest.set_pos_x(list_chest.get(i).get_pos_y());
                chest.file(list_chest.get(i).get_content());
            } 
        }
        return chest;
    }

    public void player_move(Scanner in, Hero hero){    //Faire bouger le joueur
        boolean choiceMove = false;
        while(!choiceMove){
            boolean validInput;
            do{
                System.out.println(); 
                System.out.println("--------------------------------------------------------------------\n"+
                "Vous êtes à la position {"+ hero.get_pos_x() +","+ hero.get_pos_y() +"}\n"+
                "\n"+
                "Dans quel direction voulez-vous aller ?\n"+ 
                "1 : En Haut\n"+ 
                "2 : En Bas\n"+ 
                "3 : A Gauche\n"+ 
                "4 : A droite\n"+
                "--------------------------------------------------------------------");
                System.out.println();
                int move = in.nextInt();
                validInput = true;
                switch(move){
                    case 1: 
                        choiceMove = true;
                        if(map.is_wall(hero.get_pos_x(), hero.get_pos_y() - 1) == true){
                            System.out.println(); 
                            System.out.println("--------------------------------------------------------------------\n"+ 
                            "Vous êtes face à un mur, veuillez choisir : Gauche, Droite ou Bas\n"+
                            "--------------------------------------------------------------------\n");
                            System.out.println();                            
                            break;
                        }
                        hero.turn_up();
                        System.out.println(); 
                        System.out.println("--------------------------------------------------------------------\n"+
                        "Vous êtes maintenant à la position {"+ hero.get_pos_x() +","+ hero.get_pos_y() +"}\n"+
                        "--------------------------------------------------------------------");
                        System.out.println(); 
                        if(map.is_chest(hero.get_pos_x(), hero.get_pos_y()) == true){
                            Chest chest_random = which_chest(hero.get_pos_x(), hero.get_pos_y(), chestList);
                            inout.cross_chest(in, hero, chest_random);
                        }
                        else if(map.is_enemy(hero.get_pos_x(), hero.get_pos_y()) == true){ 
                            Character enemy_x = which_enemy(hero.get_pos_x(), hero.get_pos_y(), enemyList);
                            inout.cross_enemy(enemy_x);
                            fight(hero, enemy_x, inout);
                        }
                        else if(map.is_boss(hero.get_pos_x(), hero.get_pos_y()) == true){
                            inout.cross_enemy(boss);
                            System.out.println(); 
                            System.out.println("--------------------------------------------------------------------\n"+ 
                            "Vous allez affronter un boss !\n"+
                            "--------------------------------------------------------------------\n");
                            System.out.println();                             
                            fight(hero, boss, inout);
                            if(boss.is_dead() == true) gameOver = true;
                        }
                    break;

                    case 2: 
                        choiceMove = true;
                        if(map.is_wall(hero.get_pos_x(), hero.get_pos_y() + 1) == true){
                            System.out.println(); 
                            System.out.println("--------------------------------------------------------------------\n"+ 
                            "Vous êtes face à un mur, veuillez choisir : Gauche, Droite ou Haut\n"+
                            "--------------------------------------------------------------------\n");
                            System.out.println();                             
                            break;
                        }
                        hero.turn_down();
                        System.out.println(); 
                        System.out.println("--------------------------------------------------------------------\n"+
                        "Vous êtes maintenant à la position {"+ hero.get_pos_x() +","+ hero.get_pos_y() +"}\n"+
                        "--------------------------------------------------------------------");
                        System.out.println();
                        if(map.is_chest(hero.get_pos_x(), hero.get_pos_y()) == true){
                            Chest chest_random = which_chest(hero.get_pos_x(), hero.get_pos_y(), chestList);
                            inout.cross_chest(in, hero, chest_random);
                        }
                        else if(map.is_enemy(hero.get_pos_x(), hero.get_pos_y()) == true){
                            Character enemy_x = which_enemy(hero.get_pos_x(), hero.get_pos_y(), enemyList);
                            inout.cross_enemy(enemy_x);
                            fight(hero, enemy_x, inout);
                        }
                        else if(map.is_boss(hero.get_pos_x(), hero.get_pos_y()) == true){
                            inout.cross_enemy(boss);
                            System.out.println(); 
                            System.out.println("--------------------------------------------------------------------\n"+ 
                            "Vous allez affronter un boss !\n"+
                            "--------------------------------------------------------------------\n");
                            System.out.println(); 
                            fight(hero, boss, inout);
                            if(boss.is_dead() == true) gameOver = true;
                        }
                    break;

                    case 3: 
                        choiceMove = true;
                        if(map.is_wall(hero.get_pos_x() - 1, hero.get_pos_y()) == true){
                            System.out.println(); 
                            System.out.println("--------------------------------------------------------------------\n"+ 
                            "Vous êtes face à un mur, veuillez choisir : Droite, Haut ou Bas\n"+
                            "--------------------------------------------------------------------\n");
                            System.out.println(); 
                            break;
                        }
                        hero.turn_left();
                        System.out.println(); 
                        System.out.println("--------------------------------------------------------------------\n"+
                        "Vous êtes maintenant à la position {"+ hero.get_pos_x() +","+ hero.get_pos_y() +"}\n"+
                        "--------------------------------------------------------------------");
                        System.out.println();
                        if(map.is_chest(hero.get_pos_x(), hero.get_pos_y()) == true){
                            Chest chest_random = which_chest(hero.get_pos_x(), hero.get_pos_y(), chestList);
                            inout.cross_chest(in, hero, chest_random);
                        }                     
                        else if(map.is_enemy(hero.get_pos_x(), hero.get_pos_y()) == true){
                            Character enemy_x = which_enemy(hero.get_pos_x(), hero.get_pos_y(), enemyList);
                            inout.cross_enemy(enemy_x);
                            fight(hero, enemy_x, inout);
                        }
                        else if(map.is_boss(hero.get_pos_x(), hero.get_pos_y()) == true){
                            inout.cross_enemy(boss);
                            System.out.println(); 
                            System.out.println("--------------------------------------------------------------------\n"+ 
                            "Vous allez affronter un boss !\n"+
                            "--------------------------------------------------------------------\n");
                            System.out.println();                             
                            fight(hero, boss, inout);
                            if(boss.is_dead() == true) gameOver = true;
                        }
                    break;

                    case 4: 
                        choiceMove = true;
                        if(map.is_wall(hero.get_pos_x() + 1, hero.get_pos_y()) == true){
                            System.out.println(); 
                            System.out.println("--------------------------------------------------------------------\n"+ 
                            "Vous êtes face à un mur, veuillez choisir : Gauche, Haut ou Bas\n"+
                            "--------------------------------------------------------------------\n");
                            System.out.println();                             
                            break;
                        }
                        hero.turn_right();
                        System.out.println(); 
                        System.out.println("--------------------------------------------------------------------\n"+
                        "Vous êtes maintenant à la position {"+ hero.get_pos_x() +","+ hero.get_pos_y() +"}\n"+
                        "--------------------------------------------------------------------");
                        System.out.println();
                        if(map.is_chest(hero.get_pos_x(), hero.get_pos_y()) == true){
                            Chest chest_random = which_chest(hero.get_pos_x(), hero.get_pos_y(), chestList);
                            inout.cross_chest(in, hero, chest_random);
                        }
                        else if(map.is_enemy(hero.get_pos_x(), hero.get_pos_y()) == true){
                            Character enemy_x = which_enemy(hero.get_pos_x(), hero.get_pos_y(), enemyList);
                            inout.cross_enemy(enemy_x);
                            fight(hero, enemy_x, inout);
                        }
                        else if(map.is_boss(hero.get_pos_x(), hero.get_pos_y()) == true){
                            inout.cross_enemy(boss);
                            System.out.println(); 
                            System.out.println("--------------------------------------------------------------------\n"+ 
                            "Vous allez affronter un boss !\n"+
                            "--------------------------------------------------------------------\n");
                            System.out.println();                             
                            fight(hero, boss, inout);
                            if(boss.is_dead() == true) gameOver = true;
                        }
                    break;

                    default:
                        System.out.println(); 
                        System.out.println("--------------------------------------------------------------------\n"+
                        "Je n'ai pas compris votre demande.\n"+
                        "--------------------------------------------------------------------");
                        System.out.println(); 
                        validInput = false;
                    break;
                }
            } while(!validInput);
        } 
    }
       
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
        System.out.println(        
        "Voici vos attributs :\n"+
        "Attaque : "+ hero.get_attack() +"\n"+
        "Defense : "+ hero.get_defense() +"\n"+
        "Points de vie : "+ hero.get_pv() +"\n");
        
        System.out.println(        
        "Voici les attributs de votre ennemi :\n"+
        "Attaque : "+ enemy.get_attack() +"\n"+
        "Defense : "+ enemy.get_defense() +"\n"+
        "Points de vie : "+ enemy.get_pv() +"\n"+
        "--------------------------------------------------------------------");
        System.out.println(); 
        
        int round = 0;
        while((hero.is_dead() == false) || (enemy.is_dead() == false)){
            System.out.println("round : "+round);
            if(round % 2 == 0){
                System.out.println("C'est le tour de "+ fighter_1.get_name());
                fighter_1.attack(fighter_2);
            }
            else{
                System.out.println("C'est le tour de "+ fighter_2.get_name()); 
                fighter_2.attack(fighter_1);
            }
            ++round;
            System.out.println();
            System.out.println("PV Hero : "+ hero.get_pv() +"   "+"PV Ennemi : "+ enemy.get_pv());
            fighter_1.set_dead();
            fighter_2.set_dead(); 
            if(hero.is_dead() == true){
                System.out.println(); 
                System.out.println("--------------------------------------------------------------------\n"+ 
                "Vous avez perdu: GAME OVER\n"+
                "--------------------------------------------------------------------\n");
                System.out.println();
                fighter_1.set_dead();             
                gameOver = true;
                break;
            }
    
            else if (enemy.is_dead() == true){
                System.out.println(); 
                System.out.println("--------------------------------------------------------------------\n"+ 
                "Bravo, vous avez gagné le bombat !\n"+
                "--------------------------------------------------------------------\n");
                System.out.println();             
                hero.set_xp(hero.get_xp() +1);
                enemy.set_pos_x(0);
                enemy.set_pos_y(0);
                break;
            }
        }  
    }
}