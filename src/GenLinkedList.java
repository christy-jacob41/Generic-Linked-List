// Christy Jacob Generic Linked Link Class
import java.util.NoSuchElementException;

// creating singly-linked  generic linked list class that can handle any type
public class GenLinkedList<AnyType> 
{
	// creating head and tail nodes that are private
	private Node<AnyType> head;
	private Node<AnyType> tail;
	// creaitng an int to hold the size of the linked list
	int size = 0;
	
	// creating static Node class that can hold data of any type
	private static class Node<AnyType>
	{
		// creating variables to hold the data and the next node
		AnyType data;
		Node<AnyType> next;
		
		// Node class constructor
		Node(AnyType data, Node<AnyType> next)
		{
			this.data = data;
			this.next = next;
		}
	}
	
	// addFront method with data of any type as a parameter adds that data to the front of the list
	public void addFront(AnyType data)
	{
		// if no elements in list, make new node and make that the head and tail
		if(head == null)
		{
			head = new Node<AnyType>(data, null);
			tail = head;
		}
		// if there are elements in list, add new node to the front and change head
		else
		{
			head = new Node<AnyType>(data, head);
		}
		// increment the size by one
		size++;
	}
	
	// addEnd method with data of any type as a parameter adds that data to the end of the list
	public void addEnd(AnyType data)
	{
		// if no elements in list, make new node and make that the head and tail
		if(head == null)
		{
			head = new Node<AnyType>(data, null);
			tail = head;
		}
		// if there are elements in list, add new node to the end and change tail
		else
		{
			tail.next = new Node<AnyType>(data, null);
			tail = tail.next;
		}
		// increment the size by one
		size++;
	}
	
	// removeFront method removes the first node from the list and returns its data
	public AnyType removeFront()
	{
		// create variable to hold deleted data
		AnyType deletedData;
		
		// if no elements to remove, throw exception
		if(head == null)
			throw new NoSuchElementException();
		// if only 1 element, head and tail are changed to null and remove the node
		else if(head == tail)
		{
			deletedData = head.data;
			head = null;
			tail = null;
		}
		// if more than 1 elements in list, remove first node and change the head
		else
		{
			deletedData = head.data;
			head = head.next;
		}
		// garbage collector will delete the node with no pointer to it
		
		// decrease size by 1
		size--;
		
		// return the value of the deleted data
		return deletedData;
	}
	
	// removeEnd method removes the last node from the list and returns its data
	public AnyType removeEnd()
	{
		// create variable to hold deleted data
		AnyType deletedData;
		
		// if no elements to remove, throw exception
		if(head == null)
			throw new NoSuchElementException();
		// if only 1 element, head and tail are changed to null and remove the node
		else if(head == tail)
		{
			deletedData = head.data;
			head = null;
			tail = null;
		}
		// if more than 1 elements in list, remove last node and change the tail
		else
		{
			// temporary node variable to hold current list node to reach the second to last node in list
			Node<AnyType> temp = head;
			// while loop to make temp the second to last node in list
			while(temp.next != tail)
			{
				temp = temp.next;
			}
			// make tail data the deleted data
			deletedData = tail.data;
			// make the new tail's next point to null
			temp.next = null;
			// make the second to last node in the list the new tail
			tail = temp;
		}
		// garbage collector will delete the node with no pointer to it
		
		// decrease size by 1
		size--;
		
		// return the value of the deleted data
		return deletedData;
	}
	
	// set method with an int position and data of any type as parameters, sets the element at the given postition if it's within the size
	public void set(int position, AnyType data)
	{
		// if position is within list set the data
		if(position < size && position >= 0)
		{
			// temporary node to hold the current node to get to the specified position in list
			Node<AnyType> temp = head;
			// while loop to get to the correct position 
			while(position != 0) // while the number of times you need to go to the next node isn't 0
			{
				// going to next node
				temp = temp.next;
				// decreasing number of times you need to go to the next node
				position--;
			}
			// changing the data to the new data
			temp.data = data;
		}
		// if position isn't within list, throw an array index out of bounds exception
		else
			throw new ArrayIndexOutOfBoundsException("Position " + position + "; Size " + size);
	}
	
	// get method with a position as a parameter that returns the data at the given position if within the size of the list
	public AnyType get(int position)
	{
		// variable to hold the data at the given position
		AnyType value;
		
		// if position is within list set the data
		if(position < size && position >= 0)
		{
			// temporary node to hold the current node to get to the specified position in list
			Node<AnyType> temp = head;
			// while loop to get to the correct position 
			while(position != 0) // while the number of times you need to go to the next node isn't 0
			{
				// going to next node
				temp = temp.next;
				// decreasing number of times you need to go to the next node
				position--;
			}
			// changing the data to the new data
			value = temp.data;
		}
		// if position isn't within list, throw an array index out of bounds exception
		else
			throw new ArrayIndexOutOfBoundsException("Position: " + position + "; Size: " + size);
	
		// return the data at the given position
		return value;
	}
	
	// swap method gets two index positions as parameters and swaps the nodes at those positions as long as both positions are within the size
	public void swap(int position1, int position2)
	{
		// if both positions are out of bounds, throw an exception explaining that
		if((position1<0||position1>=size)&&(position2<0||position2>=size))
		{
			throw new ArrayIndexOutOfBoundsException("Position 1: " + position1 + "; Position 2: " + position2 + "; Size " + size);
		}
		// if the first position is out of bounds, throw an exception explaining that
		else if(position1<0||position1>=size)
		{
			throw new ArrayIndexOutOfBoundsException("Position 1: " + position1 + "; Size: " + size);

		}
		// if the second position is out of bounds, throw an exception explaining that
		else if(position2<0||position2>=size)
		{
			throw new ArrayIndexOutOfBoundsException("Position 2: " + position2 + "; Size: " + size);

		}
		// if both positions are the same, do nothing
		else if(position1 == position2)
		{
			
		}
		// if both positions are in bounds, swap the two nodes by changing 
		else
		{
			// getting the new values for each index 
			AnyType newPosition1 = get(position2); 
			AnyType newPosition2 = get(position1); 
			// setting the new values for each index 
			set(position1, newPosition1); 
			set(position2, newPosition2);
		
		}
	}
	
	// shift method has an int parameter that tells how much to shift the list forward or backward as long as it's within the size
	public void shift(int shiftAmount)
	{
		// get the true shift amount needed by getting the shift amount mod size
		shiftAmount %= size;
		
		// if the shift amount is positive, move the list backward
		if(shiftAmount > 0)
		{
			// while the shift amount isn't 0 keep shifting
			while(shiftAmount != 0)
			{
				// move list backward 1
				addEnd(removeFront());
				// decrease the amount you need to shift every time you do
				shiftAmount--;
			}
		}
		// if the shift amount is negative, move the list forward
		else
		{
			// while the shift amount isn't 0 keep shifting

			while(shiftAmount != 0)
			{
				// move list forward 1
				addFront(removeEnd());
				// decrease the amount you need to shift(since the shift amount is negative) every time you do
				shiftAmount++;
			}
		}
	}
	
	// removeMatching method has a parameter of any type and every node with the given value is removed from the list
	public void removeMatching(AnyType data)
	{
		// temporary node to keep track of current node starting at head
		Node<AnyType> temp = head; 
		// int to keep track of which iteration we are on
		int iteration = 0;
		while(temp!=null)
		{
			// if the matching node is the head, remove it using the remove front method
			if(temp.data == data && temp == head)
				removeFront();
			// if the matching node is the tail, remove it using the remove end method
			else if(temp.data == data && temp == tail)
				removeEnd();
			// if the matching node is neither the head nor tail, remove it using a helper method
			else if(temp.data == data)
			{
				removeNode(iteration);
			}
			// increment iteration by 1 and go to next node
			iteration++;
			temp = temp.next;
		}
	}
	
	// erase method has parameter with a starting position and number of elements to remove starting from that position as long as it
	// doesn't exceed the size of the list
	public void erase(int startPosition, int numRemoved)
	{
		// if the index is out of bounds, throw an exception
		if(startPosition<0||startPosition>=size)
			throw new ArrayIndexOutOfBoundsException("Position: " + startPosition + "; Size: " + size);
		// display error message if the number you need to remove is negative
		else if(numRemoved<0)
		{
			System.out.println("You can't remove a negative amount of items from the list.");
		}
		// display an error message if the number of items to remove plus starting index is greater than the size of the list
		else if((startPosition+numRemoved)>size)
		{
			System.out.println("You want to remove too many elements. Try again.");
		}
		// if both parameters are okay, remove the number of items specified starting from the given position
		else
		{
			// node variable to keep track of current node 
			Node<AnyType> temp = head;
			// int variable to keep track of which node we're on
			int iteration = 0;
			// while loop to get to the starting node
			while(startPosition!=0)
			{
				// increase the index you are at by 1 while getting to the starting node
				startPosition--;
				iteration++;
				temp = temp.next;
			}
			
			// remove nodes until the number of nodes you need to remove is 0
			while(numRemoved!=0)
			{
				// remove nodes starting from the start position
				removeNode(iteration);
				numRemoved--;
			}
		}
	}
	
	// insertList method receives a generic list and position as parameters and adds the list as long as the position is wihtin the size
	public void insertList(GenLinkedList<AnyType> list2, int position)
	{
		// if the index is out of bounds, throw an exception
		if(position>=size||position<0)
		{
			throw new ArrayIndexOutOfBoundsException("Position: " + position + "; Size: " + size);
		}
		// if it's the head, use the addFront method to add each element of the second list backwards
		else if(position==0)
		{
			// int variable starting at the end of the second list to go backwards to 0 representing the index
			int iteration = list2.size-1;
			// while loop to add each element of the second list while the index is greater than 0
			while(iteration >= 0)
			{
				// adding each element to the front and decreasing the index by 1
				addFront(list2.get(iteration));
				iteration--;
			}
		}
		// if it's the head, use addEnd method to add each element of second list to the end of this list
		else if(position==size-1)
		{
			// int variable to keep track of the index of the second list
			int iteration = 0;
			// while loop to copy each element of second list to first list
			while(iteration < list2.size)
			{
				// add the element at the current spot in the second list to the back of this list and increase the index of the second list by 1
				addEnd(list2.get(iteration));
				iteration++;
			}
		}
		// if it's not the head or tail, add each element from the 2nd list to the first starting from the given position by using the insertNode private helper method
		else
		{	// int variable to keep track of index of second list		
			int iteration = 0;
			// while loop to insert each node of the second list into the first list starting at the given position
			while(iteration < list2.size)
			{
				// use insert node helper method to add each node
				insertNode(new Node<AnyType>(list2.get(iteration), null), position);
				// increase index of second list and this list by 1
				iteration++;
				position++;
			}
		}
	}
	
	// private helper method to remove the node at a certain position
	private void removeNode(int position)
	{
		// if it's the head, use the existing remove front method
		if(position == 0)
		{
			removeFront();
		}
		// if it's the tail, use the existing remove end method
		else if(position == (size-1))
		{
			removeEnd();
		}
		// otherwise remove the node by changing the previous node's next pointer to the next node after the node being removed
		else
		{
			// subtract 1 to get to the position before the node to be removed
			position -= 1;
			// temp node to keep track of current node while traversing the list to remove a node
			Node<AnyType> temp = head;
			// while loop to get to the node before the one being removed
			while(position>0)
			{
				temp = temp.next;
				position--;
			}
			// the next pointer of the node before the node being removed should point to the node after the node being removed
			// garbage collector will take care of node being removed
			temp.next = temp.next.next;
			// decrease the size by 1
			size--;
		}
	}
	
	// private helper method to insert a node with the node and the position as parameters
	private void insertNode(Node<AnyType> insertingNode, int position)
	{
		// if the position is out of bounds of the array throw an exception
		if(position>size||position<0)
		{
			throw new ArrayIndexOutOfBoundsException("Position: " + position + "; Size: " + size);
		}
		// if the position is the head, add the node and change the head
		else if(position == 0)
		{
			// make the new head's next point to the old head and change head
			insertingNode.next = head;
			head = insertingNode;
			// increase size by 1
			size++;
		}
		// if the position is the tail, add the node and change the tail
		else if(position == size)
		{
			// change the tail after making the old tail's next point to the new tail
			tail.next = insertingNode;
			tail = insertingNode;
			// tail's next should be null
			insertingNode.next = null;
			// increase size by 1
			size++;
		}
		// otherwise, add the node in the given position
		else
		{
			// get the position right before the one being changed
			position -= 1;
			// node variable to keep track of the current node to add a node in the appropriate position
			Node<AnyType> temp = head;
			// use a while loop to get to the position of the node before the one being added
			while(position>0)
			{
				temp = temp.next;
				position--;
			}
			// change the previous node's next to the added node after changing the added node's next to the next node
			insertingNode.next = temp.next;
			temp.next = insertingNode;
			// increase size by 1
			size++;
		}
	}
	
	//overrides original toString method
	@Override
	public String toString()
	{
		// creates a string builder to print out contents of linked list starting with opening bracket
		StringBuilder sb1 = new StringBuilder("[ ");
		// temporary Node variable to keep track of the current node in list to print its data
		Node<AnyType> temp  = head;
		
		// while loop to print data of each node in list
		while(temp!=null)
		{
			// adding current node's data to string builder
			sb1.append(temp.data + " ");
			// going to next node in list
			temp = temp.next;
		}
		
		// adding closing bracket
		sb1.append("]");
		
		// return string builder as a string
		return new String(sb1);
	}
	
	// main method
	public static void main(String args[])
	{
		// creating generic linked list with diamond operator
		GenLinkedList<Integer> list = new GenLinkedList<>();

		// printing out starting list
		System.out.println("Starting Linked List: " + list);

		// testing addFront method
		list.addFront(3);
		list.addFront(5);

		// list should print 5 3
		System.out.println("List: " + list);

		// testing addEnd method
		list.addEnd(7);
		list.addEnd(2);

		// list should print 5 3 7 2
		System.out.println("List: " + list);

		// testing the removeFront method
		System.out.println("Removing " + list.removeFront() + " from front");

		// list should print 3 7 2
		System.out.println("List: " + list);

		// testing removeEnd method
		System.out.println("Removing " + list.removeEnd() + " from end");
		System.out.println("Removing " + list.removeEnd() + " from end");
		System.out.println("Removing " + list.removeEnd() + " from end");

		// list should be empty
		System.out.println("List: " + list);

		// no such element exception should be thrown
		//		list.removeFront();

		// no such element exception should be thrown
		//		list.removeEnd();

		// adding elements back to list and printing to make sure they're back
		list.addFront(3);
		list.addFront(5);
		list.addEnd(7);
		list.addEnd(2);

		// list should print 5 3 7 2
		System.out.println("List: " + list);

		// testing set method
		list.set(1, 4);
		list.set(3, 10);

		// list should print 5 4 7 10
		System.out.println("List: " + list);

		// array index out of bounds exception should be thrown
		//		list.set(4, 8);

		// array index out of bounds exception should be thrown
		//		list.set(5, 6);

		// array index out of bounds exception should be thrown
		//		list.set(-1, 9);

		// testing get method
		System.out.println("Getting value at position 2: " + list.get(2));
		System.out.println("Getting value at position 0: " + list.get(0));

		// list should print 5 4 7 10
		System.out.println("List: " + list);
		
		// testing swap method
		list.swap(2, 1);

		// list should print 5 7 4 10
		System.out.println("List: " + list);

		// testing swap method
		list.swap(0, 3);

		// list should print 10 7 4 5
		System.out.println("List: " + list);

		// testing swap method
		list.swap(3, 1);

		// list should print 10 5 4 7
		System.out.println("List: " + list);

		// array index out of bounds exception should be thrown
		//		list.swap(-1, 2);

		// array index out of bounds exception should be thrown
		//		list.swap(-1, 7);

		// array index out of bounds exception should be thrown
		//		list.swap(1, -1);

		// array index out of bounds exception should be thrown
		//		list.swap(5, 2);

		// array index out of bounds exception should be thrown
		//		list.swap(1, 6);

		// testing shift method
		list.shift(-2);

		// list should print 4 7 10 5
		System.out.println("List: " + list);

		// testing shift method
		list.shift(3);

		// list should print 5 4 7 10
		System.out.println("List: " + list);

		// testing shift method
		list.shift(4);

		// list should print 5 4 7 10
		System.out.println("List: " + list);

		// testing shift method
		list.shift(-6);

		// list should print 7 10 5 4
		System.out.println("List: " + list);

		// adding nodes to list to test removeMatching method
		list.addEnd(5);
		list.addEnd(7);

		// list should print 7 10 5 4 5 7
		System.out.println("List: " + list);

		// testing removeMatching method
		list.removeMatching(7);

		// list should print 10 5 4 5 
		System.out.println("List: " + list);

		// testing removeMatching method
		list.removeMatching(5);

		// list should print 10 4
		System.out.println("List: " + list);
		
		// adding nodes to list to test erase method
		list.addEnd(25);
		list.addEnd(42);
		list.addEnd(53);
		list.addEnd(38);
		list.addEnd(8);
		list.addEnd(99);
		
		// list should print 10 4 25 42 53 38 8 99
		System.out.println("List: " + list);
				
		// array index out of bounds exception should be thrown
//		list.erase(-2, 3);
		
		// array index out of bounds exception should be thrown
//		list.erase(8, 4);
		
		// error message should be displayed
		list.erase(4, -1);
		
		// error message should be displayed
		list.erase(5, 4);
		
		// testing erase method
		list.erase(4, 3);
		
		// list should print 10 4 25 42 99
		System.out.println("List: " + list);
		
		// testing erase method
		list.erase(0, 4);

		// list should print 99
		System.out.println("List: " + list);
		
		// adding nodes to list to test erase method
		list.addEnd(87);
		list.addEnd(17);
		list.addEnd(23);
		list.addEnd(35);
		list.addEnd(54);
		list.addEnd(77);

		// list should print 99 87 17 23 35 54 77
		System.out.println("List: " + list);
				
		// error message should be displayed
		list.erase(3, 5);
		
		// testing erase method
		list.erase(3, 4);

		// list should print 99 87 17
		System.out.println("List: " + list);
		
		// adding nodes to list to test erase method
		list.addEnd(19);
		list.addEnd(15);
		list.addEnd(27);
		list.addEnd(59);
		list.addEnd(36);
		list.addEnd(43);
				
		// list should print 99 87 17 19 15 27 59 36 43
		System.out.println("List: " + list);
		
		// creating second generic linked list with diamond operator
		GenLinkedList<Integer> list2 = new GenLinkedList<>();
		list2.addFront(101);
		list2.addFront(202);
		list2.addFront(303);
		
		// list 2 should print 303 202 101
		System.out.println("Starting Linked List 2: " + list2);
		
		// testing insert list method
		list.insertList(list2, 0);
		
		// list should print 303 202 101 99 87 17 19 15 27 59 36 43
		System.out.println("List: " + list);
		
		// array out of bounds exception should be thrown since position is bigger than the last index
//		list.insertList(list2, 12);
		
		// testing insert list method
		list.insertList(list2, 11);

		// list should print 303 202 101 99 87 17 19 15 27 59 36 43 303 202 101
		System.out.println("List: " + list);
		
		// using erase to bring list back to how it was before inserting list 2 twice
		list.erase(0, 3);
		list.erase(9, 3);
		
		// list should print 99 87 17 19 15 27 59 36 43
		System.out.println("List: " + list);
		
		// testing insert list method
		list.insertList(list2, 3);
		
		// list should print 99 87 17 303 202 101 19 15 27 59 36 43
		System.out.println("List: " + list);
		
		// testing insert list method
		list.insertList(list2, 8);

		// list should print 99 87 17 303 202 101 19 15 303 202 101 27 59 36 43
		System.out.println("List: " + list);
	}
}
