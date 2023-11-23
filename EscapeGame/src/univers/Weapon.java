package univers;

public enum Weapon {
	
	Aegis(10), PoseidonTrident(15), Caduceus(5), MedusaHead(15), Sword(10), Spear(8), Mjolnir(16), NULL(0), Varatha(30);

	private final int power;
	
	private Weapon(int power) {
		this.power = power;
	}
	
	public int getPower(){
		return this.power;
	}
	
	/**
	 * returns a weapon's characteristics (name + power)
	 */
	@Override
	public String toString() {
		
		String result = this.name() + " est une arme dont le niveau de puissance est de : " + this.power ;
		return result;
		
	}

}
