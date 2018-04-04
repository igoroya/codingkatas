package com.igoroya.codingkatas.april2018.linkedlistfun;


/**
 * Basic single linked list structure
 */
public class LinkedList<T> {
	
	private ListNode<T> firstNode;
	
	public LinkedList() {
		firstNode = null;
	}
	
	public LinkedList(T nodeContent) {
		firstNode = new ListNode<T>(nodeContent, null);
	}
	
	public void addNode(T nodeContent) {
		firstNode.next = new ListNode<T>(nodeContent, null);
	}
	
	public T getLast() {
		return findLastNode().content;
	}
	
	
	public T popLast() {
		ListNode<T> last = findLastNode();
		T content = last.content;
		last = null;
		return content;
	}
	
	private ListNode<T> findLastNode() {
		ListNode<T> node = firstNode;
		
		while (!node.next.equals(null)) {
			;//NOP
		}
		
		return node;
	}

	public void printAll() {
		ListNode<T> node = firstNode;
		
		while (!node.next.equals(null)) {
			System.out.println(node.toString());
		}
	}
	
	private static class ListNode<T> {
		final T content;
		ListNode<T> next;
		
		ListNode(T content, ListNode<T> next) {
			this.content = content;
			this.next = next;
		}
		
	}

}
