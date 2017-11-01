package graphSearch;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {
	private Node[] nodes;
	private int number, size;
	private boolean isDirected;

	public Graph(int number, boolean isDirected) {
		this.number = number;
		this.size = number + 1;
		nodes = new Node[this.size];
		this.isDirected = isDirected;
		createNodes();
	}
	
	private void createNodes() {
		for (int i = 0; i < size; i++)
			nodes[i] = new Node(i, 0);
	}
	
	public boolean addEdge(int vertexFrom, int vertexTo, int weight) {
		boolean result = doAddEdge(vertexFrom, vertexTo, weight);
		
		if (!isDirected) {
			if (result)
				doAddEdge(vertexTo, vertexFrom, weight);
		}
		return result;
	}
	
	private boolean doAddEdge(int vertexFrom, int vertexTo, int weight) {
		if (vertexFrom > number || vertexTo > number) {
			System.out.println("Out of range!");
			return false;
		}
		if (vertexFrom == vertexTo) {
			System.out.println("Self-edge is not available!");
			return false;
		}
		Node current = nodes[vertexFrom];
		Node previous;
		current.weight++;
		previous = current;
		while (current != null) {
			if (current.vertex == vertexTo) {
				System.out.println("Input duplicate!");
				return false;
			}
			previous = current;
			current = current.getLink();
		}
		previous.setLink(new Node(vertexTo, weight));
		return true;
	}
	
	public boolean deleteEdge(int vertexFrom, int vertexTo) {
		Node current = nodes[vertexFrom], previous = current, first = current;
		if (current == null)
			return false;
		do {
			if (current.vertex == vertexTo) {
				previous.setLink(current.getLink());
				if (current == first)
					nodes[vertexFrom] = current.getLink();
				return true;
			}
			previous = current;
			current = current.getLink();
		} while(current != null);
		return false;
	}
	
	public String bFS(int vertex) {
		int[] visited = new int[size];
		String str = "";
		for (int i = 0; i < size; i++)
			visited[i] = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(vertex);
		visited[vertex] = 1;
		str += vertex + ", ";
		Node current = nodes[vertex].getLink();
		while(true) {
			while (current != null) {
				int i = current.vertex;
				if (visited[i] == 0) {
					str += i +", ";
					q.offer(i);
					visited[i] = 1;
				}
				current = current.getLink();
			}
			Integer c = q.poll();
			if (c == null)
				break;
			current = nodes[c].getLink();
		}
		str = str.substring(0, str.length()-2);
		return str;
	}
	
	public String dFS(int vertex) {
		String str = "";
		int[] visited = new int[size];
		for (int i = 0; i < size; i++)
			visited[i] = 0;
		Stack<Integer> s = new Stack<Integer>();
		s.push(vertex);
		visited[vertex] = 1;
		str += vertex +", ";
		Node current = nodes[vertex].getLink();
		while(!s.isEmpty()) {
			while (current != null) {
				int i = current.vertex;
				if (visited[i] == 0) {
					visited[i] = 1;
					str += i + ", ";
					s.push(i);
					current = nodes[i].getLink();
				}
				else
					current = current.getLink();
			}
			current = nodes[s.pop()].getLink();
		}
		str = str.substring(0, str.length()-2);
		return str;
	}
	
	
	@Override
	public String toString() {
		String str = "";
		str += (isDirected)? "1 ":"0 ";
		str += (number) + "\n";
		
		for (int i = 1; i < size; i++) {
			Node current = nodes[i];
			while (current != null) {
				str += String.format("%d %d\n", current.vertex, current.weight);
				current = current.getLink();
			}
		}
		return str;
	}
	
}
