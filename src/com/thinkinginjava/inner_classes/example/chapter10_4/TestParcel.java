package com.thinkinginjava.inner_classes.example.chapter10_4;

/**
 * 1.当内部类向上转型为其基类，尤其是转型为一个接口的时候，内部类就有了用武之地。
 * 这是因为此内部类——某个接口的实现——能够完全不可见，并且不可用。所得到的只是指
 * 向基类或接口的引用，所以能够很方便地隐藏实现细节。
 */
class Parcel4 {
  private class PContents implements Contents {
    private int i = 11;
    public int value() { return i; }
  }
  protected class PDestination implements Destination {
    private String label;
    private PDestination(String whereTo) {
      label = whereTo;
    }
    public String readLabel() { return label; }
  }
  public Destination destination(String s) {
    return new PDestination(s);
  }
  public Contents contents() {
    return new PContents();
  }
}

public class TestParcel {
  public static void main(String[] args) {
    Parcel4 p = new Parcel4();
    Contents c = p.contents();
    Destination d = p.destination("Tasmania");
    // Illegal -- can't access private class:
    //! Parcel4.PContents pc = p.new PContents();
  }
} ///:~
