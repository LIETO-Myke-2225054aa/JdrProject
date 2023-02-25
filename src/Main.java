import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        /*###########################################-ELEMENTS-#################################################*/

        Hero hero1 = new Hero("Player 1", "Hero", 9, 5, 10, 10, 10, 0);
        Character boss1 = new Character("Boss", "Boss", 0, 5, 15, 15, 15, 3);
        Character enemy1 = new Character("Monstre 1", "Enemy", 7, 4, 10, 10, 10, 0);
        Character enemy2 = new Character("Monstre 2", "Enemy", 5, 2, 10, 10, 10, 1);
        Character enemy3 = new Character("Monstre 3", "Enemy", 3, 3, 10, 10, 10, 2);
        Chest chest1 = new Chest(1, 5);
        Chest chest2 = new Chest(2, 8);
        Chest chest3 = new Chest(4, 3);
        Chest chest4 = new Chest(6, 7);
        Chest chest5 = new Chest(8, 5);
        
        Scanner in = new Scanner (System.in);
        Dialogue inout = new Dialogue();
        
        /*###########################################-MAP-#################################################*/
        int[][] wall = {
        {0,0},{0,1},{0,2},{0,3},{0,4},      {0,6},{0,7},{0,8},{0,9},
        {1,0},{1,1},                                    {1,8},{1,9},
        {2,0},{2,1},                                          {2,9},
        {3,0},                                                {3,9},
        {4,0},      {4,2},            {4,5},{4,6},            {4,9},
        {5,0},                        {5,5},{5,6},            {5,9},
        {6,0},                                                {6,9},
        {7,0},                                                {7,9},
        {8,0},{8,1},{8,2},{8,3},{8,4},      {8,6},{8,7},{8,8},{8,9},
        {9,0},{9,1},{9,2},{9,3},{9,4},      {9,6},{9,7},{9,8},{9,9}};
        
        int[][] hero = {{hero1.get_pos_x(), hero1.get_pos_y()}};
        int[][] boss = {{boss1.get_pos_x(), boss1.get_pos_y()}};
        
        int[][] enemy = {
        {enemy1.get_pos_x(), enemy1.get_pos_y()}, 
        {enemy2.get_pos_x(), enemy2.get_pos_y()}, 
        {enemy3.get_pos_x(), enemy3.get_pos_y()}};
        
        int[][] chest = {
        {chest1.get_pos_x(), chest1.get_pos_y()}, 
        {chest2.get_pos_x(), chest2.get_pos_y()}, 
        {chest3.get_pos_x(), chest3.get_pos_y()}, 
        {chest4.get_pos_x(), chest4.get_pos_y()}, 
        {chest5.get_pos_x(), chest5.get_pos_y()}};

        Map map1 = new Map (10, 10, wall, boss, chest, enemy, hero);
        map1.show_map();


   }
}