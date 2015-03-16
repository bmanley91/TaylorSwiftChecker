package main.groovy.TaylorChecker

/**
 * Created by BrianManley on 3/16/15.
 */
class Main {

    public static void main(String[] args) {
        // Set interval and delay for job
        long interval = 60000
        long delay = 0

        // Create timer
        Timer timer = new Timer()

        // Run job on schedule
        timer.scheduleAtFixedRate(new ScheduledTask(), delay, interval)
    }
}
