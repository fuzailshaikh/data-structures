package com.fuzailshaikh.linkedlist.doubly;

import java.util.ArrayList;
import java.util.List;

import com.fuzailshaikh.linkedlist.common.BiNode;

public class DoublyLinkedList<T> {
	protected BiNode<T> head;
	protected BiNode<T> tail;

	public DoublyLinkedList(BiNode<T> node) {
		this.head = node;
		this.tail = node;
	}

	public void addNodeBefore(BiNode<T> nodeToAdd, BiNode<T> nodeRef) {
		// Reference node is first node
		if (nodeRef == head) {
			nodeToAdd.next = head;
			head.previous = nodeToAdd;
			head = nodeToAdd;
		}
		else {
			BiNode<T> left = nodeRef.previous;
			BiNode<T> right = nodeRef;
			insertInMiddle(nodeToAdd, left, right);
		}
	}

	public void addNodeAfter(BiNode<T> nodeToAdd, BiNode<T> nodeRef) {
		// Reference node is last node
		if (nodeRef == tail) {
			tail.next = nodeToAdd;
			nodeToAdd.previous = tail;
			tail = nodeToAdd;
		}
		else {
			BiNode<T> left = nodeRef;
			BiNode<T> right = nodeRef.next;
			insertInMiddle(nodeToAdd, left, right);
		}
	}

	public void addNodeInEnd(BiNode<T> node) {
		if (tail == null) {
			head = node;
			tail = node;
		}
		else {
			addNodeAfter(node, tail);
		}
	}

	public void addNodeInFront(BiNode<T> node) {
		if (head == null) {
			head = node;
			tail = node;
		}
		else {
			addNodeBefore(node, head);
		}
	}

	// Initially L -> R
	public void insertInMiddle(BiNode<T> node, BiNode<T> left, BiNode<T> right) {
		// L <- N
		node.previous = left;

		// N -> R
		node.next = right;

		// L -> N
		left.next = node;

		// N <- R
		right.previous = node;
	}

	public boolean removeNode(BiNode<T> node) {
		// 1. Node to delete is first node of list
		// Move head pointer to second node
		if (head == node) {
			head = head.next;
			head.previous = null;
			return true;
		}

		// 2. Node to delete is last node of list
		// Move tail pointer to previous node
		if (tail == node) {
			tail = tail.previous;
			tail.next = null;
			return true;
		}

		// 2. Node to delete (B) is in middle or end
		// A -> B -> C
		// A -> C
		BiNode<T> temp = head;

		// Find node for which next pointer has the node to delete (A)
		while (temp.next != null && temp.next != node) {
			temp = temp.next;
		}

		// We reached last node and didn't find node to delete
		if (temp.next == null) {
			return false;
		}

		temp.previous.next = temp.next;
		temp.next.previous = temp.previous;
		return true;
	}

	public List<Object> getData() {
		List<Object> data = new ArrayList<>();
		BiNode<T> temp = head;

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
		BiNode<T> temp = head;

		// Loop over all nodes
		for (int i = 0; temp != null; i++) {

			// If data matches, set the current index
			if (temp != null && temp.data == data) {
				index = i;
				break;
			}

			// Jump to next BiNode
			temp = temp.next;
		}

		return index;
	}

}
