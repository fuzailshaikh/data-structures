package com.fuzailshaikh.linkedlist.single;

import java.util.ArrayList;
import java.util.List;

import com.fuzailshaikh.linkedlist.common.ILinkedList;
import com.fuzailshaikh.linkedlist.common.INode;
import com.fuzailshaikh.linkedlist.common.Node;

public class SinglyLinkedList<T> implements ILinkedList<T> {
	protected Node<T> head;
	protected int size = 0;

	public SinglyLinkedList(Node<T> head) {
		this.head = head;
		this.size = 1;
	}

	public List<Object> getData() {
		List<Object> data = new ArrayList<>();
		Node<T> temp = head;

		// Loop over all nodes
		while (!isLast(temp)) {
			data.add(temp.getValue());
			temp = getSinglyNode(temp.getNext());
		}

		return data;
	}

	@Override
	public void addNodeInEnd(INode<T> node) {
		Node<T> temp = head;

		// Find last node
		while (!isLast(temp)) {
			temp = getSinglyNode(temp.getNext());
		}

		// Connect new node to end of linked list
		temp.setNext(node);
		postInsertion();
	}

	@Override
	public void addNodeInFront(INode<T> node) {
		node.setNext(head);
		updateHeadTo(node);
		postInsertion();
	}

	@Override
	public boolean removeNode(INode<T> node) {
		// 1. Node to delete (A) is first node of list
		// A -> B
		// B
		if (head == node) {
			// Move head pointer to second node
			updateHeadTo(head.getNext());
			postDeletion();
			return true;
		}

		// 2. Node to delete (B) is in middle
		// A -> B -> C
		// A -> C
		// Find node for which next pointer has the node to delete (A)
		Node<T> temp = head;
		while (!isLast(temp.getNext())) {
			if (temp.getNext() == node) {
				temp.setNext(temp.getNext().getNext());
				postDeletion();
				return true;
			} else {
				temp = getSinglyNode(temp.getNext());
			}
		}

		// 3. Node to delete (C) is at the end
		// A -> B -> C
		// A -> B
		// We reached last node and last node is the node to delete
		if (isLast(temp.getNext()) && temp.getNext() == node) {
			temp.setNext(null);
			postDeletion();
			return true;
		}

		return false;
	}

	@Override
	public int indexOf(T data) {
		Node<T> temp = head;

		int index = 0;
		while (!isLast(temp) && !temp.contains(data)) {
			temp = getSinglyNode(temp.getNext());
			index = index + 1;
		}

		return temp.contains(data) ? index : -1;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public INode<T> getHead() {
		return head;
	}

	private void postInsertion() {
		this.size = this.size + 1;
	}

	private void postDeletion() {
		this.size = this.size - 1;
	}

	private void updateHeadTo(INode<T> node) {
		head = getSinglyNode(node);
	}

	private Node<T> getSinglyNode(INode<T> node) {
		return (Node<T>) node;
	}

	private boolean isLast(INode<T> node) {
		return node.getNext() == null;
	}

}
