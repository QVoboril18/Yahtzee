import java.util.Scanner;

public class YahtzeeGame
{
    private Scanner s = new Scanner(System.in);
	private static final int numSides = 6;
	private YahtzeeDie die1 = new YahtzeeDie(6);
	private YahtzeeDie die2 = new YahtzeeDie(6);
	private YahtzeeDie die3 = new YahtzeeDie(6);
	private YahtzeeDie die4 = new YahtzeeDie(6);
	private YahtzeeDie die5 = new YahtzeeDie(6);
	private YahtzeeScorecard scoreC = new YahtzeeScorecard();
	/* instance data should include the five yahtzee dice, a scoreboard, and a CONSTANT (static final) variable NUM_SIDES
	which should be set to six (the number of sides on a yahtzee die) */


	/* initializes the dice and scoreboard */
	public YahtzeeGame() {
    }

	/* check to see if the game is over, and while the game is not over call the method takeTurn()
	once the game ends (hint: there are 13 turns in a game of Yahtzee), the method should print a
	final scorecard and return the grand total */
	public int playGame()
	{
		for(int t = 0; t < 13; t++){
			takeTurn();
	}
		return this.scoreC.getGrandTotal();
	}

	/* 	1. call rollDice()
		2. call printDice()
		3. Ask the user if they are satisfied with their roll, or if they would like to roll again.
		   If they are not satisfied continue, otherwise call markScore()
		4. call chooseFrozen()
		5. call rollDice()
		6. call printDice()
		7. Ask the user if they are satisfied with their roll, or if they would like to roll again.
		   If they are not satisfied continue, otherwise call markScore()
		8. call chooseFrozen()
		9. call rollDice()
		10. call printDice()
		11. call markScore()
	*/
	private void takeTurn()
	{
		this.rollDice();
        System.out.println("first roll:");
        this.printDice();
        System.out.println("Is this ok: Y or N");
        String YoN = s.nextLine();
        if(YoN.equals("N")){
            this.chooseFrozen();
            this.rollDice();
            System.out.println("second roll:");
            this.printDice();
            System.out.println("Is this ok: Y or N");
            if(YoN.equals("N")) {
                this.chooseFrozen();
                this.rollDice();
                System.out.println("second roll:");
                this.printDice();
            }

        }



	}

	/* Rolls all unfrozen dice.  Also resets all dice to the unfrozen state after the roll */
	private void rollDice()
	{
		if(!die1.isFrozen()){
            die1.rollDie();
        }else{
            die1.unfreezeDie();
        }
        if(!die2.isFrozen()){
            die2.rollDie();
        }else{
            die2.unfreezeDie();
        }
        if(!die3.isFrozen()){
            die3.rollDie();
        }else{
            die3.unfreezeDie();
        }
        if(!die4.isFrozen()) {
            die4.rollDie();
        }else{
            die4.unfreezeDie();
        }
        if(!die5.isFrozen()){
            die5.rollDie();
        }else{
            die5.unfreezeDie();
        }
	}

	/* Asks the user which dice should be frozen 1-5 (should be read in in one line) */
	private void chooseFrozen()
	{
		System.out.print("Choose a die to freeze: ");
        String ch = s.nextLine();
        if(ch.contains("1") ) die1.freezeDie();
        if(ch.contains("2") ) die2.freezeDie();
        if(ch.contains("3") ) die3.freezeDie();
        if(ch.contains("4") ) die4.freezeDie();
        if(ch.contains("5") ) die5.freezeDie();
	}

	/* Should print the value of all five dice separated by a tab (\t) to the console */
	private void printDice()
	{
        System.out.println(die1.getValue()+"\t" +die2.getValue()+"\t" +die3.getValue()+"\t"+ die4.getValue()+"\t" +die5.getValue());
	}

	/* 1. Print a scoreboard
	   2. Ask the user where they would like to mark their score.
	   3. Call appropriate function
	   4. If false is returned the user entered an invalid number, so ask the user to try again	*/
	private void markScore()
	{
        boolean Success = false;
        int varIn;
        while(!Success){

        this.scoreC.printScoreCard();

        do{
            System.out.println("Choose a location for your score");
            System.out.println("1.Ones 2. Twos \n 3. Threes 4. Fours \n 5. fives \n 6. sixes \n 7. 3 of a type  8. 4 of a type \n 9. Full house 10. Sm Straight \n 11. Large straight 12. Yahtzee \n 13. chance ");
            System.out.println("1-13");
            varIn = s.nextInt();
        }while(varIn > 13 || varIn < 0);

        switch (varIn) {
            case 1:
               Success = this.scoreC.markOnes(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue());
                break;
            case 2:
                Success = this.scoreC.markTwos(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue());
                break;
            case 3:
                Success = this.scoreC.markThrees(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue());
                break;
            case 4:
                Success = this.scoreC.markFours(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue());
                break;
            case 5:
                Success = this.scoreC.markFives(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue());
                break;
            case 6:
                Success = this.scoreC.markSixes(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue());
                break;
            case 7:
                Success = this.scoreC.markThreeOfAKind(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue());
                break;
            case 8:
                Success = this.scoreC.markFourOfAKind(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue());
                break;
            case 9:
                Success = this.scoreC.markFullHouse(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue()); // LIKE THE SHOW //
                break;
            case 10:
                Success = this.scoreC.markSmallStraight(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue());
                break;
            case 11:
                Success = this.scoreC.markLargeStraight(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue());
                break;
            case 12:
                Success = this.scoreC.markYahtzee(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue());
                break;
            case 13:
                Success = this.scoreC.markChance(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue());
                break;
        }
        }

	}
}