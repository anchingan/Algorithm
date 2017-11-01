package graphSearch;

public class Node {
	public int vertex, weight;
	private Node link;

	public Node(int vertex, int weight) {
		this.vertex = vertex;
		this.weight = weight;
	}
	
	public void setLink(Node next) {
		this.link = next;
	}
	
	public Node getLink() {
		return this.link;
	}

}
