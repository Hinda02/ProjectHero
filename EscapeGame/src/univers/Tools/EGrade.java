package univers.Tools;

public enum EGrade {
	
	Minion(1), General(3), Supreme(5);
	
	private final int power;
	
	private EGrade(int power) {
		this.power = power;
	}
	
	public int getPower(){
		return this.power;
	}
	
	/**
	 * returns an enemy's power grade (grade)
	 */
	@Override
	public String toString() {
		
		String result = this.name();
		return result;
		
	}

}
