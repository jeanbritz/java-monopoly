package com.britzj.monopoly.util;

import com.britzj.monopoly.controller.Player;

/**
 * This class represents the model in which a {@link Player} will get a turn to play
 * I have seen this from <a href="http://crunchify.com/how-to-implement-a-linkedlist-class-from-scratch-in-java/">this site</a>
 * The {@link java.util.LinkedList} class was not compatible. 
 * @author BritzJ
 * @version 1.0
 * @since 1.0
 */
public class LinkedList {
	
	/**
	 * 
	 */
	private Node initNode;
	private Node headNode;
	private int size;
	
	public LinkedList() {
		headNode = new Node(null);
		initNode = headNode;
		size = 0;
	}
	
	/**
	 * 
	 * @param player
	 */
	public void add(Player player) {
		
		Node tempNode = new Node(player);
		Node currentNode = headNode;
		
		// Starting at the head Node, crawl to the end of the chain
		while(currentNode.getNextNode() != null) {
			currentNode = currentNode.getNextNode();
		}
				
		// The last Node's 'next' reference set to our new Node
		currentNode.setNextNode(tempNode);
		size++;
	}
	
	/**
	 * 
	 * @param player
	 */
	public void remove(Player player) {
		// TODO: Not yet implemented
		// Change 1
	}

	/**
	 * Change 2
	 * 
	 * @param index
	 * @return
	 */
	public Player get(int index) {
		
		// sanity check
		if(index <= 0) {
			return null;
		}
		
		Node currentNode = peekNext();
		for (int i = 1; i < index; i++) {
            if (currentNode.getNextNode() == null) {
                return null;
            }
            currentNode = currentNode.getNextNode();
        }
        return currentNode.getData();
	}
	
	/**
	 * 
	 * @return
	 */
	public Player moveToNext() {
		Node currentNode = peekNext();
		if(currentNode != null) {
			// changing the head node's reference
			headNode = currentNode.getNextNode();
			return currentNode.getData();
		} else {
			return initNode.getNextNode().getData();
		}
	}

	public Node peekNext() {
		return headNode.getNextNode();
	}

	/**
	 * 
	 * @return
	 */
	public int size() {
		return this.size;
	}
	
	/**
	 * Change 3
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * 
	 * @return
	 */
	public Node getHeadNode() {
		return this.headNode;
	}

	/**
	 * 
	 * @return
	 */
	public Node getInitNode() {
		return this.initNode;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		Node currentNode = peekNext();
		StringBuilder output = new StringBuilder(20);
        while (currentNode != null) {
        		output.append("[");
        		output.append(currentNode.getData().toString());
        		output.append("] --> ");
            currentNode = currentNode.getNextNode();
        }
		return output.toString();
    }
	
	public class Node {
		
		/**
		 * Reference to the next node in the chain, or null if there isn't one
		 */
		private Node next;

		/**
		 * Data object carried by this node
		 */
		private Player data;
		
		public Node(Player data) {
			this.next = null;
			this.data = data;
		}
		
		/**
		 * Get the {@link Player} object of this {@link Node} object
		 * 
		 * @return
		 */
		public Player getData() {
			return this.data;
		}
		
		/**
		 * Set the {@link Player} object of this {@link Node} object
		 * 
		 * @param player
		 */
		public void setData(Player data) {
			this.data = data;
		}
		
		/**
		 * Get next reference item in the chain.
		 * 
		 * @return {@link Node} object, if null then this {@link Node} is the last
		 *         one.
		 */
		public Node getNextNode() { 
			return this.next;
		}
		
		/**
		 * Set the next referenced item in the chain
		 */
		public void setNextNode(Node nextNode) {
			this.next = nextNode;
		}

		@Override
		public String toString() {
			return data + "|" + next;
		}
		
	}
}
