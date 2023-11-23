package univers;

//class inherits from Personage
public class Human extends Personage{

	/**
	 * Constructor for class Human
	 * @param name
	 * @param weapon
	 */
	public Human(String name, Weapon weapon) {
		super(name, weapon);
		super.setHp(100);
		super.setPower(100);
	}

	@Override
	public void fight(Personage opponent) {

		int damage = (int)((2*super.getPower())/5 + (3*super.getWeapon().getPower())/4);
		opponent.setHp(opponent.getHp() - damage);
		
		if(opponent.getHp() <= 0) {
			opponent.die();
		}
	}
	
	

}
