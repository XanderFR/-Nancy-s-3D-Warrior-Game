/*This Dice class represents a pair of dice objects that will be used in the Nancy's 3D Warrior Game.
 *It is a public class so it is accessible to the java file containing Nancy's 3D Warrior game.
 *The Dice class contains two private integer variables named die1 and die2.
 *The Dice class contains a constructor that uses a Random object to initialize die1 and die2 to random numbers between 1 and 6.
 *These two integer variables represent the numerical value of the two dice objects.
 *The Dice class contains two accessor methods that returns the value of die1 and die2.
 *The Dice class contains a method named rollDice() which mimics the rolling of a pair of dice. It changes the value of die1 and 
 *die2 and returns their sum.
 *The Dice class contains a boolean method called isDouble() which returns true if die1 and die2 have the same value and false 
 *otherwise.
 *The Dice class contains a toString() method that returns a string showing the numerical value of both die1 and die2.*/
import java.util.Random;
public class Dice {
	private int die1; /*Many board games are played with two dice cubes. 
	die1 and die2 represent those two cubes and the values they both hold influence player movement and energy levels during the 
	game.*/
	private int die2;
	
	public Dice() { /*Before playing Nancy's 3D Warrior game, a pair of dice need to be created / instantiated.
	This constructor produces the Dice object and sets the values to random numbers between 1 and 6.*/
		Random random = new Random();
		die1 = random.nextInt(6) + 1;
		die2 = random.nextInt(6) + 1;
	}
	
	public int getDie1() { /*This returns the value of die1. 
	Certain methods in this class and the program containing Nancy's 3D Warrior Game requires knowing the value of die1*/
		return die1;
	}
	
	public int getDie2() { /*This returns the value of die2. 
	Certain methods in this class and the program containing Nancy's 3D Warrior Game requires knowing the value of die2*/
		return die2;
	}
	
	public int rollDice() { /*This method simulates the rolling of two dice cubes.
	When first starting any game with dice cubes, they start off having certain numbers but when taken and rolled, their values 
	change.
	In Nancy's 3D Warrior Game, this method produces a number that will represent the number of times a player can potentially 
	move across the board.*/
		Random random = new Random();
		die1 = random.nextInt(6) + 1;
		die2 = random.nextInt(6) + 1;
		int sum = die1 + die2;
		return sum;
	}
	
	public boolean isDouble() { /*This method returns true when die1 and die2 have the same number.
	In Nancy's 3D Warrior Game, this method returning true is part of a conditional statement that increases a player's energy 
	level by 2 units.*/
		if (getDie1() == getDie2()) {
			return true;
		}
		else
			return false;
	}
	
	public String toString() { /*This method returns a string containing the values of both die1 and die2.
	In Nancy's 3D Warrior Game, this method shows the game players the roll they got. 
	The results of this roll can increase a player's energy level and show how many potential spaces a player can move across the 
	board.*/
		String output = String.format("Die 1: %d Die 2: %d", getDie1(), getDie2());
		return output;
	}
}