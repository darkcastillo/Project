package problem;

import java.util.ArrayList;
import static java.lang.Math.*;

/**
 * Класс решения задачи
 */
public class Solver {

    private Ellipse ellips;
    private ArrayList<Point> points;

    /**
     * Конструктор класса решения задачи
     * @param ellips - заданный эллипс
     * @param points - коллекция точек
     */
    public Solver(Ellipse ellips, ArrayList<Point> points){
        this.ellips = ellips;
        this.points = points;
    }

    /**
     * Метод решения задачи
     * @return - массив [точка1, точка2]
     */
    public Point[] solve(){
        Point[] maxpoints = new Point[4];
        double max = 0.0d;
        double a = (ellips.posAX-ellips.posBX) / 2,
                b = (ellips.posAY-ellips.posBY) / 2,
                x1 = (ellips.posAX+ellips.posBX) / 2,
                y1 = (ellips.posAY+ellips.posBY) / 2;
        for (int i=0; i < points.size()-1; ++i){
            for (int j = i+1; j < points.size(); ++j){
                double k = (points.get(j).y - points.get(i).y) / (points.get(j).x - points.get(i).x),
                       m = points.get(i).y - k * points.get(i).x;

                double d = pow(pow(a, 2) * k * (m - y1) - pow(b, 2) * x1, 2) -
                        (pow(b, 2) + pow(a, 2) * pow(k, 2)) * (pow(b * x1, 2) +
                                pow(a * ( m - y1), 2) - pow(a * b, 2));
                if (d > 0){
                    double solX1 = (- pow(a, 2) * k * (m - y1) + pow(b, 2) * x1 + sqrt(d)) / (pow(b, 2) + pow(a * k, 2)),
                            solX2 = (- pow(a, 2) * k * (m - y1) + pow(b, 2) * x1 - sqrt(d)) / (pow(b, 2) + pow(a * k, 2)),
                            solY1 = k * solX1 + m, solY2 = k * solX2 +m,
                            dist = sqrt(pow(solX1 - solX2, 2) + pow(solY1 - solY2, 2));
                    if (dist > max){
                        max = dist;
                        maxpoints[0] = new Point(solX1, solY1);
                        maxpoints[1] = new Point(solX2, solY2);
                        maxpoints[2] = points.get(i);
                        maxpoints[3] = points.get(j);
                    }
                }

            }
        }
        return maxpoints;
    }

}
