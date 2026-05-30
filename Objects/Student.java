public class Student {
    String name;
    int age;
    double gpa;
    String major;

    public Student() {
        name = "John";
        age = 18;
        gpa = 0.0;
        major = "Undeclared";
    }

    public Student(String name) {
        this.name = name; 
        this.age = 18;
        this.gpa = 0.0;
        this.major = "Undeclared";
    }

    public void updateGPA(double newGPA) {
        gpa = newGPA;
    }

    public void updateMajor(String newMajor) {
        major = newMajor;
    }

    public void printInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("GPA: " + gpa);
        System.out.println("Major: " + major);
    }
}