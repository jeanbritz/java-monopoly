package com.monopoly.controllers;

/**
 * This class represents the model in which a {@link Player} will get a turn to play
 * I have seen this from <a href="http://crunchify.com/how-to-implement-a-linkedlist-class-from-scratch-in-java/">this site</a>
 * The {@link java.util.LinkedList} class was not compatible. 
 * @author BritzJ
 * @version 1.0
 * @since 1.0
 */
public class PlayerLinkedList {
	
	private Node head;
	private int size;
	
	public PlayerLinkedList() {
		head = new Node(null);
		size = 0;
	}
	
	public void add(Player player) {
		
		Node tempNode = new Node(player);
		Node currentNode = head;
		
		// Starting at the head Node, crawl to the end of the list
		while(currentNode.getNext() != null) {
			currentNode = currentNode.getNext();
		}
				
		// The last Node's 'next' reference set to our new Node
		currentNode.setNext(tempNode);
		size++;
	}
	
	public Player get(int index) {
		
		// sanity check
		if(index <= 0) {
			return null;
		}
		
		Node currentNode = head.getNext();
		for (int i = 1; i < index; i++) {
            if (currentNode.getNext() == null) {
                return null;
            }
            currentNode = currentNode.getNext();
        }
        return currentNode.getPlayer();
	}
	
	public Player getNext() {
		Node currentNode = head.getNext();
		if(currentNode != null) {
			head = currentNode.next;
			return currentNode.getPlayer();
		} else {
			return get(0);
		}
	}
	
	public int getSize() {
		return this.size;
	}
	
	public String toString() {
        Node currentNode = head.getNext();
        String output = "";
        while (currentNode != null) {
            output += "[" + currentNode.getPlayer().toString() + "] --> ";
            currentNode = currentNode.getNext();
        }
        return output;
    }
	
	private class Node {
		
		// reference to the next node in the chain,
		// or null if there isn't one
		Node next;
		// data carried by this node
		Player player;
		
		public Node(Player player) {
			this.next = null;
			this.player = player;
		}
		
		public Player getPlayer() {
			return this.player;
		}
		
		public void setPlayer(Player player) {
			this.player = player;
		}
		
		public Node getNext() { 
			return this.next;
		}
		
		public void setNext(Node nextNode) {
			this.next = nextNode;
		}
		
	}
}
