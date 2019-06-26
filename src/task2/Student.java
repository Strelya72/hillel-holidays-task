package task2;

import java.util.Comparator;

public class Student {
    private String name;
    private String group;


    public Student(String name, String group) {
        this.name = name;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }

    public static Student create() {
        String[] names = {"Диана", "Данил", "Андрей", "Николай", "Алина", "Алиса", "Денис", "Константин", "Юрий", "Натали",
                "Александр", "Алексей", "Евгений", "Евгения", "Карина", "Михаил", "Александра"};
        String[] groups = {"11", "12", "13"};
        return new Student(
                names[(int) (Math.random() * names.length)],
                groups[(int) (Math.random() * groups.length)]);
    }

    public static Comparator<Student> compareByNameDesc() {
        return new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o2.getName().compareTo(o1.getName());
            }
        };
    }
}
