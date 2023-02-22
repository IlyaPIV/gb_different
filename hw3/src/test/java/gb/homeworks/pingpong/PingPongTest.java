package gb.homeworks.pingpong;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PingPongTest {

    @Test
    public void testPingPong(){
        PingPong game = new PingPong();
        game.playPingPong();
    }

}