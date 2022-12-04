/*This large program could be seen as being made up of 3 programming blocks, 2 large ones and 1 small one. These are Block A, Block
 *B and Block C. Block A contains programs that set up Nancy's 3D Warrior Game. Block B is where two players play Nancy's 3D Warrior
 *Game. Block C presents the winner of the game.*/
import java.util.Scanner;
import java.util.Random;
public class LetUsPlay {
	public static void main(String[] args) {
//START OF BLOCK A
/*Block A is responsible for setting up Nancy's 3D Warrior Game. This block does this by accomplishing the following tasks:
  -Print the welcome banner to Nancy's 3D Warrior Game
  -Ask the user if he / she wants to use the default game board or to create a customized board where the player defines the board
   dimensions and the number of boards to be used in the game.
  -Show the players of Nancy's 3D Warrior Game what the entire game board looks like.
  -Ask the players of the game for their player names.
  -Decide which of the two players goes first in each round of the game.
  -Show the players where they start on the board and their staring energy unit numbers.
  -Create a Dice object that will serve as the game's in-game pair of dice cubes.*/
		
		Scanner scanner = new Scanner(System.in); /*This generates a Scanner object that will be used by the players to influence
		the way the game is designed and played.*/
		
		Scanner input = new Scanner(System.in); /*This generates a second Scanner object that will be used to accept input that 
		begins the next round of the game.*/
		
	//START OF CODE THAT PRINTS THE WELCOME BANNER
		/*This small block of code uses several for loops and print statement to generate the welcome banner to Nancy's 3D Warrior 
		  Game.*/
		System.out.print("\t");
		for (int i = 1; i < 46; i++) { //This for loop prints the top part of the welcome banner
			if (i % 2 != 0)
				System.out.print("*");
			else
				System.out.print("_");
		}
		
		System.out.print("\n\t");
		
		for (int i = 1; i < 46; i++) { //This for loop creates another part of the top of the welcome banner
			if (i == 1)
				System.out.print("*");
			else if (i == 45)
				System.out.print("*");
			else
				System.out.print(" ");
		}
		
		System.out.print("\n\t");
		System.out.println("*    WELCOME to Nancy\'s 3D Warrior Game!    *"); //This prints the welcome message
		System.out.print("\t");
		
		for (int i = 1; i < 46; i++) { //This for loop creates a part of the bottom part of the welcome banner
			if (i == 1)
				System.out.print("*");
			else if (i == 45)
				System.out.print("*");
			else
				System.out.print(" ");
		}
		
		System.out.print("\n\t");
		for (int i = 1; i < 46; i++) { //This for loop prints the bottom part of the welcome banner
			if (i % 2 != 0)
				System.out.print("*");
			else
				System.out.print("_");
		}
	//END OF CODE THAT PRINTS THE WELCOME BANNER
		
		System.out.println();
		System.out.println();
		
	//START OF CODE THAT PRINTS THE GAME BOARD DESIGN MENU
		/*This block of code prints a message telling the players that they have two options for designing the game board.*/
		System.out.println("The default game board has 3 levels and each level has a 4x4 board.");
		System.out.println("You can use this default board size or change the size");
		System.out.println("\t 0 to use the default board size");
		System.out.println("\t-1 to enter your own size");
	//END OF CODE THAT PRINTS THE GAME BOARD DESIGN MENU
		
	//START OF CODE THAT ASKS FOR THE USER'S CHOICE WITH REGARDS TO GAME BOARD DESIGN
		/*This block of code is connected to the preceding block of code that asks the user for the kind of game board they 
		  want to play in. It lets the user input a value that represents their choice with regards to game board design.*/
		System.out.print("==> What do you want to do? ");
		int choice = 1;
		choice = scanner.nextInt();
	//END OF CODE THAT ASKS FOR THE USER'S CHOICE WITH REGARDS TO GAME BOARD DESIGN

	//START OF THE WHILE LOOP THAT RUNS WHEN THE USER ENTERS AN INVALID GAME BOARD DESIGN CHOICE
		/*This block of code is connected to the preceding block of code that asks the user to input a value that represents how
		  he / she wants to design the game board. If the entered value is not a 0 or a -1, this while loop will keep asking the 
		  user to enter values until the entered value is either a 0 or -1.*/
		while ((choice != 0) && (choice != -1)) {
			System.out.println(String.format("\nSorry but %d is not a legal choice.", choice));
			System.out.print("==> What do you want to do? ");
			choice = scanner.nextInt();
		}
	//END OF THE WHILE LOOP THAT RUNS WHEN THE USER ENTERS AN INVALID GAME BOARD DESIGN CHOICE
		
		System.out.println();
		
		Board game = new Board(); /*This creates a Board object called game that will serves as the game board that the players will 
		play on.*/
		
	//START OF PROGRAM BLOCK THAT MAKES THE GAME BOARD
		/*This block of code creates either the default game board which is made of 3 4x4 grid game boards or it creates 3 to 10
		  square game boards whose lengths are between 4 and 10.*/
		//Start of if block that makes default board
		if (choice == 0) { /*If the user entered 0 as their game board design choice, it means they want their game to have 3 4x4 grid
		game boards and this block shows the players what this board looks like.*/
			game = new Board();
			System.out.println("Your 3D board has been set up and it looks like this:");
			System.out.println();
			System.out.println(game.toString());
		}//End of if block that makes default board
		
		//Start of else if block that makes custom board
		else if (choice == -1) { /*If the user entered -1 as their game board design choice, it means they want to define the board size and
		number.*/
			System.out.print("How many levels would you like? (minimum size 3, max 10) "); /*This asks the user to enter how many board levels
			the user wants. The number has to be between 3 and 10, inclusively.*/
			int levelChoice = 0;
			levelChoice = scanner.nextInt();
			
			//Start of while loop that runs for invalid number choices
			/*This while loop runs when the number of board levels the user wants is less than 3 or more than 10. It will keep asking the user 
			  to enter numbers until the user enters one that is within the proper number range.*/
			while ((levelChoice < 3) || (levelChoice > 10)) { 
				System.out.println(String.format("\nSorry but %d is not a legal choice.", levelChoice));
				System.out.print("How many levels would you like? (minimum size 3, max 10) ");
				levelChoice = scanner.nextInt();
			}//End of while loop that runs for invalid number choices
			
			System.out.println();
			
			//Start of code that asks for the board size number
			/*This block of code asks the user to define how large he / she wants the game boards to be. The number has to be between
			  4 and 10, inclusively.*/
			System.out.println("What size do you want the nxn boards on each level to be?");
			System.out.println("Minimum size is 4x4, max is 10x10");
			System.out.print("==> Enter the value of n: ");
			int sizeChoice = 0;
			sizeChoice = scanner.nextInt();
			//End of code that asks for the board size number
			
			//Start of while loop that runs for invalid board size choices
			/*This while loop runs when the user enters a board size number that is less than 4 or more than 10. It will keep asking the
			  user to enter numbers until the user enters a number that is within the proper number range.*/
			while ((sizeChoice < 4) || (sizeChoice > 10)) { 
				System.out.println(String.format("\nSorry but %d is not a legal choice.", sizeChoice));
				System.out.println("What size do you want the nxn boards on each level to be?");
				System.out.println("Minimum size is 4x4, max is 10x10");
				System.out.print("==> Enter the value of n: ");
				sizeChoice = scanner.nextInt();
			}//End of while loop that runs for invalid board size choices
			
			//Start of code that makes and prints the game boards
			/*This block of code is what creates the customized board for a play through of Nancy's 3D Warrior Game.
			  It also shows the players what the game board looks like.*/
			game = new Board(levelChoice, sizeChoice);
			System.out.println("\nYour 3D board has been set up and it looks like this:");
			System.out.println();
			System.out.println(game.toString());
			//End of code that makes and prints the game boards
			
		}//End of else if block that makes custom board
	//END OF PROGRAM BLOCK THAT MAKES THE GAME BOARD
		
		scanner.nextLine(); 
		
	//START OF CODE THAT ASKS FOR PLAYER NAMES
		System.out.print("What is player 0\'s name (one word only): "); /*This asks a player to enter their name.*/
		String playerName0 = scanner.nextLine();
		
		System.out.println();
		
		System.out.print("What is player 1\'s name (one word only): "); /*This asks the other player to enter their name.*/
		String playerName1 = scanner.nextLine();
	//END OF CODE THAT ASKS FOR PLAYER NAMES
		
	//START OF CODE THAT MAKES PLAYER ARRAY
		/*This block of code is where a Player object array is created. It stores two Player objects named after the names 
		  entered by the two players of Nancy's 3D Warrior Game.*/
		Player[] players = new Player[2];
		
		players[0] = new Player(playerName0);
		players[1] = new Player(playerName1);
	//END OF CODE THAT MAKES PLAYER ARRAY
		
	//START OF CODE THAT DECIDES WHICH PLAYER GOES FIRST
		/*This block of code decides which of the two players goes first in each round of the game. It generates a random integer,
		  either a 0 or a 1. If the number is 0, the player that goes first is the one represented by the Player object at index 0
		  in the Player array named players. Otherwise, the player that goes first is the one represented by the Player object at
		  index 1. Then the block of code prints a message on who goes first.*/
		Random random = new Random();
		int decider = random.nextInt(2);
		
		Player player1;
		Player player2;
		
		if (decider == 0) {
			player1 = players[0];
			player2 = players[1];
			System.out.printf("\nThe game has started %s goes first\n", player1.getName());
		}
		
		else {
			player1 = players[1];
			player2 = players[0];
			System.out.printf("\nThe game has started %s goes first\n", player1.getName());
		}
	//END OF CODE THAT DECIDES WHICH PLAYER GOES FIRST
		
		for (int i = 0; i < 50; i++)
			System.out.print("=");
		
		System.out.println();
		
		//The line of code below prints a message saying where the two players begin on the game board and how many energy units they have.
		System.out.println(String.format("\nBoth %s and %s start the game at Row 0, Column 0 on Level 0 with 10 energy units each.\n", 
				player1.getName(), player2.getName()));
		
		Dice gameDice = new Dice(); //This line of code generates the Dice object that will be used in the game.
		
//END OF BLOCK A
		
//START OF BLOCK B
/*Block B is where the two players play Nancy's 3D Warrior Game. In this block Player 1 and Player 2 take turns moving across
  the board. This block contains conditional statements for the following in-game events:
  -When a player has negative energy units
  -When a player has positive energy units
  -When a player is on the second to last spot on the game board
  -When the player gets a double dice roll
  -When a player lands on a spot already occupied by another player
  -When a player wins the game*/
		
	//START OF THE WHILE LOOP THAT REPRESENTS THE TWO PLAYERS PLAYING THE GAME
		while (!(player1.won(game)) && !(player2.won(game))) { /*This while loop runs until one of the two players wins the game.*/
			
			for (int i = 0; i < 98; i++) //This for loop prints a line that separates each round of the game.
				System.out.print("=");
			
			System.out.println();
			
			int moveCount; //This variable keeps track of how many spaces a player can move
			int boardValue; //This variable stores the energy adjustment value from a given position on the board
			
		//START OF PLAYER 1'S TURN
			System.out.println(String.format("It is %s\'s turn", player1.getName()));
			
			//Start of Energy Booster for Player 1
			/*If it is player 1's turn and their energy unit number is less than or equal to 0, this will roll the dice 3 times
			  and keep track of how many times 2 of the same number appears. Player 1's energy units increase by two for every 
			  double dice rolls that appear.*/
			if (player1.getEnergy() <= 0) {
				int doublesCount = 0;
				System.out.println(String.format("\tUh Oh, %s does not have enough energy to move. "
						+ "Lets roll the dice 3 times to see if things change.", player1.getName())); /*This lets Player 1 know 
						that they don't have enough energy to move.*/
				
				for (int i = 0; i < 3; i++) {//This for loop rolls the dice 3 times and counts the number of doubles
					gameDice.rollDice();
					System.out.println(String.format("\tRoll %d => %s", i + 1, gameDice.toString()));
					if (gameDice.isDouble()) {
						doublesCount++;
					}
				}
				System.out.println(String.format("\tYou got %d doubles.", doublesCount)); /*This shows how many doubles the player
				got.*/
				
				if(doublesCount > 0) { //If Player 1 got one or more double dice, this will increase his / her energy unit numbers
					System.out.println(String.format("\tSo your energy goes up by %d energy units\n", doublesCount * 2));
					player1.setEnergy(player1.getEnergy() + (2 * doublesCount));
				}
			}//End of Energy Booster for Player 1
			
			//Start of board movement for Player 1
			if (player1.getEnergy() > 0) { /*This large if block runs when Player 1 has one or more energy units. 
			This block focuses of moving Player 1 across the game board.*/
				
				moveCount = gameDice.rollDice(); //This represents Player 1 rolling the dice
				
				System.out.println(String.format("\t%s you rolled %s", player1.getName(), gameDice.toString())); /*This lets
				player know what numbers they got.*/
				
				/*These three integer variables below record the original position of Player 1. They get used to modify the position of a Player
				that loses a challenge for a given spot on the board.*/
				int originalplayer1Level = player1.getLevel();
				int originalplayer1XRow = player1.getX();
				int originalplayer1YColumn = player1.getY();
				
				/*These three integer variables represent Player 1's new potential location*/
				int player1Level = player1.getLevel();
				int player1XRow = player1.getX();
				int player1YColumn = player1.getY();
				
				/*This if / else block is what moves Player 1 across the board. The direction Player 1 goes in depends on Player
				  1's position on the game board. If Player 1 is on the second to last spot on the board, Player 1 goes backwards.
				  Otherwise, Player 1 goes forwards.*/
				if ((originalplayer1Level == (game.getLevel() - 1)) && 
				   (originalplayer1XRow == (game.getSize() - 1)) &&
				   (originalplayer1YColumn == (game.getSize() - 2))) { /*This block of code is what will make Player 1 go in reverse.*/
					
					System.out.println("Sorry, since you are on the second to last spot on the game board, you need to go in reverse.");
					
					//Start of while loop that moves Player 1 across the game boards
					while (moveCount != 0) { /*This while loop makes Player 1's new  potential location some point farther away from the
					finishing point. This is so Player 1 can have the chance to roll numbers that would allow Player 1 to land at the 
					finishing point without going off it.*/
						player1YColumn--;

						if (player1YColumn == -1) {
							player1XRow--;
							player1YColumn = game.getSize() - 1;
							
						}
						
						if (player1XRow == -1) {
							player1Level--;
							player1XRow = game.getSize() - 1;
							player1YColumn = game.getSize() - 1;
							
						}
						moveCount--;
					}//End of while loop that moves Player 1 across the game boards
				}
				
				else { /*If Player 1 is not on the second to last spot on the game board, the Player 1 goes in a forward direction, towards
				the finishing point.*/
					//Start of while loop that moves Player 1 across the game boards
					while (moveCount != 0) { /*This while loop makes Player 1's new potential location some point closer to the finishing point.*/
						player1YColumn++;
					
						if (player1YColumn == game.getSize()) {
							player1XRow++;
							player1YColumn = 0;
						
						}
						if (player1XRow == game.getSize()) {
							player1Level++;
							player1XRow = 0;
							player1YColumn = 0;
						
						}
						moveCount--;
					}//End of while loop that moves player 1 across the game boards
				}
				
				
				if (gameDice.isDouble()) { /*If Player 1 got matching numbers for the dice roll, this increases the energy units by 2.*/
					player1.setEnergy(player1.getEnergy() + 2);
					System.out.println(String.format("\tCongratulations you rolled a double %d. Your energy went up by 2 units.", gameDice.getDie1()));
				}
				
				//Start of code that sets Player 1's position to its new values
				/*Whether Player 1 goes forwards or backwards, there needs to be a way to set Player 1's location on the board to the new position
				  defined by player1Level, player1XRow, and player1YColumn. This block of code is that way.*/
				player1.setLevel(player1Level);
				player1.setX(player1XRow);
				player1.setY(player1YColumn);
				//End of code that sets Player 1's position to its new values
				
				//Start of code that runs when Player 1 gets to a spot already taken by Player 2
				if (player1.equals(player2)) {
					//Lets Player 1 know that Player 2 was there first
					System.out.println(String.format("Player %s is at your new location", player2.getName())); /*This lets Player 1
					know that Player 2 was already at the spot he / she was going to.*/
					
					//Start of code that ask for Player 1's choice
					/*This lets Player 1 know that when landing on a spot taken by another player, they can challenge that player for
					  the spot or forfeit and go to the position they were meant to go but one level down or back to the beginning if on
					  Level 0. They can choose to enter either a 0 or a 1.*/
					System.out.println("What do you want to do?");
					System.out.println("\t0 - Challenge and risk losing 50% of your energy units if you lose");
					System.out.println("\t    or move to new location and get 50% of the other player\'s energy units if you win");
					System.out.println("\t1 - to move down one level or move to (Row: 0, Column: 0) if at Level 0 and lose 2 energy units");
					System.out.print("Enter your choice here: ");
					
					int challengeChoice = -1;
					
					challengeChoice = scanner.nextInt();
					//End of code that asks for Player 1's choice
					
					//Start of while loop that runs for invalid choices
					/*This while loop runs when Player 1 enters numbers that are not 0 or 1. It will keep asking Player 1 to enter numbers
					  until Player 1 enters either a 0 or 1.*/
					while ((challengeChoice != 0) && (challengeChoice != 1)) {
						System.out.println(String.format("\nSorry but %d is not a legal choice.", challengeChoice));
						
						System.out.print("Enter your choice here: ");
						
						challengeChoice = scanner.nextInt();
					}//End of while loop that runs for invalid choices
					
					//Start of code that runs if Player 1 challenges Player 2 for the spot
					if (challengeChoice == 0) { /*If Player 1 decides to challenge Player 2 for the spot, a random number between 0 and
					10 is generated. If the number is less than 6, Player 1 loses the challenge, otherwise Player 1 wins.*/
						System.out.println(String.format("\nYou have chosen to challenge Player %s for the spot.\n", player2.getName()));										
						
						int challengeOutcome = random.nextInt(11);
						
						System.out.println(String.format("Challenge outcome: %d", challengeOutcome));
						
						boolean player1Wins; //A boolean variable that represents Player 1 winning or not
						
						if (challengeOutcome < 6) { 
							player1Wins = false; //For player1 losing
						}
						
						else { 
							player1Wins = true; //For player1 winning
						}
						
						//Start of code for Player 1's victory
						if (player1Wins == true) { /*If Player 1 won the challenge, Player 2 goes to Player 1's original position which is defined
						by the variables originalplayer1Level, originalplayer1XRow, and originalplayer1YColumn. Also Player 2 loses half of their
						energy units to Player 1.*/
							System.out.println(String.format("Bravo %s!! You won the challenge. "
									+ "Which means %s will go to your original spot and loses half his/her energy units to you.", player1.getName(), player2.getName()));
							
							//This puts Player 2 at Player 1's original position
							player2.setLevel(originalplayer1Level);
							player2.setX(originalplayer1XRow);
							player2.setY(originalplayer1YColumn);
							
							int halfOfLoserEnergyUnits = player2.getEnergy() / 2; /*This represents half of Player 2's energy units.*/
							
							//This takes half of Player 2's energy units and gives them to Player 1.
							player2.setEnergy(player2.getEnergy() - halfOfLoserEnergyUnits);
							player1.setEnergy(player1.getEnergy() + halfOfLoserEnergyUnits);
						}
						//End of code for Player 1's victory
						
						//Start of code for player1 defeat
						else if (player1Wins == false) { /*If Player 1 loses the challenge, they go back to the position where they were before.
						This position is defined by the variables originalplayer1Level, originalplayer1XRow, and originalplayer1YColumn. Also Player
						1 loses half their energy units*/
							System.out.println(String.format("!!! Sorry %s you lost. "
									+ "You are going back to where you were before and you lost half your energy units.", player1.getName()));
							
							//This puts Player 1 back to the position they were in before moving
							player1.setLevel(originalplayer1Level);
							player1.setX(originalplayer1XRow);
							player1.setY(originalplayer1YColumn);
							
							//This makes Player 1 lose half their energy units
							int halfOfLoserEnergyUnits = player1.getEnergy() / 2;	
							player1.setEnergy(player1.getEnergy() - halfOfLoserEnergyUnits);
						}//End of code for player1 defeat
						
					}//End of code that runs if Player 1 challenges Player 2 for the spot
					
					//Start of code for Player 1 forfeiting
					else if (challengeChoice == 1) { /*If Player 1 decides to forfeit to Player 2, Player 1 goes down 1 level. If Player 1's level
					is now negative, Player 1 goes back to beginning of the board, the zeroth column of the zeroth row on the zeroth level.*/
						System.out.println("\nYou have chosen to move down a level or go back to the beginning if at Level 0.\n");	
						
						System.out.println(String.format("You were at (Row: %d, Column: %d) on Level %d", player1.getX(), player1.getY(), player1.getLevel()));
						
						player1Level -= 1; //Decreases Player 1's level number by 1
						
						if (player1Level < 0) { //Puts Player 1 at the beginning if Player 1 is on Level 0
							
							player1.setLevel(0);
							player1.setX(0);
							player1.setY(0);
							
							System.out.println(String.format("Now you are at (Row: %d, Column: %d) on Level %d", player1.getX(), player1.getY(), player1.getLevel()));
							
						}
						
						else { //Player 1 goes down a level and loses 2 energy units
							
							player1.setLevel(player1Level);
							
							System.out.println(String.format("Now you are at (Row: %d, Column: %d) on Level %d and you lost 2 energy units", player1.getX(), player1.getY(), player1.getLevel()));
							
							player1.setEnergy(player1.getEnergy() - 2);
						}
					}//End of code for Player 1 forfeiting
					
				}//End of code that runs when Player 1 gets to a spot already taken by Player 2
				
				//Start of code that runs when Player 1 is meant to go to a spot beyond the end of the game board
				if (player1.getLevel() >= game.getLevel()) { /*If Player 1 is about to go beyond the finish line, this code
				keeps Player 1 in his / her original position and they lose 2 energy units.*/
					System.out.println("!!! Sorry you need to stay where you are - that throw takes you off the grid and you loose 2 energy units.");
					
					//This keeps Player 1 in their original position
					player1.setLevel(originalplayer1Level);
					player1.setX(originalplayer1XRow);
					player1.setY(originalplayer1YColumn);
					
					//This makes Player 1 lose 2 energy units
					player1.setEnergy(player1.getEnergy() - 2);
					
				}//End of code that runs when Player 1 is meant to go to a spot beyond the end of the game board
				
				else { /*If Player 1 is still on the game board after moving, this code takes the energy adjustment value at Player 1's
				new location and it gets used to modify their energy unit number.*/
					boardValue = game.getEnergyAdj(player1.getLevel(), player1.getX(), player1.getY()); //Gets energy adjustment value for Player 1's position on the board
				
					player1.setEnergy(player1.getEnergy() + boardValue); //This makes Player 1's energy units go up or down
				    
					//This tells Player 1 where he / she is now and by how much his / her energy is being adjusted by
					System.out.println(String.format("\tYour energy is adjusted by %d for landing at Row: %d, Column: %d at Level %d", boardValue, player1.getX(), player1.getY(), player1.getLevel()));	
				}
				//End of code that runs when Player 1 is meant to go to a spot beyond the end of the game board
				
			}//End of board movement for Player 1
			
			if (player1.won(game)) { /*If Player 1 made it to the end of the board after moving, the loop breaks because 
			Player 1 achieved victory first*/
				break;
			}
		//END OF PLAYER 1'S TURN
			
		//START OF PLAYER 2'S TURN
			System.out.println(String.format("It is %s\'s turn", player2.getName()));
			
			//Energy Booster for Player 2
			/*If it is Player 2's turn and their energy unit number is less than or equal to 0, this will roll the dice 3 times
			  and keep track of how many times 2 of the same number appears. Player 2's energy units increase by two for every 
			  double dice rolls that appear.*/
			if (player2.getEnergy() <= 0) {
				int doublesCount = 0;
				System.out.println(String.format("\tUh Oh, %s does not have enough energy to move. "
						+ "Lets roll the dice 3 times to see if things change.", player2.getName())); /*This lets Player 2 know 
				that they don't have enough energy to move.*/
				
				for (int i = 0; i < 3; i++) { //This for loop rolls the dice 3 times and counts the number of doubles
					gameDice.rollDice();
					System.out.println(String.format("\tRoll %d => %s", i + 1, gameDice.toString()));
					
					if (gameDice.isDouble()) {
						doublesCount++;
					}
				}
				
				System.out.println(String.format("\tYou got %d doubles.", doublesCount)); /*This shows how many doubles the player got.*/
				
				if(doublesCount > 0) { /*If Player 2 got 1 or more doubles, this increases their energy unit numbers*/
					System.out.println(String.format("\tSo your energy goes up by %d energy units\n", doublesCount * 2));
					player2.setEnergy(player2.getEnergy() + (2 * doublesCount));
				}
			}//End of Energy Booster for Player 2
			
			//Board movement for Player 2
			if (player2.getEnergy() > 0) { /*This large if block runs when Player 2 has one or more energy units. 
				This block focuses of moving Player 2 across the game board.*/
				
				moveCount = gameDice.rollDice(); //This represents Player 2 rolling the dice
				
				System.out.println(String.format("\t%s you rolled %s", player2.getName(), gameDice.toString())); /*This lets
				player know what numbers they got.*/
				
				/*These three integer variables below record the original position of Player 2. They get used to modify the position of a Player
				that loses a challenge for a given spot on the board.*/
				int originalplayer2Level = player2.getLevel();
				int originalplayer2XRow = player2.getX();
				int originalplayer2YColumn = player2.getY();
				
				/*These three integer variables represent Player 2's new potential location*/
				int player2Level = player2.getLevel();
				int player2XRow = player2.getX();
				int player2YColumn = player2.getY();
				
				/*This if / else block is what moves Player 2 across the board. The direction Player 2 goes in depends on Player
				  2's position on the game board. If Player 2 is on the second to last spot on the board, Player 2 goes backwards.
				  Otherwise, Player 2 goes forwards.*/
				if ((originalplayer2Level == (game.getLevel() - 1)) && 
					(originalplayer2XRow == (game.getSize() - 1)) &&
			    	(originalplayer2YColumn == (game.getSize() - 2))) { /*This block of code is what will make Player 1 go in reverse.*/
					
					System.out.println("Sorry, since you are on the second to last spot on the game board, you need to go in reverse.");
					
					while (moveCount != 0) { /*This while loop makes Player 2's new  potential location some point farther away from the
						finishing point. This is so Player 2 can have the chance to roll numbers that would allow Player 2 to land at the 
						finishing point without going off it.*/
						player2YColumn--;

						if (player2YColumn == -1) {
							player2XRow--;
							player2YColumn = game.getSize() - 1;
									
						}
						if (player2XRow == -1) {
							player2Level--;
							player2XRow = game.getSize() - 1;
							player2YColumn = game.getSize() - 1;
									
						}
						moveCount--;
					}
				}
				
				else {
					//Start of while loop that moves Player 2 across the game boards
					while (moveCount != 0) { /*This while loop makes Player 2's new potential location some point closer to the finishing point.*/
						player2YColumn++;
					
						if (player2YColumn == game.getSize()) {
							player2XRow++;
							player2YColumn = 0;
						
						}
						if (player2XRow == game.getSize()) {
							player2Level++;
							player2XRow = 0;
							player2YColumn = 0;
						
						}
						moveCount--;
					}//End of while loop that moves player 2 across the game boards
				}
								
				if (gameDice.isDouble()) { /*If Player 2 got matching numbers for the dice roll, this increases the energy units by 2.*/
					player2.setEnergy(player2.getEnergy() + 2);
					System.out.println(String.format("\tCongratulations you rolled a double %d. Your energy went up by 2 units.", gameDice.getDie1()));
				}
				
				//Start of code that sets Player 2's position to its new values
				/*Whether Player 2 goes forwards or backwards, there needs to be a way to set Player 2's location on the board to the new position
				  defined by player2Level, player2XRow, and player2YColumn. This block of code is that way.*/
				player2.setLevel(player2Level);
				player2.setX(player2XRow);
				player2.setY(player2YColumn);
				//End of code that sets Player 2's position to its new values
				
				//Start of code that runs when player2 gets to a spot already taken by player1
				if (player2.equals(player1)) {
					//Lets player2 know player1 was there first
					System.out.println(String.format("Player %s is at your new location", player1.getName())); /*This lets Player 2
					know that Player 1 was already at the spot he / she was going to.*/
					
					//Start of code that asks for Player 2's choice
					/*This lets Player 2 know that when landing on a spot taken by another player, they can challenge that player for
					  the spot or forfeit and go to the position they were meant to go but one level down or back to the beginning if on
					  Level 0. They can choose to enter either a 0 or a 1.*/
					System.out.println("What do you want to do?");
					System.out.println("\t0 - Challenge and risk losing 50% of your energy units if you lose");
					System.out.println("\t    or move to new location and get 50% of the other player\'s energy units if you win");
					System.out.println("\t1 - to move down one level or move to (Row: 0, Column: 0) if at Level 0 and lose 2 energy units");
					System.out.print("Enter your choice here: ");
					
					int challengeChoice = -1;
					
					challengeChoice = scanner.nextInt();
					//End of code that asks for Player 2's choice
					
					//Start of while loop that runs for invalid choices
					/*This while loop runs when Player 2 enters numbers that are not 0 or 1. It will keep asking Player 2 to enter numbers
					  until Player 2 enters either a 0 or 1.*/
					while ((challengeChoice != 0) && (challengeChoice != 1)) {
						System.out.println(String.format("\nSorry but %d is not a legal choice.", challengeChoice));
						System.out.print("Enter your choice here: ");
						challengeChoice = scanner.nextInt();
					}
					//End of while loop that runs for invalid choices
					
					//Start of code that runs if player2 challenges player1 for the spot
					if (challengeChoice == 0) { /*If Player 2 decides to challenge Player 1 for the spot, a random number between 0 and
						10 is generated. If the number is less than 6, Player 2 loses the challenge, otherwise Player 2 wins.*/
						System.out.println(String.format("\nYou have chosen to challenge Player %s for the spot.\n", player1.getName()));
						
						int challengeOutcome = random.nextInt(11);
						
						System.out.println(String.format("Challenge outcome: %d", challengeOutcome));
						
						boolean player2Wins; //A boolean variable that represents Player 2 winning or not
						
						if (challengeOutcome < 6) {
							player2Wins = false; //For Player 2 losing
						}
						
						else {
							player2Wins = true; //For Player 2 winning
						}
						
						//Start of code for Player 2 victory
						if (player2Wins == true) { /*If Player 2 won the challenge, Player 1 goes to Player 2's original position which is defined
							by the variables originalplayer2Level, originalplayer2XRow, and originalplayer2YColumn. Also Player 1 loses half of their
							energy units to Player 2.*/
							System.out.println(String.format("Bravo %s!! You won the challenge. "
									+ "Which means %s will go to your original spot and loses half his/her energy units to you.", player2.getName(), player1.getName()));
							
							//This puts Player 1 at Player 2's original position
							player1.setLevel(originalplayer2Level);
							player1.setX(originalplayer2XRow);
							player1.setY(originalplayer2YColumn);
							
							int halfOfLoserEnergyUnits = player1.getEnergy() / 2; //This represents half of Player 1's energy units.
							
							//Player 1 loses half their energy units to Player 2
							player1.setEnergy(player1.getEnergy() - halfOfLoserEnergyUnits);
							
							player2.setEnergy(player2.getEnergy() + halfOfLoserEnergyUnits);
						}
						//End of code for Player 2 victory
						
						//Start of code for Player 2 defeat
						else if (player2Wins == false) { /*If Player 2 loses the challenge, they go back to the position where they were before.
							This position is defined by the variables originalplayer2Level, originalplayer2XRow, and originalplayer2Column. Also Player
							2 loses half their energy units*/
							System.out.println(String.format("!!! Sorry %s you lost. "
									+ "You are going back to where you were before and you lost half your energy units.", player2.getName()));
							
							//This puts Player 2 back to the position they were in before moving
							player2.setLevel(originalplayer2Level);
							player2.setX(originalplayer2XRow);
							player2.setY(originalplayer2YColumn);
							
							//This makes Player 2 lose half their energy units
							int halfOfLoserEnergyUnits = player2.getEnergy() / 2;
							player2.setEnergy(player2.getEnergy() - halfOfLoserEnergyUnits);
						}
						//End of code for Player 2 defeat
					}
					
					//Start of code for Player 2 forfeiting
					else if (challengeChoice == 1) { /*If Player 2 decides to forfeit to Player 1, Player 2 goes down 1 level. If Player 2's level
						is now negative, Player 2 goes back to beginning of the board, the zeroth column of the zeroth row on the zeroth level.*/
						System.out.println("\nYou have chosen to move down a level or go back to the beginning if at Level 0.\n");			
						
						System.out.println(String.format("You were at (Row: %d, Column: %d) on Level %d", player2.getX(), player2.getY(), player2.getLevel()));
						
						player2Level -= 1;
						
						if (player2Level < 0) { //Puts Player at the beginning if Player 2 is on Level 0
							
							player2.setLevel(0);
							player2.setX(0);
							player2.setY(0);
							
							System.out.println(String.format("Now you are at (Row: %d, Column: %d) on Level %d", player2.getX(), player2.getY(), player2.getLevel()));
							
						}
						
						else { //Player 2 goes down a level and loses 2 energy units
							player2.setLevel(player2Level);
							
							System.out.println(String.format("Now you are at (Row: %d, Column: %d) on Level %d and you lost 2 energy units", player2.getX(), player2.getY(), player2.getLevel()));
							
							player2.setEnergy(player2.getEnergy() - 2);
						}
					}
					//End of code for Player 2 forfeiting 
					
				}//End of code that runs when Player 2 gets to a spot already taken by Player 1
				
				//Start of code that runs when Player 2 is meant to go to a spot beyond the end of the game board
				if (player2.getLevel() >= game.getLevel()) { /*If Player 2 is about to go beyond the finish line, this code
					keeps Player 2 in his / her original position and they lose 2 energy units.*/
					System.out.println("!!! Sorry you need to stay where you are - that throw takes you off the grid and you loose 2 energy units.");
					
					player2.setLevel(originalplayer2Level);
					player2.setX(originalplayer2XRow);
					player2.setY(originalplayer2YColumn);
					
					player2.setEnergy(player2.getEnergy() - 2);
				}//End of code that runs when Player 2 is meant to go to a spot beyond the end of the game board
				
				else { /*If Player 2 is still on the game board after moving, this code takes the energy adjustment value at Player 2's
					new location and it gets used to modify their energy unit number.*/
					boardValue = game.getEnergyAdj(player2.getLevel(), player2.getX(), player2.getY()); //Gets energy adjustment value for Player2 position on board
				
					player2.setEnergy(player2.getEnergy() + boardValue); //This makes Player 2's energy units go up or down
					
					//This tells Player 2 where her / she is now and by how much his / her energy is being adjusted by
					System.out.println(String.format("\tYour energy is adjusted by %d for landing at Row: %d, Column: %d at Level %d", boardValue, player2.getX(), player2.getY(), player2.getLevel()));
				}			
					
			}//End of Board movement for Player 2
			
			if (player2.won(game)) { /*If Player 2 made it to the end of the board after moving, the loop breaks because 
				Player 2 achieved victory first*/
				break;
			}
			
			System.out.println();		
			
		//End of Round
			/*This little block of code runs when Player 1 and Player 2 have settled into their new positions on the board.
			  This block of code lets the players know where they are on the game board and how many energy units they have.
			  It also prompts a player to enter a key to continue to the next round.*/
			System.out.println("At the end of this round:");
			System.out.println(String.format("\t%s is on Level %d at location (Row: %d, Column: %d) and has %d units of energy.", player1.getName(), player1.getLevel(), player1.getX(), player1.getY(), player1.getEnergy()));
			System.out.println(String.format("\t%s is on Level %d at location (Row: %d, Column: %d) and has %d units of energy.", player2.getName(), player2.getLevel(), player2.getX(), player2.getY(), player2.getEnergy()));
			
			System.out.print("Any key to continue to next round ... ");
			input.nextLine();
			
			System.out.println();
		}
	//END OF THE WHILE LOOP THAT REPRESENTS THE TWO PLAYERS PLAYING THE GAME
		
//END OF BLOCK B
		
//START OF BLOCK C
/*Block C runs when one of the two players reaches the end of the game board and the loop running the game breaks. When that 
  happens, the current board locations of both players get presented. Afterwards a congratulatory message gets presented
  containing the name of the winning player.*/	
		System.out.println("At the end of this round:");
		System.out.println(String.format("\t%s is on Level %d at location (Row: %d, Column: %d) and has %d units of energy.", player1.getName(), player1.getLevel(), player1.getX(), player1.getY(), player1.getEnergy()));
		System.out.println(String.format("\t%s is on Level %d at location (Row: %d, Column: %d) and has %d units of energy.", player2.getName(), player2.getLevel(), player2.getX(), player2.getY(), player2.getEnergy()));
		
		System.out.println();
		
		if (player1.won(game)) { //If Player 1 won the game
			System.out.println(String.format("The winner is player %s. Well done!!!", player1.getName()));
		}
		
		else if (player2.won(game)) { //If Player 2 won the game
			System.out.println(String.format("The winner is player %s. Well done!!!", player2.getName()));
		}
		
		scanner.close();
		input.close();
//END OF BLOCK C
	}
}