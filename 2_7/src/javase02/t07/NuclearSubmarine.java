package javase02.t07;

import static java.lang.System.out;
/**
 * Created by akulakov on 26.10.2015.
 */
public class NuclearSubmarine {
    private String name;
    private Engine engine;

    public NuclearSubmarine(String name, int maxVelocity) {
        this.name = name;
         engine = new Engine(maxVelocity);
    }

    class Engine {
        private int maxVelocity;

        public Engine(int maxVelocity) {
            this.maxVelocity = maxVelocity;
        }
    }

    public void move() {
        out.println(name + " submarine with " + engine.maxVelocity + " maxVelocity has moved");
    }

}
