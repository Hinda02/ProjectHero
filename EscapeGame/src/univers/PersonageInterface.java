package univers;

/**
 * Interface that defines the mandatory methods for Personage classes
 */
public interface PersonageInterface {
	
	void fight(Personage opponent);
	
	void die();
	
	String toString();
	
	boolean equals(Object obj);
}
