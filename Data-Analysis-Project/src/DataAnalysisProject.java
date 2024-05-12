import java.util.ArrayList;

public class DataAnalysisProject {

    public static void main(String[] args) {

        // Create an array to store the data
        float[] stockPriceArray = {126.0f, 121.0f, 120.0f, 121.0f, 126.6f, 123.0f, 121.0f, 124.0f, 125.0f, 126.1f};

        // Create an ArrayList to store the data
        ArrayList<Float> stockPriceArrayList = new ArrayList<>();
        for (float price : stockPriceArray) {
            stockPriceArrayList.add(price);
        }

        // Calculate the average stock price using a method
        float average = calculateAveragePrice(stockPriceArray);
        System.out.println("Average price of array: " + average);

        // Calculate the maximum stock price using a method
        float max = findMaximumPrice(stockPriceArray);
        System.out.println("Maximum price: " + max);

        // Count the number of occurrences of a specific price
        float target = 121.0f;
        int count = countOccurrences(stockPriceArray, target);
        System.out.println("Number of occurrences of " + target + ": " + count);

        // Compute the cumulative sum of stock prices using an ArrayList
        ArrayList<Float> cumulativeSumList = computeCumulativeSum(stockPriceArrayList);
        System.out.print("Cumulative sum of stock prices: ");
        for (Float sum : cumulativeSumList) {
            System.out.print(sum + " ");
        }
        System.out.println();

    }

    // Method to calculate the average stock price
    public static float calculateAveragePrice(float[] stockPriceArray) {
        float sum = 0.0f;
        for (int i = 0; i < stockPriceArray.length; i++) {
            sum += stockPriceArray[i];
        }
        return sum / stockPriceArray.length;
    }

    // Method to find the maximum stock price
    public static float findMaximumPrice(float[] stockPriceArray) {
        float max = stockPriceArray[0];
        for (int i = 1; i < stockPriceArray.length; i++) {
            if (stockPriceArray[i] > max) {
                max = stockPriceArray[i];
            }
        }
        return max;
    }

    // Method to count the number of occurrences of a specific price
    public static int countOccurrences(float[] stockPriceArray , float target) {
        int count = 0;
        for (int i = 0; i < stockPriceArray.length; i++) {
            if (stockPriceArray[i] == target) {
                count++;
            }
        }
        return count;
    }

    // Method to compute the cumulative sum of stock prices
    public static ArrayList<Float> computeCumulativeSum(ArrayList<Float> stockPriceArrayList) {
        ArrayList<Float> cumulativeSum = new ArrayList<>();
        float sum = 0.0f;
        for (int i = 0; i < stockPriceArrayList.size(); i++) {
          sum += stockPriceArrayList.get(i);
          cumulativeSum.add(sum);
        }
        return cumulativeSum;
      }
      
      
          
}
