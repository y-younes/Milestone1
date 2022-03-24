package model.abilities;

public class Ability {
	private String name;
	private int manaCost;
	private int baseCooldown;
	private int currentCooldown;
	private int castRange;
	private int requiredActionPoints;
	private AreaOfEffect castArea;
	public String getName() {
		return name;
	}
	public int getManaCost() {
		return manaCost;
	}
	public int getBaseCooldown() {
		return baseCooldown;
	}
	public int getCastRange() {
		return castRange;
	}
	public int getRequiredActionPoints() {
		return requiredActionPoints;
	}
	public AreaOfEffect getCastArea() {
		return castArea;
	}
	public int getCurrentCooldown() {
		return currentCooldown;
	}
	public void setCurrentCooldown(int currentCooldown) {
		this.currentCooldown = currentCooldown;
	}
	public Ability(String name, int manaCost, int baseCooldown, int castRange,AreaOfEffect castArea, int requiredActionPoints
			) {
		
		this.name = name;
		this.manaCost = manaCost;
		this.baseCooldown = baseCooldown;
		this.castRange = castRange;
		this.requiredActionPoints = requiredActionPoints;
		this.castArea = castArea;
	}
	public static void main(String[] args) {
		
	}
	
	
	
	

}