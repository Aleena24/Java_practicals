public abstract class Robber {
    abstract int RowHouses(int[] moneyInRowHouses);
    abstract int RoundHouses(int[] moneyInRoundHouses);
    abstract int SquareHouses(int[] moneyInSquareHouses);
    abstract int MultiHouseBuilding(int[] moneyInMultiTypeBuilding);

    void RobbingClass(){
        System.out.println("Msc AIML");
        }

    void MachineLearning(){
        System.out.println("I love Machine Learning");
    }
}

    class JavaProfessionalRobber extends Robber {

        
        int RowHouses(int[] moneyInRowHouses){
            return 0;
        }

        @Override
        int RoundHouses(int[] moneyInRoundHouses){
            return 0;
        }

        @Override
        int SquareHouses(int[] moneyInSquareHouses){
            return 0;
        }

        @Override
        int MultiHouseBuilding(int[] moneyInMultiTypeBuilding){
            return 0;
        }
}

public class Main {
    public static void main(String[] args) {
        JavaProfessionalRobber javaRobber = new JavaProfessionalRobber();
        javaRobber.RobbingClass();
        javaRobber.MachineLearning();

        int[] moneyInRowHouses = {10, 20, 30, 45};
        int maxRobbedRowHouses = javaRobber.RowHouses(moneyInRowHouses);
        System.out.println("Maximum amount of money robbed from Row Houses: " + maxRobbedRowHouses);

        int[] moneyInRoundHouses = {10, 24, 73, 93};
        int maxRobbedRoundHouses = javaRobber.RoundHouses(moneyInRoundHouses);
        System.out.println("Maximum amount of money robbed from Round Houses: " + maxRobbedRoundHouses);

        int[] moneyInSquareHouses = {10, 36, 96, 67};
        int maxRobbedSquareHouses = javaRobber.SquareHouses(moneyInSquareHouses);
        System.out.println("Maximum amount of money robbed from Square Houses: " + maxRobbedSquareHouses);

        int[] moneyInMultiTypeBuilding = {10, 25, 30, 95};
        int maxRobbedMultiHouses = javaRobber.MultiHouseBuilding(moneyInMultiTypeBuilding);
        System.out.println("Maximum amount of money robbed from Multi-type Building: " + maxRobbedMultiHouses);
    }
}
