import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class EmployeeManager {
    public static void main(String[] args) {
        Set<String> employees = new HashSet<>();
        String fileName = "employees.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    employees.add(line.trim());
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        System.out.println("Collection size (unique only): " + employees.size());

        System.out.println("\nMethod 1 (Standard for loop via array):");
        Object[] employeeArray = employees.toArray();
        for (int i = 0; i < employeeArray.length; i++) {
            System.out.println(i + ": " + employeeArray[i]);
        }

        System.out.println("\nMethod 2 (For-each loop):");
        for (String employee : employees) {
            System.out.println("Employee: " + employee);
        }

        System.out.println("\nMethod 3 (Iterator interface):");
        Iterator<String> iterator = employees.iterator();
        while (iterator.hasNext()) {
            System.out.println("Item: " + iterator.next());
        }

        String checkName = "Will Bayler";
        if (employees.contains(checkName)) {
            System.out.println("Result: Employee '" + checkName + "' exists in the set.");
        } else {
            System.out.println("Result: Employee '" + checkName + "' was not found.");
        }
    }
}