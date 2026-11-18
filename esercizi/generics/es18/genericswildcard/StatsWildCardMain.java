package generics.es18.genericswildcard;

public class StatsWildCardMain {
    public static void main(String[] args) {
        Double[] dArray = { 4.3, 3.4, 6.7 };
        Integer[] iArray = { 3, 5, 3 };

        StatsWildCard<Double> dStats = new StatsWildCard<>(dArray);
        StatsWildCard<Integer> iStats = new StatsWildCard<>(iArray);

        if (iStats.sameAvg(dStats)) {
            System.out.println("Le medie sono le stesse");
        } else {
            System.out.println("Le medie sono diverse");
        }
    }
}
