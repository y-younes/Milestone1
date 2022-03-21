package model.abilities;

public class DamagingAbility extends Ability {
	private int damageAmount;

	public DamagingAbility(int damageAmount) {
		super();
		this.damageAmount = damageAmount;
	}

	public int getDamageAmount() {
		return damageAmount;
	}

	public void setDamageAmount(int damageAmount) {
		this.damageAmount = damageAmount;
	}
	
	

}
