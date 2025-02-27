import java.awt.*;
import java.awt.event.InputEvent;
import java.util.Timer;
import java.util.TimerTask;

public class App {
    public static void main(String[] args) throws Exception {

        PointerInfo pt = MouseInfo.getPointerInfo();
        System.out.println(pt.getLocation());

        String a = "x=1377,y=338";
        String b = "x=1194,y=578";

        Robot robot = new Robot();

        Timer timer = new Timer();
        TimerTask task = new TimerTask()
        {
            @Override
            public void run()
            {
                robot.mouseMove(1377, 338);
                robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                robot.mouseMove(1194, 578);
                robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            }
        };
        timer.schedule(task, 1000, 1000);
    }
}
