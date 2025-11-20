//File Name EmployeeManager.java
import java.io.*;
import java.util.*;

public class EmployeeManager {

    private static String[] readEmployees() throws IOException { //change made 6
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(Constants.EMPLOYEE_FILE))); //change made 6
        String[] employees = reader.readLine().split(","); //change made 6
        reader.close(); //change made 6
        return employees; //change made 6
    }

    private static void writeEmployees(String[] employees) throws IOException { //change made 6
        BufferedWriter writer = new BufferedWriter(
                new FileWriter(Constants.EMPLOYEE_FILE)); //change made 6
        writer.write(String.join(",", employees)); //change made 6
        writer.close(); //change made 6
    }

    private static void appendEmployee(String employee) throws IOException { //change made 6
        BufferedWriter writer = new BufferedWriter(
                new FileWriter(Constants.EMPLOYEE_FILE, true)); //change made 6
        writer.write(", " + employee); //change made 6
        writer.close(); //change made 6
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println(Constants.ERROR_ARGUMENT);
            return;
        }

        if (args[0].equals("l")) {
            System.out.println(Constants.LOADING_MESSAGE);
            try {
                for (String employee : readEmployees()) { //change made 6
                    System.out.println(employee);
                }
            } catch (Exception ex) {}
            System.out.println(Constants.DATA_LOADED);
        } else if (args[0].equals("s")) {
            System.out.println(Constants.LOADING_MESSAGE);
            try {
                String[] employees = readEmployees(); //change made 6
                System.out.println(String.join(",", employees));
                System.out.println(employees[new Random().nextInt(employees.length)]);
            } catch (Exception ex) {}
            System.out.println(Constants.DATA_LOADED);
        } else if (args[0].contains("+")) {
            System.out.println(Constants.LOADING_MESSAGE);
            try {
                appendEmployee(args[0].substring(1)); //change made 6
            } catch (Exception ex) {}
            System.out.println(Constants.DATA_LOADED);
        } else if (args[0].contains("?")) {
            System.out.println(Constants.LOADING_MESSAGE);
            try {
                String searchName = args[0].substring(1);
                for (String employee : readEmployees()) { //change made 6
                    if (employee.equals(searchName)) {
                        System.out.println("Employee found!");
                        break;
                    }
                }
            } catch (Exception ex) {}
            System.out.println(Constants.DATA_LOADED);
        } else if (args[0].contains("c")) {
            System.out.println(Constants.LOADING_MESSAGE);
            try {
                char[] characters = String.join(",", readEmployees()).toCharArray(); //change made 6
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
            System.out.println(Constants.DATA_LOADED);
        } else if (args[0].contains("u")) {
            System.out.println(Constants.LOADING_MESSAGE);
            try {
                String updateName = args[0].substring(1);
                String[] employees = readEmployees(); //change made 6
                for (int i = 0; i < employees.length; i++) {
                    if (employees[i].equals(updateName)) {
                        employees[i] = "Updated";
                    }
                }
                writeEmployees(employees); //change made 6
            } catch (Exception ex) {}
            System.out.println(Constants.DATA_UPDATED);
        } else if (args[0].contains("d")) {
            System.out.println(Constants.LOADING_MESSAGE);
            try {
                String deleteName = args[0].substring(1);
                List<String> employeeList = new ArrayList<>(Arrays.asList(readEmployees())); //change made 6
                employeeList.remove(deleteName);
                writeEmployees(employeeList.toArray(new String[0])); //change made 6
            } catch (Exception ex) {}
            System.out.println(Constants.DATA_DELETED);
        }
    }
}
 
