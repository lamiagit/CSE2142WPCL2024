//File Name EmployeeManager.java
import java.io.*;
import java.util.*;

public class EmployeeManager {

    // Method to read all employees from file //change made 4
    private static String[] readEmployees() throws IOException { //change made 4
        BufferedReader reader = new BufferedReader( //change made 4
                new InputStreamReader(
                        new FileInputStream("employees.txt"))); //change made 4
        String line = reader.readLine(); //change made 4
        reader.close(); //change made 4
        return line.split(","); //change made 4
    } //change made 4

    // Method to write employees array to file //change made 4
    private static void writeEmployees(String[] employees) throws IOException { //change made 4
        BufferedWriter writer = new BufferedWriter( //change made 4
                new FileWriter("employees.txt")); //change made 4
        writer.write(String.join(",", employees)); //change made 4
        writer.close(); //change made 4
    } //change made 4

    // Method to append a new employee to file //change made 4
    private static void appendEmployee(String employee) throws IOException { //change made 4
        BufferedWriter writer = new BufferedWriter( //change made 4
                new FileWriter("employees.txt", true)); //change made 4
        writer.write(", " + employee); //change made 4
        writer.close(); //change made 4
    } //change made 4

    public static void main(String[] args) {
        if (args.length != 1) {  
            System.out.println("Error: Please provide exactly one argument.");  
            return;  
        }  

        // Check arguments
        if (args[0].equals("l")) {
            System.out.println("Loading data ...");
            try {
                String[] employees = readEmployees(); //change made 4
                for (String employee : employees) {
                    System.out.println(employee);
                }
            } catch (Exception ex) {}
            System.out.println("Data Loaded.");
        } else if (args[0].equals("s")) {
            System.out.println("Loading data ...");
            try {
                String[] employees = readEmployees(); //change made 4
                System.out.println(String.join(",", employees));
                Random random = new Random();  
                int randomIndex = random.nextInt(employees.length);  
                System.out.println(employees[randomIndex]);  
            } catch (Exception ex) {}
            System.out.println("Data Loaded.");
        } else if (args[0].contains("+")) {
            System.out.println("Loading data ...");
            try {
                String newEmployee = args[0].substring(1);  
                appendEmployee(newEmployee); //change made 4
            } catch (Exception ex) {}
            System.out.println("Data Loaded.");
        } else if (args[0].contains("?")) {
            System.out.println("Loading data ...");
            try {
                String[] employees = readEmployees(); //change made 4
                boolean found = false;
                String searchName = args[0].substring(1);  
                for (int i = 0; i < employees.length && !found; i++) {  
                    if (employees[i].equals(searchName)) {  
                        System.out.println("Employee found!");
                        found = true;
                    }
                }
            } catch (Exception ex) {}
            System.out.println("Data Loaded.");
        } else if (args[0].contains("c")) {
            System.out.println("Loading data ...");
            try {
                String[] employees = readEmployees(); //change made 4
                char[] characters = String.join(",", employees).toCharArray(); //change made 4
                boolean inWord = false;
                int wordCount = 0;  
                for (char character : characters) {  
                    if (character == ' ') {  
                        if (!inWord) {
                            wordCount++;  
                            inWord = true;
                        } else {
                            inWord = false;
                        }
                    }
                }
                System.out.println(wordCount + " word(s) found " + characters.length);  
            } catch (Exception ex) {}
            System.out.println("Data Loaded.");
        } else if (args[0].contains("u")) {
            System.out.println("Loading data ...");
            try {
                String[] employees = readEmployees(); //change made 4
                String updateName = args[0].substring(1);  
                for (int i = 0; i < employees.length; i++) {  
                    if (employees[i].equals(updateName)) {  
                        employees[i] = "Updated";  
                    }
                }
                writeEmployees(employees); //change made 4
            } catch (Exception ex) {}
            System.out.println("Data Updated.");
        } else if (args[0].contains("d")) {
            System.out.println("Loading data ...");
            try {
                String[] employees = readEmployees(); //change made 4
                String deleteName = args[0].substring(1);
                List<String> employeeList = new ArrayList<>(Arrays.asList(employees)); 
                employeeList.remove(deleteName); 
                writeEmployees(employeeList.toArray(new String[0])); //change made 4
            } catch (Exception ex) {}
            System.out.println("Data Deleted.");
        }
    }
}
 
