package model.abilities;

import model.effects.Effect;

public class CrowdControlAbility extends Ability {
	Effect effect;

	public CrowdControlAbility(Effect effect) {
		super();
		this.effect = effect;
	}

	public Effect getEffect() {
		return effect;
	}
	
	

}
