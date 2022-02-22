import java.util.Arrays;
import java.util.Scanner;

public class Hangman {
	
    public static String[] words = {"ant", "baboon", "badger", "bat", "bear", "beaver", "camel",
    "cat", "clam", "cobra", "cougar", "coyote", "crow", "deer",
    "dog", "donkey", "duck", "eagle", "ferret", "fox", "frog", "goat",
    "goose", "hawk", "lion", "lizard", "llama", "mole", "monkey", "moose",
    "mouse", "mule", "newt", "otter", "owl", "panda", "parrot", "pigeon", 
    "python", "rabbit", "ram", "rat", "raven","rhino", "salmon", "seal",
    "shark", "sheep", "skunk", "sloth", "snake", "spider", "stork", "swan",
    "tiger", "toad", "trout", "turkey", "turtle", "weasel", "whale", "wolf",
    "wombat", "zebra"};

    public static String[] gallows = {"+---+\n" +
    	    "|   |\n" +
    	    "    |\n" +
    	    "    |\n" +
    	    "    |\n" +
    	    "    |\n" +
    	    "=========\n",

    	    "+---+\n" +
    	    "|   |\n" +
    	    "O   |\n" +
    	    "    |\n" +
    	    "    |\n" +
    	    "    |\n" +
    	    "=========\n",

    	    "+---+\n" +
    	    "|   |\n" +
    	    "O   |\n" +
    	    "|   |\n" +
    	    "    |\n" +
    	    "    |\n" +
    	    "=========\n",

    	    " +---+\n" +
    	    " |   |\n" +
    	    " O   |\n" +
    	    "/|   |\n" +
    	    "     |\n" +
    	    "     |\n" +
    	    " =========\n",

    	    " +---+\n" +
    	    " |   |\n" +
    	    " O   |\n" +
    	    "/|\\  |\n" + //if you were wondering, the only way to print '\' is with a trailing escape character, which also happens to be '\'
    	    "     |\n" +
    	    "     |\n" +
    	    " =========\n",

    	    " +---+\n" +
    	    " |   |\n" +
    	    " O   |\n" +
    	    "/|\\  |\n" +
    	    "/    |\n" +
    	    "     |\n" +
    	    " =========\n",

    	    " +---+\n" +
    	    " |   |\n" +
    	    " O   |\n" +
    	    "/|\\  |\n" + 
    	    "/ \\  |\n" +
    	    "     |\n" +
    	    " =========\n"};
   
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.println("\t---This is a Mehmet Ali Mergen Product---\n\t           Have some fun\n");
    	String keyWord= randomWord();
    	char[] placeHolder = new char[keyWord.length()];
    	
    	char[] misses = new char[6];
        
    	int miss = 0 ;
        int count=0;
        
    	for(int i=0; i<placeHolder.length; i++) {
    		placeHolder[i]='_';
    	}
    	
        
        while(miss<6) {
        	System.out.println( gallows[miss]);
        	
        	System.out.print("\nWord: ");
        	printPlaceholders(placeHolder);
        
        	
        	System.out.print("\n\nMisses: " );
        	printMissedGuess(misses);
        
        	
        	System.out.print("\n\nGuess: ");
        	char guess= console.next().charAt(0);
            System.out.println("\n");
        	  
        	  for(int i=0; i<keyWord.length(); i++) {
        		  if(guess==keyWord.charAt(i)) {
        			  count++;
        		  } 
        	  } 
        	  
        	  
        	  if(count>0) {
        		   uptadePlaceholders(keyWord, placeHolder, guess);
        	  } else if(count==0){
        		  misses[miss]=guess;
        		  miss++;
        	  }
        	    count=0;
        	    
             if(Arrays.equals(placeHolder, keyWord.toCharArray())) {
            	 System.out.println(gallows[miss]);
                 System.out.println("\nWord: ");
                 printPlaceholders(placeHolder);
                 System.out.println("\n\n\tGood Work !!");
                 System.exit(0);
            	 
             }
              
        	    
        } //while
        	    
        
        if(miss>=6) {
        	System.out.println(gallows[miss]);
        	System.out.println("\n\tR.I.P !!");
        	System.out.println( "\nThe word was: "+ keyWord);
        } 
  
        console.close();
        } //main
   
   public static String randomWord() {
    	int numWords= words.length;
    	double randomDouble = Math.random();
    	int randomIndex= (int) (randomDouble* numWords);
    	return words[randomIndex];
    	
    }

   public static void printPlaceholders(char[] placeHolder) {
    	for(int i=0; i<placeHolder.length; i++) {
    	 System.out.print(" " + placeHolder[i]);
    	}
    }
        
   public static boolean checkGuess(String word, char guess ) {
	   for(int i=0; i<word.length(); i++) {
		   if(word.charAt(i) == guess) {
			   return true;
		   }
	   }
	   return false;
}

   public static void uptadePlaceholders( String word, char[] placeHolder, char guess ) {
		   for(int i=0; i<word.length(); i++) {
			   if(word.charAt(i)==guess) {
				   placeHolder[i]= guess;
			   }
		   
		   }
  }
 
   public static void printMissedGuess(char[] misses) {
    	for(int i=0; i<misses.length; i++) {
    		System.out.print(misses[i]);
    	}
    }

}


