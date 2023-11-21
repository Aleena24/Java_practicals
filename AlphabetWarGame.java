import java.util.Scanner;

public class AlphabetWarGame {

    //class declared with private instance variables
    // Default strengths for the left-side letters
    private int strength_w = 4;
    private int strength_p = 3;
    private int strength_b = 2;
    private int strength_s = 1;

    // Default strengths for the right-side letters
    private int strength_m = 4;
    private int strength_q = 3;
    private int strength_d = 2;
    private int strength_z = 1;



    // Constructors
    public AlphabetWarGame() {
        // Default constructor with default strengths
    }

    // Parameterized constructor to customize strengths
    public AlphabetWarGame(int strength_w, int strength_p, int strength_b, int strength_s,
                           int strength_m, int strength_q, int strength_d, int strength_z) {
        setCustomStrengths(strength_w, strength_p, strength_b, strength_s,
                strength_m, strength_q, strength_d, strength_z);
    }


    // Method to set custom strengths
    public void setCustomStrengths(int strength_w, int strength_p, int strength_b, int strength_s,
                                   int strength_m, int strength_q, int strength_d, int strength_z) {
        this.strength_w = strength_w;
        this.strength_p = strength_p;
        this.strength_b = strength_b;   
        this.strength_s = strength_s;               
        this.strength_m = strength_m;
        this.strength_q = strength_q;
        this.strength_d = strength_d;
        this.strength_z = strength_z;
    }
    //this keyword is used to differentiate between method or constructor which has a parameter with same name as object variable.


    // Method for one-word battle
    //calculateStrength : takes word as input and calculate total strength for both
    //determineWinner : words and returns a string stating which side has won or tied
    public String battle(String word) {
        int leftStrength = calculateStrength(word, "w", "p", "b", "s");
        int rightStrength = calculateStrength(word, "m", "q", "d", "z");

        return determineWinner(leftStrength, rightStrength);
    }


    // calculateStrength method to calculates the total strength of a word
    private int calculateStrength(String word, String... letters) {
        int totalStrength = 0;

        for (char c : word.toCharArray()) {
            for (String letter : letters) {
                if (String.valueOf(c).equalsIgnoreCase(letter)) {
                    totalStrength += getStrength(letter);
                    break;
                }
            }
        }

        return totalStrength;
    }


    // getStrength method  gets the strength of a letter
    private int getStrength(String letter) {
        switch (letter.toLowerCase()) {
            case "w":
                return strength_w;
            case "p":
                return strength_p;
            case "b":
                return strength_b;
            case "s":
                return strength_s;
            case "m":
                return strength_m;
            case "q":
                return strength_q;
            case "d":
                return strength_d;
            case "z":
                return strength_z;
            default:
                return 0;
        }
    }

    // determineWinner method to determine the winner based on strengths
    private String determineWinner(int leftStrength, int rightStrength) {
        if (leftStrength > rightStrength) {
            return "Left side wins!";
        } else if (leftStrength < rightStrength) {
            return "Right side wins!";
        } else {
            return "Let's fight again!";
        }
    }


    //main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter strength for 'w': ");
        int strength_w = scanner.nextInt();

        System.out.println("Enter strength for 'p': ");
        int strength_p = scanner.nextInt();

        System.out.println("Enter strength for 'b': ");
        int strength_b = scanner.nextInt();

        System.out.println("Enter strength for 's': ");
        int strength_s = scanner.nextInt();

        System.out.println("Enter strength for 'm': ");
        int strength_m = scanner.nextInt();

        System.out.println("Enter strength for 'q': ");
        int strength_q = scanner.nextInt();

        System.out.println("Enter strength for 'd': ");
        int strength_d = scanner.nextInt();

        System.out.println("Enter strength for 'z': ");
        int strength_z = scanner.nextInt();

        
        // Example test case with custom strengths
        AlphabetWarGame customGame = new AlphabetWarGame(strength_w, strength_p, strength_b, strength_s,
                strength_m, strength_q, strength_d, strength_z);

        System.out.println("Who will win....?: ");
        String word = scanner.next();

        System.out.println(customGame.battle(word));

        scanner.close();
    }
}
