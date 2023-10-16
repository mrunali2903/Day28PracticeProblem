import java.util.ArrayList;
import java.util.Scanner;

public class PayrollService {
    private ArrayList<EmployeePayroll> employeeList;

    public PayrollService() {
        employeeList = new ArrayList<>();
    }

    public void addEmployee(int id, String name, double salary) {
        EmployeePayroll employee = new EmployeePayroll(id, name, salary);
        employeeList.add(employee);
        System.out.println("Employee added to the payroll.");
    }

    public void displayEmployeeDetails() {
        if (employeeList.isEmpty()) {
            System.out.println("No employees in the payroll.");
        } else {
            System.out.println("Employee Details:");
            for (EmployeePayroll employee : employeeList) {
                System.out.println(employee);
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        PayrollService payrollService = new PayrollService();
        Scanner scanner = new Scanner(System.in);
        char choice;

        do {
            System.out.println("Employee Payroll Service Menu");
            System.out.println("1. Add Employee");
            System.out.println("2. Display Employee Details");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.next().charAt(0);

            switch (choice) {
                case '1':
                    System.out.print("Enter Employee ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character
                    System.out.print("Enter Employee Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Employee Salary: $");
                    double salary = scanner.nextDouble();
                    payrollService.addEmployee(id, name, salary);
                    break;
                case '2':
                    payrollService.displayEmployeeDetails();
                    break;
                case '3':
                    System.out.println("Exiting Employee Payroll Service. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != '3');

        scanner.close();
    }
}
