import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        /*        
        Hero hero = new Hero(0, 0, 10, 10, 10, 3);
        Enemy monster = new Enemy("Le Monstre", 0, 0, 10, 10, 8, 1);
        Fight fight = new Fight(hero, monster);
        Conversation inout = new Conversation();
        inout.start(hero);
        inout.cross_enemy();
        inout.fight(hero, monster, fight);*/
        //Map map = new Map(10, 10);
        //Scanner in = new Scanner (System.in);
        Hero hero = new Hero("hero 1", "Hero", 0, 0, 10, 10, 10, 3);
        Dialogue inout = new Dialogue();
       
       
        Scanner in = new Scanner (System.in);
        inout.player_move(in, hero);
        



        String [][] map = {
            {"XX...B..XX"},
            {"XX...C..XX"},
            {"XX.A....C."},
            {"...E......"},
            {"..XC.XX.A."},
            {"..E..XX..X"},
            {"X.A....C.X"},
            {"X...E....X"},
            {"XXXXXCXXXX"},
            {"XXXXXOXXXX"}
        };
        Map donjon = new Map(map);

        donjon.showMap();
    }
}