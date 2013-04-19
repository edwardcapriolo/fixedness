package com.jointhegrid.fixedness;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class Core {

  public static class println<T, Returns> extends C.R1<Returns, T> {
    public Returns call(T p1) {
      System.out.println(p1);
      return null;
    }
  }

  public static class range extends C.R3<Iterable<Integer>, Integer, Integer, Integer> {
    public Iterable<Integer> call(Integer start, Integer end, Integer step) {
      Collection<Integer> c = new ArrayList<Integer>();
      for (int i=start;i<end;i++){
        c.add(i);
      }
      return c;
    }
  }
  
  public static class lazyrange extends C.R3<Iterable<Integer>, Integer, Integer, Integer> {
   public Iterable<Integer> call(final Integer start, final Integer end, final Integer step) {
      Iterable<Integer> c = new Iterable<Integer>(){
        public Iterator<Integer> iterator() {
          return new Iterator<Integer>(){
            int x = start;
            public boolean hasNext() {
              return x<end;
            }
            public Integer next() {
              int ret = x;
              x=x+step;
              return ret;
            }
            public void remove() {
            }
          };
        }
      };
      return c;
    }
  }
  
  public static class take<T> extends C.R2<Iterable<T>, Integer, Iterable<T>>{
    public Iterable<T> call(final Integer p1, final Iterable<T> p2) {
      return new Iterable<T>(){
        public Iterator<T> iterator() {
          return new Iterator<T>(){
            int taken=0;
            Iterator<T> i = p2.iterator();    
            public boolean hasNext() {
              return taken< p1 && i.hasNext();
            }
            public T next() {
              if (hasNext()){
                taken++;
                return i.next();
              } else throw new NoSuchElementException("size of take is "+p1+" your trying to take element " +(taken+1));
            }
            public void remove() {
            }    
          };
        }        
      };
    }    
  }

  public static class mapper<KEY, VALUE> extends
          C.R2<Iterable<VALUE>, mapFx<KEY, VALUE>, Iterable<KEY>> {
    public Iterable<VALUE> call(mapFx<KEY, VALUE> p1, Iterable<KEY> p2) {
      List<VALUE> results = new ArrayList<VALUE>();
      for (KEY p : p2) {
        results.add(p1.call(p));
      }
      return results;
    }
  }

  public abstract static class mapFx<KEY, VALUE> extends C.R1<VALUE, KEY> {
    public abstract VALUE call(KEY p1);
  }

}
