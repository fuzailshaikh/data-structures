package com.fuzailshaikh.linkedlist.common;

public interface INode<T> {
	T getValue();
	void setValue(T data);

	INode<T> getNext();
	void setNext(INode<T> node);

	default boolean contains(T data) {
		return getValue() == data;
	}
}
