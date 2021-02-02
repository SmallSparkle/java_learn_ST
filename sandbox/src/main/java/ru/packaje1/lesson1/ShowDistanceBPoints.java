package ru.packaje1.lesson1;

import static ru.packaje1.lesson1.Point.*;

public class ShowDistanceBPoints {
  public static void main(String[] args) {
    Point p = new Point(1.0, 12.0);
    Point p1 = new Point(44.0, 5.0);
    System.out.println("Расстояние между точками рассчитанное методом объекта = " + p.distance(p1));
  //вызов метода объекта Point
    System.out.println("Расстояние между точками рассчитанное static методом = " +distance(p, p1));

  }
  public static double distance(Point p, Point p1){
    return Math.sqrt(Math.pow(p.x - p1.x, 2) + Math.pow(p.y -p1.y, 2));
    //AB = √(xb - xa)2 + (yb - ya)2
  }//функция вычисления расстояния между 2-мя точками
}
