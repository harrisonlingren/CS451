public interface Stack
{
  public void push(Object x);
  public Object pop();
  public void makeEmpty();
  
  public Object getTop();
  public int size();
  public boolean isEmpty();
  public boolean isFull();

}
