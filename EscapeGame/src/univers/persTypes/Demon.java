package univers.persTypes;

import java.util.Random;

import univers.Tools.Weapon;

//class inherits from Angel
public class Demon extends Angel {
	
	//private attribute
	private int curse;

	/**
	 * Constructor for class Demon
	 * @param name
	 * @param weapon
	 */
	public Demon(String name, Weapon weapon) {
		super(name, weapon);
		super.setHp(250);
		super.setPower(70);
		super.setBlessing(20);
		//random curse number between -30 and 30
		Random rand = new Random();
		this.curse = rand.nextInt(60) - 30;
	}
	
	@Override
	public void fight(Personage opponent) {

		int damage = (int)((3*super.getPower())/5 + (3*super.getWeapon().getPower())/4);
		opponent.setHp(opponent.getHp() - damage);
		super.setHp(super.getHp() + super.getBlessing());
		super.setHp(super.getHp() + this.curse);
		
		if(opponent.getHp() <= 0) {
			opponent.die();
		}
	}
	
	@Override
	public String toString() {
		
		String result = super.toString() + " \nPuissance de malédiction: " + curse + ".";
		
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(!(obj instanceof Demon)) {
			return false;
		}
		
		Demon thing = (Demon) obj;
		
		if(super.equals(thing) && (this.curse == thing.curse)) {
			return true;
		}else {
			return false;
		}
		
	}

}
