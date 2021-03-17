package problem;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;

public class Line {
    /**
     * Рисование точки
     *
     * @param gl переменная OpenGl для рисования
     */
    double x1;
    double y1;
    double x2;
    double y2;

    public Line(Point a, Point b) {
        this(a.x, a.y, b.x, b.y);
    }


    public Line(double x1, double y1, double x2, double y2) {
        double dx = x2 - x1;
        double dy = y2 - y1;
        double ln = Math.sqrt(dx * dx + dy * dy);
        dx = dx / ln * 3;
        dy = dy / ln * 3;
        this.x1 = x1 - dx;
        this.y1 = y1 - dy;

        this.x2 = x1 + dx;
        this.y2 = y1 + dy;
    }

    void render(GL2 gl) {

        gl.glBegin(GL.GL_LINES);

        gl.glVertex2d(x1, y1);
        gl.glVertex2d(x2, y2);

        gl.glEnd();

    }
}
