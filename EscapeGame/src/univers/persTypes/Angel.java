package univers.persTypes;

import univers.Tools.Weapon;

//class inherits from Personage
public class Angel extends Personage{

	//private attribute
	private int blessing;

	/**
	 * Constructor for class Angel
	 * @param name
	 * @param weapon
	 */
	public Angel(String name, Weapon weapon) {
		super(name, weapon);
		super.setHp(250);
		super.setPower(70);
		this.blessing = 60;
	}

	/**
	 * returns blessing level
	 * @return int
	 */
	public int getBlessing() {
		return blessing;
	}

	/**
	 * sets blessing level
	 * to be accessed in this class and its inheriting classes
	 * @param blessing
	 */
	protected void setBlessing(int blessing) {
		this.blessing = blessing;
	}

	@Override
	public void fight(Personage opponent) {

		int damage = (int)((3*super.getPower())/5 + (3*super.getWeapon().getPower())/4);
		opponent.setHp(opponent.getHp() - damage);
		super.setHp(super.getHp() + this.blessing);
		
		if(opponent.getHp() <= 0) {
			opponent.die();
		}
	}
	
	@Override
	public String toString() {
		
		String result = super.toString() + " \nPuissance de bénédiction : " + blessing + ".";
		
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(!(obj instanceof Angel)) {
			return false;
		}
		
		Angel thing = (Angel) obj;
		
		if(super.equals(thing) && (this.blessing == thing.blessing)) {
			return true;
		}else {
			return false;
		}
		
	}

	
}
