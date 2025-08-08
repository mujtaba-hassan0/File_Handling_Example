import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Write{
    public static void main(String[] args) {


        // Create a Scanner object to read user input
        Scanner sc = new Scanner(System.in);

        // Prompt the user for the file name
        System.out.println("Enter the File name you want to create:");
        // Read the file name from user input
        String fileName = sc.nextLine();

        // Create a File object
        File f = new File(fileName);


        String userInput="";
        //checks if file is already exists then handle accordingly
       if(f.exists()){
        System.out.println("This file is already exixts. You want to Append to it or overwritie it?");
        System.out.println("If you want to append, type 'append'. If you want to overwrite, type 'overwrite'.");
        userInput = sc.nextLine();
       }
       
     

    //    new file if not exits
    if(!f.exists()){
        try(FileWriter writer = new FileWriter(fileName)) {
            // Create a new file and write content to it
            System.out.println("Enter the content you want to write to the file:");
            String content = sc.nextLine();
            writer.write(content);
            System.out.println("Content written to file successfully.");
        }
          catch(FileNotFoundException e){
            System.out.println("File not found: " + e.getMessage());
        }
         catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
       
    }

        
        //appending content to the file
        else if(userInput.equalsIgnoreCase("append")){
        try(FileWriter writer = new FileWriter(fileName, true)){

                System.out.println("Enter the additional content to append to the file (type 'exit' to stop):");
                String addContent = sc.nextLine();

                
                if(addContent.equalsIgnoreCase("exit")){
                System.out.println("Exiting the program as per your request.");
                }
                writer.write(addContent + System.lineSeparator());
                System.out.println("Content appended to file successfully.");
            }
            
            catch(FileNotFoundException e){
                System.out.println("File not found: " + e.getMessage());
            }
            catch (IOException e) {
                System.out.println("An error occurred while appending to the file: " + e.getMessage()); 
            }
        }
    


    else if(userInput.equalsIgnoreCase("overwrite")){
        try(FileWriter writer = new FileWriter(fileName , false)){
            System.out.println("Overwriting your file, if you want to exit or stop for adding content then type exit or stop in the end to execite program");
            System.out.println("Enter the Content: ");
            String addNewContent = sc.nextLine();

            if(addNewContent.contains("exit") || addNewContent.contains("stop")){
               
                System.out.println("Executing the program");
                
            }
            writer.write(addNewContent);
            System.out.println("File overwritten successfully.");
        }   

        
        catch(FileNotFoundException e){
            System.out.println("File not found: " + e.getMessage());
        }
        catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }

    else{   
        System.out.println("Invalid option: Exiting the program.");
    }

    sc.close();
    }
}
