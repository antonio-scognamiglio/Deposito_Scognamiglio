package EserciziObserver.facile;

import java.util.function.Consumer;

class FanObserver implements Consumer<Double> {
    private boolean isOn = false;

    @Override
    public void accept(Double val) {
        if (val > 28.0) {
            System.out.println(isOn ? "Il ventilatore è già acceso" : "Il ventilatore si accende");
            isOn = true;
        } else {
            System.out.println(!isOn ? "Il ventilatore è già spento" : "Il ventilatore si spegne");
            isOn = false;
        }
    }
}