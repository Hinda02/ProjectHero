package main;

import java.util.ArrayList;


import java.util.List;
import java.util.Scanner;

import representation.*;
import univers.*;
import univers.Tools.Weapon;
import univers.Tools.EGrade;
import univers.Tools.Item;
import univers.persTypes.Angel;
import univers.persTypes.Demon;
import univers.persTypes.Enemy;
import univers.persTypes.Human;
import univers.persTypes.Mage;
import univers.persTypes.Personage;


public class Main {

	public static void main (String[] args) {
		
		// Characters
		
		Personage cerberus = new Enemy("Cerberus", Weapon.NULL, EGrade.Minion, 10, 100);
		Personage charon = new Enemy("Charon", Weapon.Aegis, EGrade.General, 1000, 1000);
		Personage hades = new Enemy("Hades", Weapon.Varatha, EGrade.Supreme, 1200, 1500);
		
		// Intro to Story 
		
		System.out.println("Zeus a perdu son �clair divin ! Il est s�r que quelqu'un l'a vol� pour \nr�aliser de mauvais desseins. Il promet d'exaucer le voeu de celui ou celle qui le lui rendra.");
		System.out.println("Vous d�cidez d'accepter cette qu�te. ");
		//System.out.println("Vos recherches vous am�nent jusqu'aux Enfers, le territoire d'Hades. \nPour entrer il vous faudra passer les serviteurs du roi des Enfers, notamment : \nCerberus et Charon. La premi�re �tape est Cerberus");
		
		
		// Choice of character data
		
		Scanner myObj = new Scanner(System.in);
		
	    String choice;
	    String nom;
	    int weapon;
	    
	    List<Weapon> weapons = new ArrayList<Weapon>();
	    
	    weapons.add(Weapon.Aegis);
	    weapons.add(Weapon.Caduceus);
	    weapons.add(Weapon.MedusaHead);
	    weapons.add(Weapon.Mjolnir);
	    weapons.add(Weapon.PoseidonTrident);
	    weapons.add(Weapon.Spear);
	    weapons.add(Weapon.Sword);
	    
		System.out.println("Choisis ton personnage parmis: (Saisissez une des classes suivantes)");
		System.out.println("Humain _ Mage _ Ange _ Demon");

		//get player input
	    choice = myObj.next(); 
	    
		System.out.println("Personnalise ton personnage:");
		System.out.println("Nom:");
		
		//get player input
		nom = myObj.next();
		
		System.out.println("Choisis ton arme: (Saisissez le num�ro de l'arme)");
		int i = 0;
		for(Weapon item : weapons) {
			i++;
			System.out.println(i + ": " + item.toString());
		}
		
		//get player input
		weapon = myObj.nextInt();
		Weapon w = weapons.get(weapon-1);
		
	    //Initialize a player
		Personage player = null;
		
		
		
		
		// Nodes (story line)
	    // Petite histoire TEST
	    // 1- Le joueur se trouve face � un ennemi (Cerberus)
	    // 2- Il fait son premier choix de l'attaquer ou de faire diversion
	    // 3- Cas diversion: il r�ussira ou �chouera al�atoirement (ChanceNode)
	    // 4- Cas attaque: il faut calculer correctement pour se battre (InnerNode)
		
		Node node15 = new TerminalNode(15, "Dead face a Hades");
		Node node14 = new TerminalNode(14, "eclaire de zeus");
		Node node12 = new InnerNode(12, "Combattre Hades", node14, node15);
		Node node10 = new ChanceNode(10, "Hades", node14, node12);
        Node node5 = new TerminalNode(5, "Votre diversion �tait parfaite. Malheureusement, vous \ntr�buchez sur une pierre et Cerberus vous attrape! Partie perdue!");
        Node node13 = new TerminalNode(13, "Dead face a charon");
	    Node node4 = new InnerNode(4, "F�licitations ! Votre diversion a fonctionn�.combat contre charon", node10, node13);
	    Node node9 = new InnerNode(9, "Utiliser l'obole", node10, node4);
        Node node6 = new InnerNode(6, "Vous avez gagn� le combat! ;) cerberus dropped an item that will help beat charon. write its name to pick it up.", node9, node4);
        Node node7 = new TerminalNode(7, "Cerberus vous a battu! :(");
        Node node2 = new ChanceNode(2, "Vous d�cidez de faire diversion", node4, node5);
        Node node3 = new InnerNode(3, "Vous d�cidez de combattre Cerberus", node6, node7);
	    Node node1 = new DecisionNode(1, "Vous vous retrouvez devant la tani�re de Cerberus, que \nsouhaitez vous faire ? Le combattre ou Faire diversion ?", node2, node3);
		
		/*ArrayList<Node> nodes = new ArrayList<Node>();
		nodes.add(node1);
		nodes.add(node2);
		nodes.add(node3);
		nodes.add(node4);
		nodes.add(node5);
		nodes.add(node6);
		nodes.add(node7);
		nodes.add(node8);
		nodes.add(node9);
		nodes.add(node10);
		nodes.add(node11);
		nodes.add(node12);
		nodes.add(node13);
		nodes.add(node14);
		nodes.add(node15);*/
		
		
		//Initialize a currentNode
		Node currentNode = null;
		
		//Create player object
	    switch(choice) {
	    
		    case "Humain":
		    	player = new Human(nom, w);
		    	currentNode = node1;
		    	break;
		    	
		    case "Mage":
		    	player = new Mage(nom, w);
		    	currentNode = node1;
		    	break;
		    	
		    case "Ange":
		    	player = new Angel(nom, w);
		    	currentNode = node1;
		    	break;
		    	
		    case "Demon":
		    	player = new Demon(nom, w);
		    	currentNode = node1;
		    	break;
		    	
		    default:
		    	player = new Human(nom, w);
		    	currentNode = node1;
		    	break;
	    }
		
		
		//Display player data
	    System.out.println(player.toString()); 
        

	    
	    
       //Main Code (Game)
	    
	    System.out.println();
	    currentNode.display();
	    currentNode = currentNode.chooseNext();
	    
	    while(!(currentNode instanceof TerminalNode)) {
	    	
	    	if(!(currentNode instanceof DecisionNode) && !(currentNode instanceof ChanceNode) && !(currentNode.equals(node6)) && !(currentNode.equals(node9))) {
		    	if(currentNode.equals(node3)) {
		    		currentNode = currentNode.chooseNext(player, cerberus);
		    	}else if(currentNode.equals(node4)) {
		    		currentNode = currentNode.chooseNext(player, charon);
		    	}else {
		    		currentNode = currentNode.chooseNext(player, hades);
		    	}
	    		
		    	
		    }else {
		    	if(currentNode.equals(node6)) {
		    		
		    		String rep = myObj.next();
		    		if(rep.equals("obole")) {
		    			player.getInventory().put(Item.OboleOfCharon, 1);
		    		}
		    		
		    		currentNode = currentNode.chooseNext(player);
		    		
		    	}else {
			    	currentNode = currentNode.chooseNext();

		    	}
		    }
		   
		    currentNode.display();
	    }
	    
	    myObj.close();

}

	}
