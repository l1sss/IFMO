package patterns.observer;

/**
 * Created by l1s on 23.04.17.
 */
public class Main {
    public static void main(String[] args) throws Exception {

        Sensor sensor = new Sensor();

        sensor.subscribe(new Cleaner());
        sensor.subscribe(new Engineer());
        sensor.subscribe(new President());

        for (int i = 70; i <= 500; i += 10) {
            Thread.sleep(1000);

            if (i > 100 && i <= 250)
                sensor.newMessage("t реактора: " + i, Code.GREEN);
            else if (i > 250 && i <= 400)
                sensor.newMessage("t реактора: " + i, Code.YELLOW);
            else if (i > 400 && i < 500)
                sensor.newMessage("t реактора: " + i, Code.RED);
            else if (i == 500)
                System.out.println((char) 27 + "[30mBOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOM!!!!!!!");
        }
    }
}
