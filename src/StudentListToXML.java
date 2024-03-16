import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    private String name;
    private int age;
    private double gpa;

    public Student(String name, int age, double gpa) {
        this.name = name;
        this.age = age;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getGpa() {
        return gpa;
    }
}

public class StudentListToXML {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        // Nhập thông tin sinh viên từ bàn phím
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số lượng sinh viên:");
        int numberOfStudents = scanner.nextInt();
        scanner.nextLine(); // Đọc ký tự newline từ lệnh trước

        for (int i = 0; i < numberOfStudents; i++) {
            System.out.println("Nhập thông tin cho sinh viên thứ " + (i + 1));
            System.out.print("Tên: ");
            String name = scanner.nextLine();
            System.out.print("Tuổi: ");
            int age = scanner.nextInt();
            System.out.print("Điểm trung bình: ");
            double gpa = scanner.nextDouble();
            scanner.nextLine(); // Đọc ký tự newline từ lệnh trước
            students.add(new Student(name, age, gpa));
        }

        // Ghi thông tin sinh viên vào file XML
        try {
            FileWriter writer = new FileWriter("student_list.xml");
            writer.write("<students>\n");
            for (Student student : students) {
                writer.write("\t<student>\n");
                writer.write("\t\t<name>" + student.getName() + "</name>\n");
                writer.write("\t\t<age>" + student.getAge() + "</age>\n");
                writer.write("\t\t<gpa>" + student.getGpa() + "</gpa>\n");
                writer.write("\t</student>\n");
            }
            writer.write("</students>");
            writer.close();
            System.out.println("Đã tạo file XML thành công.");
        } catch (IOException e) {
            System.out.println("Đã xảy ra lỗi khi tạo file XML: " + e.getMessage());
        }
    }
}
