package graphStructure_AdjacencyList;

public class Graph {
	private Node[] nodes;
	private int number, size;

	public Graph(int number) {
		this.number = number;
		this.size = number + 1;
		nodes = new Node[this.size];
	}
	
	public boolean addEdge(int vertexFrom, int vertexTo) {
		if (vertexFrom > number || vertexTo > number) {
			System.out.println("Out of range!");
			return false;
		}
		if (vertexFrom == vertexTo) {
			System.out.println("Self-edge is not available!");
			return false;
		}
		Node current = nodes[vertexFrom];
		if (current == null) {
			nodes[vertexFrom] = new Node(vertexTo);
			return true;
		}
		else {
			Node previous = current;
			while (current != null) {
				if (current.vertex == vertexTo) {
					System.out.println("Input duplicate!");
					return false;
				}
				previous = current;
				current = current.getLink();
			}
			previous.setLink(new Node(vertexTo));
		}
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
	
	@Override
	public String toString() {
		String str = "Vertex:\n{";
		//Vertex
		for (int i = 1; i < size - 1; i++) {
			str += i + ", ";
		}
		str += number + "}\nEdges:\n{";
		//last vertex
		for (int i = 1; i < size; i++) {
			Node current = nodes[i];
			while (current != null) {
				str += String.format("(%d,%d) ", i, current.vertex);
				current = current.getLink();
			}
		}
		str += "}";
		return str;
	}
	
}
