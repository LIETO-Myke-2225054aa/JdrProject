import java.util.*;

public class Chest {
	private boolean state_content = false;
	private List<Object> content = new ArrayList <Object>();
	private int pos_x;
	private int pos_y;
	
    public Chest(int pos_x, int pos_y){
        this.pos_x = pos_x;
        this.pos_y = pos_y;
    }

	public boolean get_state_content(){
		return state_content;
	}
	public void set_state_content(boolean new_state_content){
		this.state_content = new_state_content ;
	}
	
	public Object get_content(){
		return content.get(0);
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
    

	public void take(){
		content.remove(0);
		this.set_state_content(false);
	}
	public void file(Object object){
		content.add(object);
		this.set_state_content(true);	
	}
	
	public void view_content(){
		System.out.println("Ce coffre contient : "+ this.content.get(0).get_description());
	}
}
