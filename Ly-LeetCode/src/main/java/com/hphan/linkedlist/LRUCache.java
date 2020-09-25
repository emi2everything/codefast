package com.hphan.linkedlist;

import java.util.HashMap;
import java.util.Map;

class LRUCache
{

    /**
     * ["LRUCache","put","put","get","put","get","put","get","get","get"]
     * [[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
     */
    public static void main(String[] args)
    {
	System.out.println("Test");

	LRUCache cache = new LRUCache(2);

	cache.put(2, 1);
	cache.put(2, 2);
	System.out.println(cache.get(2));

	cache.put(1, 1);
	cache.put(4, 1);
	System.out.println(cache.get(2));

    }

    class Node
    {
	int key, value;
	Node next, previous;

	public Node()
	{
	    super();
	}

	public Node(int k, int v)
	{
	    key = k;
	    value = v;
	}
    }

    private void addNode(Node newNode)
    {
	newNode.previous = end.previous;
	end.previous.next = newNode;
	end.previous = newNode;
	newNode.next = end;
    }

    private void print()
    {
	System.out.println("-------------------");
	System.out.println(cache.keySet());
	System.out.println("LL");
	Node t = end;
	int count = 0;
	while (t != null && count < 10)
	{
	    System.out.print(" " + t.key);
	    t = t.previous;
	    count++;
	}
	System.out.println();
    }

    private void removeNode(Node oldNode)
    {
	oldNode.previous.next = oldNode.next;
	oldNode.next.previous = oldNode.previous;
    }

    private void moveToEnd(Node thisNode)
    {
	removeNode(thisNode);
	addNode(thisNode);
    }

    Node front, end;
    Map<Integer, Node> cache = new HashMap<Integer, Node>();
    int capacity, size;

    public LRUCache(int c)
    {
	capacity = c;
	size = 0;
	front = new Node();
	end = new Node();
	front.next = end;
	end.previous = front;
    }

    public int get(int key)
    {
	if (cache.get(key) == null)
	    return -1;
	
	moveToEnd(cache.get(key));
	
	// print();
	return cache.get(key).value;
    }

    public void put(int k, int v)
    {
	Node newNode = new Node(k, v);

	if (cache.get(k) != null)
	{
	    cache.get(k).value = v;
	    moveToEnd(cache.get(k));
	} 
	
	else
	{
	    cache.put(k, newNode);
	    addNode(newNode);
	    size++;

	    if (size > capacity)
	    {
		cache.remove(front.next.key);
		removeNode(front.next);
		size--;
	    }
	}
	// print();
    }
    
    /**
     * Using Java library
     */
//    class LRUCache extends LinkedHashMap<Integer, Integer>{
//	    private int capacity;
//	    
//	    public LRUCache(int capacity) {
//	        super(capacity, 0.75F, true);
//	        this.capacity = capacity;
//	    }
//
//	    public int get(int key) {
//	        return super.getOrDefault(key, -1);
//	    }
//
//	    public void put(int key, int value) {
//	        super.put(key, value);
//	    }
//
//	    @Override
//	    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
//	        return size() > capacity; 
//	    }
//	}
}