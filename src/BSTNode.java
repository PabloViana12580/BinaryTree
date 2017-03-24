//Clase tomada de http://www.cs.pomona.edu/classes/cs062/res/structure5/Node.java


public class BSTNode<E> {
    

   protected BSTNode<E> nextElement; // ref to next

   public BSTNode(E v, BSTNode<E> next)
   {
 
       nextElement = next;
   }

   public BSTNode(E v)
   {
      this(v,null);
   }

   public BSTNode<E> next()
   {
      return nextElement;
   }

   public void setNext(BSTNode<E> next)
   {
      nextElement = next;
   }

 
}
