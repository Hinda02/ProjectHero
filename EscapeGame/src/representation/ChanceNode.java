package representation;

import java.util.Random;

//Class inherits from InnerNode
public class ChanceNode extends InnerNode{

	/**
	 * Constructor for class ChanceNode
	 * @param id
	 * @param description
	 * @param n1
	 * @param n2
	 */
	public ChanceNode(int id, String description, Node n1, Node n2) {
		super(id, description, n1, n2);
	}
	
	/**
	 * returns a random node from in between 2
	 */
	@Override
	public Node chooseNext() {
			
			
        Random rand = new Random();
   
        // Generate random integers in range 0 to 1
        int randNode = rand.nextInt(2);
        
        while(this.nodes.get(randNode) == null) {
        	randNode = rand.nextInt(2);
        }
        
        return this.nodes.get(randNode);
			
	}

	
}
