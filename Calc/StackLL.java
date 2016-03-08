
public class StackLL implements Stack
{
  private class node
  {
    public Object data;
	public node next;
  }
  node top;
  int count;
  
  public StackLL()
  {
    top=null; count=0;
  }

  public void push(Object x)
  {
    node newnode=new node();
	newnode.data=x;
	newnode.next=top;
	top=newnode;
	count++;
  }
  public Object pop()
  {
    if(isEmpty()) return null;
    Object popped=top.data;
	top=top.next;
	count--;	
	return popped;
  }
  public void makeEmpty()
  {
    top=null; count=0;
  }
  
  public Object getTop()
  {
    if(isEmpty()) return null;
    return top.data;
  }
  public int size() { return count; }
  public boolean isEmpty()
    { return top==null; }
  
  public boolean isFull()
    { return false; }
}