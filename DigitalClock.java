import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class DigitalClock {

    private static boolean is24HourFormat = true;

    public static void main(String[] args) {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                displayTime();
            }
        };

        timer.scheduleAtFixedRate(task, 0, 1000);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nEnter '24' to switch to 24-hour format, '12' to switch to 12-hour format, or 'exit' to quit:");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("24")) {
                is24HourFormat = true;
            } else if (input.equalsIgnoreCase("12")) {
                is24HourFormat = false;
            } else if (input.equalsIgnoreCase("exit")) {
                timer.cancel();
                break;
            } else {
                System.out.println("Invalid input. Please try again.");
            }
        }

        scanner.close();
    }

    private static void displayTime() {
        long currentTimeMillis = System.currentTimeMillis();
        long totalSeconds = currentTimeMillis / 1000;
        int currentSecond = (int) (totalSeconds % 60);

        long totalMinutes = totalSeconds / 60;
        int currentMinute = (int) (totalMinutes % 60);

        long totalHours = totalMinutes / 60;
        int currentHour = (int) (totalHours % 24);

        if (!is24HourFormat) {
            String amPm = currentHour < 12 ? "AM" : "PM";
            currentHour = currentHour % 12;
            if (currentHour == 0) {
                currentHour = 12;
            }
            System.out.printf("\rCurrent Time: %02d:%02d:%02d %s", currentHour, currentMinute, currentSecond, amPm);
        } else {
            System.out.printf("\rCurrent Time: %02d:%02d:%02d", currentHour, currentMinute, currentSecond);
        }

        System.out.flush();
    }
}
