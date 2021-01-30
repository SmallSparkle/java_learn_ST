package ru.packaje1.lesson1;

public class MyFirstProgram {
  public static void main(String[] args) {
    hello("World");
    hello("User");

    Square s = new Square();
    s.l =5;
//    System.out.println("Площадь квадрата со стороной "+s.l+" = "+area(s.l));

    Rectangle r = new Rectangle();

    r.a=4;
    r.b=6;
   // System.out.println("Площадь прямоугольника со сторонами "+r.a+" "+r.b+" = "+area(r.a, r.b));
  }

  public static void hello(String somebody) {
    System.out.println("Hello " + somebody + "!");
  }

  public static double area(Square s) {
    return s.l * s.l;
  }

  public static double area(Rectangle r){
    return r.a * r.b;
  }
}
