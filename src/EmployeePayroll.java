import java.util.ArrayList;
import java.util.Scanner;

public class EmployeePayroll {

        private int id;
        private String name;
        private double salary;

        public EmployeePayroll(int id, String name, double salary) {
            this.id = id;
            this.name = name;
            this.salary = salary;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public double getSalary() {
            return salary;
        }

        @Override
        public String toString() {
            return "Employee ID: " + id + "\nName: " + name + "\nSalary: $" + salary;
        }
    }


