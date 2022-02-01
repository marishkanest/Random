import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {


    public static void main(String[] args) throws IOException {

        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl("jdbc:postgresql://localhost:5432/andersen_random");
        hikariConfig.setDriverClassName("org.postgresql.Driver");
        hikariConfig.setUsername("postgres");
        hikariConfig.setPassword("Ksenia0709");
        hikariConfig.setMaximumPoolSize(20);

        DataSource dataSource = new HikariDataSource(hikariConfig);

        StudentsRepository studentsRepository = new StudentsRepository(dataSource);
        Scanner s = new Scanner(System.in);
        RandomService randomService = new RandomService();

        while (true) {
            System.out.println("1. Чтение списка студентов из файла и запись в базу данных");
            System.out.println("2. Получить список студентов из базы данных");
            System.out.println("3. Запустить опрос студентов");
            //System.out.println("4. Добавление студента");
            //System.out.println("5. Удаление студента по id");

            int command = s.nextInt();
            s.nextLine();

            switch (command) {
                case 1: {

                    System.out.println("Введите путь к файлу:");
                    String path = s.nextLine();

                    List<String> strings;
                    strings = Files.readAllLines(
                            Paths.get(path));


                    List<Student> students = strings.stream()
                            .map(string -> {
                                String[] array = string.split(",");
                                return new Student(Integer.parseInt(array[0]), array[1]);
                            })
                            .collect(Collectors.toList());

                    for (Student student : students) {
                        studentsRepository.save(student);
                    }
                }
                case 2: {
                    System.out.println(studentsRepository.findAll());
                }
                case 3: {
                    randomService.random(studentsRepository.findAll());

                }


            }


        }
    }
}


