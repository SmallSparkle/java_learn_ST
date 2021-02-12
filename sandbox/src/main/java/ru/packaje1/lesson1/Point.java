package ru.packaje1.lesson1;

import java.lang.Math;

public class Point {
  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }//конструктор

  public double x;
  public double y;
  //переменные осей

  public double distance(Point b) {
    return Math.sqrt(Math.pow(this.x - b.x, 2) + Math.pow(this.y - b.y, 2));
  }//метод объекта Point

}
