//File Name EmployeeManager.java
import java.io.*;
import java.util.*;

public class EmployeeManager {
    public static void main(String[] args) {
        if (args.length != 1) { 
            System.out.println("Error: Please provide exactly one argument."); 
            return; 
        }         
        // Check arguments
        if (args[0].equals("l")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader reader = new BufferedReader( //change made 3
                        new InputStreamReader(
                                new FileInputStream("employees.txt")));
                String line = reader.readLine(); //change made 3
                String employees[] = line.split(","); //change made 3
                for (String employee : employees) { //change made 3
                    System.out.println(employee);
                }
            } catch (Exception ex) {}
            System.out.println("Data Loaded.");
        } else if (args[0].equals("s")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader reader = new BufferedReader( //change made 3
                        new InputStreamReader(
                                new FileInputStream("employees.txt")));
                String line = reader.readLine(); //change made 3
                System.out.println(line);
                String employees[] = line.split(","); //change made 3
                Random random = new Random(); //change made 3
                int randomIndex = random.nextInt(employees.length); //change made 3
                System.out.println(employees[randomIndex]); //change made 3
            } catch (Exception ex) {}
            System.out.println("Data Loaded.");
        } else if (args[0].contains("+")) {
            System.out.println("Loading data ...");
            try {
                BufferedWriter writer = new BufferedWriter( //change made 3
                        new FileWriter("employees.txt", true));
                String newEmployee = args[0].substring(1); //change made 3
                writer.write(", " + newEmployee); //change made 3
                writer.close();
            } catch (Exception ex) {}
            System.out.println("Data Loaded.");
        } else if (args[0].contains("?")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader reader = new BufferedReader( //change made 3
                        new InputStreamReader(
                                new FileInputStream("employees.txt")));
                String line = reader.readLine(); //change made 3
                String employees[] = line.split(","); //change made 3
                boolean found = false;
                String searchName = args[0].substring(1); //change made 3
                for (int i = 0; i < employees.length && !found; i++) { //change made 3
                    if (employees[i].equals(searchName)) { //change made 3
                        System.out.println("Employee found!");
                        found = true;
                    }
                }
            } catch (Exception ex) {}
            System.out.println("Data Loaded.");
        } else if (args[0].contains("c")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader reader = new BufferedReader( //change made 3
                        new InputStreamReader(
                                new FileInputStream("employees.txt")));
                String line = reader.readLine(); //change made 3
                char[] characters = line.toCharArray(); //change made 3
                boolean inWord = false;
                int wordCount = 0; //change made 3
                for (char character : characters) { //change made 3
                    if (character == ' ') { //change made 3
                        if (!inWord) {
                            wordCount++; //change made 3
                            inWord = true;
                        } else {
                            inWord = false;
                        }
                    }
                }
                System.out.println(wordCount + " word(s) found " + characters.length); //change made 3
            } catch (Exception ex) {}
            System.out.println("Data Loaded.");
        } else if (args[0].contains("u")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader reader = new BufferedReader( //change made 3
                        new InputStreamReader(
                                new FileInputStream("employees.txt")));
                String line = reader.readLine(); //change made 3
                String employees[] = line.split(","); //change made 3
                String updateName = args[0].substring(1); //change made 3
                for (int i = 0; i < employees.length; i++) { //change made 3
                    if (employees[i].equals(updateName)) { //change made 3
                        employees[i] = "Updated"; //change made 3
                    }
                }
                BufferedWriter writer = new BufferedWriter( //change made 3
                        new FileWriter("employees.txt"));
                writer.write(String.join(",", employees)); //change made 3
                writer.close();
            } catch (Exception ex) {}
            System.out.println("Data Updated.");
        } else if (args[0].contains("d")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader reader = new BufferedReader( //change made 3
                        new InputStreamReader(
                                new FileInputStream("employees.txt")));
                String line = reader.readLine(); //change made 3
                String employees[] = line.split(","); //change made 3
                String deleteName = args[0].substring(1); //change made 3
                List<String> employeeList = new ArrayList<>(Arrays.asList(employees)); //change made 3
                employeeList.remove(deleteName); //change made 3
                BufferedWriter writer = new BufferedWriter( //change made 3
                        new FileWriter("employees.txt"));
                writer.write(String.join(",", employeeList)); //change made 3
                writer.close();
            } catch (Exception ex) {}
            System.out.println("Data Deleted.");
        }
    }
}
