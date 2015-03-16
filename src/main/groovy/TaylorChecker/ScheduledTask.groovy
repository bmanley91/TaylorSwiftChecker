package main.groovy.TaylorChecker

/**
 * Created by BrianManley on 3/16/15.
 */
class ScheduledTask extends TimerTask {

    public void run() {
        if(SwiftyChecker.checkForTaylor()) {
            println "Taylor is available!"
        }
        else{
            println 'No Tay Tay...'
        }
    }
}
