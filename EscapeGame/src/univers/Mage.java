package univers;

//class inherits from Personage
public class Mage extends Personage {
	
	//private attribute
	private int mp;

	/**
	 * Constructor for class Mage
	 * @param name
	 * @param weapon
	 */
	public Mage(String name, Weapon weapon) {
		super(name, weapon);
		super.setHp(200);
		super.setPower(150);
		this.mp = 100;
		
	}

	/**
	 * returns a mage's mp level
	 * @return int
	 */
	public int getMp() {
		return mp;
	}

	@Override
	public void fight(Personage opponent) {
		int damage = (int)((super.getPower())/10 + (2*super.getWeapon().getPower())/4 + (this.mp)/3);
		opponent.setHp(opponent.getHp() - damage);
		
		if(opponent.getHp() <= 0) {
			opponent.die();
		}
	}
	
	@Override
	public String toString() {
		
		String result = super.toString() + " \nPouvoir magique: " + mp + ".";
		
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(!(obj instanceof Mage)) {
			return false;
		}
		
		Mage mage = (Mage) obj;
		
		if(super.equals(mage) && (this.mp == mage.mp)) {
			return true;
		}else {
			return false;
		}
		
	}


}
