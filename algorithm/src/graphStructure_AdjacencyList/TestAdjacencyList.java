package graphStructure_AdjacencyList;

import java.util.Scanner;

public class TestAdjacencyList {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Graph graph;
		System.out.print("Please input number of vertex:");
		graph = new Graph(scanner.nextInt());
		while (true) {
			System.out.print("1)Insert 2)Delete 3)Show all 4)Quit:");
			int option = scanner.nextInt(), from, to;
			if (option == 1) {
				System.out.println("Edge from:");
				from = scanner.nextInt();
				System.out.println("Edge to:");
				to = scanner.nextInt();
				graph.addEdge(from, to);
			}
			else if (option == 2) {
				System.out.println("Edge from:");
				from = scanner.nextInt();
				System.out.println("Edge to:");
				to = scanner.nextInt();
				graph.deleteEdge(from, to);
			}
			else if (option == 3) {
				System.out.println(graph);
			}
			else if (option == 4)
				break;
			else
				System.out.println("Input error!");
		}
		
		System.out.println("Bye!");
	}

}
