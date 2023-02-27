public class Map {
/*###########################################-ATTRIBUTS-################################################################################################*/

    private int row;
    private int column;
    private int[][] wall;
    private int[][] boss;
    private int[][] chest;
    private int[][] enemy;
    private int[][] hero;

/*###########################################-CONSTRUCTEUR-###########################################################################################*/

    public Map(int row, int column, int[][] wall, int[][] boss, int[][] chest, int[][] enemy, int[][] hero){
        this.row = row;
        this.column = column;
        this.wall = wall;
        this.boss = boss;
        this.chest = chest;
        this.enemy = enemy;
        this.hero = hero;
    }

/*###########################################-GETTER/SETTER-###########################################################################################*/

    public int getRow() {
        return row;
    }
    public void setRow(int new_row) {
        this.row = new_row;
    }

    public int getColumn() {
        return column;
    }
    public void setColumn(int new_column) {
        this.column = new_column;
    }

    public int[][] getWall() {
        return wall;
    }
    public void setWall(int[][] new_wall) {
        this.wall = new_wall;
    }

    public int[][] getBoss() {
        return boss;
    }
    public void setBoss(int[][] new_boss) {
        this.boss = new_boss;
    }

    public int[][] getChest() {
        return chest;
    }
    public void setChest(int[][] new_chest) {
        this.chest = new_chest;
    }

    public int[][] getEnemy() {
        return enemy;
    }
    public void setEnemy(int[][] new_enemy) {
        this.enemy = new_enemy;
    }

    public int[][] getHero() {
        return hero;
    }
    public void setHero(int[][] new_hero) {
        this.hero = new_hero;
    }

/*###########################################-METHODES-################################################################################################*/

    public boolean is_wall(int row, int column){
        boolean is_wall = false;
        for(int i = 0; i < wall.length; i++){
            if(row == wall[i][0] && column == wall[i][1]){
                is_wall = true;
            }
        }
        return is_wall;
    }
    public boolean is_boss(int row, int column){
        boolean is_boss = false;
        for(int i = 0; i < boss.length; i++){
            if(row == boss[i][0] && column == boss[i][1]){
                is_boss = true;
            }
        }
        return is_boss;
    }
    public boolean is_chest(int row, int column){
        boolean is_chest = false;
        for(int i = 0; i < chest.length; i++){
            if(row == chest[i][0] && column == chest[i][1]){
                is_chest = true;
            }
        }
        return is_chest;
    }
    public boolean is_enemy(int row, int column){
        boolean is_enemy = false;
        for(int i = 0; i < enemy.length; i++){
            if(row == enemy[i][0] && column == enemy[i][1]){
                is_enemy = true;
            }
        }
        return is_enemy;
    }
    public boolean is_hero(int row, int column){
        boolean is_hero = false;
        for(int i = 0; i < hero.length; i++){
            if(row == hero[i][0] && column == hero[i][1]){
                is_hero = true;
            }
        }
        return is_hero;
    }
    
    public void show_map(){
        for (int i = 0; i < row; i++){
            for (int j = 0; j < column; j++){
                if (this.is_wall(i, j)) {
                    System.out.print("X\t");
                } 
                else if (this.is_boss(i, j)){
                    System.out.print("B\t");
                }
                else if (this.is_chest(i, j)){
                    System.out.print("C\t");
                }
                else if (this.is_enemy(i, j)){
                    System.out.print("E\t");
                }
                else if (this.is_hero(i, j)){
                    System.out.print("O\t");
                }
                else {
                    System.out.print(".\t");
                }  
            }
            System.out.println();
        }
    }
}

