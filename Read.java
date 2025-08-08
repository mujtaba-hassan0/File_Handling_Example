import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


public class Read{
    public static void main(String[] args) {
        // This class is intended to read from a file
        // Implementation will be added later
        System.out.println("This is the Read class. Implementation will be added later.");
       

        System.out.println("Please enter the file name you want to read: ");
        String filePath = new Scanner(System.in).nextLine();


        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int wordCount = 0;
            int charCount = 0;
            while((line = reader.readLine()) != null){

            String trimmedLine = line.trim();

    if (!trimmedLine.isEmpty()) {
        String[] words = trimmedLine.split("\\s+"); // Split by 1 or more spaces
        wordCount += words.length;
    }
    
    // Count characters excluding spaces
    for (char c : line.toCharArray()) {
        if (c != ' ' && c != '\r' && c != '\n') {
            charCount++;
        }
    }
                System.out.println(line);
               
            }  
            
            System.out.println("Total words: " + wordCount);
            System.out.println("Total characters: " + charCount);


        } 
        catch(FileNotFoundException e){
            System.out.println("File not found: " + e.getMessage());
        }
        catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        } finally {
            // Any necessary cleanup can be done here
        }{
            System.out.println("File reading completed.");
        }

       
    }
}