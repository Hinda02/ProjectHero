package representation;

public class TerminalNode extends Node {
	
	/**
	 * Constructor for class TerminalNode
	 * @param id
	 * @param description
	 */
	public TerminalNode(int id, String description) {
		super(id, description);
	}
	
	/**
	 * returns this same node
	 */
	@Override
	public Node chooseNext() {
		return this;
	}
}
