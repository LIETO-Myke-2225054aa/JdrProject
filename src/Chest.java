import java.util.*;

public class Chest {
	private boolean state_content = false;
	private List<Object> content = new ArrayList <Object>();
	final int POSITION_X;
	final int POSITION_Y;
	
    public Chest(int POSITION_X, int POSITION_Y){
        this.POSITION_X = POSITION_X;
        this.POSITION_Y = POSITION_Y;
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
