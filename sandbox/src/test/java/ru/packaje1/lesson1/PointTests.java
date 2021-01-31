package ru.packaje1.lesson1;

import org.testng.Assert;
import org.testng.annotations.Test;

import static ru.packaje1.lesson1.Point.distance;

public class PointTests {

  @Test
  public void SquareTests() {
    Point p = new Point(1.0, 2.0);
    Point p1 = new Point(3.0, 5.0);
    Assert.assertEquals(p.distance(p1), 3.605551275463989);
    //тест метода объекта - проходит
  }

  @Test
  public void SquareTestsStatic() {
    Point p = new Point(1.0, 2.0);
    Point p1 = new Point(3.0, 5.0);
    Assert.assertEquals(distance(p, p1), 3.60555127546398);
    //тест статичного метода - падает т.к. ожидание указано не верно
  }
}