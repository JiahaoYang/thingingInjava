package eleven;

import java.util.LinkedList;

class Stack<T> {
	private LinkedList<T> list = new LinkedList<>();
	public void push(T v) {
		list.addFirst(v);
	}
	public T pop() {
		return list.removeFirst();
	}
	public T peek() {
		return list.getFirst();
	}
	public boolean isEmpty() { 
		return list.isEmpty();
	}
	public String toString() {
		return list.toString();
	}
}
public class TestStack {
	
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		System.out.println(stack.pop());
		System.out.println(stack.peek());
		
		String string = "a".toUpperCase();
	}

}
