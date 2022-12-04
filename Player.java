/*Nancy's 3D Warrior Game is a two player game and players need a way to represent themselves on the game board.
 *The Player class allows players to create a kind of virtual avatar that they will use for their play through of
 *Nancy's 3D Warrior Game.
 *The Player class contains a string variable  called name that stores a name that players decide for themselves.
 *The Player class contains three integer variables Level, x, and y which keep track of a player's position on the 
 *game board.
 *The Player class contains an integer variable named energy that represents a player's energy level during a play
 *through of Nancy's 3D Warrior Game.
 *The Player class contains constructors that create Player objects based on what the players of the game want them to be.
 *The Player class contains mutator and accessor methods that can modify and return information about Player objects.
 *The Player class contains methods that return boolean values. These methods influence game play during a play through
 *of Nancy's 3D Warrior Game.
 *The Player class contains a toString() method that returns a string containing information of a Player object's position 
 *on the game board.*/
public class Player {
	private String name; /*This string variable represents a player's name.*/
	
	private int Level; /*This integer variable represents the level a player is on.*/
	
	private int x; /*This integer variable represents the horizontal position of a player on the game board. 
	It could also represent the row on the game board that a player is on*/
	
	private int y; /*This integer variable represents the vertical position of a player on the game board.
	It could also represent the column on the game board that a player is on.*/
	
	private int energy; /*This integer variable represents the amount of energy a player has. Positive values for the energy
	variable mean that a Player object can move across the game board.*/
	
	public Player() { /*This Player constructor is a no-argument constructor that creates a Player object with no name, and 
	starts the game with 10 energy units and is initially positioned at the starting point on the first level of the game board.*/
		this.name = "";
		this.Level = 0;
		this.x = 0;
		this.y = 0;
		this.energy = 10;
	}
	
	public Player(String identity) { /*This Player constructor takes a customized name entered by the user and creates a Player object
	with the customized name as its name, 10 energy units and is initially positioned at the starting point on the first level of the 
	game board.*/
		this.name = identity;
		this.Level = 0;
		this.x = 0;
		this.y = 0;
		this.energy = 10;
	}
	
	public Player (int L, int x, int y) { /*This Player constructor takes integer arguments representing a position on the game board.
	It creates a Player object with no name, 10 energy units and is positioned at a spot on the game board defined by the three integer 
	arguments.*/
		this.name = "";
		this.Level = L;
		this.x = x;
		this.y = y;
		this.energy = 10;
	}
	
	public Player (Player player) { /*This Player constructor creates a copy of the Player object argument that goes into it.
	The resulting Player object has the same String and integer values as another Player object.*/
		this.name = player.getName();
		this.Level = player.getLevel();
		this.x = player.getX();
		this.y = player.getY();
		this.energy = player.getEnergy();
	}
	
	public String getName() { /*This method returns the name of a Player object. In Nancy's 3D Warrior Game, this method is used 
	to identify the players of the game and to tell what is happening to those players while playing the game.*/
		return name;
	}
	
	public int getLevel() { /*This method returns the board level number a player is on. In Nancy's 3D Warrior Game, it helps to determine
	a player's position on the game board, whether they are going to a position that is off the game board, and if a player wins the 
	game.*/
		return Level;
	}
	
	public int getX() { /*This method returns the row number a player is on. In Nancy's 3D Warrior Game, it helps to determine a player's
	position on the game board, whether they go to the next level of the game board, and if a player wins the game.*/
		return x;
	}
	
	public int getY() { /*This method returns the column number a player is on. In Nancy's 3D Warrior Game, it helps to determine a player's
	position on the game board, whether they go to the next row or next level of the game board, and if a player wins the game.*/
		return y;
	}
	
	public int getEnergy() { /*In Nancy's 3D Warrior Game, this method returns the number of energy units a player has. It can also be used 
	to modify the number of energy units a player has when used in conjunction with the setEnergy() method. */
		return energy;
	}
	
	public void setName(String new_name) { /*This method can change the name of a Player object.*/
		name = new_name;
	}
	
	public void setLevel(int new_Level) { /*This method changes the board level a Player object is on.*/
		Level = new_Level;
	}
	
	public void setX(int new_X) { /*This method changes the board row that a Player object is on.*/
		x = new_X;
	}
	
	public void setY(int new_Y) { /*This method changes the board column that a Player object is on.*/
		y = new_Y;
	}
	
	public void setEnergy(int new_Energy) { /*This method changes the number of energy units that a Player has. In Nancy's 3D
	Warrior Game, this method modifies the Player's energy unit number based on where the Player object lands on the game board
	or based on whether the Player wins or loses a challenge to another Player.*/
		energy = new_Energy;
	}
	
	public boolean equals(Player p) { /*This method is what activates a Player versus Player challenge in Nancy's 3D Warrior Game.
	It returns true when a player is meant to land on a spot on the game board that is already occupied by another player.*/
		if ((Level == p.getLevel()) && 
			(x == p.getX()) && 
			(y == p.getY()))
			return true;
		else
			return false;
	}
	
	public boolean won(Board b) { /*This method returns true when a Player object has reached the final spot on the game board. In
	Nancy's 3D Warrior Game, this method is what ends the game when any of the two players reaches the last column on the last row 
	of the last level.*/
		if ((Level == (b.getLevel() - 1)) && (x == (b.getSize() - 1)) && (y == (b.getSize() - 1)))
			return true;
		else 
			return false;
	}
	
	public String toString() { /*This method returns a string providing the location / position of a Plater object on the game board.*/
		String stats = String.format("Level = %d Row = %d Column = %d", Level, x, y);
		return stats;
	}
}