package task2;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Collection<Student> students = createStudentsList();
        Map<String, Collection<Student>> mapStudentsPerGroup = createMapStudentsPerGroup(students);
        printGroupStudents(mapStudentsPerGroup);
        System.out.println("Sorted:");
        printGroupStudentsSort(mapStudentsPerGroup, Student.compareByNameDesc());
    }

    /**
     *
     * @return Collection students
     */
    private static Collection<Student> createStudentsList() {
        final Collection<Student> students = new ArrayList<>();

        for (int i = 0; i < 30; i++) {
            students.add(Student.create());
        }

        return students;
    }

    /**
     *
     * @param students Collection
     * @return map of students in groups
     */
    private static Map<String, Collection<Student>> createMapStudentsPerGroup(Collection<Student> students) {
        final Map<String, Collection<Student>> mapStudentsPerGroup = new HashMap<>();

        for (Student student : students) {
            String group = student.getGroup();

            Collection<Student> studentsInGroup = mapStudentsPerGroup.computeIfAbsent(group, k -> new ArrayList<>());

            studentsInGroup.add(student);
        }

        return mapStudentsPerGroup;
    }

    /**
     * Print a list of students in groups
     * @param studentsPerGroup
     */
    private static void printGroupStudents(Map<String, Collection<Student>> studentsPerGroup) {
        for (String key : studentsPerGroup.keySet()) {
            System.out.println("Group: " + key);
            System.out.println("Students:");

            for (Student student : studentsPerGroup.get(key)) {
                System.out.println(student.getName());
            }

            System.out.println();
        }
    }

    /**
     * Print sorted list students in groups
     * @param studentsPerGroup
     * @param comparator
     */
    private static void printGroupStudentsSort(Map<String, Collection<Student>> studentsPerGroup, Comparator comparator) {
        for (String key : studentsPerGroup.keySet()) {
            System.out.println("Group: " + key);
            System.out.println("Students:");

            List<Student> students = (List<Student>) studentsPerGroup.get(key);
            students.sort(comparator);

            for (Student student : studentsPerGroup.get(key)) {
                System.out.println(student.getName());
            }

            System.out.println();
        }
    }
}

