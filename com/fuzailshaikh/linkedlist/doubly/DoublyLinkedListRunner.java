package com.fuzailshaikh.linkedlist.doubly;

import com.fuzailshaikh.linkedlist.common.BiNode;

public class DoublyLinkedListRunner {
	public static void main(String[] args) {
		BiNode<String> e = new BiNode<String>("E");
		BiNode<String> h = new BiNode<String>("H");
		BiNode<String> firstL = new BiNode<String>("L");
		BiNode<String> secondL = new BiNode<String>("L");
		BiNode<String> o = new BiNode<String>("O");

		DoublyLinkedList<String> list = new DoublyLinkedList<>(firstL);

		// Insert nodes
		list.addNodeInFront(h);
		list.addNodeBefore(e, firstL);
		list.addNodeAfter(secondL, firstL);
		list.addNodeInEnd(o);
		System.out.println(list.getData());

		// Remove nodes
		list.removeNode(secondL);
		System.out.println(list.getData());

		// Index of 'E'
		int index = list.index("E");
		System.out.println("Index of E: " + index);

	}
}
