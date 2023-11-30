import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class array {

    // Static variable to store the input array
    private static int[] numbers;

    // Static method to find and print the top K numbers with the highest occurrences
    public static void findTopKNos(int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();  // Create a map to store the frequency of each number

        // Calculate the frequency of each number in the array (input is iterated)
        for (int num : numbers) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Create an array to store the unique numbers from the input array
        int[] uniqueNumbers = new int[frequencyMap.size()];
        int index = 0;
        for (int num : frequencyMap.keySet()) {
            uniqueNumbers[index++] = num;
        }

        // Sort the unique numbers based on their frequencies and values
        for (int i = 0; i < uniqueNumbers.length - 1; i++) {
            for (int j = i + 1; j < uniqueNumbers.length; j++) {
                int frequency1 = frequencyMap.get(uniqueNumbers[i]);
                int frequency2 = frequencyMap.get(uniqueNumbers[j]);

                if (frequency1 < frequency2 || (frequency1 == frequency2 && uniqueNumbers[i] < uniqueNumbers[j])) {
                    // Swap the numbers if needed
                    int temp = uniqueNumbers[i];
                    uniqueNumbers[i] = uniqueNumbers[j];
                    uniqueNumbers[j] = temp;
                }
            }
        }

        // Print the top K numbers with the highest occurrences
        System.out.println("Top " + k + " numbers with the highest occurrences:");

        for (int i = 0; i < k; i++) {
            int num = uniqueNumbers[i];
            int frequency = frequencyMap.get(num);
            System.out.println(num + " - Occurrences: " + frequency);
        }
    }

    public static void main(String[] args) {
        // Scanner to get input from the user
        Scanner scanner = new Scanner(System.in);

        // Get the size of the array from the user
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        // Get the array elements from the user
        numbers = new int[size];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            numbers[i] = scanner.nextInt();
        }

        // Get the value of K from the user
        System.out.print("Enter the value of K: ");
        int k = scanner.nextInt();

        // Close the scanner
        scanner.close();

        // Call the static method to find and print the top K numbers
        findTopKNos(k);
    }
}
