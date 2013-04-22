package com.jointhegrid.fixedness;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import junit.framework.Assert;

import org.junit.Test;
import static com.jointhegrid.fixedness.Core.*;
import static org.junit.Assert.fail;

public class CTest {

  @Test
  public void printlnTest(){
    println < Object, Object> o = new println<Object, Object>();
    o.call("What up");
  }

  @Test
  public void testMap(){
    mapper<Integer,Integer> mpr = new mapper<Integer,Integer>();
    mapFx<Integer,Integer> mfx = new mapFx<Integer,Integer>(){
      public Integer call(Integer p1) {
        return p1*2;
      }
    };
    Collection<Integer> ints = Arrays.asList(3,4,5);
    Assert.assertEquals(Arrays.asList(6,8,10), mpr.call(mfx, ints) );
  }
  
  @Test
  public void reduceTest(){
    Iterable<Integer> i = Arrays.asList(4,5,6);
    reducer<Integer> reducer = new reducer<Integer>();
    C.R2<Integer, Integer, Integer> sum = new C.R2<Integer, Integer, Integer> (){
      public Integer call(Integer p1, Integer p2) {
        return p1 + p2;
      }
    };
    Assert.assertEquals(Integer.valueOf(15), reducer.scall(sum, i));
  }
  

  @Test
  public void testRange(){
    Assert.assertEquals(Arrays.asList(1,2,3), new Core.range().call(1, 4, 1) );
  }
  
  @Test
  public void testLazyRange(){
    Iterable<Integer> it = new Core.lazyrange().call(1, Integer.MAX_VALUE, 1) ;
    Iterator<Integer> i = it.iterator();
    Assert.assertEquals(Integer.valueOf(1), i.next() );
    Assert.assertEquals(Integer.valueOf(2), i.next() );
  }
  
  @Test
  public void takeTest(){
    //and dont fail!
    Iterable<Integer> i = new range().call(1, 10, 1);
    take<Integer> t = new take<Integer>();
    Iterator<Integer> res = t.call(4,i).iterator();
    Assert.assertEquals(Integer.valueOf(1), res.next());
    Assert.assertEquals(Integer.valueOf(2), res.next());
    Assert.assertEquals(Integer.valueOf(3), res.next());
    Assert.assertEquals(Integer.valueOf(4), res.next());
    Assert.assertEquals(false, res.hasNext());
    
    try {
      Assert.assertEquals(Integer.valueOf(5), res.next());
      Assert.fail();
    } catch (NoSuchElementException e){ }
  }
  
  
  @Test
  public void motivateTest(){
    Iterable<Integer> i = new range().call(1, 4, 1);
    motivate<Integer> m = new motivate<Integer>();
    Assert.assertEquals(Arrays.asList(1,2,3), m.call(i));
  }
  
 @Test
 public void rsum(){
   List<Integer> x = Arrays.asList(4,5,6);
   Assert.assertEquals(15, sum(x));
 }
 
 public int sum(Iterable<Integer> i  ){
   Iterator<Integer> j = i.iterator();
   return sum (j);
 }
 
 public int sum(Iterator<Integer> i){
  if (i.hasNext()){
    return i.next()+sum(i);
  }
  return 0;
 }
 
}
