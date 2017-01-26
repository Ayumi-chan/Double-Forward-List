public class DLinkedList<T> {
	
	private DListNode<T> firstNode;
	
	private DListNode<T> lastNode;

	/**
	 * Construct an empty list
	 */
	public DLinkedList() {
		firstNode = null;
		lastNode = null;
	}

	public void setFirstNode(DListNode<T> firstNode)
	{
		this.firstNode = firstNode;
	}

	public void setLastNode(DListNode<T> lastNode)
	{
		this.lastNode = lastNode;
	}



	/**
	 * Returns true if the list contains no elements
	 */
	public boolean isEmpty()
	{
		return size() == 0;
	}

	/**
	 * Inserts the argument as the first element of this list.
	 */


	public void addFirst(T o) 
	{
		if (size() == 0)
		{
			firstNode = new DListNode<>(o, firstNode, null);
			lastNode = firstNode;
		}
		else
		{
			firstNode = new DListNode<>(o, firstNode, null);

			if (firstNode.getNext().getPrevious() == null)
			{
				firstNode.getNext().setPrevious(firstNode);
			}
		}


	}
	/**
	 * Inserts the argument as the last element of this list.
	 */
	
	

	public void addLast(T o) 
	{
		if (size() == 0)
		{
			addFirst(o);
			return;
		}
		lastNode.setNext(new DListNode<>(o, null, lastNode));
		lastNode = lastNode.getNext();
	}

	public DListNode<T> getFirst()
	{
		return firstNode;
	}

	public DListNode<T> getLast()
	{
		return lastNode;
	}

	/**
	 * Removes and returns the first element of this list.
	 */

//ok
	public T removeFirst() 
	{
		T val = firstNode.getValue();
		
		firstNode = firstNode.getNext();
		firstNode.setPrevious(null);
		
		return val;
	}

/**
	 * Removes and returns the last element of this list.
	 */

//ok
	public T removeLast()
	{
		T val = lastNode.getValue();


		lastNode = lastNode.getPrevious();
		lastNode.setNext(null);

		
		return val;
	}

	
	/**
	 * Returns a String representation of the list.
	 */
	//ok
	public String toString() 
	{
		StringBuilder str = new StringBuilder();
		str.append("[");
		for (DListNode<T> n = firstNode; n != null; n = n.getNext())
		{
			str.append(n.getValue());
			if (n.getNext() != null)
			{
				str.append(" ");
			}
		}
		str.append("]");
		return str.toString();
	}

	
	/**
	 * Returns the number of elements in the list as an int.
	 */
	//ok
	public int size() 
	{
		int m = 0;
		for (DListNode<T> n = firstNode; n != null; ++m, n = n.getNext());
		return m;
	}

	/**
	 * Removes all of the elements from this list.
	 */
	//ok
	public void clear()
	{
		firstNode = null;
		lastNode = null;
	}
		
	/**
	 * Returns a DListIterator.
	 */
	

	public DListIterator<T> iterator() 
	{
		return new DListIterator<>(this);
	}


	public static void main(String[] args) throws Exception {

		DLinkedList<String> bowl = new DLinkedList<>();
		bowl.addLast("three");
		bowl.addLast("four");
		bowl.addLast("five");
		bowl.addLast("six");
		bowl.addFirst("two");
		bowl.addLast("seven");
		bowl.addLast("eight");
		bowl.addLast("nine");
		bowl.addLast("ten");
		bowl.addFirst("one");
		System.out.println("Testing addFirst(),addLast() methods");
		System.out.println(bowl);
		System.out.println();
		System.out.println("Testing removeFirst() and removeLast() methods");
		bowl.removeFirst();
		bowl.removeLast();
		System.out.println(bowl);
		System.out.println();
		System.out.println("Testing MyLinkedList Iterator");
		System.out.println("Testing hasNext() next()");
		DListIterator<String> iter1 = bowl.iterator();
		while (iter1.hasNext())
			System.out.print(iter1.next() + " ");
		System.out.println();
		System.out.println();
		System.out.println("Testing hasPrevious() previous()");
		while (iter1.hasPrevious())
			System.out.print(iter1.previous() + " ");
		System.out.println();
		System.out.println();
		
		System.out.println("Testing set()");
		DListIterator<String> iter2 = bowl.iterator();
		iter2.next();
		iter2.next();
		
		
		iter2.set("3");
		System.out.println("FORWARD");
		iter1 = bowl.iterator();
		while (iter1.hasNext())
			System.out.print(iter1.next() + " ");
		System.out.println();
		System.out.println();
		System.out.println("BACKWORD");
		while (iter1.hasPrevious())
			System.out.print(iter1.previous() + " ");
		System.out.println();
		System.out.println("Testing add()");
		DListIterator<String> iter3 = bowl.iterator();
		iter3.next();
		iter3.next();
		iter3.next();
		iter3.add("5");
		System.out.println("FORWARD");
		iter1 = bowl.iterator();
		while (iter1.hasNext())
			System.out.print(iter1.next() + " ");
		System.out.println();
		System.out.println();
		System.out.println("BACKWORD");
		while (iter1.hasPrevious())
			System.out.print(iter1.previous() + " ");
		System.out.println();
		
		System.out.println("Testing remove()");
		DListIterator<String> iter4 = bowl.iterator();
		iter4.next();
		iter4.next();
		iter4.next();
		iter4.next();
		iter4.next();
		iter4.remove();
		System.out.println("FORWARD");
		iter1 = bowl.iterator();
		while (iter1.hasNext())
			System.out.print(iter1.next() + " ");
		System.out.println();
		System.out.println();
		System.out.println("BACKWORD");
		while (iter1.hasPrevious())
			System.out.print(iter1.previous() + " ");
		System.out.println();
		
	}
}


