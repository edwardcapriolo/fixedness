package com.jointhegrid.fixedness;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

import junit.framework.Assert;

import org.junit.Test;
import static com.jointhegrid.fixedness.Core.*;

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
}
