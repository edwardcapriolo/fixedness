fixedness
=========

Functional programming and closures hacks for Java

How does it work
===========

    public static class mapper<KEY,VALUE> extends C.R2<Iterable<VALUE>, mapFx<KEY,VALUE>,Iterable<KEY>> {
      public Iterable<VALUE> call(mapFx<KEY, VALUE> p1, Iterable<KEY> p2) {
        List<VALUE> results = new ArrayList<VALUE>(); 
        for (KEY p: p2){
          results.add( p1.call(p) );
        }
        return results;
      }
    }
  
    public abstract static class mapFx<KEY,VALUE> extends C.R1<VALUE,KEY> {
      public abstract VALUE call(KEY p1);     
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

Inspiration
============
The original concept came from https://github.com/MSeifeddo/Closure-implementation-for-Java-5-6-and-7


The name
=========
Functional fixedness is a cognitive bias that limits a person to using an object only in the way it is traditionally used. The concept of functional fixedness originated in Gestalt Psychology, a movement in psychology that emphasizes holistic processing. Karl Duncker defined functional fixedness as being a "mental block against using an object in a new way that is required to solve a problem." (Duncker, 1945) This "block" limits the ability of an individual to use components given to them to complete a task, as they can not move past the original purpose of those components. For example, if someone needs a paperweight, but they only have a hammer, they may not see how the hammer can be used as a paperweight. This inability to see a hammer's use as anything other than for pounding nails, is functional fixedness. The person couldn't think to use the hammer in a way other than in its conventional function.

http://en.wikipedia.org/wiki/Functional_fixedness
