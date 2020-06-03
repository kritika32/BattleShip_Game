import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class BattleShip {
	Scanner scn = new Scanner(System.in);
	final int size;
	char[][] ocean;
	final int ships;

	public BattleShip() throws InterruptedException {
		this(10, 20);
	}

	public BattleShip(int size, int ships) throws InterruptedException {
		this.size = size;
		this.ships = ships;
		ocean = new char[this.size][this.size];
		fill(ocean, '_');
		separator(100);
			align(4, 2, 0, "Status: Loading");
		TimeUnit.MILLISECONDS.sleep(50);

		for (int i = 0; i < 3; i++) {
			System.out.print(".");
			TimeUnit.SECONDS.sleep(1);
		}
		separator(100);
		align(4, 1, 1, "Status: Completed!");

		separator(100);
		System.out.println();

	}

	private void align(int t, int l, int after, String string) throws InterruptedException {

		for (int i = 0; i < l; i++) {
			System.out.println();
		}
		for (int i = 0; i < t; i++) {
			System.out.print("\t");
		}
		createDelay(string);

		for (int i = 0; i < after; i++) {
			System.out.println();
		}
	}

	public void separator(int value) {
		System.out.println();
		for (int i = 0; i < value; i++) {
			System.out.print("-");
		}
		System.out.println();
	}

	public void createDelay(String str) throws InterruptedException {
		for (char ch : str.toCharArray()) {
			System.out.print(ch);
			TimeUnit.MILLISECONDS.sleep(70);
		}
		TimeUnit.MILLISECONDS.sleep(70);
	}

	public void fill(char[][] ocean, char val) throws InterruptedException {
		for (char[] row : ocean) {
			TimeUnit.MILLISECONDS.sleep(90);
			Arrays.fill(row, val);
			TimeUnit.MILLISECONDS.sleep(90);
		}
	}

	public void PrintOcean() throws InterruptedException {
		
		align(3, 0, 2, "Welcome to the Battle Ship Game! [^_^]");
		align(2, 0, 2, "I Present you the Ocean to Place your Ships! |-{*_*}-|");
		align(4, "   ");
		
		for (int j = 0; j < ocean[0].length; j++)
			System.out.print(j + " ");

		System.out.println();
		for (int row = 0; row < ocean.length; row++) {
			leftpadding(4);
			System.out.print(row + "| ");
			for (int col = 0; col < ocean[row].length; col++) {

				TimeUnit.MILLISECONDS.sleep(40);
				System.out.print(ocean[row][col] + " ");
			}
			System.out.print(row + "|");
			System.out.println();
		}
		System.out.println();
		align(4, "   ");
		for (int j = 0; j < ocean[0].length; j++)
			System.out.print(j + " ");

		System.out.println();
		separator(100);
	}

	private void align(int t, int l, String string) throws InterruptedException {
		for (int i = 0; i < l; i++)
			System.out.println();

		for (int i = 0; i < t; i++)
			System.out.print("\t");

		createDelay(string);
	}

	public void Menu() throws InterruptedException {
		align(4, 0, 2, "~~~~~MENU~~~~~\n");
		align(4, 0, 1, "1. Start Game\n");
		align(4, 0, 1, "2.How to Play\n");
		align(4, 0, 1, "3.Exit Game\n");
		
		while (true) {
			separator(100);
			align(4, 1, 0, "Enter your choice: ");
			int choice = scn.nextInt();
			if (choice == 1) {
				break;
			} else if (choice == 2) {
				instructions();
			} else {
				break;
			}
		}
	}

	public void instructions() throws InterruptedException {
		align(3, 2, "1. Place your 5 ships in the Ocean.");
		align(3, 2, "2. Then Computer will place its 5 ships.");
		align(3, 2, "3. Then you both will be granted Chance one");
		align(3, 2, "   by one to attack at desired position.");
		align(3, 2, "4. Anyone who destroyed all of opponent's ship");
		align(3, 2, "   will win. [$^_^$].");

	}

	public void align(int t, String s) {
		for (int i = 0; i < t; i++) {
			System.out.print("\t");
		}
		System.out.print(s);
	}

	public void leftpadding(int t) {
		for (int i = 0; i < t; i++)
			System.out.print("\t");
	}
}
