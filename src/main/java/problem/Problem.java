package problem;

import javax.media.opengl.GL2;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Класс задачи
 */
public class Problem {
    /**
     * текст задачи
     */
    public static final String PROBLEM_TEXT = "ПОСТАНОВКА ЗАДАЧИ:\n" +
            "На плоскости задано множество точек, и \"параллельный\" эллипс. Множество точек\n" +
            "образует все возможные прямые, которые могут быть построены парами точек\n" +
            "множества. Найти такую прямую (и такие две точки, через которые она проходит),\n" +
            "что эта прямая пересекает указанный эллипс, и при этом длина отрезка прямой,\n" +
            "находящейся внутри эллипса, максимальна.\n";

    /**
     * заголовок окна
     */
    public static final String PROBLEM_CAPTION = "Итоговый проект ученика 10-7 Иванова Ивана";

    /**
     * путь к файлу
     */
    private static final String FILE_NAME = "points.txt";

    /**
     * список точек
     */
    public ArrayList<Point> points;

    Ellips ellips;


    /**
     * Конструктор класса задачи
     */
    public Problem() {
        points = new ArrayList<>();
    }

    /**
     * Добавить точку
     *
     * @param x      координата X точки
     * @param y      координата Y точки
     */
    public void addPoint(double x, double y) {
        Point point = new Point(x, y);
        points.add(point);
    }

    /**
     * Решить задачу
     */
    public void solve() {
        // перебираем пары точек
        for (Point p : points) {
            for (Point p2 : points) {
                // если точки являются разными
                if (p != p2) {
                    // если координаты у них совпадают
                    if (Math.abs(p.x - p2.x) < 0.0001 && Math.abs(p.y - p2.y) < 0.0001) {
                        p.isSolution = true;
                        p2.isSolution = true;
                    }
                }
            }
        }
    }

    /**
     * Загрузить задачу из файла
     */
    public void loadFromFile() {
        points.clear();
        try {
            File file = new File(FILE_NAME);
            Scanner sc = new Scanner(file);
            // пока в файле есть непрочитанные строки
            while (sc.hasNextLine()) {
                double x = sc.nextDouble();
                double y = sc.nextDouble();
                int setVal = sc.nextInt();
                sc.nextLine();
                Point point = new Point(x, y);
                points.add(point);
            }
        } catch (Exception ex) {
            System.out.println("Ошибка чтения из файла: " + ex);
        }
    }

    /**
     * Сохранить задачу в файл
     */
    public void saveToFile() {
        try {
            PrintWriter out = new PrintWriter(new FileWriter(FILE_NAME));
            for (Point point : points) {
                out.printf("%.2f %.2f %d\n", point.x, point.y);
            }
            out.close();
        } catch (IOException ex) {
            System.out.println("Ошибка записи в файл: " + ex);
        }
    }

    /**
     * Добавить заданное число случайных точек
     *
     * @param n кол-во точек
     */
    public void addRandomPoints(int n) {
        for (int i = 0; i < n; i++) {
            Point p = Point.getRandomPoint();
            points.add(p);
        }
    }

    public void setRandomElipse(){
        ellips = Ellips.getRandomEllips();
    }

    /**
     * Очистить задачу
     */
    public void clear() {
        points.clear();
        ellips = null;
    }

    /**
     * Нарисовать задачу
     *
     * @param gl переменная OpenGL для рисования
     */
    public void render(GL2 gl) {
        for (Point point : points) {
            point.render(gl);
        }
        if (ellips != null)
            ellips.render(gl);

        //  Figures.renderPoint(gl,0.1,0.7, 5);
        //   Figures.renderPoint(gl,0.3,0.6, 7);

        //  Figures.renderLine(gl, 0.4, 0.8, 0.8, 0.5, 5 );
        //  Figures.renderTriangle(gl, -0.1, -0.5, -0.3, 0.5, -0.7, 0.6, true);
        //  Figures.renderQuad(gl, 0.1, 0.1, 0.1, 0.5, 0.8, 0.5, 0.8, 0.1, true);

        //   Figures.renderCircle(gl, 0, 0, 0.6, false);

//        Ellips ellips = new Ellips(0.7, 0.3, 0.5, 0.6);
//        ellips.render(gl);
//        Line line = new Line(0.1,0.2,-0.1,0.3);
//        line.render(gl);
    }
}
