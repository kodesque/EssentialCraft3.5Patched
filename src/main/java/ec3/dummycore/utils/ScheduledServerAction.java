package ec3.dummycore.utils;

public abstract class ScheduledServerAction {

    public int actionTime;

    public ScheduledServerAction(int time) {
        actionTime = time;
    }

    public abstract void execute();
}
