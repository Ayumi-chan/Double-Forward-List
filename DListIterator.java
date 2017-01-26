
public class DListIterator<T>  {

	private DListNode<T> previous;
	private DListNode<T> current;
	private DLinkedList<T> myList;
	private int iteratorIndex;
	//Developed by Jay Zhou and Kenny Xu
	public DListIterator(DLinkedList<T> list)
	{
		myList = list;
		current = myList.getFirst();
		previous = null;
		iteratorIndex = 0;
	}


	public String toString()
	{
		String str = "\r\n";
		for (DListNode<T> n = myList.getFirst(); n != null; n = n.getNext())
		{
			try
			{
				str += n.getPrevious().getValue();
			}
			catch (NullPointerException e)
			{
				str += null;
			}
			str += " "  + n.getValue() + " ";
			try
			{
				str += n.getNext().getValue();
			}
			catch(NullPointerException e)
			{
				str += null;
			}
			str +=  "\r\n";
		}
		str += "\r\n";
		return str;
	}

	//ok
	public boolean hasNext()
	{

		return iteratorIndex < myList.size();
	}

	//ok
	public T next()
	{
		if (!hasNext())
		{
			return null;
		}

		try
		{
			if (current == null)
			{
				current = myList.getFirst();
			}

			previous = current;
			current = current.getNext();
			++iteratorIndex;
			return previous.getValue();
		}
		catch (NullPointerException e)
		{
			return null;
		}

	}

	//ok
	public boolean hasPrevious()
	{
		return iteratorIndex > 0;
	}

	//ok
	public T previous()
	{
		if (!hasPrevious())
		{
			return null;
		}

		if (current == null)
		{
			current = myList.getLast();
		}
		else
		{
			current = current.getPrevious();
		}

		previous = current;
		--iteratorIndex;
		return previous.getValue();
	}

	//ok
	public void remove() throws Exception
	{
		if (previous == null)
		{
			throw new Exception("Unable to remove. next() or previous() not called.");
			//return;
		}

		DListNode<T> temp = previous.getNext();

		DListNode<T> _next = previous.getNext();
		DListNode<T> _prev = previous.getPrevious();

		if (_prev == null)
		{
			myList.setFirstNode(_next);
		}
		else
		{
			_prev.setNext(_next);
			previous.setPrevious(null);
		}

		if (_next == null)
		{
			myList.setLastNode(_prev);
		}
		else
		{
			_next.setPrevious(_prev);
			previous.setNext(null);
		}

		if (current == previous)
		{
			current = temp;
		}
		else
		{
			--iteratorIndex;
		}
		previous = null;
	}

	//ok
	public void add(T element)
	{
		previous = null;
		if (iteratorIndex == myList.size())
		{
			myList.addLast(element);

		}
		else if (current == null)
		{
			myList.addFirst(element);
			current = myList.getFirst().getNext();
		}
		else
		{
			DListNode<T> previous = current.getPrevious();
			DListNode<T> node = new DListNode<>(element, current, previous);
			current.setPrevious(node);
			if (previous == null)
			{
				myList.addFirst(element);
			}
			else
			{
				previous.setNext(node);
			}
		}
		++iteratorIndex;
	}

	//ok
	public void set(T element) throws Exception
	{
		if (previous == null)
		{
			throw new Exception("Unable to remove. next() or previous() not called.");
			//return;
		}
		previous.setValue(element);
	}

}
