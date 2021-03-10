package problem;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;

public class Line {
    /**
     * Рисование точки
     *
     * @param gl переменная OpenGl для рисования
     */
    double a;
    double b;
    double c;



    public Line(double x1, double y1, double x2, double y2) {
        this.a = y1 - y2;
        this.b = x2 - x1;
        this.c = x1 * y2 - x2 * y1;
    }

    void render(GL2 gl) {

        gl.glBegin(GL.GL_LINES);
        double p1x = -c/a;
        double p2y = -c/b;
        gl.glVertex2d(0, p2y);
        gl.glVertex2d(p1x, 0);

        gl.glEnd();

    }
}
