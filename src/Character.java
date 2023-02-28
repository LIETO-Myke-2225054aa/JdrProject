public class Character {
/*###########################################-ATTRIBUTS-################################################################################################*/
    
    private String name;
    private String id;
    private int pos_x;
	private int pos_y;
	private int attack;
	private int defense;
	private int pv;
    private int xp;
    private boolean dead = false;

/*###########################################-CONSTRUCTEUR-###########################################################################################*/

    public Character(String name, String id, int pos_x, int pos_y, int attack, int defense, int pv, int xp){
        this.name = name;
        this.id = id;
        this.pos_x = pos_x;
        this.pos_y = pos_y;
        this.attack = attack;
        this.defense = defense;
        this.pv = pv;
        this.xp = xp;
    }
    
/*###########################################-GETTER/SETTER-###########################################################################################*/
    
    public String get_name(){
        return name;
    }
    public void set_name(String new_name){
        this.name = new_name;
    }
    
    public String get_id(){
        return id;
    }
    public void set_id(String new_id){
        this.id = new_id;
    }
    
    public int get_pos_x(){
        return pos_x;
    }
    public void set_pos_x(int new_x){
        pos_x = new_x;
    }
    
    public int get_pos_y(){
        return pos_y;
    }
    public void set_pos_y(int new_y){
        pos_y = new_y;
    }
    
    public int get_attack(){
        return attack;
    }
    public void set_attack(int new_attack){
        attack = new_attack;
    }
    
    public int get_defense(){
        return defense;
    }
    public void set_defense(int new_defense){
        defense = new_defense;
    }
    
    public int get_pv(){
        return pv;
    }
    public void set_pv(int new_pv){
        this.pv = new_pv;
    }
    
    public int get_xp(){
        return xp;
    }
    public void set_xp(int new_xp){
        xp = new_xp;
    }
    
    public boolean is_dead(){   // get_dead
        return dead;
    }
    public void set_dead(){
        if(this.get_pv() <= 0) this.dead = true;
    }
    
/*###########################################-METHODES-################################################################################################*/
    
    public void attack(Character victim){
        int new_pv = victim.get_pv() - this.get_attack() + victim.get_defense();
        victim.set_pv(new_pv);
    }
} 
