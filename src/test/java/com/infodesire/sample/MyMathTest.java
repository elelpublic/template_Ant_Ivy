package com.infodesire.sample;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyMathTest {

  @Test
  public void byTwo() {

    assertEquals( 122, new MyMath().timesTwo( 61 ) );

  }

}