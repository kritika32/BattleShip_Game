import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class battleship_ {
	public static int user_ships = 5;
	public static int computer_ships = 5;
	public static Scanner scn = new Scanner(System.in);
	public static Random r = new Random();

	public static void main(String[] args) {
		int endgame = -1;
		char[][] grid = new char[10][10];
		ArrayList<String> playerGuesses = new ArrayList<>();
		ArrayList<String> computerMisses = new ArrayList<>();
		ArrayList<String> computerGuesses = new ArrayList<>();

		System.out.println("**************WELCOME TO BATTLESHIP GAME**************");
		System.out.println("Right,now the sea is empty.\n");

		print_grid(grid);

		// Player deploys his ship
		for (int i = 0; i < 5; i++)
			Place_Player(grid, i);

//        Computer deploy's its ship
		System.out.println("\n Computer is DEPLOYING its SHIP");
		for (int i = 0; i < 5; i++) {
			Place_Computer(grid);
			System.out.println((i + 1) + " SHIP DEPLOYED");
		}

		// BATTLE BEGIN'S

		System.out.println("*************BATTLE BEGINS*************");

		while (endgame == -1) {
			Player_Turn(grid, playerGuesses, computerMisses);
			if (user_ships == 0 || computer_ships == 0)
				endgame = 0;
			else
				Computer_Turn(grid, computerGuesses, computerMisses, playerGuesses);
			
			System.out.println();
			print_grid(grid);
			print_footer(user_ships,computer_ships);
			
			if(user_ships==0)
				System.out.println("GAME OVER!!! YOU LOSE!! BETTER LUCK NEXT TIME!!");
			else if(computer_ships==0)
				System.out.println("HORRAY!!!!! YOU WON THE GAME!!!");
				
		}

	}

	private static void print_footer(int user_ships, int computer_ships2) {
		System.out.println("PLAYER SHIPS : "+user_ships+"||"+" COMPUTER SHIPS : "+computer_ships);
		
	}

	private static void Computer_Turn(char[][] grid, ArrayList<String> computerGuesses,
			ArrayList<String> computerMisses, ArrayList<String> playerGuesses) {

		System.out.println("*******COMPUTER'S TURN*******");
		int x, y;
		do {
			x = r.nextInt(9);
			y = r.nextInt(9);
		} while (playerGuesses.contains(x + " " + y) || computerGuesses.contains(x + " " + y));

		computerGuesses.add(x + " " + y);

		switch (grid[x][y]) {
		case '#':
			System.out.println("Computer sunken one of its ship");
			grid[x][y] = '!';
			computer_ships--;
			break;

		case '@':
			System.out.println("The computer sunk one of your ships!!");
			grid[x][y] = 'x';
			user_ships--;
			break;

		case '0':
			System.out.println("You Missed!!");
			computerMisses.add(x + " " + y);
			break;
		}
		
		System.out.println("COMPUTER'S GUESS WAS : "+ x+" "+y);
	}

	private static void Player_Turn(char[][] grid, ArrayList<String> playerGuesses, ArrayList<String> computerMisses) {
		int x = 0, y = 0;

		System.out.println("\n *****YOUR TURN***** ");

		int res = 1;
		while (res == 1) {
			System.out.print("Enter x coordinate : ");
			x = scn.nextInt();
			System.out.print("Enter y coordinate : ");
			y = scn.nextInt();

			if (valid(x, y)) {
				if (playerGuesses.contains(x + " " + y))
					System.out.println("You have already guessed these coordinates...Try something different!");
				else if (computerMisses.contains(x + " " + y))
					System.out.println("The computer missed when targeting here!! So try something different!!");
				else if (grid[x][y] == 'x')
					System.out
							.println("The Computer had already sunken one of your ship here!! So try something else!!");
				else if (grid[x][y] == '!')
					System.out.println("The Computer had sunken one of its ship here!! So try again!!");
				else
					res = -1;
			} else {
				System.out.println("INVALID Coordinates!!! Try something else ranging from 0 to 9.");
			}
		}
		playerGuesses.add(x + " " + y);

		switch (grid[x][y]) {
		case '#':
			System.out.println("Boom! You sunk the ship!");
			grid[x][y] = '!';
			computer_ships--;
			break;
		case '@':
			System.out.println("Oh no, you sunk your own ship :(");
			grid[x][y] = 'x';
			user_ships--;
			break;
		case '0':
			System.out.println("You Missed!!!");
			grid[x][y] = '-';
			break;

		}
	}

	private static void Place_Computer(char[][] grid) {
		int x = 0, y = 0;
		do {
			x = r.nextInt(9);
			y = r.nextInt(9);

		} while ((int) grid[x][y] != 0);

		grid[x][y] = '#';

	}

	private static void Place_Player(char[][] grid, int i) {
		int error = 1, x = 0, y = 0;

		while (error == 1) {
			System.out.print("\n Enter x coordinate for your " + (i + 1) + " ship . :");
			x = scn.nextInt();
			System.out.print("\n Enter x coordinate for your " + (i + 1) + " ship . :");
			y = scn.nextInt();

			if (valid(x, y)) {
				if (grid[x][y] != 0)
					System.out.println("You have already placed a ship here!!! Try another one!!");
				else
					error = -1;
			} else {
				System.out.println("Invalid cooordinates!!! Try Again!!");
			}
		}
		grid[x][y] = '@';
	}

	private static boolean valid(int x, int y) {
		if (x > 9 || x < 0 || y > 9 || y < 0)
			return false;
		return true;
	}

	private static void print_grid(char[][] grid) {
		System.out.print(" |");

		for (int i = 0; i < grid.length; i++) {
			System.out.print(i + " |");
		}
		System.out.println();

		for (int i = 0; i < grid.length; i++) {
			System.out.print(i + "|");
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '0' || grid[i][j] == '#')
					System.out.print(" |");
				else
					System.out.print(grid[i][j] + " |");
			}
			System.out.println();
		}

	}

}
