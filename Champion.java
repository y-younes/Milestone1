package model.world;

import java.util.ArrayList;

public class Champion extends Cover {
	private String name;
	private int maxHP;
	private int mana;
	private int maxActionPointsPerTurn;
	private int currentActionPoints;
	private int attackRange;
	private int attackDamage;
	private int speed;
	private ArrayList<Ability> abilities;
	private ArrayList<Effect> appliedEffects;
	private Condition condition;

}
public Champion(String name, int maxHP, int mana, int maxActions, int speed, int attackRange,
		int attackDamage){
	super();
	this.name=name;
	this.maxHP=maxHP;
	this.mana=mana;
	maxActionPointsPerTurn=maxActions;
	//currentActionPoints=maxActions;
	this.speed=speed;
	this.attackRange=attackRange;
	this.attackDamage=attackDamage;
	abilities=new ArrayList<>();
	Effect=new ArrayList<>();
	this.condition=Condition.ACTIVE;
	
}











public String getName() {
	return name;
}
public int getMaxHP() {
	return maxHP;
}
public int getMana() {
	return mana;
}
public int getMaxActionPointsPerTurn() {
	return maxActionPointsPerTurn;
}
public void setMaxActionPointsPerTurn(int maxActionPointsPerTurn) {
	this.maxActionPointsPerTurn = maxActionPointsPerTurn;
}

public int getCurrentActionPoints() {
	return currentActionPoints;
}
public int getAttackRange() {
	return attackRange;
}

public int getAttackDamage() {
	return attackDamage;
}
public void setAttackDamage(int attackDamage) {
	this.attackDamage = attackDamage;
}

public int getSpeed() {
	return speed;
}
public void setSpeed(int speed) {
	this.speed = speed;
}

public ArrayList<Ability> getAbilities() {
	return abilities;
}
public void setAbilities(ArrayList<Ability> abilities) {
	this.abilities = abilities;
}

public ArrayList<Effect> getAppliedEffects() {
	return appliedEffects;
}
public void setAppliedEffects(ArrayList<Effect> appliedEffects) {
	this.appliedEffects = appliedEffects;
}

public Condition getCondition() {
	return condition;
}
public void setCondition(Condition condition) {
	this.condition = condition;
}













}

