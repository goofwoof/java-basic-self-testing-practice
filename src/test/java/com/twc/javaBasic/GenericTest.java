package com.twc.javaBasic;

import com.twc.javaBasic.util.Pair;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GenericTest {
  @Test
  void should_auto_resolve_generic_method() {
    final String[] words = {"Hello", "Good", "Morning"};

    // TODO:
    //  The getMiddle method is a generic method. Now, please call getMiddle method for string
    //  type.
    // <--start
    //final String middle = words[words.length/2];
    final String middle = getMiddle(words);
    // --end-->

    assertEquals("Good", middle);
  }

  class Mynum implements Comparable<Mynum> {
    int i;
    public Mynum(int i){
      this.i = i;
    }

    @Override
    public int compareTo(Mynum mynum) {
      if(i < mynum.i)
        return -1;
      else
        return 1;
    }
  }

  @Test
  void should_specify_a_type_restriction_on_typed_parameters() {
    // Hint: please implement the min() method in this class.
    int minimumInteger = min(new Integer[] {1, 2, 3});
    double minimumReal = min(new Double[] {1.2, 2.2, -1d});
    //Mynum minimumStr = min(new Mynum[]{new Mynum(3), new Mynum(4), new Mynum(2)});
    assertEquals(1, minimumInteger);
    assertEquals(-1d, minimumReal, 1.0E-05);
    //assertEquals(2, minimumStr.i);
  }

  @Test
  void should_swap() {
    Pair<String> pair = new Pair<>("Hello", "World");

    // Hint: please implement swap() method in this class.
    swap(pair);

    assertEquals("World", pair.getFirst());
    assertEquals("Hello", pair.getSecond());
  }

  private static <T> T getMiddle(T[] args) {
    return args[args.length / 2];
  }

  // TODO:
  //  please implement the following code to pass the test. It should be generic
  //  after all. The method should only accept `Number` and the number should
  //  implement `Comparable<T>`.
  //  You should not change the signature of the function. But you can change
  //  the declaration of the generic type parameter.
  // <--start
  private static <T extends Number &  Comparable<T> > T min(T[] values) {
    //throw new RuntimeException("Not implemented");
    return Arrays.stream(values).sorted().collect(Collectors.toList()).get(0);
  }
  // --end-->

  // TODO:
  //  please implement following method to pass the test. The method should be able
  //  to swap fields in a pair. But you cannot change the signature of the function.
  //
  // Hint:
  //  A wildcard is not a type variable, so we can’t write code that uses ? as a type.
  // <--start
  private static void swap(Pair<?> pair) {
    throw new RuntimeException("Not implemented");
  }

  // TODO: You can add additional method within the range if you like

  // --end-->
}
