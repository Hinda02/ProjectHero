package representation;

import java.util.List;
import java.util.Scanner;

//class inherits from InnerNode
public class DecisionNode extends InnerNode{

	/**
	 * Constructor for class DecisionNode
	 * @param id
	 * @param description
	 * @param n1
	 * @param n2
	 */
	public DecisionNode(int id, String description, Node n1, Node n2) {
		super(id, description, n1, n2);
	}
	/**
	 * Constructor for class DecisionNode
	 * @param id
	 * @param description
	 * @param nodes
	 */
	public DecisionNode(int id, String description, List<Node> nodes) {
		super(id, description, nodes);
	}

	/**
	 * returns the next node
	 * according to the player's choice
	 */
	@Override
	public Node chooseNext() {
			
			int i = 0;
			
			System.out.println("Saisissez le numéro de votre choix:");
			
	        for(Node item : this.nodes) {
              i++;
              System.out.println();
              System.out.print(i + ": " );
              item.display();
	        }	
		
	        //get the player's input
		    Scanner myObj = new Scanner(System.in);
		    int node;
		    
		    node = myObj.nextInt(); 
		    
		    return this.nodes.get(node-1);
			
	}
}
