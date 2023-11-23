package univers;

//class implements PersonageInterface
public abstract class Personage implements PersonageInterface {
	
	//private attributes
	private String name;
	private int hp;
	private int power;
	private Weapon weapon;
	private boolean alive = true;
	
	/**
	 * Constructor for class Personage
	 * @param name
	 * @param weapon
	 */
	public Personage(String name, Weapon weapon) {
		this.name = name;
		this.hp = 0;
		this.power = 0;
		this.weapon = weapon;
	}
	
	/**
	 * returns true if personage is alive
	 * otherwise false
	 * @return boolean
	 */
	public boolean isAlive() {
		return alive;
	}

	/**
	 * returns personage's name
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * returns personage's hp level
	 * @return int
	 */
	public int getHp() {
		return hp;
	}

	/**
	 * modifies a personage's hp level
	 */
	public void setHp(int hp) {
		this.hp = hp;
	}

	/**
	 * returns personage's power level
	 * @return int
	 */
	public int getPower() {
		return power;
	}

	/**
	 * modifies a personage's power level
	 */
	public void setPower(int power) {
		this.power = power;
	}

	/**
	 * returns personage's weapon of choice
	 * @return Weapon
	 */
	public Weapon getWeapon() {
		return weapon;
	}


	/**
	 * abstract methods that deducts damage points from the opponent's hp level
	 */
	public abstract void fight(Personage opponent);
	

	/**
	 * sets alive attribute to false
	 */
	public void die() {
		
		this.alive = false;
		
	}
	
	/**
	 * returns the personage's info
	 * @return String
	 */
	@Override
	public String toString() {
		
		String result = name + " est ";
		
		if(alive) {
			result += "en vie.\n";
		}else {
			result += "mort.\n";
		}
		
		result += "Points de vie: " + hp + ". \nNiveau de puissance: " + power + ". \nArme équipée: " + weapon + ".";
		
		return result;
	}
	
	/**
	 * compares two objects of type Personage
	 * @return boolean
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj == this) {
			return true;
		}
		
		if (!(obj instanceof Personage)) {
			return false;
		}
		
		Personage personage = (Personage) obj;
		
		if((this.name == personage.name) && (this.alive == personage.alive) && (this.hp == personage.hp) && (this.power == personage.power) && (this.weapon == personage.weapon)) {
			return true;
		}else {
			return false;
		}
	}

}
