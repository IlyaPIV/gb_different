package gb.homeworks.pingpong;

public class PingPong {

    public void playPingPong(){
        Object LOCK_OBJ = new Object();

        Thread ping = new Thread(new PingPongThread(LOCK_OBJ, "ping"));
        Thread pong = new Thread(new PingPongThread(LOCK_OBJ, "pong"));
        ping.start();
        pong.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        ping.interrupt();
        pong.interrupt();
    }
}
