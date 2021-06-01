package com.fuzailshaikh.linkedlist.circular;

import java.util.ArrayList;
import java.util.List;

import com.fuzailshaikh.linkedlist.common.Node;

public class CircularLinkedList<T> {
	protected Node<T> head;
	protected Node<T> tail;

	public CircularLinkedList(Node<T> node) {
		this.head = node;
		this.tail = node;
	}

	public void addNodeInFront(Node<T> node) {
		// Old tail node would point to new node
		tail.next = node;

		// New first node should point to head node
		node.next = head;

		// Head is the new node
		head = node;
	}

	public void addNodeInEnd(Node<T> node) {
		// Old tail node would point to new node
		tail.next = node;

		// New last node should point to head node
		node.next = head;

		// Make new node as tail node
		tail = node;
	}

	public boolean removeNode(Node<T> node) {
		// 1. Node to delete is first node of list
		// Move head pointer to second node
		if (head == node) {
			head = head.next;
			tail.next = head;
			return true;
		}

		// 2. Node to delete (B) is in middle or end
		// A -> B -> C
		// A -> C
		Node<T> temp = head;

		// Find node for which next pointer has the node to delete (A)
		while (temp.next != head && temp.next != node) {
			temp = temp.next;
		}

		// We reached last node and didn't find node to delete
		if (temp.next == head) {
			return false;
		}
		// Node to delete is last node
		else if (temp.next == tail) {
			temp.next = head;
			tail = temp;
		}
		else {
			temp.next = temp.next.next;
		}

		return true;
	}

	public List<Object> getData() {
		List<Object> data = new ArrayList<>();
		Node<T> temp = head;

		// Loop over all nodes
		do {
			data.add(temp.data);
			temp = temp.next;
		} while (temp != head);

		return data;
	}

	public boolean contains(Object data) {
		return index(data) != -1;
	}

	public int index(Object data) {
		int index = -1;
		Node<T> temp = head;

		// Loop over all nodes
		for (int i = 0; temp != tail; i++) {

			// If data matches, set the current index
			if (temp != null && temp.data == data) {
				index = i;
				break;
			}

			// Jump to next node
			temp = temp.next;
		}

		return index;
	}

}
