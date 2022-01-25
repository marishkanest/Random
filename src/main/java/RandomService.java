import java.security.SecureRandom;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RandomService {

    public void random(List<Student> source) {

        Random student1 = new SecureRandom();
        Random student2 = new SecureRandom();

        Scanner in = new Scanner(System.in);

        while(true) {

            System.out.print("Press enter!");
            in.nextLine();

            try {
                //для первого студента
                int studentIndex = student1.nextInt(source.size());
                Student studentElement = source.get(studentIndex);
                System.out.println("Спрашивает: " + studentElement);
                source.remove(studentIndex);

                //для второго студента
                int studentIndex2 = student2.nextInt(source.size());
                Student studentElement2 = source.get(studentIndex2);
                if (studentElement2.team != studentElement.team) {
                    System.out.println("Отвечает: " + studentElement2);
                    source.remove(studentIndex2);
                } else {
                    System.out.println("Отвечает: " + studentElement2 + " Люди из одной команды. Сделать еще раз Рандом");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Список пуст");
                break;
            }
        }
    }
}
