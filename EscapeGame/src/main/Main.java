package main;

import java.util.ArrayList;
import java.util.Arrays;
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
		Personage hephaistos = new Enemy("Hephaistos", Weapon.NULL,EGrade.Minion ,20, 20);
		Personage ares = new Enemy("Ares", Weapon.NULL,EGrade.General, 20, 20);
		Personage posseidon = new Enemy("Posseidon", Weapon.NULL,EGrade.Supreme, 20, 20);
		Personage achilles = new Enemy("Posseidon", Weapon.NULL,EGrade.General, 20, 20);
		Personage mistress = new Enemy("Hord of Mistress", Weapon.NULL,EGrade.Minion, 20, 20);
		Personage zeus = new Enemy("Zeus", Weapon.NULL,EGrade.Supreme, 20, 20);
		Personage hera = new Enemy("Hera", Weapon.NULL,EGrade.Supreme, 20, 20);
		
		
		// Intro to Story 
		
		System.out.println("Zeus a perdu son ï¿½clair divin ! Il est sï¿½r que quelqu'un l'a volï¿½ pour \nrï¿½aliser de mauvais desseins. Il promet d'exaucer le voeu de celui ou celle qui le lui rendra.");
		System.out.println("Vous dï¿½cidez d'accepter cette quï¿½te. ");
		//System.out.println("Vos recherches vous amï¿½nent jusqu'aux Enfers, le territoire d'Hades. \nPour entrer il vous faudra passer les serviteurs du roi des Enfers, notamment : \nCerberus et Charon. La premiï¿½re ï¿½tape est Cerberus");
		
		
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
		
		System.out.println("Choisis ton arme: (Saisissez le numï¿½ro de l'arme)");
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
	    // 1- Le joueur se trouve face ï¿½ un ennemi (Cerberus)
	    // 2- Il fait son premier choix de l'attaquer ou de faire diversion
	    // 3- Cas diversion: il rï¿½ussira ou ï¿½chouera alï¿½atoirement (ChanceNode)
	    // 4- Cas attaque: il faut calculer correctement pour se battre (InnerNode)
		
		Node node15 = new TerminalNode(15, "Dead face a Hades");
		Node node14 = new TerminalNode(14, "eclaire de zeus");
		Node node12 = new InnerNode(12, "Combattre Hades", node14, node15);
		Node node10 = new ChanceNode(10, "Hades", node14, node12);
        Node node5 = new TerminalNode(5, "Votre diversion ï¿½tait parfaite. Malheureusement, vous \ntrï¿½buchez sur une pierre et Cerberus vous attrape! Partie perdue!");
        Node node13 = new TerminalNode(13, "Dead face a charon");
	    Node node4 = new InnerNode(4, "Fï¿½licitations ! Votre diversion a fonctionnï¿½.combat contre charon", node10, node13);
	    Node node9 = new InnerNode(9, "Utiliser l'obole", node10, node4);
        Node node6 = new InnerNode(6, "Vous avez gagnï¿½ le combat! ;) cerberus dropped an item that will help beat charon. write its name to pick it up.", node9, node4);
        Node node7 = new TerminalNode(7, "Cerberus vous a battu! :(");
        Node node2 = new ChanceNode(2, "Vous dï¿½cidez de faire diversion", node4, node5);
        Node node3 = new InnerNode(3, "Vous dï¿½cidez de combattre Cerberus", node6, node7);
	    Node node1 = new DecisionNode(1, "Vous vous retrouvez devant la taniï¿½re de Cerberus, que \nsouhaitez vous faire ? Le combattre ou Faire diversion ?", node2, node3);
		
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
		
// Mage
	    
	    Node mageKeepStormDesc = new TerminalNode(101, "Vous decidez de garder l'éclair de Zeus. \nEn effet, c'est la juste récompense pour avoir traversé tous ses obstacles. \nVotre décision plonge le monde dans le chaos et provoque la colère de Zeus et des autres Dieux. \nVous survivez au chaos grâce à l'éclair.");
	    Node mageGiveStormDesc = new TerminalNode(102, "Vous rendez l'éclair divin à son propriétaire. \nAinsi, vous ramenez le calme dans la monde. \nDe plus, Zeus vous exauce votre voeu le plus cher. \nVOUS ÊTES UN GRAND HEROS !");
	    
	    Node mageKeepStorm = new UniqueNextNode(103, "Vous decidez de garder l'éclair de Zeus. ",mageKeepStormDesc);
	    Node mageGiveStorm = new UniqueNextNode(104, "Vous rendez l'éclair divin à son propriétaire.", mageGiveStormDesc);
	    
	    
	    //// Fountain Path
	    
	    Node mageZeusLose = new TerminalNode(105, "Vous perdez contre Zeus ! Pour punition contre cette affront, votre âme connaitra le tourment éternel.");
	    Node mageZeusWin = new TerminalNode(106, "INCROYABLE ! Ce jour est à marqué d'une pierre blanche ! \nVOUS êtes le nouveau roi des Dieux");
	    Node mageZeusFight = new InnerNode(107,"Vous décidez de combattre Zeus pour mettre fin à toute cette injustice en vous alliant à ses différentes maitresses!", 
	    		mageZeusWin,
	    		mageZeusLose
	    		);
	    Node mageWomenLose = new TerminalNode(108, "Vous vous êtes battu comme vous le pouviez malheureusement, elles étaient trop nombreuses. Vous êtes vaincu...");
	    Node mageWomenWin = new DecisionNode(109, "Vous vous êtes bien battu. Vous avez gagné contre les maitresses de Zeus et repartez avec l'éclair.",
	    		mageKeepStorm,
	    		mageGiveStorm);
	    Node mageWomenFight = new InnerNode(110, "Vous refusez de vous ranger aux côtés des femmes. Elles se réunissent autour de vous et vous attaquent. Défendez-vous! ",
	    		mageWomenWin,
	    		mageWomenLose);
	    Node mageFollowWomen = new UniqueNextNode(111, "Vous décidez de suivre le mouvement de ses femmes dont Zeus a fait du tord !", mageZeusFight );
	    Node mageThetisTalk = new DecisionNode(112, "Thétis vous avoue qu'elle et plusieurs femmes se sont réunies pour battre Zeus. \n \" Oh grand héros ! Rejoins-nous pour faire face à cette injustice !\" ", 
	    		mageFollowWomen,
	    		mageWomenFight
	    		);
	    Node mageAchillesLose = new TerminalNode(113, "Vous vous êtes battu comme vous le pouviez malheureusement, Achille n'a pas volé son titre de héros. \nDans une autre vie peut être que vous auriez gagné... ");
	    
	    Node mageThetisRevenge = new TerminalNode(114, "Thetis s'effondre. Elle se retrouve sans enfant. Elle décide de sauter  dans le lac en vous tenant afin de vous donner la mort avec elle.");
	    Node mageHeadlessImpossible = new TerminalNode(115, "N'avez vous jamais entendu parlé de talon d'Achille ? \nC'est son point faible! \nNe pas savoir cela vous a couté la vie. ");
	    Node mageAchillesHeadChop = new UniqueNextNode(116, "Vous décidez de couper la tête d'Achille",mageHeadlessImpossible);
	    Node mageAchillesClemence = new UniqueNextNode(117,"Pour votre clémence, Thétis vous propose de vous donner de l'eau d'une source pour soigner vos blessures. ",mageThetisTalk);	
	    Node mageAchillesStandUp = new UniqueNextNode(118,"Achilles se relève. Cette fois-ci il ne rate pas votre tête. \nVous êtes mort.", mageAchillesLose);	
	    Node mageAchillesNothing = new ChanceNode(119, "Vous décidez de le laisser tranquille",
	    		mageAchillesClemence,
	    		mageAchillesStandUp
	    		);
	    Node mageAchillesHeel = new UniqueNextNode(120,"Vous décidez de couper les chevilles d'Achille",mageThetisRevenge);
	    Node mageAchillesWin = new DecisionNode(121, "Quand 2 héros s'affrontent, celui qui gagne se doit de couper la tête du perdant. Qu'allez-vous faire ?",
	    		Arrays.asList(mageAchillesHeadChop,
	    	    		mageAchillesHeel,
	    	    		mageAchillesNothing)
	    		);
	    Node mageAchillesFight = new InnerNode(122, "En provoquant Thétis, vous provoquez la colère de son fils qui décide de vous combatre à sa place",
	    		mageAchillesWin,
	    		mageAchillesLose);
	    Node mageThetisMeet = new UniqueNextNode(123,"Vous décidez de parler à Thétis",mageThetisTalk );
	    Node mageThetisFight = new UniqueNextNode(124, "Vous décidez d'attaquer Thétis.", mageAchillesFight);
	    Node mageThetis = new DecisionNode(125,"Vous retrouvez Thétis face à un lac.",
	    		mageThetisMeet,
	    		mageThetisFight
	    		);
	    Node mageThetisCoupable = new UniqueNextNode(126, "Thétis", mageThetis);
	    
	    //// Flower Path
	    Node mageLetStormDesc = new TerminalNode(127, "Vous décidez de les laisser se venger de Zeus. \nVOUS N'AUREZ JAMAIS VOTRE NOM INSCRIS \nDANS LES PLUS GRANDS LIVRES D'HISTOIRE !");
	    Node mageLetStormHeraDesc = new TerminalNode(128, "La vengeance d'Héra est fondée. Zeus mérite une punition ! \nVous décidez de la laisser faire en oubliant tout vos désirs d'entrer dans la légende. ");
	    
	    Node mageLetStorm = new UniqueNextNode(129, "Vous comprenez l'objectif des fils d'Héra.", mageLetStormDesc);
	    Node mageLetStormHera = new UniqueNextNode(130, "Vous ne reprenez pas la foudre. ", mageLetStormHeraDesc);
	    Node mageStormChoice = new DecisionNode(131, "Vous avez gagné le combat contre Arès ! ", 
	    		Arrays.asList(mageKeepStorm, mageGiveStorm,mageLetStorm)
	    		);
	    Node mageAresDeath = new TerminalNode(132, "Arès vous a battu :( ");
	    Node mageAresFight = new InnerNode(133, "Arès, le Dieu de la guerre.\nC'est lui qui, poussé par la colère, a volé le trèsor du souverain des Dieux. \nPrévenu de votre venu, il vous accueille la lance à la main ! \nBattez-vous pour récupérer la foudre !", 
	    		mageStormChoice,
	    		mageAresDeath);
	    Node mageHeraDeath = new TerminalNode(134, "Hera vous a battu :( ");
	    Node mageHeraStormChoice = new DecisionNode(135, "Héra est vaincue ! ", 
	    		Arrays.asList(mageKeepStorm, mageGiveStorm,mageLetStormHera)
	    		);
	    Node mageHeraFight = new InnerNode(136,"Depuis le début, c'était Héra qui possédait la foudre ! \nPrévenue de votre arrivée par son fils, elle se jette sur vous, son sceptre à la main. ", 
	    		mageHeraStormChoice,
	    		mageHeraDeath
	    		);
	    Node mageAresOrHera = new ChanceNode(137, "Vous décidez de parler avec Hephaistos. \nIl vous donne le nom du détenteur de l'écair. Vous n'en croyez pas vos oreilles...", 
	    		mageAresFight,
	    		mageHeraFight
	    		);
	    Node mageHephaLost = new TerminalNode(138, "Hephaistos vous tue à l'aide de son marteau. Il ne reste plus rien de vous...");
	    Node mageHephaWin = new UniqueNextNode(139, "Vous avez gagné le combat contre Hephaistos :) \nEn échange de votre bravoure, il vous livre le nom de son frère. ", mageAresFight);
	    Node mageHephaistosFight = new InnerNode(140, "Vous décidez de combattre Hephaistos.",
	    		mageHephaWin,
	    		mageHephaLost
	    		);
	    Node mageHephaistosMeet = new DecisionNode(141, "Vous vous dirigez vers la forge, le territoire d'Hephaistos. Vous avez le choix entre lui demander de l'aide et le combattre. ", 
	    		mageAresOrHera,
	    		mageHephaistosFight
	    		);
	    Node mageHeraHepha = new UniqueNextNode(142, "Héra est touchée par votre sensibilité vis-à-vis de sa situation. \nElle n'avait jamais croisé un inconnu avec une âme aussi pure. \nEn pleurs, elle avoue que par amour ses fils ont décidé de la venger de Zeus.", mageHephaistosMeet);
	    Node mageAgreeHera = new UniqueNextNode(143, "Vous êtes d'accord avec elle ! Elle n'a pas à subir l'adultère de Zeus !", mageHeraHepha);
	    Node mageDisagreeDeath = new TerminalNode(144, "Vous mourez empoisonné, seul,  dans ce labyrinthe de fleurs ensanglantées de votre propre sang... ");	    
	    
	    /// Fountain Path suite 
	    
	    // Nymphes
	    
	    Node mageHypnosis = new TerminalNode(145,"Les nymphes aquatiques vous offrent des friandises aux fleurs de lotus. \nVous ne voyez pas le temps passer. \nVous finnissez par être emprisonné dans une illusion sans fin. \nFIN");
	    Node mageNymphes = new UniqueNextNode(146,"Vous vous retrouvez entouré de nymphes auqatiques.",mageHypnosis);
	    
	    
	    // Hera suite
	    
	    Node mageDisagreeMiracle = new UniqueNextNode(147, "Une petite nymphe aquatique vous a suivi pendant tout votre périple et s'est pris d'affection pour vous ! \n Elle soigne tant bien que mal vos blessures. \n Elle vous ramène près d'une source d'eau où se trouvent d'autres nymphes. ",mageNymphes);
	    Node mageHeraKill = new ChanceNode(148,"Héra est en FURIEUSE ! Elle décide de lancer ses serpents sur vous. \nIls vous mordent et vous empoisonnent.",mageDisagreeDeath,mageDisagreeMiracle);
	    Node mageDisagreeHera = new UniqueNextNode(149, "Vous n'êtes pas d'accord avec elle ! Bien que Zeus continue à courtiser d'autres femmes, c'est le privilège du Roi !", mageHeraKill);
	    
	   //Attention ! Risque de cycle ! 
	    Node mageHeraNotTalk = new UniqueNextNode(150, "Vous décidez de ne pas parler à Héra. Elle fait bient trop peur ! Vous reborussez chemin...", mageThetis); 
	    Node mageOpinionHera = new DecisionNode(151, "Héra vous explique sa situation : \nZeus, son mari, la trompe une fois encore. \nElle ne sait plus quoi faire pour l'empêcher de continuer. \nElle veut que Zeus souffre mais ne sait pas si c'est une bonne idée de s'attirer les foudres du dieu de la foudre en ce moment...",
	    		mageDisagreeHera,
	    		mageAgreeHera
	    		); 
	    Node mageHeraTalk = new UniqueNextNode(152, "Vous décidez de parler à Héra",mageOpinionHera);  
	    Node mageHeraMeet = new DecisionNode(153,"En avançant, vous remarquez que l'allée de fleurs menait en fait vers un labyrithe de hautes herbes. \nVous vous retrouvez face à une femme magnifique. \nSans aucun doute, il s'agit bien de Héra, la déesse du foyer.",
	    		mageHeraTalk,
	    		mageHeraNotTalk
	    		); 
	    Node mageFlowerPath = new UniqueNextNode(154, "Vous décidez de marcher vers l'allée de fleurs. ", mageHeraMeet);
	    Node mageHera = new UniqueNextNode(155, "Héra", mageFlowerPath);
	    
	    // Suite posseidon
	    
	    Node magePosseidonWin = new ChanceNode(156,"Suite à votre victoire, Posséidon vous confie l'identité du voleur de foudre. \nIl s'agit de : ",
	    		mageHera,
	    		mageThetisCoupable);
	    Node magePosseidonLose = new TerminalNode(157, "Vous perdez contre Posséidon ! Pour punition contre cette affront, votre âme connaitra le tourment éternel.");
	    Node magePosseidonFight = new InnerNode(158,"Vous décidez de combattre Posseidon", 
	    		magePosseidonWin,
	    		magePosseidonLose
	    		);
	    Node magePosseidonMood = new ChanceNode(159, "Posséidon est occupé à parler avec une autre divinité. \nIl pointe une direction pour que vous y aller. ",
	    		mageNymphes,
	    		mageHeraMeet);
	    Node magePosseidonTalk = new UniqueNextNode(160,"Vous décidez de parler avec Posséidon.", magePosseidonMood);
	    Node magePosseidonMeet = new DecisionNode(161,"En avançant, vous vous retrouvez face à Posséidon, le dieu des Océans. \nDes rumeurs circulent que c'est lui qui détient l'éclair. \nGrâce à cette dernière, il pourrait descendre dans \nle monde des humains sans difficultés pour revoir son fils et sa femme \nque Zeus lui aurait interdit de voir...",
	    		magePosseidonTalk,
	    		magePosseidonFight
	    		); 
	    Node mageFountainPath = new UniqueNextNode(162, "Vous décidez de marcher vers la fontaine d'eau. ", magePosseidonMeet);
	    	    
	    
	    //// Library Path
	    
	    Node mageOutLibrary = new DecisionNode(163,"Vous vous faites jeter de la bibliothèque. Où allez vous maintenant ?", 
	    		mageFountainPath,
	    		mageFlowerPath);
	    Node mageJustAnOwl = new UniqueNextNode(164,"C'était une simple chouette...Rien de surnaturel...",mageOutLibrary);
	    Node mageAthenaClue = new UniqueNextNode(165, "Pour vous remercier de votre générosité, elle vous mène vers le coupable.", mageHephaistosMeet);
	    Node mageNotJustAnOwl = new UniqueNextNode(166, "Il s'agissait d'Athéna déguisée !!", mageAthenaClue);
	    Node mageOwlMeta = new ChanceNode(167,"Vous donnez à manger à la chouette en espérant un miracle.", mageJustAnOwl, mageNotJustAnOwl);
	    Node mageOwlScream = new UniqueNextNode(168,"L'oiseau cri. Un responsable arrive :(", mageOutLibrary);
	    Node mageOwlHungry = new UniqueNextNode(169,"La chouette n'est pas à vous, pas besoin d'y faire attention.", mageOwlScream);
	    Node mageOwlFeed = new DecisionNode(170, "L'oiseau a l'air affamé. ", mageOwlMeta,mageOwlHungry);
	    Node mageOwlApproach = new UniqueNextNode(171,"Vous décidez de vous rapprocher de la chouette pour l'admirer.", mageOwlFeed);
	    Node mageOwlNoApproach = new UniqueNextNode(172,"Vous décidez de ne pas vous approcher de la chouette. Vous en avez peur...", mageOwlScream);
	    Node mageGoNextOwl = new DecisionNode(173,"Vous apercevez une chouette suspendue à un perchoir au fond de la salle. ", mageOwlApproach, mageOwlNoApproach);
	    Node mageNobody = new UniqueNextNode(174, "Il n'y a personne ici...", mageOutLibrary);
	    Node mageLibraryEntry = new ChanceNode(175,"Vous entrez dans la bibliothèque.", mageNobody,mageGoNextOwl );
	    
	    Node mage1 = new DecisionNode(100, "Ou commenceriez-vous vos recherches ? ",
	    		Arrays.asList(mageFountainPath,
	    				mageFlowerPath,
	    	    		mageLibraryEntry)
	    		);
		
		//Initialize a currentNode
		Node currentNode = null;
		
		//Create player object
	    switch(choice) {
	    
		    case "Humain":
		    	player = new Human(nom, w);
		    	currentNode = node1;
		    	System.out.println("Vos recherches vous amènent jusqu'aux Enfers, le territoire d'Hades. \nPour entrer il vous faudra passer les serviteurs du roi des Enfers, notamment : \nCerberus et Charon. La première étape est Cerberus");
		    	break;
		    	
		    case "Mage":
		    	player = new Mage(nom, w);
		    	currentNode = mage1;
		    	System.out.println("Vos recherches vous amènent jusqu'à l'Olympe, le territoire des Dieux. \nUn des Olympiens (Dieux siègeant à l'Olympe, les Dieux principaux) serait le coupable de ce vol...\nMais qui ?");
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
	    	
	    	if(!(currentNode instanceof DecisionNode) && !(currentNode instanceof ChanceNode) && !(currentNode.equals(node6)) && !(currentNode.equals(node9))&& !(currentNode instanceof UniqueNextNode)) {
		    	if(currentNode.equals(node3)) {
		    		currentNode = currentNode.chooseNext(player, cerberus);
		    	}else if(currentNode.equals(node4)) {
		    		currentNode = currentNode.chooseNext(player, charon);
		    	}else if(currentNode.equals(mageHephaistosFight)) {
		    		currentNode = currentNode.chooseNext(player, hephaistos);
		    	}else if(currentNode.equals(mageHeraFight)) {
		    		currentNode = currentNode.chooseNext(player, hera);
		    	}else if(currentNode.equals(magePosseidonFight)) {
		    		currentNode = currentNode.chooseNext(player, posseidon);
		    	}else if(currentNode.equals(mageAresFight)) {
		    		currentNode = currentNode.chooseNext(player, ares);
		    	}else if(currentNode.equals(mageAchillesFight)) {
		    		currentNode = currentNode.chooseNext(player, achilles);
		    	}else if(currentNode.equals(mageZeusFight)) {
		    		currentNode = currentNode.chooseNext(player, zeus);
		    	}else if(currentNode.equals(mageWomenFight)) {
		    		currentNode = currentNode.chooseNext(player, mistress);
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
