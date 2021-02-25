package lesson4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collections {
  public static void main(String[] args) {
    String[] langs = {"Java", "C#", "Python", "PHP"};
    for (int i = 0; i < langs.length; i++) {
      System.out.println("Я хочу выучить " + langs[i]);
    }
    System.out.println("");

    for (String l : langs) {
      System.out.println("Я хочу выучить " + l);
    }
    System.out.println("");

    List<String> languages = Arrays.asList("Java", "C#", "Python", "PHP");
    for (String l : languages) {
      System.out.println("Я хочу выучить " + l);
    }

  }
}
