import iota.Manager;
import iota.display.IotaDisplay;

public class DisplayRunner {

    public static void main(String[] args) {
        Manager m = new Manager();
        IotaDisplay.run(m, new Gilbert(m), new BetterDave(m), new Dave(m));
    }
}
