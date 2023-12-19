package representation;

public class UniqueNextNode extends Node {
	private Node nextNode;
	/**
	 * Constructor for class UniqueNextNode
	 * @param id
	 * @param description
	 * @param nextNode
	 */
	public UniqueNextNode(int id, String description, Node nextNode) {
		super(id, description);
		this.nextNode = nextNode;
	}
	
	/**
	 * Return the next node
	 */
	@Override
	public Node chooseNext() {
		return this.nextNode;
	}

	@Override
	public void display() {
		super.display();
	}

	@Override
	public String toString() {
		String result = super.toString() + "Prédecesseur de : " + nextNode.toString();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == this) {
			return true;
		}
		
		if (!(obj instanceof UniqueNextNode)) {
			return false;
		}
		
		UniqueNextNode uniqueNextNode = (UniqueNextNode) obj;
		
		if(!super.equals(uniqueNextNode)) {
			return false;
		}
		
		
		if(!(nextNode.equals(uniqueNextNode.nextNode))) {
				return false; 
		}
			
		
		return true;
	}
	
	
}
