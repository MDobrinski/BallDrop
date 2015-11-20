import java.util.Scanner;

public class BallDrop {

	public static void main(String[] args) {
		char direction = ' ';
		int numOfBalls = 0, numSlots = 0, numLRdecisions = 0, slotNumber = 0;
		Scanner input = new Scanner(System.in);

		System.out.print("\nEnter the number of slots in the game machine: ");
		numSlots = input.nextInt();
		System.out.print("\nEnter the number of balls to drop: ");
		numOfBalls = input.nextInt();
		int []  slots = new int[numSlots];
		numLRdecisions = numSlots-1;

		for (int i = 1; i<=numOfBalls; i++){
			slotNumber = 0;
			System.out.println();
			for (int j = 1; j<=numLRdecisions; j++){
				if (getDecision() =='R'){
					slotNumber++;
					System.out.print("R");
				}
				else{
					System.out.print("L");
				}
				slots[slotNumber]++;
			}

		}


	} // End of Main method

	public static char getDecision(){
		if (MyRandoms.randomNumber(1,2) == 1){
			return 'L';
		}
		else {
			return 'R';
		}
	}



} // End of BallDrop class
