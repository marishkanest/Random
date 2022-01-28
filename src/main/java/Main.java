import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static RandomService randomService = new RandomService();


    public static void main(String[] args) throws IOException {

        System.out.println("Введите путь к файлу:");
        Scanner s = new Scanner(System.in);
        String path = s.nextLine();

        final List<String> strings;
        strings = Files.readAllLines(
                Paths.get(path));


        final List<Student> students = strings.stream()
                .map(string -> {
                    String[] array = string.split(",");
                    return new Student(Integer.parseInt(array[0]), array[1]);
                })
                .collect(Collectors.toList());


        randomService.random(students);
    }
}


