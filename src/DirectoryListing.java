import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DirectoryListing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập đường dẫn thư mục: ");
        String directoryPath = scanner.nextLine();
        File directory = new File(directoryPath);

        try {
            FileWriter writer = new FileWriter("directory_structure.xml");
            writer.write("<directory>");
            listDirectory(directory, writer);
            writer.write("</directory>");
            writer.close();
            System.out.println("Đã tạo file XML thành công.");
        } catch (IOException e) {
            System.out.println("Đã xảy ra lỗi khi tạo file XML: " + e.getMessage());
        }
    }

    private static void listDirectory(File directory, FileWriter writer) throws IOException {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    writer.write("<" + file.getName() + ">");
                    listDirectory(file, writer);
                    writer.write("</" + file.getName() + ">");
                } else {
                    writer.write("<file>" + file.getName() + "</file>");
                }
            }
        }
    }
}
