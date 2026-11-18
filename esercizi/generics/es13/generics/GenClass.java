package generics.es13.generics;

public class GenClass<T> extends Object {
    private T obj;

    public GenClass(T obj) {
        this.obj = obj;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public void showType() {
        System.out.println("Type of T is:" + obj.getClass().getName());
    }
}
