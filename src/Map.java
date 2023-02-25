/*
    Map donjon = new Map(map);
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
*/
public class Map {
    private int NUM_ROWS;       
    private int NUM_COLS;  
    String[][] my_map = new String[NUM_ROWS][NUM_COLS];

    public Map(String[][] map) {    //constructeur
        for (int row = 0; row < map.length; ++row) {
            for (int col = 0; col < map[0].length; ++col) {
                this.my_map[row][col] = map[row][col];
            }
        }
    }

    public void showMap(){
        for (int row = 0; row < this.my_map.length; ++row) {
            for (int col = 0; col < this.my_map[row].length; ++col) {
               System.out.printf("%3d",this.my_map[row][col]);
            }
            System.out.println();
        }
    }
}

