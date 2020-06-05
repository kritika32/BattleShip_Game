import java.util.*;
import java.util.concurrent.TimeUnit;

public class BattleShip {
	Scanner scn = new Scanner(System.in);
	final int size;
	char[][] ocean;
	boolean isManual;
	Random rand = new Random();
	final int ships;

	private static class indent {

		private static void printLegend() {
			align(4, 0, "x: User Destroyed Ship!\n\n");
			align(4, 0, "#: Computer's Destroyed Ship!\n\n");
			align(4, 0, "@: User Saved Ship!\n\n");
			align(4, 0, "!: Computer's Hidden Ship\n\n");
		}

		private static void align(int t, int l, String string) {

			for (int i = 0; i < l; i++) {
				System.out.println();
			}
			for (int i = 0; i < t; i++) {
				System.out.print("\t");
			}
			System.out.print(string);

		}

		public static void separator(int value) {
			System.out.println();
			for (int i = 0; i < value; i++) {
				System.out.print("-");
			}
			System.out.println();
		}

		public static void createDelay(String str) throws InterruptedException {
			for (char ch : str.toCharArray()) {
				System.out.print(ch);
				TimeUnit.MILLISECONDS.sleep(60);
			}
			TimeUnit.MILLISECONDS.sleep(60);
		}

		private static void alignSlow(int t, int l, String string) throws InterruptedException {
			for (int i = 0; i < l; i++)
				System.out.println();

			for (int i = 0; i < t; i++)
				System.out.print("\t");

			createDelay(string);
		}

		public static void leftpadding(int t) {
			for (int i = 0; i < t; i++)
				System.out.print("\t");
		}

		public static void instructions() throws InterruptedException {
			align(4, 2, "1. Place your 5 ships in the Ocean.");
			align(4, 2, "2. Then Computer will place its 5 ships.");
			align(4, 2, "3. Then you both will be granted Chance one");
			align(4, 2, "   by one to attack at desired position.");
			align(4, 2, "4. Anyone who destroyed all of opponent's ship");
			align(4, 2, "   will win. [$^_^$].\n\n");

		}
	}

	// Default Constructor to initialize size of ocean and ships
	public BattleShip() throws InterruptedException {
		this(10, 20);
	}

	public BattleShip(int size, int ships) throws InterruptedException {
		this.size = size;
		this.ships = ships;
		ocean = new char[this.size][this.size];
		fill(ocean, '_');
		indent.separator(100);
		indent.alignSlow(4, 0, "Status: Loading");
		TimeUnit.MILLISECONDS.sleep(50);

		for (int i = 0; i < 3; i++) {
			System.out.print(".");
			TimeUnit.SECONDS.sleep(1);
		}
		indent.separator(100);
		indent.alignSlow(4, 1, "Status: Completed!\n");

		indent.separator(100);
		System.out.println();

		indent.alignSlow(3, 0, "Welcome to the Battle Ship Game! [^_^]\n\n");
		indent.alignSlow(2, 0, "I Present you the Ocean to Place your Ships! |-{*_*}-|\n\n");

	}

	public void fill(char[][] ocean, char val) throws InterruptedException {
		for (char[] row : ocean) {
			Arrays.fill(row, val);
		}
	}

	public void PrintOcean(boolean show) throws InterruptedException {

		indent.align(4, 0, "   ");

		for (int j = 0; j < ocean[0].length; j++)
			System.out.print(j + " ");

		System.out.println();
		for (int row = 0; row < ocean.length; row++) {
			indent.leftpadding(4);
			System.out.print(row + "| ");
			for (int col = 0; col < ocean[row].length; col++) {

				TimeUnit.MILLISECONDS.sleep(40);
				if (ocean[row][col] == '1') {
					System.out.print("@ ");
					continue;
				} else if (ocean[row][col] == '2') {
					System.out.print((!show ? "_" : "!") + " ");
					continue;
				}

				System.out.print(ocean[row][col] + " ");
			}
			System.out.print(row + "|");
			System.out.println();
		}
		System.out.println();
		indent.align(4, 0, "   ");
		for (int j = 0; j < ocean[0].length; j++)
			System.out.print(j + " ");

		System.out.println();
		indent.separator(100);
	}

	public void Menu() throws InterruptedException {
		indent.alignSlow(4, 0, "~~~~~MENU~~~~~\n\n\n");
		indent.alignSlow(4, 0, "1. Start Game\n\n");
		indent.alignSlow(4, 0, "2.How to Play\n\n");
		indent.alignSlow(4, 0, "3.Exit Game\n\n");

		while (true) {
			indent.separator(100);
			indent.align(4, 1, "Enter your choice: ");
			int choice = scn.nextInt();
			if (choice == 1) {
				Start();
				break;
			} else if (choice == 2) {
				indent.instructions();
			} else {
				break;
			}
		}
	}

	public int[] getXY(boolean isUser, boolean isManual) throws InterruptedException {

		if (isUser && isManual) {
			indent.align(4, 1, "Enter X and Y location : ");
			return new int[] { scn.nextInt(), scn.nextInt() };
		} else
			return new int[] { rand.nextInt(10), rand.nextInt(10) };
	}

	public void deploy(boolean isUser, Set<String> loc) throws InterruptedException {

		if (isUser)
			indent.alignSlow(4, 2, "Start placing your ships!!!\n\n");
		else
			indent.alignSlow(4, 2, "Computer placing it's ships\n\n");

		for (int i = 0; i < 20;) {
			int[] xy = getXY(isUser, false);
			while (loc.contains(xy[0] + " " + xy[1])) {
				indent.align(4, 1, "Cannot Place here... Try Again!!\n\n");
				xy = getXY(isUser, false);
				continue;
			}
			loc.add(xy[0] + " " + xy[1]);
			if (isUser)
				indent.align(4, 0, "" + (i + 1) + ". Your Ship Deployed at {" + xy[0] + ":" + xy[1] + "}\n\n");
			else
				indent.align(4, 0, "" + (i + 1) + ". Ship Deployed.\n\n");

			this.ocean[xy[0]][xy[1]] = isUser ? '1' : '2';

			i++;
		}
		System.out.println();
		System.out.println();
		PrintOcean(false);

	}

	public int killShips(boolean isUSer, Set<String> loc) throws InterruptedException {

		if (isUSer)
			indent.align(4, 1, "Your Turn Choose Location to Fire {#__#} \n");
		else
			indent.align(4, 1, "Computer Firing {*__*} \n");

		int[] xy = getXY(isUSer, true);

		while (loc.contains(xy[0] + " " + xy[1])) {
			indent.align(4, 1, "Cannot Fire Here!!!\n\n");
			xy = getXY(isUSer, true);
		}

		loc.add(xy[0] + " " + xy[1]);

		if (this.ocean[xy[0]][xy[1]] == '1') {
			if (isUSer)
				indent.align(4, 1, "You Blown your own ship you Idiot [-__-]\n");
			else
				indent.align(4, 1, "Computer sunk one of your Ship {@__@}\n");
			this.ocean[xy[0]][xy[1]] = 'x';
			return 1;
		} else if (this.ocean[xy[0]][xy[1]] == '2') {
			if (isUSer)
				indent.align(4, 1, "Boom!! You sunk Computer's Ship [^__^]\n");
			else
				indent.align(4, 1, "Computer sunk its own ship...[Noob] [-__-]\n");
			this.ocean[xy[0]][xy[1]] = '#';
			return 2;
		}

		else {
			System.out.println();
			String res = isUSer ? "User" : "Computer";

			indent.alignSlow(4, 0, res + "  missed !!! \n");
			return 0;

		}
	}

	public void Start() throws InterruptedException {
		Set<String> loc = new HashSet<>();

		deploy(true, loc);

		deploy(false, loc);

		int UserLeftShips = 5;
		int CompLeftShips = 5;
		Set<String> pos = new HashSet<>();
		boolean isuser = true;

		while (UserLeftShips > 0 && CompLeftShips > 0) {

			for (int i = 0; i < 2; i++) {

				int res = killShips(isuser, pos);
				if (res == 1)
					UserLeftShips--;
				else if (res == 2)
					CompLeftShips--;
				isuser = !isuser;
			}

			UserLeftShips = UserLeftShips < 0 ? 0 : UserLeftShips;
			CompLeftShips = CompLeftShips < 0 ? 0 : CompLeftShips;
			indent.separator(100);

			indent.align(4, 0, "Your Ship count: " + UserLeftShips + " Computer's Ship count: " + CompLeftShips);

			indent.separator(100);
			PrintOcean(false);
		}

		if (UserLeftShips == 0 && CompLeftShips == 0)
			indent.alignSlow(4, 2, "Its a Tie between Warriors :/\n\n");
		else if (UserLeftShips == 0)
			indent.alignSlow(4, 2, "Machine slayed Human [%__%]\n\n");
		else
			indent.alignSlow(4, 2, "Human defeated Machine (^__^)\n\n");

		indent.separator(100);
		System.out.println();
		PrintOcean(true);
		System.out.println();
		indent.printLegend();
		indent.separator(100);

	}

}
