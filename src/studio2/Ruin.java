package studio2;

public class Ruin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int initialAmount = 2, startAmount = initialAmount, winLimit = 10, round = 1, totalSimulations = 500, totalRuin = 0;
		double winChance = 0.7;
		
		for (int i = 1; i < totalSimulations; i++) {
			while (0 < startAmount && startAmount < winLimit) {
				//System.out.println("round " + round + ":");
				round++;
				//winChance = Math.random();
				double rand = Math.random();
				if (rand < winChance) {
					startAmount = startAmount + 1;
					//System.out.println("win!");
				}
				else {
					startAmount = startAmount - 1;
					//System.out.println("loss!");
				}
			}
			
			if (startAmount == 0) {
				System.out.println("RUIN");
				totalRuin++;
			}
			else {
				System.out.println("SUCCESS");
			}
			startAmount = initialAmount;
			System.out.println("plays " + round);
			System.out.println("day " + i);
			round = 1;
		}
		double expectedRuin;
		double alpha = (1 - winChance)/winChance;
		if (winChance == 0.5) {
			expectedRuin = 1 - ((double)startAmount/winLimit);
		}
		else {
			expectedRuin = (Math.pow(alpha, startAmount) - Math.pow(alpha, winLimit)) / (1 - Math.pow(alpha, winLimit));
		}
		System.out.println("Expected Ruin " + expectedRuin);
		
		double ruinRate = (double)totalRuin/totalSimulations;
		System.out.println("Ruin Rate " + ruinRate);
	}

}
