import java.util.*;
import java.util.concurrent.TimeUnit;
class BattleGame {

	char[][] ocean;
	final int size;
	Random rand;
	final int ships;
	boolean isManual;
	Scanner scn = new Scanner(System.in);

	private static class indent {

		static int leftPadding = 3;
		static int sep = 100;

		public static void createDelay(String messg) throws InterruptedException {
			for (char ch : messg.toCharArray()) {
				System.out.print(ch);
				TimeUnit.MILLISECONDS.sleep(50);
			}
			TimeUnit.MILLISECONDS.sleep(50);
		}

		public static void align(int t, int l, String messg) {

			for (int i = 0; i < t; i++) {
				System.out.println();
			}

			for (int i = 0; i < l; i++) {
				System.out.print("\t");
			}

			System.out.print(messg);
		}

		public static void align(int t, String messg) {

			align(t, leftPadding, messg);
		}

		public static void separator(int val) {
			System.out.println();
			for (int i = 0; i < val; i++)
				System.out.print("-");

			System.out.println();
		}

		public static void printLegends() {

			align(2, "x: User Destroyed Ship!\n");
			align(1, "#: Computer's Destroyed Ship!\n");
			align(1, "@: User Saved Ship!\n");
			align(1, "!: Computer's Hidden Ship\n");
		}

		public static void PrintInst() {

			align(2, "1. Place your N ships in the Ocean.\n");
			align(1, "2. Then Computer will place its N ships.\n");
			align(1, "3. Then you both will be granted Chance one \n");
			align(0, "   by one to attack at desired position.\n");
			align(1, "4. Anyone who destroyed all of opponent's ship \n");
			align(0, "   will win. [$^_^$].\n");
		}

		public static void AlignSlowmo(int t, int l, String messg) throws InterruptedException {

			align(t, l, "");
			createDelay(messg);
		}

		public static void AlignSlowmo(int t, String messg) throws InterruptedException {

			AlignSlowmo(t, leftPadding, messg);
		}

		public static void AlignPrint(int t, String messg) {
			align(t, "");
			System.out.print(messg);
		}

	}

	public BattleGame() throws InterruptedException {

		this(10, 10, false);
	}

	public BattleGame(int cap, int ships, boolean isManual) throws InterruptedException {
		this.size = cap;
		this.ocean = new char[size][size];
		rand = new Random();
		this.isManual = isManual;
		Fill(ocean, '_');
		this.ships = ships;

		indent.separator(indent.sep);
		indent.align(1, "   Status: Loading");
		TimeUnit.SECONDS.sleep(1);

		for (int i = 0; i < 3; i++) {
			System.out.print(".");
			TimeUnit.SECONDS.sleep(1);
		}
		System.out.println();
		indent.separator(indent.sep);
		indent.align(1, "   Status: Completed! \n");
		indent.separator(indent.sep);

		indent.AlignSlowmo(2, 2, "      Welcome to the Battle Ship Game! [^_^]\n");
		indent.AlignSlowmo(2, 2, "  I Present you the Ocean to Place your Ships! |-{*_*}-|");
	}

	public void Fill(char[][] mat, char val) {
		for (char[] m : mat) {
			Arrays.fill(m, val);
		}
	}

	public void header_footer(int v, int t) {

		indent.align(v, "      ");
		for (int j = 0; j < ocean[0].length; j++) {
			System.out.print(j + " ");
		}

		for (int i = 0; i < t; i++)
			System.out.println();

	}

	public void printOcean(boolean show) throws InterruptedException {

		header_footer(2, 1);

		for (int i = 0; i < ocean.length; i++) {
			indent.align(0, "   " + i + "| ");
			for (int j = 0; j < ocean[i].length; j++) {
				TimeUnit.MILLISECONDS.sleep(30);
				if (ocean[i][j] == '1') {
					System.out.print("@ ");
					continue;
				} else if (ocean[i][j] == '2') {
					System.out.print((!show ? "_" : "!") + " ");
					continue;

				}
				System.out.print(ocean[i][j] + " ");
			}
			System.out.println("|" + i);
		}
		System.out.println();
		header_footer(0, 1);
		indent.separator(indent.sep);
	}

	public int[] getXY(boolean isUser) throws InterruptedException {

		if (isUser && isManual) {
			indent.AlignPrint(1, "    Enter X & Y of the Location: ");
			return new int[] { scn.nextInt(), scn.nextInt() };
		} else {
			return new int[] { rand.nextInt(10), rand.nextInt(10) };
		}

	}

	public void deployShip(boolean isUser, Set<String> loc) throws InterruptedException {

		String decide = "";
		if (isUser)
			decide = "   Start Placing Your Ships\n";
		else
			decide = "Computer Placing its Ships\n";

		indent.AlignSlowmo(2, decide);
		for (int i = 0; i < this.ships;) {
			int[] xy = getXY(isUser);
			System.out.println();
			if (!loc.add(xy[0] + "" + xy[1])) {
				indent.AlignPrint(0, "  Cannot Place at Here!!!\n\n");
				continue;
			}

			if (isUser)
				decide = "" + (i + 1) + ". Your Ship Deployed at [" + xy[0] + ":" + xy[1] + "]\n";
			else
				decide = "     " + (i + 1) + ". Ship Deployed.\n";
			indent.AlignPrint(0, decide);
			this.ocean[xy[0]][xy[1]] = isUser ? '1' : '2';
			i++;
		}
		printOcean(false);
	}

	public int KillShip(boolean isUser, Set<String> loc) throws InterruptedException {

		int killed = 0;
		String decide = "";
		if (isUser)
			decide = "Your Turn Choose Location to Fire {#__#}\n";
		else
			decide = "Computer Firing {*__*}\n";

		indent.AlignPrint(2, decide);

		this.isManual = true;
		int[] xy = getXY(isUser);
		while (loc.contains(xy[0] + "" + xy[1])) {
			indent.AlignSlowmo(0, "Cannot Fire Here!!!\n\n");
			xy = getXY(isUser);
		}
		loc.add(xy[0] + "" + xy[1]);
		if (this.ocean[xy[0]][xy[1]] == '1') {
			this.ocean[xy[0]][xy[1]] = 'x';
			if (isUser) {
				indent.AlignSlowmo(2, "You Blown your own ship you Idiot [-__-]\n");
			} else {
				indent.AlignSlowmo(2, "Computer sunk one of your Ship {@__@}\n");
			}
			killed = 1;
		} else if (this.ocean[xy[0]][xy[1]] == '2') {
			this.ocean[xy[0]][xy[1]] = '#';
			if (isUser) {
				indent.AlignSlowmo(2, "Boom!! You sunk Computer's Ship [^__^]\n");
			} else {
				indent.AlignSlowmo(2, "Computer sunk its own ship...[Noob] [-__-]\n");
			}
			killed = 2;
		} else {
			decide = isUser ? "User" : "Computer";
			indent.AlignSlowmo(2, decide + " missed !!! ");
		}

		return killed;

	}

	public void Start() throws InterruptedException {

		Set<String> loc = new HashSet<>();
		deployShip(true, loc);
		deployShip(false, loc);
		int threshold = 5;
		int userShips = threshold;
		int compShips = threshold;
		loc = new HashSet<>();
		boolean isUser = true;
		while (userShips > 0 && compShips > 0) {

			for (int i = 0; i < 2; i++) {
				int r = KillShip(isUser, loc);
				if (r == 1) {
					userShips--;
				} else if (r == 2) {
					compShips--;
				}
				isUser = !isUser;
			}

			userShips = userShips < 0 ? 0 : userShips;
			compShips = compShips < 0 ? 0 : compShips;
			indent.separator(indent.sep);
			indent.AlignPrint(1, "Your Ship count: " + userShips + " Computer's Ship count: " + compShips);
			indent.separator(indent.sep);
		}

		if (userShips == 0 && compShips == 0) {
			indent.AlignSlowmo(1, "Its a Tie between Warriors :/\n");
		} else if (userShips == 0) {
			indent.AlignSlowmo(1, "Machine slayed Human [%__%]");
		} else {
			indent.AlignSlowmo(1, "Human defeated Machine (^__^)");
		}

		printOcean(true);
		System.out.println();
		indent.printLegends();
		indent.align(1, "~~~~~~~~The End~~~~~~~\n");
		indent.separator(indent.sep);
	}

	public void Menu() throws InterruptedException {

		indent.align(2, 4, "~~~~~MENU~~~~~");
		indent.align(2, 4, " 1.Start Game\n");
		indent.align(1, 4, " 2.How to Play\n");
		indent.align(1, 4, " 3.Exit Game\n");

		while (true) {
			indent.separator(indent.sep);
			indent.align(1, 4, "Enter your choice: ");
			int choice = scn.nextInt();

			if (choice == 1) {
				indent.AlignSlowmo(1, 2, "Do you want to Manually place your ships(true/false)");
				this.isManual = scn.nextBoolean();
				Start();
				break;
			} else if (choice == 2) {
				indent.PrintInst();
			} else {
				break;
			}

		}

	}

}

public class Game {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		BattleGame game = new BattleGame();
		game.printOcean(false);
		game.Menu();
	}

}

