package problem;

import javax.media.opengl.GL2;
import java.util.Random;

public class Ellipse {
    double posAX;
    double posAY;
    double posBX;
    double posBY;

    public Ellipse(double posAX, double posAY, double posBX, double posBY) {
        this.posAX = posAX;
        this.posAY = posAY;
        this.posBX = posBX;
        this.posBY = posBY;
    }

    void render(GL2 gl) {
        Figures.renderEllipse(gl, posAX, posAY, posBX, posBY);
    }

    /**
     * Получить случайную точку
     *
     * @return случайная точка
     */
    static Ellipse getRandomEllipse() {
        Random r = new Random();
        double posAX = r.nextDouble()*2 - 1;
        double posAY = r.nextDouble()*2 - 1;
        double posBX = r.nextDouble()*2 - 1;
        double posBY = r.nextDouble()*2 - 1;
        return new Ellipse(posAX, posAY, posBX, posBY);
    }

}
