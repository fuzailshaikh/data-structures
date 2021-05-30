package com.fuzailshaikh.linkedlist.single;

import java.util.ArrayList;
import java.util.List;

import com.fuzailshaikh.linkedlist.common.Node;

public class SinglyLinkedList<T> {
	protected Node<T> head;

	public SinglyLinkedList(Node<T> head) {
		this.head = head;
	}

	public void addNodeInEnd(Node<T> node) {
		Node<T> temp = head;

		// Find last node
		while (temp.next != null) {
			temp = temp.next;
		}

		// Connect new node to end of linked list
		temp.next = node;
	}

	public void addNodeInFront(Node<T> node) {
		node.next = head;
		head = node;
	}

	public boolean removeNode(Node<T> node) {
		// 1. Node to delete is first node of list
		// Move head pointer to second node
		if (head == node) {
			head = head.next;
			return true;
		}

		// 2. Node to delete (B) is in middle or end
		// A -> B -> C
		// A -> C
		Node<T> temp = head;

		// Find node for which next pointer has the node to delete (A)
		while (temp.next != null && temp.next != node) {
			temp = temp.next;
		}

		// We reached last node and didn't find node to delete
		if (temp.next == null) {
			return false;
		}

		temp.next = temp.next.next;
		return true;
	}

	public List<Object> getData() {
		List<Object> data = new ArrayList<>();
		Node<T> temp = head;

		// Loop over all nodes
		while (temp != null) {
			data.add(temp.data);
			temp = temp.next;
		}

		return data;
	}

	public boolean contains(Object data) {
		return index(data) != -1;
	}

	public int index(Object data) {
		int index = -1;
		Node<T> temp = head;

		// Loop over all nodes
		for (int i = 0; temp != null; i++) {

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
