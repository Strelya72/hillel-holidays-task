package task1;

public class Main {
    public static void main(String[] args) {
        // Task 1
        System.out.println("Task 1:");
        MyTuple<Integer, String, Long> myTuple = MyTuple.of(1, "Hi", 3L);
        System.out.println(myTuple.getField1());
        System.out.println(myTuple.getField2());
        System.out.println(myTuple.getField3());
    }
}
