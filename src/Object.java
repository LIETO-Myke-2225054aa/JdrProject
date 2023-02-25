public class Object {
    private String id;
    private String description;
    private int power;

    public Object(String id, String description, int power){
        this.id = id;
        this.description = description;
        this.power = power;
    }
    
    public String get_id(){
        return id;
    }
    public void set_id(String new_id){
        this.id = new_id;
    }
    
    public String get_description(){
        return description;
    }
    public void set_description(String new_description){
        this.description = new_description;
    }

    public int get_power(){
        return power;
    }
    public void set_power(int new_power){
        this.power = new_power;
    }
}
