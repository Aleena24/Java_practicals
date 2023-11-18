public class AlphabetWarGame {

    // Strengths for the left-side letters
    private int strength_w;
    private int strength_p;
    private int strength_b;
    private int strength_s;

    // Strengths for the right-side letters
    private int strength_m;
    private int strength_q;
    private int strength_d;
    private int strength_z;

    // Constructors
    public AlphabetWarGame() {
        // Set default strengths
    }

    public AlphabetWarGame(int strength_w, int strength_p, int strength_b, int strength_s,
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

    // Method to determine the winner when only one word is passed
    public String battle(String word) {
        int leftStrength = calculateStrength(word, "w", "p", "b", "s");
        int rightStrength = calculateStrength(word, "m", "q", "d", "z");

        return determineWinner(leftStrength, rightStrength);
    }

    // Method to determine the winner when separate left and right words are passed
    public String battle(String leftWord, String rightWord) {
        int leftStrength = calculateStrength(leftWord, "w", "p", "b", "s");
        int rightStrength = calculateStrength(rightWord, "m", "q", "d", "z");

        return determineWinner(leftStrength, rightStrength);
    }

    // Helper method to calculate the total strength of a word
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

    // Helper method to get the strength of a letter
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

    // Helper method to determine the winner based on strengths
    private String determineWinner(int leftStrength, int rightStrength) {
        if (leftStrength > rightStrength) {
            return "Left side wins!";
        } else if (leftStrength < rightStrength) {
            return "Right side wins!";
        } else {
            return "Let's fight again!";
        }
    }

    public static void main(String[] args) {
        // Example test cases
        AlphabetWarGame game1 = new AlphabetWarGame();
        System.out.println(game1.battle("z")); // Right side wins!

        AlphabetWarGame game2 = new AlphabetWarGame();
        System.out.println(game2.battle("zdqmwpbs")); // Let's fight again!

        AlphabetWarGame game3 = new AlphabetWarGame();
        System.out.println(game3.battle("wwwwwwz")); // Left side wins!
    }
}