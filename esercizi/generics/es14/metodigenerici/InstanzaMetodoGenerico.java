package generics.es14.metodigenerici;

public class InstanzaMetodoGenerico<T> {
    private T data;

    public InstanzaMetodoGenerico(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public <TypeVisualizer> void showA(TypeVisualizer typeVisualizer) {
        System.out.println("Hello " + typeVisualizer);
        System.out.println("data: " + this.data);
    }
}
