import iota.*;
public class Runner {

    public static void main(String[] args) {
        Manager m = new Manager();
        Player p1 = new Dave(m);
        Player p2 = new Dave(m);
        m.addPlayers(p1, p2);
        m.play();
        m.play();
    }
}
