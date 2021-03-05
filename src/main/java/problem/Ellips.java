package problem;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;

public class Ellips {
    double posAX;
    double posAY;
    double posBX;
    double posBY;

    public Ellips(double posAX, double posAY, double posBX, double posBY) {
        this.posAX = posAX;
        this.posAY = posAY;
        this.posBX = posBX;
        this.posBY = posBY;
    }

    void render(GL2 gl) {
        Figures.renderEllips(gl, posAX, posAY, posBX, posBY);
    }
}
