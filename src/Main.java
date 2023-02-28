import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args){
    /*###########################################-ELEMENTS-###########################################################################################*/

        //Personnages
        Hero hero_1 = new Hero("Player 1", "Hero", 5, 9, 10, 10, 10, 0);
        Character boss_1 = new Character("Boss", "Boss", 5, 0, 15, 15, 15, 3);
        Character enemy_1 = new Character("Monstre 1", "Enemy", 4, 7, 10, 5, 5, 0);
        Character enemy_2 = new Character("Monstre 2", "Enemy", 2, 5, 10, 10, 5, 1);
        Character enemy_3 = new Character("Monstre 3", "Enemy", 3, 3, 10, 10, 5, 2);
        List<Character> enemyList = new ArrayList<Character>();
        enemyList.add(enemy_1);
        enemyList.add(enemy_2);
        enemyList.add(enemy_3);
        
        //Coffres
        Chest chest_1 = new Chest(5, 1);
        Chest chest_2 = new Chest(8, 2);
        Chest chest_3 = new Chest(3, 4);
        Chest chest_4 = new Chest(7, 6);
        Chest chest_5 = new Chest(5, 8);
        List<Chest> chestList = new ArrayList<Chest>();
        chestList.add(chest_1);
        chestList.add(chest_2);
        chestList.add(chest_3);
        chestList.add(chest_4);
        chestList.add(chest_5);


        //Objets
        Object arme_1 = new Object("Arme", "Arc", 3);
        Object artefact_1 = new Object("Artefact", "Pierre de pouvoir : Attaque", 4);
        Object artefact_2 = new Object("Artefact", "Pierre de pouvoir : Défense", 2);
        Object potion_1 = new Object("Potion", "Potion de régénération", 2);
        Object potion_2 = new Object("Potion", "Potion de régénération", 3);
        
        chest_1.file(arme_1);
        chest_2.file(potion_1);
        chest_3.file(artefact_1);
        chest_4.file(potion_2);
        chest_5.file(artefact_2);


        
        Scanner in = new Scanner (System.in);
        Dialogue inout = new Dialogue();

    /*###########################################-MAP-###########################################################################################*/
        
        int[][] wall = {
        {0,0},{1,0},{2,0},{3,0},{4,0},      {6,0},{7,0},{8,0},{9,0},
        {0,1},{1,1},                                    {8,1},{9,1},
        {0,2},{1,2},                                          {9,2},
        {0,3},                                                {9,3},
        {0,4},      {2,4},            {5,4},{6,4},            {9,4},
        {0,5},                        {5,5},{6,5},            {9,5},
        {0,6},                                                {9,6},
        {0,7},                                                {9,7},
        {0,8},{1,8},{2,8},{3,8},{4,8},      {6,8},{7,8},{8,8},{9,8},
        {0,9},{1,9},{2,9},{3,9},{4,9},      {6,9},{7,9},{8,9},{9,9}};
        
        int[][] hero = {{hero_1.get_pos_x(), hero_1.get_pos_y()}};
        int[][] boss = {{boss_1.get_pos_x(), boss_1.get_pos_y()}};
        
        int[][] enemy = {
        {enemy_1.get_pos_x(), enemy_1.get_pos_y()}, 
        {enemy_2.get_pos_x(), enemy_2.get_pos_y()}, 
        {enemy_3.get_pos_x(), enemy_3.get_pos_y()}};
        
        int[][] chest = {
        {chest_1.get_pos_x(), chest_1.get_pos_y()}, 
        {chest_2.get_pos_x(), chest_2.get_pos_y()}, 
        {chest_3.get_pos_x(), chest_3.get_pos_y()}, 
        {chest_4.get_pos_x(), chest_4.get_pos_y()}, 
        {chest_5.get_pos_x(), chest_5.get_pos_y()}};

        Map map1 = new Map (10, 10, wall, boss, chest, enemy, hero);
        
    /*###########################################-GAME-###########################################################################################*/

        Game game_1 = new Game(hero_1, boss_1, enemy_1, enemy_2, enemy_3, enemyList, chest_1, chest_2, chest_3, chest_4, chest_5, chestList, arme_1, artefact_1, artefact_2, potion_1, potion_2, in, inout, map1);
        game_1.start_game();
  
    /*###########################################################################################################################################*/
    }
}