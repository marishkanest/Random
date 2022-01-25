import java.util.ArrayList;
import java.util.List;

public class Main {

    public static RandomService randomService = new RandomService();
    public static List<Student> list  = new ArrayList<>();

    public static void main(String[] args) {

        Student st1 = new Student(1,"Ананьев Максим");
        list.add(st1);
        Student st2 = new Student(1,"Симонов Юрий");
        list.add(st2);
        Student st3 = new Student(1, "Полтораков Сергей");
        list.add(st3);
        Student st4 = new Student(1, "Деревяго Роман");
        list.add(st4);
        Student st5 = new Student(2, "Пятков Петр");
        list.add(st5);
        Student st6 = new Student(2, "Гайниев Эдуард");
        list.add(st6);
        Student st7 = new Student(2, "Карпенков Алексей");
        list.add(st7);
        Student st8 = new Student(3, "Чернов Александр");
        list.add(st8);
        Student st9 = new Student(3, "Белинский Виталий");
        list.add(st9);
        Student st10 = new Student(4, "Шимарин Александр");
        list.add(st10);
        Student st11 = new Student(4, "Ахметханов Ильдар");
        list.add(st11);
        Student st12 = new Student(4, "Дашков Ильдар");
        list.add(st12);
        Student st13 = new Student(4, "Войтенков Сергей");
        list.add(st13);
        Student st14 = new Student(5, "Шерхонов Алексей");
        list.add(st14);
        Student st15 = new Student(5, "Фатыхов Ильназ");
        list.add(st15);
        Student st16 = new Student(5, "Цема Антон");
        list.add(st16);
        Student st17 = new Student(6, "Занько Анна");
        list.add(st17);
        Student st18 = new Student(6, "Егоров Михаил");
        list.add(st18);
        Student st19 = new Student(6, "Валеев Вадим");
        list.add(st19);
        Student st20 = new Student(7, "Нестерова Марина");
        list.add(st20);
        Student st21 = new Student(7, "Епифанов Анатолий");
        list.add(st21);
        Student st22 = new Student(7, "Шуляев Александр");
        list.add(st22);
        Student st23 = new Student(7, "Асфандиаров Тимур");
        list.add(st23);
        Student st24 = new Student(9, "Федоренко Станислав");
        list.add(st24);
        Student st25 = new Student(9, "Азаев Марк");
        list.add(st25);
        Student st26 = new Student(9, "Борисов Дмитрий");
        list.add(st26);
        Student st27 = new Student(10, "Симаков Александр");
        list.add(st27);
        Student st28 = new Student(10, "Тоболев Денис");
        list.add(st28);
        Student st29 = new Student(10, "Шкарпенкин Дмитрий");
        list.add(st29);
        Student st30 = new Student(12, "Мороз Александр");
        list.add(st30);
        Student st31 = new Student(12, "Сажин Виктор");
        list.add(st31);
        Student st32 = new Student(12, "Шолков Василий");
        list.add(st32);
        Student st33 = new Student(12, "Детский Ярослав");
        list.add(st33);

        randomService.random(list);
    }
}


