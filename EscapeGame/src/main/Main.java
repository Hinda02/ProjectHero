package main;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

import representation.*;
import univers.*;


public class Main {

	public static void main (String[] args) {
		
		// Characters
		
		Personage cerberus = new Enemy("Cerberus",Weapon.NULL,1000, 1000);
		Personage charon = new Enemy("Charon",Weapon.Aegis,1000, 1000);
		Personage hades = new Enemy("Hades",Weapon.Varatha,1200, 1500);
		
		// Intro to Story 
		
		System.out.println("Zeus a perdu son �clair divin ! Il est s�r que quelqu'un l'a vol� pour \nr�aliser de mauvais desseins. Il promet d'exaucer le voeu de celui ou celle qui le lui rendra.");
		System.out.println("Vous d�cidez d'accepter cette qu�te. ");
		System.out.println("Vos recherches vous am�nent jusqu'aux Enfers, le territoire d'Hades. \nPour entrer il vous faudra passer les serviteurs du roi des Enfers, notamment : \nCerberus et Charon. La premi�re �tape est Cerberus");
		
		
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
		//Create player object
	    switch(choice) {
	    
		    case "Humain":
		    	player = new Human(nom, w);
		    	break;
		    	
		    case "Mage":
		    	player = new Mage(nom, w);
		    	break;
		    	
		    case "Ange":
		    	player = new Angel(nom, w);
		    	break;
		    	
		    case "Demon":
		    	player = new Demon(nom, w);
		    	break;
		    	
		    default:
		    	player = new Human(nom, w);
		    	break;
	    }
		
		
		//Display player data
	    System.out.println(player.toString());
		
		
		// Nodes (story line)
	    // Petite histoire TEST
	    // 1- Le joueur se trouve face � un ennemi (Cerberus)
	    // 2- Il fait son premier choix de l'attaquer ou de faire diversion
	    // 3- Cas diversion: il r�ussira ou �chouera al�atoirement (ChanceNode)
	    // 4- Cas attaque: il faut calculer correctement pour se battre (InnerNode)
	    
	    Node node4 = new TerminalNode(4, "F�licitations ! Votre diversion a fonctionn�. En vous \naventurant plus profond�ment dans les Enfers, vous vous retrouvez face � l'�clair de Zeus! Partie gagn�e! ");
        
        Node node5 = new TerminalNode(5, "Votre diversion �tait parfaite. Malheureusement, vous \ntr�buchez sur une pierre et Cerberus vous attrape! Partie perdue!");
        
        Node node6 = new TerminalNode(6, "Vous avez gagn� le combat! ;)");
        
        Node node7 = new TerminalNode(7, "Cerberus vous a battu! :(");
        
        Node node2 = new ChanceNode(2, "Vous d�cidez de faire diversion", node4, node5);
        
        Node node3 = new InnerNode(3, "Vous d�cidez de combattre Cerberus", node6, node7);
	    
	    Node node1 = new DecisionNode(1, "Vous vous retrouvez devant la tani�re de Cerberus, que \nsouhaitez vous faire ? Le combattre ou Faire diversion ?", 
                node2,
                node3);
	    
      
        
        

       //Main Code (Game)
	    
	    Node actualNode = node1;
	    System.out.println();
	    actualNode.display();
	    actualNode = actualNode.chooseNext();
	    
	    if(!(actualNode instanceof DecisionNode) && !(actualNode instanceof ChanceNode)) {
	    	actualNode = actualNode.chooseNext(player, cerberus);
	    	
	    }else {
	    	actualNode = actualNode.chooseNext();
	    }
	   
	    actualNode.display();
	    
	    myObj.close();

}

	}
