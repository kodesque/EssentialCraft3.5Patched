package ec3.utils.dummycore.utils.system;

public abstract class ScheduledServerAction {

    public int actionTime;

    public ScheduledServerAction(int time) {
        actionTime = time;
    }

    public abstract void execute();
}
