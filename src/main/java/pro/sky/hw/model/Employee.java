package pro.sky.hw.model;

public class Employee {
    private final String firstName;
    private final String middleName;
    private final String lastName;
    private final int department;
    private double salary;

    public Employee(String firstName, String middleName, String lastName, int department, double salary) {
        if(firstName == null || middleName == null || lastName == null || department < 0 || department > 7 || salary < 0){
            throw new IllegalArgumentException("Illegal parameters in Employee class constructor");
        }
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.department = department;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

}
