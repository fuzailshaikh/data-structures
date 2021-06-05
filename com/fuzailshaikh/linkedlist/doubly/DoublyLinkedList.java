package com.fuzailshaikh.linkedlist.doubly;

import java.util.ArrayList;
import java.util.List;

import com.fuzailshaikh.linkedlist.common.BiNode;
import com.fuzailshaikh.linkedlist.common.ILinkedList;
import com.fuzailshaikh.linkedlist.common.INode;

public class DoublyLinkedList<T> implements ILinkedList<T> {
	protected BiNode<T> head;
	protected BiNode<T> tail;
	protected int size = 0;

	public DoublyLinkedList(BiNode<T> node) {
		this.head = node;
		this.tail = node;
		this.size = 1;
	}

	public void addNodeBefore(BiNode<T> nodeToAdd, BiNode<T> nodeRef) {
		// Reference node is first node
		if (nodeRef == head) {
			nodeToAdd.setNext(head);
			head.setPrevious(nodeToAdd);
			updateHeadTo(nodeToAdd);
		} else {
			BiNode<T> left = getDoublyNode(nodeRef.getPrevious());
			BiNode<T> right = nodeRef;
			insertInMiddle(nodeToAdd, left, right);
		}
		postInsertion();
	}

	public void addNodeAfter(BiNode<T> nodeToAdd, BiNode<T> nodeRef) {
		// Reference node is last node
		if (nodeRef == tail) {
			tail.setNext(nodeToAdd);
			nodeToAdd.setPrevious(tail);
			updateTailTo(nodeToAdd);
		} else {
			BiNode<T> left = nodeRef;
			BiNode<T> right = getDoublyNode(nodeRef.getNext());
			insertInMiddle(nodeToAdd, left, right);
		}
		postInsertion();
	}

	// Initially L -> R
	public void insertInMiddle(BiNode<T> node, BiNode<T> left, BiNode<T> right) {
		// L <- N
		node.setPrevious(left);

		// N -> R
		node.setNext(right);

		// L -> N
		left.setNext(node);

		// N <- R
		right.setPrevious(node);
	}

	@Override
	public void addNodeInEnd(INode<T> node) {
		if (tail == null) {
			updateHeadTo(node);
			updateTailTo(node);
		} else {
			addNodeAfter(getDoublyNode(node), tail);
		}
	}

	@Override
	public void addNodeInFront(INode<T> node) {
		if (head == null) {
			updateHeadTo(node);
			updateTailTo(node);
		} else {
			addNodeBefore(getDoublyNode(node), head);
		}
	}

	@Override
	public boolean removeNode(INode<T> node) {
		// 1. Only one node in list
		if (size == 1) {
			head = null;
			tail = null;
		}

		// 2. Node to delete is first node of list
		// Move head pointer to second node
		else if (head == node) {
			updateHeadTo(head.getNext());
			head.setPrevious(null);
		}

		// 3. Node to delete is last node of list
		// Move tail pointer to previous node
		else if (tail == node) {
			updateTailTo(tail.getPrevious());
			tail.setNext(null);
		}

		// 4. Node to delete (B) is in middle or end
		// A -> B -> C
		// A -> C
		else {
			BiNode<T> left = getDoublyNode(getDoublyNode(node).getPrevious());
			BiNode<T> right = getDoublyNode(node.getNext());
			left.setNext(right);
			right.setPrevious(left);
		}

		postDeletion();
		return true;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public INode<T> getHead() {
		return head;
	}

	public List<Object> getData() {
		List<Object> data = new ArrayList<>();
		BiNode<T> temp = head;

		// Loop over all nodes
		while (temp != null) {
			data.add(temp.getValue());
			temp = getDoublyNode(temp.getNext());
		}

		return data;
	}

	public int indexOf(T data) {
		BiNode<T> temp = head;

		int index = 0;
		while (!isLast(temp) && !temp.contains(data)) {
			temp = getDoublyNode(temp.getNext());
			index = index + 1;
		}

		return temp.contains(data) ? index : -1;
	}

	private void postInsertion() {
		this.size = this.size + 1;
	}

	private void postDeletion() {
		this.size = this.size - 1;
	}

	private void updateHeadTo(INode<T> node) {
		head = getDoublyNode(node);
	}

	private void updateTailTo(INode<T> node) {
		tail = getDoublyNode(node);
	}

	private BiNode<T> getDoublyNode(INode<T> node) {
		return (BiNode<T>) node;
	}

	private boolean isLast(INode<T> node) {
		return node.getNext() == null;
	}

}
