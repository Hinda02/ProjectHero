package representation;

import java.util.ArrayList;

import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import univers.Personage;

public class InnerNode extends Node{

	//protected attribute containing next possible nodes
	protected List<Node> nodes = new ArrayList<Node>();
	
	/**
	 * Constructor for class InnerNode
	 * @param id
	 * @param description
	 * @param n1
	 * @param n2
	 */
	public InnerNode(int id, String description, Node n1, Node n2) {
		super(id, description);
		this.nodes.add(n1);
		this.nodes.add(n2);
		
	}

	/**
	 * Not to be used for this class!
	 */
	@Override
	public Node chooseNext() {
		return null;
	}
	
	/**
	 * returns next node
	 * according to whether the player wins or loses the combat
	 */
	public Node chooseNext(Personage player, Personage opponent) {
				
		System.out.println("Attaquez l'ennemi en répondant correctement aux calculs.");
		
		//_____________ The opponent's fighting section ____________
		//defines a runnable that executes the enemy's fight() method
    	Runnable oppFightRunnable = new Runnable() {
		    public void run() {
		        opponent.fight(player);
		    }
		};
		
		//a scheduled thread that executes the runnable every 10 seconds
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
		executor.scheduleAtFixedRate(oppFightRunnable, 0, 10, TimeUnit.SECONDS);
		
		//runnable code taken from: https://stackoverflow.com/questions/12908412/print-hello-world-every-x-seconds
		//___________________________________________________________
		
			
		while(player.isAlive() && opponent.isAlive()) {
		
			//mathematical expressions are generated to symbolize 
			//a player's fight move
			int res = generateExp();
			
			//get the player's input
			Scanner myObj = new Scanner(System.in);
		    int response;
		    response = myObj.nextInt(); 
		    
		    //if the player's response to the equation is correct
		    //he fights
		    if(res == response) {
		    	
		    	player.fight(opponent);
		    	

		    }
		}
		    
			
		if(player.isAlive()) {
			executor.shutdown();
			return this.nodes.get(0);
		}else {
			executor.shutdown();
			return this.nodes.get(1);
		}
		
	    
	}
	
	/**
	 * generates a mathematical expression
	 * code inspired by Calculate() method
	 * on: https://www.geeksforgeeks.org/build-a-calculate-expression-game-in-java/
	 * @return int
	 */
	private int generateExp() {
		
		int num1 = new Random().nextInt(11); // 0 to 10 
        int num2 = new Random().nextInt(12); // 1 to 11 
        
        String operator = "+-*"; 
        int random_operator = new Random().nextInt(3); 
        
        System.out.println("(" + num1 + ") " + operator.charAt(random_operator) + " (" + num2 + ")");
        
        return switch (operator.charAt(random_operator)) { 
        case ('+') -> num1 + num2; 
        case ('-') -> num1 - num2; 
        case ('*') -> num1 * num2;  
        default -> 0; 
        };
        
	}
	
	/**
	 * returns the InnerNode's info
	 * @return String
	 */
	@Override
	public String toString() {
		
		String result = super.toString() + " \n Prédecesseur de : " ;
		for(Node item : nodes) {
			result += "\n" + item.toString();
		}
		return result; 
		
	}
	
	/**
	 * compares two objects of type InnerNode
	 * @return boolean
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj == this) {
			return true;
		}
		
		if (!(obj instanceof InnerNode)) {
			return false;
		}
		
		InnerNode innerNode = (InnerNode) obj;
		
		if(!super.equals(innerNode)) {
			return false;
		}
		
		for(int i =0; i < nodes.size(); i++) {
			if(nodes.get(i).equals(innerNode.nodes.get(i))) {
				return false; 
			}
			
		}
		return true;
	}
	
	
	
	
	
}
