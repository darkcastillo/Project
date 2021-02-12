package problem;
import javax.media.opengl.GL2;
import javax.media.opengl.GL2GL3;

import static javax.media.opengl.GL.*;

public class Figures {
    public static void render(GL2 gl) { //точку рисуем
        gl.glPointSize(5);
        gl.glBegin(GL_POINTS);
        gl.glColor3d(1, 1, 1);
        gl.glVertex2d(0.5, 0.5);

        gl.glEnd();
    }

    public static void renderPoint(GL2 gl, double posX, double posY, int size) {
        gl.glPointSize(size);
        gl.glBegin(GL_POINTS);
        gl.glColor3d(1, 1, 1);
        gl.glVertex2d(posX,posY);

        gl.glEnd();
    }

    public static void renderLine(GL2 gl, double posAX, double posAY, double posBX, double posBY, int width) {
        gl.glLineWidth(width);
        gl.glBegin(GL_LINES);

        gl.glColor3d(1, 1, 1);
        gl.glVertex2d(posAX,posAY);

        gl.glColor3d(1, 0, 1);
        gl.glVertex2d(posBX,posBY);

        gl.glEnd();
    }

    public static void renderTriangle(GL2 gl, double posAX, double posAY, double posBX, double posBY, double posCX, double posCY, boolean filled) {
        if (filled) {
            gl.glColor3d(1, 1, 1);
            gl.glBegin(GL_TRIANGLES);

            gl.glVertex2d(posAX, posAY);
            gl.glVertex2d(posBX, posBY);
            gl.glVertex2d(posCX, posCY);

            gl.glEnd();
        }


        else {
            gl.glColor3d(1, 0, 0);
            gl.glBegin(GL_LINE_STRIP);

            gl.glVertex2d(posAX, posAY);
            gl.glVertex2d(posBX, posBY);
            gl.glVertex2d(posCX, posCY);
            gl.glVertex2d(posAX, posAY);

            gl.glEnd();
        }
    }

    public static void renderQuad(GL2 gl, double posAX, double posAY, double posBX, double posBY, double posCX, double posCY, double posDX, double posDY, boolean filled) {
        if (filled) {
            gl.glColor3d(1, 1, 0);
            gl.glBegin(GL2GL3.GL_QUADS);

            gl.glVertex2d(posAX, posAY);
            gl.glVertex2d(posBX, posBY);
            gl.glVertex2d(posCX, posCY);
            gl.glVertex2d(posDX, posDY);

            gl.glEnd();
        }
        else {
            gl.glColor3d(0, 1, 0);
            gl.glBegin(GL_LINE_STRIP);

            gl.glVertex2d(posAX, posAY);
            gl.glVertex2d(posBX, posBY);
            gl.glVertex2d(posCX, posCY);
            gl.glVertex2d(posDX, posDY);
            gl.glVertex2d(posAX, posAY);

            gl.glEnd();
        }
    }

    public static void renderCircle(GL2 gl, double posX, double posY, double rad, boolean filled) {
        if (filled) {

            gl.glColor3d(1, 1, 0);
            gl.glBegin(GL_TRIANGLE_FAN);

            gl.glVertex2d(posX, posY);

            for (int i = 0 ; i <= 50 ; i++) {
                double ugol = Math.toRadians(i * (360.0 / 50));

                double x = posX + rad * Math.cos(ugol);
                double y = posY + rad * Math.sin(ugol);

                gl.glVertex2d(x, y);
            }

            gl.glEnd();
        }
        else {
            gl.glColor3d(0, 1, 0);
            gl.glBegin(GL_LINE_STRIP);

            for (int i = 0 ; i <= 50 ; i++) {
                double ugol = Math.toRadians(i * (360.0 / 50));

                double x = posX + rad * Math.cos(ugol);
                double y = posY + rad * Math.sin(ugol);

                gl.glVertex2d(x, y);
            }

            gl.glEnd();
        }
    }

}
