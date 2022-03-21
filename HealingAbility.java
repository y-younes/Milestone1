package model.abilities;

public class HealingAbility extends Ability {
	private int healAmount;

	public HealingAbility(int healAmount) {
		super();
		this.healAmount = healAmount;
	}

	public int getHealAmount() {
		return healAmount;
	}

	public void setHealAmount(int healAmount) {
		this.healAmount = healAmount;
	}
	
	

}
