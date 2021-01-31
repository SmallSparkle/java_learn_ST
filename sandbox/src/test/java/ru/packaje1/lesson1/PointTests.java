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
  public void SquareTestsNull() {
    Point p = new Point(3.0, 4.0);
    Point p1 = new Point(3.0, 4.0);
    Assert.assertEquals(p.distance(p1), 0.0);
  }

  @Test
  public void SquareTestsNegativeNumber() {
    Point p = new Point(-10.0, -7.5);
    Point p1 = new Point(-0.1, -6.0);
    Assert.assertEquals(p.distance(p1), 10.012991560967182);
  }

  @Test
  public void SquareTestsStatic() {
    Point p = new Point(1.0, 2.0);
    Point p1 = new Point(3.0, 5.0);
    Assert.assertEquals(distance(p, p1), 3.60555127546398);
  }//тест статичного метода - падает т.к. ожидание указано не верно

  @Test
  public void SquareTestsStaticPasst() {
    Point p = new Point(1.0, 12.0);
    Point p1 = new Point(44.0, 5.0);
    Assert.assertEquals(distance(p, p1), 43.56604182158393);
  }
}
