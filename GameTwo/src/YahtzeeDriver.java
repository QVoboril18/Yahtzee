import java.util.Scanner;

public class YahtzeeDriver
{
	/*
	1. Creates a new instance of the YahtzeeGame class
	2. Calls the playGame method on the Yahtzee object
	3. Asks user if they would like to play again
	4. When the user is done playing, prints the number of games played, min, max, and average score
	*/
	public static void main(String [] args)
	{
            Scanner s = new Scanner(System.in);
			int score = 0;
			int t = 0;

        YahtzeeScorecard Sc = new YahtzeeScorecard();
        YahtzeeGame myGame = new YahtzeeGame();
        System.out.println("Enter Your name: ");
        String name = s.nextLine();
        System.out.println("Welcome to" + name + " s APCSA Yahtzee Game!");
        String trig;
        int tp = 0;
        int score2 = 0;
        int g = 0;
        int l = 0;
        int avg = 0;
        while(t != 1) {
            score = myGame.playGame();


            System.out.println("Play again? Enter Y or N");
            trig = s.nextLine();
            tp ++;
            if (trig.equals("N")) t++;
            for(int h = 0; h < tp; h ++){
                if(score > score2){
                    g = score;

                }
                if(score < score2){
                    l = score;
                }

                avg += score + score2;

            }
            score2 = score;
        }

        System.out.println(g);
        System.out.println(l);
        System.out.println(avg / tp);
    }
}
