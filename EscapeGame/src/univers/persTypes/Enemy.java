package univers.persTypes;

import univers.Tools.Weapon;
import univers.Tools.EGrade;


//class inherits from Personage
public class Enemy extends Personage{
	
	//private attribute
	private int specialAttack = 1;
	private EGrade grade;//look up a use for this
	
	/**
	 * Constructor for class Enemy
	 * @param name
	 * @param weapon
	 * @param hp
	 * @param power
	 */
	public Enemy(String name, Weapon weapon, EGrade grade, int hp, int power) {
		super(name, weapon);
		super.setHp(hp);
		super.setPower(power);
		this.grade = grade;
		
	}
	
	/**
	 * returns specialAttack points
	 * @return int
	 */
	public int getSpecialAttack() {
		return specialAttack;
	}

	/**
	 * sets specialAttack points
	 * @param specialAttack
	 */
	public void setSpecialAttack(int specialAttack) {
		this.specialAttack = specialAttack;
	}
	
	@Override
	public void fight(Personage opponent) {
		int damage =  0;
	
		if((this.getSpecialAttack() % 4) == 0 ) {
			damage = (int)((super.getPower()/10) + super.getWeapon().getPower());

			opponent.setHp(opponent.getHp() - damage);
			
			if(opponent.getHp() <= 0) {
				opponent.die();
			} 
			
		}else {
			
			damage = (int)(super.getPower()/20);
			opponent.setHp(opponent.getHp() - damage);
			
			if(opponent.getHp() <= 0) {
				opponent.die();
			}
			this.setSpecialAttack(this.getSpecialAttack()+1);
		}
		
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(!(obj instanceof Enemy)) {
			return false;
		}
		
		Enemy enemy = (Enemy) obj;
		
		if(super.equals(enemy) && (this.specialAttack == enemy.specialAttack)) {
			return true;
		}else {
			return false;
		}
		
	}
	
	
}
