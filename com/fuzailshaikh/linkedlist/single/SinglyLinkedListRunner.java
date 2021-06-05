package com.fuzailshaikh.linkedlist.single;

import com.fuzailshaikh.linkedlist.common.Node;

public class SinglyLinkedListRunner {
	public static void main(String[] args) {
		Node<String> head = new Node<String>("E");
		SinglyLinkedList<String> list = new SinglyLinkedList<>(head);

		Node<String> n1 = new Node<String>("H");
		Node<String> n2 = new Node<String>("L");
		Node<String> n3 = new Node<String>("L");
		Node<String> n4 = new Node<String>("O");

		// Insert nodes
		list.addNodeInFront(n1);
		list.addNodeInEnd(n2);
		list.addNodeInEnd(n3);
		list.addNodeInEnd(n4);
		System.out.println(list.getData());

		// Remove nodes
		list.removeNode(n4);
		System.out.println(list.getData());

		// Index of 'E'
		int index = list.indexOf("E");
		System.out.println("Index of E: " + index);

	}
}
