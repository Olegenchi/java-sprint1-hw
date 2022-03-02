public class Main {
    public static void main(String[] args) {
        StepTracker stepTracker = new StepTracker();
        CommandLineManager commandLineManager = new CommandLineManager(stepTracker);
        commandLineManager.printMenuAndHandleCommand();
    }
}


