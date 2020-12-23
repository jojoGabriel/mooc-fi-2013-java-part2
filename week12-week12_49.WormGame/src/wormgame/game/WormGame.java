package wormgame.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Timer;
import wormgame.Direction;
import wormgame.domain.Apple;
import wormgame.domain.Worm;
import wormgame.gui.Updatable;

public class WormGame extends Timer implements ActionListener {

    private int width;
    private int height;
    private boolean continues;
    private Updatable updatable;
    private Worm worm;
    private Apple apple;

    public WormGame(int width, int height) {
        super(1000, null);

        this.width = width;
        this.height = height;
        this.continues = true;
        this.worm = new Worm((int) width / 2, (int) height / 2, Direction.DOWN);
        int x = new Random().nextInt(width);
        int y = new Random().nextInt(height);
        this.apple = new Apple(x, y);

        while (worm.runsInto(apple)) {
            x = new Random().nextInt(width);
            y = new Random().nextInt(height);
            this.apple = new Apple(x, y);
        }

        addActionListener(this);
        setInitialDelay(2000);

    }

    public boolean continues() {
        return continues;
    }

    public void setUpdatable(Updatable updatable) {
        this.updatable = updatable;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (!continues) {
            return;
        }
        
        worm.move();
        if (worm.runsInto(apple)) {
            apple = new Apple(new Random().nextInt(width), new Random().nextInt(height));
            while(worm.runsInto(apple)) {
                apple = new Apple(new Random().nextInt(width), new Random().nextInt(height));
            }
            worm.grow();
        }

        if (worm.runsIntoItself()) {
            continues = false;
        }
        
        if (worm.getHead().getX() == this.width  || worm.getHead().getX() <= 0 ||
            worm.getHead().getY() == this.height || worm.getHead().getY() <= 0) {
            continues = false;
        }
    
        updatable.update();

        setDelay(1000 / worm.getLength());

    }

    public Worm getWorm() {
        return worm;
    }

    public void setWorm(Worm worm) {
        this.worm = worm;
    }

    public Apple getApple() {
        return apple;
    }

    public void setApple(Apple apple) {
        this.apple = apple;
    }

}
