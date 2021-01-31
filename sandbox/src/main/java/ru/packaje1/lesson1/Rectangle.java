package ru.packaje1.lesson1;

public class Rectangle {
  public Rectangle(double a, double b){
    this.a=a;
    this.b=b;
  }
  public double a;
  public double b;
  public double area() {
  return this.a * this.b;
  }
}
