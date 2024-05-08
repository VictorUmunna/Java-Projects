import java.util.ArrayList;
import java.util.Arrays;
    public class DataAnalysisProject {
        public static void main(String[] args) {

            // Create an array to store the data
            double[] data = {126.0, 121.0, 120.0, 121.5, 126.6, 123.0, 124.2, 124.0, 125.0, 126.1};
            
            // Create an ArrayList to store the data
            ArrayList<Double> dataList = new ArrayList<>(Arrays.asList(126.0, 121.0, 120.0, 121.5, 126.6, 123.0, 124.2, 124.0, 125.0, 126.1));
            
            
            // Calculate the average stock price using a method
            double average = calculateAveragePrice(data);
        
            System.out.println("Average price: " + average);
        }
        
        // Method to calculate the average stock price
        public static double calculateAveragePrice(double[] data) {
            double sum = 0.0;
            for (int i = 0; i < data.length; i++) {
            sum += data[i];
            }
            return sum / data.length;
      }
}
    