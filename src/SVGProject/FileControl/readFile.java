package SVGProject.FileControl;

import SVGProject.Commands.Console;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class readFile {

    public void FileRead(){

        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();

        try {
            List<String> lines = Files.readAllLines(Path.of(fileName));

            if (lines.isEmpty()) {
                Console.log("Файла е празен.");
                return;
            }

            for (String line : lines) {
                Console.log(line);
            }

        } catch (IOException e) {
            Console.log("Не е намерен файла.");
        }

    }

}
