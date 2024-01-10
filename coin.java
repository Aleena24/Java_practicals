import java.util.Scanner;
import java.util.concurrent.*;

//constructor
class CoinCombinationCalculator implements Callable<Integer> {
    private final int[] coins;
    private final int sum;
    private final int currentIndex;

    //parametrised construtor
    public CoinCombinationCalculator(int[] coins, int sum, int currentIndex) {
        this.coins = coins;
        this.sum = sum;
        this.currentIndex = currentIndex;
    }

    @Override
    public Integer call() {
        if (sum == 0) {
            return 1;  
        }

        if (sum < 0 || currentIndex >= coins.length) {
            return 0;
        }

        // calculation with current coin
        int include = callWithNewThread(coins, sum - coins[currentIndex], currentIndex);

        // calculation with current coin 
        int exclude = callWithNewThread(coins, sum, currentIndex + 1);

        //sum of both include and exclude calculations
        return include + exclude;
    }

    private int callWithNewThread(int[] coins, int sum, int currentIndex) {
        //new object of coin combination calc is created
        CoinCombinationCalculator calculator = new CoinCombinationCalculator(coins, sum, currentIndex);

        //thread is created 
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        //call() method is executed in a thread
        Future<Integer> future = executorService.submit(calculator);

        try {
            //get result of calculation
            return future.get();  
        } 
        
        //handle exceptions
        catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return 0;
        } finally {
            executorService.shutdown();
        }
    }
}


//A single-threaded executor in Java is an instance of the ExecutorService interface 
//that manages a single thread for executing tasks. 
//It is created using the Executors.newSingleThreadExecutor() method, 
//which returns an instance of SingleThreadExecutor.

public class coin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of coins: ");
        int n = scanner.nextInt();

        int[] coins = new int[n];
        System.out.println("Enter the denominations of coins:");
        for (int i = 0; i < n; i++) {
            coins[i] = scanner.nextInt();
        }

        System.out.print("Enter the target sum: ");
        int sum = scanner.nextInt();

        int ways = calculateWaysConcurrently(coins, sum);
        System.out.println("Ways to make sum " + sum + ": " + ways);
    }

    private static int calculateWaysConcurrently(int[] coins, int sum) {
        CoinCombinationCalculator calculator = new CoinCombinationCalculator(coins, sum, 0);
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> future = executorService.submit(calculator);

        try {
            return future.get();  // Get the final result from the new thread
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return 0;
        } finally {
            executorService.shutdown();
        }
    }
}
