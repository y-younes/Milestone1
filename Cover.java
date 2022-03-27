package model.world;

import java.awt.Point;
import java.util.Random;

public class Cover {
    private	int currentHP;
	private Point location;
public Cover(){
	location=new Point(0,0);
	currentHP=0;
}
public Cover(int x, int y){
	location=new Point(x,y);
	Random rand=new Random();
	currentHP=rand.nextInt(900)+100;	
}
public int getCurrentHP() {
	return currentHP;
}
public void setCurrentHP(int currentHP) {
	this.currentHP = currentHP;
}
public Point getLocation() {
	return location;
}



}