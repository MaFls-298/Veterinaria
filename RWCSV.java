import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RWCSV{
    public static void main(String[] args) {
        String filePath = "data.csv"; // Replace with your CSV file path
        String line;
        String delimiter = ","; 

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(delimiter);
                // Process each field (e.g., print them)
                for (String field : fields) {
                    System.out.print(field + " ");
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}