import java.util.*;

public class BattleShip {
	Scanner scn = new Scanner(System.in);
	final int size;
	char[][] ocean;
	boolean isManual;
	Random rand;
	final int ships;

	// Default Constructor to initialize size of ocean and ships
	public BattleShip() throws InterruptedException {
		this(10, 20);
	}

	public BattleShip(int size, int ships) throws InterruptedException {
		this.size = size;
		this.ships = ships;
		ocean = new char[this.size][this.size];
		fill(ocean, '_');
		separator(100);
		align(4, 0, 0, "Status: Loading");
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
			Arrays.fill(row, val);
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

	/*
	 * getXY: Method, params: isUSer, isManual isUSer && isManual: scn.nextInt()
	 * otherwise: rand.nextInt(10) return: arr[2] = {X, Y}
	 */

	public void getXY(boolean isUser, boolean isManual) {

		// check the above condition and return arr[2] (X, Y)
	}

	/*
	 * 1. Deploy Ships: This method will deploy ships for User and Computer. params:
	 * isUser, Loc(Set)
	 */

	public void deploy(boolean isUser, Set<String> loc) {

		// 1. Print the message (User or Computer)

		// 2. Place 20 ships using loop
		// 2.1 calculate x and y: getXY(isUSer, false)
		// 2.2 check for duplicate location
		// 2.2.1 Print Message and continue
		// 2.3 Corresponding Message
		// 22.4 update the Ocean Matrix (1 for User) & (2 for Computer)
		// 22.5 i++

		// 3. Print Ocean

	}

	/*
	 * KillShips: Method, params: isUser, Set(String) Loc print Messg (User: Choose
	 * X and Y) otherwise Predict X and Y isUSer: takeInput X and Y: getXY(isUSer,
	 * true) , Computer: Random: getXY(isUser, false) Kill at that position Return
	 * the correspoinding Digit
	 */

	public void killShips(boolean isUSer, Set<String> loc) {

		// 1. Print messg

		// 2. X, Y = getXY(isUSer, true)

		// 3. Duplicate_loc
		// 3.1 Loop till X and y are duplicates
		// 3.1.1 Print messg (Cannot place. try again!!!)
		// 3.1.2 X, Y = getXY(isUSer, true)

		// 4. Loc.add(X,Y)

		// 5. ocean[X][Y] == ?
		// 5.1 if value = 1
		// 5.1.1 isUser: OwnShip, Computer: Boom!
		// 5.1.2 ocean[X][Y] = x
		// return 1

		// 5.2 if value = 2
		// 5.2.1 isUSer: Boom!, Computer: Idiot
		// 5.2.2 ocean[X][Y] = #
		// 5.2.3 return 2

		// 5.3 otherwise
		// 5.3.1 Print (isUser: User Missed, Computer: Computer missed)
		// 5.3.2 return 0

	}

	/*
	 * 2. Start: Method , params - None It will Deploy ships for User & Computer.
	 * This will keep track of the killed and left ships. At the end it will declare
	 * the Winner Print the Ocean Print the Legends
	 */

	public void Start() {

		// 1. Deploy user ships

		// 2. Deploy Computer ships

		// 3. Declare UserLeftShips and CompLeftShips and Set(String) loc and isUSer =
		// true

		// 4. Iterate till Game ends(UserLeftShips > 0 && CompLeftShips >0)

		// 4.1 Loop: Which will run 2 times
		// 4.1.1 KillShips: isUser, Set(String) loc
		// 4.1.2 KillShips(Return type: int(1: User, 2:comp))
		// 4.1.2.1 return == 1 (UserLeftShips--)
		// 4.1.2.2 return == 2 (CompLeftShips--)
		// 4.1.3 isUser = !isUser

		// 4.2 Print Status: UserLeftShips Count and CompLeftShips Count
		// 4.3 Print Ocean

		// 5. Decide Winner 
		// 5.1 UserLeftShips <= 0: Computer won
		// 5.2 CompLeftShips <= 0: User won

		// 6. Print Ocean
		// 7. Print Legend

	}

}
