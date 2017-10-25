package com.nodemules.data.util.math;

/**
 * @author brent
 * @since 10/24/17.
 */
public final class MathUtil {

  public static Integer getRandomInteger(int max) {
    return getRandomInteger(0, max);
  }

  public static Integer getRandomInteger(int min, int max) {
    return (int) Math.round(Math.random() * max);
  }
}
