/*The Board class represents the game board that will be used for Nancy's 3D Warrior Game.
 *It is a public class so it is accessible to the java file containing Nancy's 3D Warrior game.
 *The Board class contains integer variables that are used to determine the dimensions of the game board and the number of game 
 *boards there will be.
 *The Board class contains accessor methods that return the number of boards and their dimensions.
 *The Board class contains constructors that produce either a default game board or a custom game board depending on the player's 
 *choice.
 *The Board class contains a private method named createBoard() that creates the game board depending on the argument in the 
 *constructor.
 *The Board class contains a toString() method that returns a string the represents the entire layout of the game board and the 
 *placement of the energy adjustment values.
 *The Board class contains the method getEnergyAdj() that returns the number associated with a spot on the board that the 
 *current player is on.*/
public class Board {
	private int[][][] board; /*This is a 3 dimensional integer array that will be turned into the game board for Nancy's 3D 
	Warrior Game.*/
	
	public static int MIN_LEVEL = 3; /*This integer variable represents the minimum number of levels that can be in Nancy's 3D 
	Warrior Game.*/
	
	public static int MIN_SIZE = 3; /*This integer variable gets added to 1 and the sum represents the minimum board length in 
	Nancy's 3D Warrior Game.*/
	
	private int Level; /*This variable represents the maximum number of levels in Nancy's 3D Warrior Game.*/
	
	private int size; /*This variable represent the maximum length of a game board in Nancy's 3D Warrior Game.*/
	
	public int getLevel() { /*This method returns the number contained in the integer variable named Level.
	This method is useful for acquiring a player's location during Nancy's 3D Warrior Game.*/
		return Level;
	}
	
	public int getSize() { /*This method returns the number contained in the integer variable named size.
	This method is useful for acquiring a player's location during Nancy's 3D Warrior Game.*/
		return size;
	}
	
	public Board() { /*This Board constructor produces 3 4x4 game boards for Nancy's 3D Warrior Game.*/
		Level = MIN_LEVEL;
		size = MIN_SIZE + 1;
		createBoard(Level, size);
	}
	
	public Board(int L, int x) { /*This Board constructor produces a custom game board for Nancy's 3D Warrior Game.
	The user of the program enters the size of the boards and the number of boards he / she wants and this constructor makes 
	the board based on the arguments.*/
		Level = L;
		size = x;
		createBoard(Level, size);
	}
	
	private void createBoard(int level, int size) { /*This method which is present in the Board constructors is what actually 
	makes the game boards.*/
		
		int L = level; //This variable represents the number of levels in Nancy's 3D Warrior Game.
		
		int x = size; //This variable represents the length of a board in Nancy's 3D Warrior Game.
		
		int y = size; //This variable also represents the length of a board in Nancy's 3D Warrior Game.
		
		board = new int[L][x][y]; /*This sets the 3 dimensional integer array named board to the dimensions provided by the L, 
		x, and y variables.*/
		/*The triple nested for loop shown below takes the 3 dimensional integer array named board and fills it with numbers 
		  based on certain rules*/
		
		for (int l = 0; l < board.length; l++) { /*This part of the nested for loop goes through all the boards in Nancy's 3D 
			Warrior Game.*/
			
			for (int row = 0; row < board[l].length; row++) { /*This part of the nested for loop goes through all the rows on a 
			given board in Nancy's 3D Warrior Game.*/
				
				for (int column = 0; column < board[l][row].length; column++) { /*This part of the nest for loop goes through all 
				the columns on a given row of a given board in Nancy's 3D Warrior Game.*/
					
					int sum = l + row + column; /*As this nested for loop program goes through every possible position on the game 
					board the numbers representing the current level, row, and column are taken and added up. This sum is stored in
					an integer variable named sum.*/
					
					if (sum % 3 == 0) /*If the sum of the numbers representing the current level, row, and column is divisible by 3,
					put a -3 in that position on the game board.*/
						board[l][row][column] = -3; 
					
					else if (sum % 5 == 0) /*If the sum of the numbers representing the current level, row, and column is divisible by 5,
					put a -2 in that position on the game board.*/
						board[l][row][column] = -2;
					
					else if (sum % 7 == 0) /*If the sum of the numbers representing the current level, row, and column is divisible by 7,
						put a 2 in that position on the game board.*/
						board[l][row][column] = 2;
					
					else { /*This puts a 0 into all other positions on the board and puts a 0 into the very first spot on the board.*/
						board[l][row][column] = 0;
						board[0][0][0] = 0;
					}
						
				}
			}
		}	
	}
	
	public String toString() { /*This method generates a string that shows the position of every number on every board that will 
	be used in a play through of Nancy's 3D Warrior Game.*/
		
		StringBuilder gameBoard = new StringBuilder(); /*This produces a string builder object that will be used to gather strings
		representing the names of the game boards and the numbers that will be on those game boards.*/
		
		/*This triple nested for loop goes through every position on the game board, takes the number stored in that position, turns it
		 *into a string and the string builder adds it to the string it is building. Each iteration of this nested for loop produces a 
		 *label and a square matrix that gets added to the string builder object.*/
		for (int l = 0; l < board.length; l++) { /*This for loop goes through every level in the game board. For every game board, 
		the program adds a string representing a kind of banner with the name of the level itself.*/
			gameBoard.append(String.format("Level %d\n", l));
			gameBoard.append("--------\n");
			
			for (int row = 0; row < board[l].length; row++) { /*This for loop goes through all the rows in a given level board.*/
				
				for (int column = 0; column < board[l][row].length; column++) { /*This for loop goes through all the columns in a 
				given row*/
					gameBoard.append(String.format(" %2d  ", board[l][row][column])); /*This line of code produces a string 
					containing every number in a given row on the board and it gets added to the string builder.*/
				}
			gameBoard.append("\n");
			}
			gameBoard.append("\n");
		}
		return gameBoard.toString(); /*The triple nested for loop above this statement produces a giant string containing square matrices, 
		each accompanied by a label showing which game level a given matrix represents. The string builder named gameBoard was the means by 
		which this giant string was assembled. It gets turned into a string that serves as the output of this function. In Nancy's 3D Warrior
		Game, this method shows the players the entire game board on which they will be playing.*/
	}
	
	public int getEnergyAdj(int L, int x, int y) { /*This method returns the number at a given position on the game board. In Nancy's 3D Warrior 
	Game, this method gets used to modify a given player's energy level by adding the player's energy level to the output value of this method.*/
		return board[L][x][y];
	}
}