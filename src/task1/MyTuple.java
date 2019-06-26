package task1;

public class MyTuple <T,U,V>{
    private final T field1;
    private final U field2;
    private final V field3;

    private MyTuple(T field1, U field2, V field3) {
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
    }

    public static <T,U,V> MyTuple<T,U,V> of (T t, U u, V v) {
        return new MyTuple<>(t, u, v);
    }

    public static <T,U,V> MyTuple <T,U,V>  of (T field1, U field2) {
        return new MyTuple<>(field1, field2, null);
    }

    public static <T,U,V> MyTuple<T,U,V> of (T field1) {
        return new MyTuple<>(field1, null, null);
    }

    public static <T,U,V> MyTuple<T,U,V> of () {
        return new MyTuple<>(null, null, null);
    }

    public T getField1() {
        return field1;
    }

    public U getField2() {
        return field2;
    }

    public V getField3() {
        return field3;
    }
}
