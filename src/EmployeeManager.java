//File Name EmployeeManager.java
import java.io.*;
import java.util.*;

public class EmployeeManager {

    private static String[] readEmployees() throws IOException {  
        BufferedReader reader = new BufferedReader(  
                new InputStreamReader(
                        new FileInputStream(Constants.EMPLOYEE_FILE))); //change made 5
        String line = reader.readLine();  
        reader.close();  
        return line.split(",");  
    }  

    private static void writeEmployees(String[] employees) throws IOException {  
        BufferedWriter writer = new BufferedWriter(  
                new FileWriter(Constants.EMPLOYEE_FILE)); //change made 5
        writer.write(String.join(",", employees));  
        writer.close();  
    }  

    private static void appendEmployee(String employee) throws IOException {   
        BufferedWriter writer = new BufferedWriter(  
                new FileWriter(Constants.EMPLOYEE_FILE, true)); //change made 5
        writer.write(", " + employee);  
        writer.close();  
    }    

    public static void main(String[] args) {
        if (args.length != 1) {  
            System.out.println(Constants.ERROR_ARGUMENT); //change made 5
            return;  
        }  

        if (args[0].equals("l")) {
            System.out.println(Constants.LOADING_MESSAGE); //change made 5
            try {
                String[] employees = readEmployees();
                for (String employee : employees) {
                    System.out.println(employee);
                }
            } catch (Exception ex) {}
            System.out.println(Constants.DATA_LOADED); //change made 5
        } else if (args[0].equals("s")) {
            System.out.println(Constants.LOADING_MESSAGE); //change made 5
            try {
                String[] employees = readEmployees(); 
                System.out.println(String.join(",", employees));
                Random random = new Random(); 
                int randomIndex = random.nextInt(employees.length); 
                System.out.println(employees[randomIndex]); 
            } catch (Exception ex) {}
            System.out.println(Constants.DATA_LOADED); //change made 5
        } else if (args[0].contains("+")) {
            System.out.println(Constants.LOADING_MESSAGE); //change made 5
            try {
                String newEmployee = args[0].substring(1);
                appendEmployee(newEmployee); 
            } catch (Exception ex) {}
            System.out.println(Constants.DATA_LOADED); //change made 5
        } else if (args[0].contains("?")) {
            System.out.println(Constants.LOADING_MESSAGE); //change made 5
            try {
                String[] employees = readEmployees();
                boolean found = false;
                String searchName = args[0].substring(1);  
                for (int i = 0; i < employees.length && !found; i++) {  
                    if (employees[i].equals(searchName)) {   
                        System.out.println("Employee found!");
                        found = true;
                    }
                }
            } catch (Exception ex) {}
            System.out.println(Constants.DATA_LOADED); //change made 5
        } else if (args[0].contains("c")) {
            System.out.println(Constants.LOADING_MESSAGE); //change made 5
            try {
                String[] employees = readEmployees(); 
                char[] characters = String.join(",", employees).toCharArray(); 
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
            System.out.println(Constants.DATA_LOADED); //change made 5
        } else if (args[0].contains("u")) {
            System.out.println(Constants.LOADING_MESSAGE); //change made 5
            try {
                String[] employees = readEmployees(); 
                String updateName = args[0].substring(1); 
                for (int i = 0; i < employees.length; i++) { 
                    if (employees[i].equals(updateName)) { 
                        employees[i] = "Updated"; 
                    }
                }
                writeEmployees(employees); 
            } catch (Exception ex) {}
            System.out.println(Constants.DATA_UPDATED); //change made 5
        } else if (args[0].contains("d")) {
            System.out.println(Constants.LOADING_MESSAGE); //change made 5
            try {
                String[] employees = readEmployees(); 
                String deleteName = args[0].substring(1); 
                List<String> employeeList = new ArrayList<>(Arrays.asList(employees)); 
                employeeList.remove(deleteName); 
                writeEmployees(employeeList.toArray(new String[0])); 
            } catch (Exception ex) {}
            System.out.println(Constants.DATA_DELETED); //change made 5
        }
    }
}
 
