package gb.homeworks.pingpong;

public class PingPongThread implements Runnable{
    private final Object LOCK_MONITOR;
    private final String message;

    public PingPongThread(Object LOCK_MONITOR, String message) {
        this.LOCK_MONITOR = LOCK_MONITOR;
        this.message = message;
    }

    @Override
    public void run() {
        synchronized (LOCK_MONITOR) {
            while (true) {

                System.out.println(message);

                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }

                LOCK_MONITOR.notify();
                try {
                    LOCK_MONITOR.wait(100);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
