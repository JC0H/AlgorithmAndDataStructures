package Algorithms_FourthEdition.Part_I.I_Fundamentals.BagsQueueStacks;

public class LinearProbingHashST<Key, Value> {
   private int M = 30001;
   private Key[] keys = (Key[]) new Object[M];
   private Value[] vals = (Value[]) new Object[M];
   private int hash(Key key){
        return (key.hashCode() & 0x7fffffff )% M ;
    }

   public Value get(Key key){
      for (int i = hash(key); keys[i] != null; i = (i+1) % M){
          if (key.equals(keys[i]))
              return vals[i];
      }
      return null;
   }

   public void put(Key key , Value value){
       int i;
       for ( i = hash(key); keys[i] != null; i = (i+1) % M)
           if (key.equals(keys[i])) break;
       keys[i] = key;
       vals[i] = value;
   }
}
