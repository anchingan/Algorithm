package graphStructure_AdjacencyList;

public class Node {
	public int vertex;
	private Node link;

	public Node(int vertex) {
		this.vertex = vertex;
	}
	
	public void setLink(Node next) {
		this.link = next;
	}
	
	public Node getLink() {
		return this.link;
	}

}
