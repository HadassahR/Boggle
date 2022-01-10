package rosenfeld.boggle;

import java.util.Timer;
import java.util.TimerTask;

public class GameTimer {
    Timer timer;

    public GameTimer(int seconds, Game game, BoggleController controller) {
        timer = new Timer();
        timer.schedule(new GameTask(game, controller), seconds * 1000);
    }

    class GameTask extends TimerTask {
        Game game;
        BoggleController controller;
        public GameTask (Game game, BoggleController controller) {
            this.game = game;
            this.controller = controller;
        }
        @Override
        public void run() {
            timer.cancel();
            controller.endGame();
        }

    }
}
