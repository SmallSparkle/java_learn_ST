package ru.packaje1.lesson1;

import java.lang.Math;

public class Point {
  Point(double x, double y){
   this.x = x;
   this.y = y;
  }//конструктор

  double x;
  double y;
  //переменные осей

  public double distance(Point b) {
    return distance(this, b);
  }//метод объекта Point

  //изменила названия параметров, мне удобнее ориентироваться
  public static double distance(Point a, Point b){
    return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y -b.y, 2));
    //AB = √(xb - xa)2 + (yb - ya)2
  }//функция вычисления расстояния между 2-мя точками

}
