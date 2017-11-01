package graphSearch;

import java.util.Scanner;

public class TestAdjacencyList {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Graph graph;
		
		graph = new Graph(7, false);
		graph.addEdge(1, 3, 5);
		graph.addEdge(1, 2, 2);
		graph.addEdge(2, 4, 6);
		//graph.addEdge(2, 5, 3);
		graph.addEdge(3, 4, 8);
		//graph.addEdge(3, 5, 3);
		graph.addEdge(3, 6, 4);
		graph.addEdge(4, 7, 2);
		graph.addEdge(2, 5, 3);
		graph.addEdge(3, 5, 3);
		graph.addEdge(5, 6, 3);
		graph.addEdge(5, 7, 2);
		System.out.println(graph);
		System.out.println(graph.bFS(1));
		System.out.println(graph.dFS(2));
		/*
		System.out.print("Please input number of vertex:");
		int num = scanner.nextInt();
		System.out.println("Please choose graph type 0)Undirected, 1)directed:");
		int w = scanner.nextInt();
		
		graph = new Graph(num, (w == 0) ? false:true);
		while (true) {
			System.out.print("1)Insert 2)Delete 3)Show all 4)Quit:");
			int option = scanner.nextInt(), from, to, weight;
			if (option == 1) {
				System.out.println("Edge from:");
				from = scanner.nextInt();
				System.out.println("Edge to:");
				to = scanner.nextInt();
				System.out.println("Weight:");
				weight = scanner.nextInt();
				graph.addEdge(from, to, weight);
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
		*/
		
		System.out.println("Bye!");
	}

}
