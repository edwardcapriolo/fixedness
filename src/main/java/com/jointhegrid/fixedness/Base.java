package com.jointhegrid.fixedness;

public abstract class Base {
  private Object[] args;

  public Base(Object... args) {
    setArgs(args);
  }

  public void setArgs(Object[] args) {
    this.args = args;
  }

  public Object[] getArgs() {
    return args;
  }

  @SuppressWarnings("unchecked")
  protected static <T> T cast(Object obj) {
    if (obj != null)
      return (T) obj;
    return null;
  }

  protected static <T> T castAt(int index, Object[] objs) {
    return cast(objs[index]);
  }

  protected final void Break(Object object) {
    throw new Break(object);
  }

  protected final void Break() {
    throw new Break();
  }

  public Object getArgAt(int index) {
    return getArgs()[index];
  }
  
  public void setArgAt(Object arg, int index){
    args[index]=arg;
  }

}
