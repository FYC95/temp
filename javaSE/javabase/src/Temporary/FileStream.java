package Temporary;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileStream {
    public static void main(String[] args) throws IOException {
        String path;
        Scanner scanner = new Scanner(System.in);
        path = scanner.nextLine();
        File file = new File("g:/",path);
//        File file = new File("g:/a/b/c");
        if (!file.exists()){
            System.out.println("None");
            if (path.lastIndexOf("/") == path.length() - 1) {
                if (file.mkdirs()) {
                    System.out.println("Success");
                } else {
                    System.out.println("Failed");
                }
            }else {
                if (file.createNewFile()){
                    System.out.println("Success");
                }else {
                    System.out.println("Failed");
                }
            }
        }
    }
}
