import java.util.Scanner;

public class BallDrop {

	public static void main(String[] args) {

		int numOfBalls, numSlots, numLRdecisions, slotNumber;
		Scanner input = new Scanner(System.in);

		System.out.print("\nEnter the number of slots in the game machine: ");
		numSlots = input.nextInt();
		System.out.print("\nEnter the number of balls to drop: ");
		numOfBalls = input.nextInt();
		int []  slots = new int[numSlots]; // Create array 1 element per slot
                                           // this will hold the number of balls
                                           // that drop into the slot.
		numLRdecisions = numSlots-1; // Calculate the number of LR decisions
                                     // that need to be made for each ball
                

		for (int i = 1; i<=numOfBalls; i++){   // For each ball
			slotNumber = 0; // Reset the slot number to drop a new ball.
			System.out.println();
			for (int j = 1; j<=numLRdecisions; j++){ // For each time the ball
                                                  // hits a peg and goes L or R
				if (getDecision() =='R'){
					slotNumber++; // Count the number of Right turns. This gives
                                  // the slot number that the ball lands in.
					System.out.print("R"); // Ball turned Right
				}                          // Display the direction the ball 
				else{                      // goes each time it hits a peg.
					System.out.print("L"); // Ball turned Left
				}
				
			}
            slots[slotNumber]++;  // Add one to the total of the slot the ball
		} // Drop the next ball   // lands in.
        
        // This section prints out the number of balls that fell into each slot
        System.out.println();
        for (int k=0; k<slots.length;k++){
            System.out.printf(" %3d ", slots[k]);
        }
        System.out.println();
                
        // This calls a method to display each slot with a O for each ball.
        printSlots(slots);
		input.close();
	} // End of Main method

	public static char getDecision(){
		if (MyRandoms.randomNumber(1,2) >1){
			return 'L';
		}
		else {
			return 'R';
		}
	}

	public static void printSlots(int [] slots){
        //    System.out.println(findMax(slots));
            System.out.println();
            
            int count = findMax(slots); // Find the max number of balls in any
                                        // slot. This is the number of lines
            for (int m=count; m>0; m--){ // For each row in the stack of balls 
                for (int h=0; h<slots.length;h++){ // For each slot
                    if (slots[h]>=m){
                        System.out.print("| O |"); // Ball in the slot at this
                    }                              // level
                    else{
                        System.out.print("|   |"); // Empty at this level
                    }
                }
                System.out.println();
            }
            for (int i = 0; i<(slots.length)*5;i++){
            System.out.print("-");
            }
            System.out.println();
	}
        // Find the maximum number of balls in any slot.
        public static int findMax(int [] slots){
            int max = 0;
            for (int i=0; i<slots.length; i++){
                max = (slots[i]>max)?slots[i]:max;
            }
            return max;
        }


} // End of BallDrop class
