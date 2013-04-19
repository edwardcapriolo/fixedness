package com.jointhegrid.fixedness;

public class Break extends RuntimeException {

  private static final long serialVersionUID = 1L;
  private Object obj;

  public Break() {
    this(null);
  }

  public Break(Object p0) {
    setObject(p0);
  }

  private void setObject(Object p0) {
    this.obj = p0;
  }

  public Object getObject() {
    return this.obj;
  }

}
