package generics.es18.genericswildcard;

public class StatsWildCard<T extends Number> {

    private T[] numbers;

    public StatsWildCard() {
        super();
    }

    public StatsWildCard(T[] numeri) {
        this.numbers = numeri;
    }

    public T[] getNumbers() {
        return numbers;
    }

    public void setNumbers(T[] numbers) {
        this.numbers = numbers;
    }

    public double average() {
        double sum = 0.0;
        for (T number : this.numbers) {
            sum += number.doubleValue();

        }
        return sum / this.numbers.length;
    }

    // T è già un generico, ma nelle operazioni della classe presuppone che il tipo
    // concreto sia lo stesso (es. Integer vs Integer).
    // Per consentire tipi concreti diversi (es. Integer vs Double) nel parametro si
    // usa <? wildcard: sempre la stessa classe StatsWildCard, ma con qualsiasi T.
    public boolean sameAvg(StatsWildCard<?> obj) {
        if (this.average() == (obj.average())) {
            return true;
        } else {
            return false;
        }
    }

}
