package EserciziObserver.facile;

public class ObserverFacile {
    public static void main(String[] args) {
        ThermometerSubject thermometerPublisher = new ThermometerSubject();
        thermometerPublisher.subscribe(new FanObserver());
        thermometerPublisher.subscribe(new DisplayObserver());

        thermometerPublisher.notify(25.0);
        thermometerPublisher.notify(29.0);
        thermometerPublisher.notify(27.0);
    }
}
