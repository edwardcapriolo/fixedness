package com.jointhegrid.fixedness;

public class C {
  
  public static abstract class G extends Base {
    public abstract Object gCall(Object... objs);
    protected G(Object... constructorArgs) {
      super(constructorArgs);
    }
  }

  public static abstract class RG<Returns> extends G {
    public abstract Returns gCall(Object... objs);
    public RG(Object... constructorArgs) {
      super(constructorArgs);
    }
  }
  
  public static abstract class R0<Returns> extends G {
    public abstract Returns call();
    public final Returns scall() {
      try {
        return call();
      } catch (Break b) {
        return cast(b.getObject());
      }
    }
    public final  Returns gCall(Object... objs){
      try {
        return scall();
      } catch (Break b) {
        return cast(b.getObject());
      }
    }
    public R0(Object... constructorArgs) {
      super(constructorArgs);
    }
  }

  public static abstract class R1<Returns,Param1> extends RG<Returns> {
    public R1(Object... constructorArgs) {
      super(constructorArgs);
    }
    public abstract Returns call(Param1 p1);
    public final Returns scall(Param1 p1) {
      try {
        return call(p1);
      } catch (Break b) {
        return cast(b.getObject());
      }
    }
    public final Returns gCall(Object... objs) {
      try {
        Param1 p1 = castAt(0, objs);
        return call(p1);
      } catch (Break b) {
        return cast(b.getObject());
      }
    }
  }
  
  public static abstract class R2<Returns, Param1, Param2> extends RG<Returns> {
    public R2(Object... constructorArgs) {
      super(constructorArgs);
    }
    public abstract Returns call(Param1 p1, Param2 p2);
    public final Returns scall(Param1 p1, Param2 p2) {
      try {
        return call(p1, p2);
      } catch (Break b) {
        return cast(b.getObject());
      }
    }
    public final Returns gCall(Object... objs) {
      try {
        Param1 p1 = castAt(0, objs);
        Param2 p2 = castAt(1, objs);
        return call(p1, p2);
      } catch (Break b) {
        return cast(b.getObject());
      }
    }
  }
  
  public static abstract class R3<Returns, Param1, Param2, Param3> extends RG<Returns> {
    public R3(Object... constructorArgs) {
      super(constructorArgs);
    }
    public abstract Returns call(Param1 p1, Param2 p2, Param3 p3);
    public final Returns scall(Param1 p1, Param2 p2, Param3 p3) {
      try {
        return call(p1, p2, p3);
      } catch (Break b) {
        return cast(b.getObject());
      }
    }
    public final Returns gCall(Object... objs) {
      try {
        Param1 p1 = castAt(0, objs);
        Param2 p2 = castAt(1, objs);
        Param3 p3 = castAt(2, objs);
        return call(p1, p2, p3);
      } catch (Break b) {
        return cast(b.getObject());
      }
    }
  }
}
