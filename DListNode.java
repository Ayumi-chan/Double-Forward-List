
public class DListNode<T>
{
  
	private T value;
    private DListNode<T> next;
    private DListNode<T> previous;


    public DListNode(T initValue, DListNode<T> initNext, DListNode<T> initPrev)
    {
        value= initValue;
        next = initNext; 
        previous = initPrev;
    }
    
    public T getValue() {
		return value;
	}


	public void setValue(T value) {
		this.value = value;
	}


	public DListNode<T> getNext() {
		return next;
	}


	public void setNext(DListNode<T> next) {
		this.next = next;
	}


	public DListNode<T> getPrevious() {
		return previous;
	}


	public void setPrevious(DListNode<T> previous) {
		this.previous = previous;
	}

}