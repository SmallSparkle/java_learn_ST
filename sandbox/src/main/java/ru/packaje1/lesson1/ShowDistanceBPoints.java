package ru.packaje1.lesson1;

import static ru.packaje1.lesson1.Point.distance;

public class ShowDistanceBPoints {
  public static void main(String[] args) {
    Point p = new Point(1.0,2.0);
    Point p1 = new Point(3.0,5.0);
    System.out.println("Расстояние между точками = "+distance(p,p1));


    System.out.println("Расстояние между точками v.2 = " + p.distance(p1));

  }
}
