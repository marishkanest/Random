import java.security.SecureRandom;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RandomService {

    public void random(List<Student> source) {

        Random student1 = new SecureRandom(); //задает вопрос
        Random student2 = new SecureRandom(); //отвечает

        Scanner in = new Scanner(System.in); //для кнопки

        while(true) { //запускаем цикл

            System.out.println(); //просто для красоты
            System.out.print("Press enter! Пока не будет сообщения, что список пуст)");
            System.out.println(); //просто для красоты
            in.nextLine(); //ввод кнопки

            try { //для исключения блок
                int studentIndex = student1.nextInt(source.size()); //выбор случайного индекса из элементов списка
                Student studentElement = source.get(studentIndex); //назначаем по индексу студента который спрашивает


                int studentIndex2 = student2.nextInt(source.size());//выбор случайного индекса из элементов списка
                Student studentElement2 = source.get(studentIndex2);//назначаем по индексу студента который отвечает
                if (studentElement2.team != studentElement.team                        //если команды студентов разные
                        && studentElement.sprosil!=1 && studentElement2.otvetil!=1) { //и первый еще не спашивал а второй еще не отвечал
                    System.out.println("Спрашивает: " + studentElement); //спрашивает первый
                    System.out.println("Отвечает: " + studentElement2); //спрашивает второй
                    studentElement.sprosil++; // у всех сначала стоит переменная 0, тут добавляем единицу, чтобы больше не вызывать этих студентов
                    studentElement2.otvetil++; // тоже самое для ответа

                    if(studentElement.sprosil==1 && studentElement.otvetil==1){ //тут удаляем студента если он уже и спрашивал и отвечал
                        source.remove(studentElement);
                    }
                    if(studentElement2.sprosil==1 && studentElement2.otvetil==1){ // тут для второго студента тоже самое
                        source.remove(studentElement2);
                    }
                }

            } catch (IllegalArgumentException e) { //тут исключение , наверно чтобы не было ошибок при удалении, надо у Александра спросить
                System.out.println("Список пуст");
                break; // останавливаем цикл, когда список пуст, чтобы не было ошибок
            }
        }
    }
}
