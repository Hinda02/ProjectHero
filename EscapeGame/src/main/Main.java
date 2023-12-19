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
		
// Mage
	    
	    Node mageKeepStormDesc = new TerminalNode(101, "Vous decidez de garder l'�clair de Zeus. \nEn effet, c'est la juste r�compense pour avoir travers� tous ses obstacles. \nVotre d�cision plonge le monde dans le chaos et provoque la col�re de Zeus et des autres Dieux. \nVous survivez au chaos gr�ce � l'�clair.");
	    Node mageGiveStormDesc = new TerminalNode(102, "Vous rendez l'�clair divin � son propri�taire. \nAinsi, vous ramenez le calme dans la monde. \nDe plus, Zeus vous exauce votre voeu le plus cher. \nVOUS �TES UN GRAND HEROS !");
	    
	    Node mageKeepStorm = new UniqueNextNode(103, "Vous decidez de garder l'�clair de Zeus. ",mageKeepStormDesc);
	    Node mageGiveStorm = new UniqueNextNode(104, "Vous rendez l'�clair divin � son propri�taire.", mageGiveStormDesc);
	    
	    
	    //// Fountain Path
	    
	    Node mageZeusLose = new TerminalNode(105, "Vous perdez contre Zeus ! Pour punition contre cette affront, votre �me connaitra le tourment �ternel.");
	    Node mageZeusWin = new TerminalNode(106, "INCROYABLE ! Ce jour est � marqu� d'une pierre blanche ! \nVOUS �tes le nouveau roi des Dieux");
	    Node mageZeusFight = new InnerNode(107,"Vous d�cidez de combattre Zeus pour mettre fin � toute cette injustice en vous alliant � ses diff�rentes maitresses!", 
	    		mageZeusWin,
	    		mageZeusLose
	    		);
	    Node mageWomenLose = new TerminalNode(108, "Vous vous �tes battu comme vous le pouviez malheureusement, elles �taient trop nombreuses. Vous �tes vaincu...");
	    Node mageWomenWin = new DecisionNode(109, "Vous vous �tes bien battu. Vous avez gagn� contre les maitresses de Zeus et repartez avec l'�clair.",
	    		mageKeepStorm,
	    		mageGiveStorm);
	    Node mageWomenFight = new InnerNode(110, "Vous refusez de vous ranger aux c�t�s des femmes. Elles se r�unissent autour de vous et vous attaquent. D�fendez-vous! ",
	    		mageWomenWin,
	    		mageWomenLose);
	    Node mageFollowWomen = new UniqueNextNode(111, "Vous d�cidez de suivre le mouvement de ses femmes dont Zeus a fait du tord !", mageZeusFight );
	    Node mageThetisTalk = new DecisionNode(112, "Th�tis vous avoue qu'elle et plusieurs femmes se sont r�unies pour battre Zeus. \n \" Oh grand h�ros ! Rejoins-nous pour faire face � cette injustice !\" ", 
	    		mageFollowWomen,
	    		mageWomenFight
	    		);
	    Node mageAchillesLose = new TerminalNode(113, "Vous vous �tes battu comme vous le pouviez malheureusement, Achille n'a pas vol� son titre de h�ros. \nDans une autre vie peut �tre que vous auriez gagn�... ");
	    
	    Node mageThetisRevenge = new TerminalNode(114, "Thetis s'effondre. Elle se retrouve sans enfant. Elle d�cide de sauter  dans le lac en vous tenant afin de vous donner la mort avec elle.");
	    Node mageHeadlessImpossible = new TerminalNode(115, "N'avez vous jamais entendu parl� de talon d'Achille ? \nC'est son point faible! \nNe pas savoir cela vous a cout� la vie. ");
	    Node mageAchillesHeadChop = new UniqueNextNode(116, "Vous d�cidez de couper la t�te d'Achille",mageHeadlessImpossible);
	    Node mageAchillesClemence = new UniqueNextNode(117,"Pour votre cl�mence, Th�tis vous propose de vous donner de l'eau d'une source pour soigner vos blessures. ",mageThetisTalk);	
	    Node mageAchillesStandUp = new UniqueNextNode(118,"Achilles se rel�ve. Cette fois-ci il ne rate pas votre t�te. \nVous �tes mort.", mageAchillesLose);	
	    Node mageAchillesNothing = new ChanceNode(119, "Vous d�cidez de le laisser tranquille",
	    		mageAchillesClemence,
	    		mageAchillesStandUp
	    		);
	    Node mageAchillesHeel = new UniqueNextNode(120,"Vous d�cidez de couper les chevilles d'Achille",mageThetisRevenge);
	    Node mageAchillesWin = new DecisionNode(121, "Quand 2 h�ros s'affrontent, celui qui gagne se doit de couper la t�te du perdant. Qu'allez-vous faire ?",
	    		Arrays.asList(mageAchillesHeadChop,
	    	    		mageAchillesHeel,
	    	    		mageAchillesNothing)
	    		);
	    Node mageAchillesFight = new InnerNode(122, "En provoquant Th�tis, vous provoquez la col�re de son fils qui d�cide de vous combatre � sa place",
	    		mageAchillesWin,
	    		mageAchillesLose);
	    Node mageThetisMeet = new UniqueNextNode(123,"Vous d�cidez de parler � Th�tis",mageThetisTalk );
	    Node mageThetisFight = new UniqueNextNode(124, "Vous d�cidez d'attaquer Th�tis.", mageAchillesFight);
	    Node mageThetis = new DecisionNode(125,"Vous retrouvez Th�tis face � un lac.",
	    		mageThetisMeet,
	    		mageThetisFight
	    		);
	    Node mageThetisCoupable = new UniqueNextNode(126, "Th�tis", mageThetis);
	    
	    //// Flower Path
	    Node mageLetStormDesc = new TerminalNode(127, "Vous d�cidez de les laisser se venger de Zeus. \nVOUS N'AUREZ JAMAIS VOTRE NOM INSCRIS \nDANS LES PLUS GRANDS LIVRES D'HISTOIRE !");
	    Node mageLetStormHeraDesc = new TerminalNode(128, "La vengeance d'H�ra est fond�e. Zeus m�rite une punition ! \nVous d�cidez de la laisser faire en oubliant tout vos d�sirs d'entrer dans la l�gende. ");
	    
	    Node mageLetStorm = new UniqueNextNode(129, "Vous comprenez l'objectif des fils d'H�ra.", mageLetStormDesc);
	    Node mageLetStormHera = new UniqueNextNode(130, "Vous ne reprenez pas la foudre. ", mageLetStormHeraDesc);
	    Node mageStormChoice = new DecisionNode(131, "Vous avez gagn� le combat contre Ar�s ! ", 
	    		Arrays.asList(mageKeepStorm, mageGiveStorm,mageLetStorm)
	    		);
	    Node mageAresDeath = new TerminalNode(132, "Ar�s vous a battu :( ");
	    Node mageAresFight = new InnerNode(133, "Ar�s, le Dieu de la guerre.\nC'est lui qui, pouss� par la col�re, a vol� le tr�sor du souverain des Dieux. \nPr�venu de votre venu, il vous accueille la lance � la main ! \nBattez-vous pour r�cup�rer la foudre !", 
	    		mageStormChoice,
	    		mageAresDeath);
	    Node mageHeraDeath = new TerminalNode(134, "Hera vous a battu :( ");
	    Node mageHeraStormChoice = new DecisionNode(135, "H�ra est vaincue ! ", 
	    		Arrays.asList(mageKeepStorm, mageGiveStorm,mageLetStormHera)
	    		);
	    Node mageHeraFight = new InnerNode(136,"Depuis le d�but, c'�tait H�ra qui poss�dait la foudre ! \nPr�venue de votre arriv�e par son fils, elle se jette sur vous, son sceptre � la main. ", 
	    		mageHeraStormChoice,
	    		mageHeraDeath
	    		);
	    Node mageAresOrHera = new ChanceNode(137, "Vous d�cidez de parler avec Hephaistos. \nIl vous donne le nom du d�tenteur de l'�cair. Vous n'en croyez pas vos oreilles...", 
	    		mageAresFight,
	    		mageHeraFight
	    		);
	    Node mageHephaLost = new TerminalNode(138, "Hephaistos vous tue � l'aide de son marteau. Il ne reste plus rien de vous...");
	    Node mageHephaWin = new UniqueNextNode(139, "Vous avez gagn� le combat contre Hephaistos :) \nEn �change de votre bravoure, il vous livre le nom de son fr�re. ", mageAresFight);
	    Node mageHephaistosFight = new InnerNode(140, "Vous d�cidez de combattre Hephaistos.",
	    		mageHephaWin,
	    		mageHephaLost
	    		);
	    Node mageHephaistosMeet = new DecisionNode(141, "Vous vous dirigez vers la forge, le territoire d'Hephaistos. Vous avez le choix entre lui demander de l'aide et le combattre. ", 
	    		mageAresOrHera,
	    		mageHephaistosFight
	    		);
	    Node mageHeraHepha = new UniqueNextNode(142, "H�ra est touch�e par votre sensibilit� vis-�-vis de sa situation. \nElle n'avait jamais crois� un inconnu avec une �me aussi pure. \nEn pleurs, elle avoue que par amour ses fils ont d�cid� de la venger de Zeus.", mageHephaistosMeet);
	    Node mageAgreeHera = new UniqueNextNode(143, "Vous �tes d'accord avec elle ! Elle n'a pas � subir l'adult�re de Zeus !", mageHeraHepha);
	    Node mageDisagreeDeath = new TerminalNode(144, "Vous mourez empoisonn�, seul,  dans ce labyrinthe de fleurs ensanglant�es de votre propre sang... ");	    
	    
	    /// Fountain Path suite 
	    
	    // Nymphes
	    
	    Node mageHypnosis = new TerminalNode(145,"Les nymphes aquatiques vous offrent des friandises aux fleurs de lotus. \nVous ne voyez pas le temps passer. \nVous finnissez par �tre emprisonn� dans une illusion sans fin. \nFIN");
	    Node mageNymphes = new UniqueNextNode(146,"Vous vous retrouvez entour� de nymphes auqatiques.",mageHypnosis);
	    
	    
	    // Hera suite
	    
	    Node mageDisagreeMiracle = new UniqueNextNode(147, "Une petite nymphe aquatique vous a suivi pendant tout votre p�riple et s'est pris d'affection pour vous ! \n Elle soigne tant bien que mal vos blessures. \n Elle vous ram�ne pr�s d'une source d'eau o� se trouvent d'autres nymphes. ",mageNymphes);
	    Node mageHeraKill = new ChanceNode(148,"H�ra est en FURIEUSE ! Elle d�cide de lancer ses serpents sur vous. \nIls vous mordent et vous empoisonnent.",mageDisagreeDeath,mageDisagreeMiracle);
	    Node mageDisagreeHera = new UniqueNextNode(149, "Vous n'�tes pas d'accord avec elle ! Bien que Zeus continue � courtiser d'autres femmes, c'est le privil�ge du Roi !", mageHeraKill);
	    
	   //Attention ! Risque de cycle ! 
	    Node mageHeraNotTalk = new UniqueNextNode(150, "Vous d�cidez de ne pas parler � H�ra. Elle fait bient trop peur ! Vous reborussez chemin...", mageThetis); 
	    Node mageOpinionHera = new DecisionNode(151, "H�ra vous explique sa situation : \nZeus, son mari, la trompe une fois encore. \nElle ne sait plus quoi faire pour l'emp�cher de continuer. \nElle veut que Zeus souffre mais ne sait pas si c'est une bonne id�e de s'attirer les foudres du dieu de la foudre en ce moment...",
	    		mageDisagreeHera,
	    		mageAgreeHera
	    		); 
	    Node mageHeraTalk = new UniqueNextNode(152, "Vous d�cidez de parler � H�ra",mageOpinionHera);  
	    Node mageHeraMeet = new DecisionNode(153,"En avan�ant, vous remarquez que l'all�e de fleurs menait en fait vers un labyrithe de hautes herbes. \nVous vous retrouvez face � une femme magnifique. \nSans aucun doute, il s'agit bien de H�ra, la d�esse du foyer.",
	    		mageHeraTalk,
	    		mageHeraNotTalk
	    		); 
	    Node mageFlowerPath = new UniqueNextNode(154, "Vous d�cidez de marcher vers l'all�e de fleurs. ", mageHeraMeet);
	    Node mageHera = new UniqueNextNode(155, "H�ra", mageFlowerPath);
	    
	    // Suite posseidon
	    
	    Node magePosseidonWin = new ChanceNode(156,"Suite � votre victoire, Poss�idon vous confie l'identit� du voleur de foudre. \nIl s'agit de : ",
	    		mageHera,
	    		mageThetisCoupable);
	    Node magePosseidonLose = new TerminalNode(157, "Vous perdez contre Poss�idon ! Pour punition contre cette affront, votre �me connaitra le tourment �ternel.");
	    Node magePosseidonFight = new InnerNode(158,"Vous d�cidez de combattre Posseidon", 
	    		magePosseidonWin,
	    		magePosseidonLose
	    		);
	    Node magePosseidonMood = new ChanceNode(159, "Poss�idon est occup� � parler avec une autre divinit�. \nIl pointe une direction pour que vous y aller. ",
	    		mageNymphes,
	    		mageHeraMeet);
	    Node magePosseidonTalk = new UniqueNextNode(160,"Vous d�cidez de parler avec Poss�idon.", magePosseidonMood);
	    Node magePosseidonMeet = new DecisionNode(161,"En avan�ant, vous vous retrouvez face � Poss�idon, le dieu des Oc�ans. \nDes rumeurs circulent que c'est lui qui d�tient l'�clair. \nGr�ce � cette derni�re, il pourrait descendre dans \nle monde des humains sans difficult�s pour revoir son fils et sa femme \nque Zeus lui aurait interdit de voir...",
	    		magePosseidonTalk,
	    		magePosseidonFight
	    		); 
	    Node mageFountainPath = new UniqueNextNode(162, "Vous d�cidez de marcher vers la fontaine d'eau. ", magePosseidonMeet);
	    	    
	    
	    //// Library Path
	    
	    Node mageOutLibrary = new DecisionNode(163,"Vous vous faites jeter de la biblioth�que. O� allez vous maintenant ?", 
	    		mageFountainPath,
	    		mageFlowerPath);
	    Node mageJustAnOwl = new UniqueNextNode(164,"C'�tait une simple chouette...Rien de surnaturel...",mageOutLibrary);
	    Node mageAthenaClue = new UniqueNextNode(165, "Pour vous remercier de votre g�n�rosit�, elle vous m�ne vers le coupable.", mageHephaistosMeet);
	    Node mageNotJustAnOwl = new UniqueNextNode(166, "Il s'agissait d'Ath�na d�guis�e !!", mageAthenaClue);
	    Node mageOwlMeta = new ChanceNode(167,"Vous donnez � manger � la chouette en esp�rant un miracle.", mageJustAnOwl, mageNotJustAnOwl);
	    Node mageOwlScream = new UniqueNextNode(168,"L'oiseau cri. Un responsable arrive :(", mageOutLibrary);
	    Node mageOwlHungry = new UniqueNextNode(169,"La chouette n'est pas � vous, pas besoin d'y faire attention.", mageOwlScream);
	    Node mageOwlFeed = new DecisionNode(170, "L'oiseau a l'air affam�. ", mageOwlMeta,mageOwlHungry);
	    Node mageOwlApproach = new UniqueNextNode(171,"Vous d�cidez de vous rapprocher de la chouette pour l'admirer.", mageOwlFeed);
	    Node mageOwlNoApproach = new UniqueNextNode(172,"Vous d�cidez de ne pas vous approcher de la chouette. Vous en avez peur...", mageOwlScream);
	    Node mageGoNextOwl = new DecisionNode(173,"Vous apercevez une chouette suspendue � un perchoir au fond de la salle. ", mageOwlApproach, mageOwlNoApproach);
	    Node mageNobody = new UniqueNextNode(174, "Il n'y a personne ici...", mageOutLibrary);
	    Node mageLibraryEntry = new ChanceNode(175,"Vous entrez dans la biblioth�que.", mageNobody,mageGoNextOwl );
	    
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
		    	System.out.println("Vos recherches vous am�nent jusqu'aux Enfers, le territoire d'Hades. \nPour entrer il vous faudra passer les serviteurs du roi des Enfers, notamment : \nCerberus et Charon. La premi�re �tape est Cerberus");
		    	break;
		    	
		    case "Mage":
		    	player = new Mage(nom, w);
		    	currentNode = mage1;
		    	System.out.println("Vos recherches vous am�nent jusqu'� l'Olympe, le territoire des Dieux. \nUn des Olympiens (Dieux si�geant � l'Olympe, les Dieux principaux) serait le coupable de ce vol...\nMais qui ?");
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
