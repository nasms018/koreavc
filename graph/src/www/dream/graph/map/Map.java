package www.dream.graph.map;

import java.util.List;

import www.dream.graph.model.Edge;
import www.dream.graph.model.Graph;
import www.dream.graph.model.Vertex;

public class Map {
	public static void main(String[] args) {
		Graph 대한민국 = new Graph();
		
		/** 대한민국 직할 시 수준의 연결고리 지도 */
		Vertex 서울 = new Vertex("서울");
		대한민국.addVertex(서울);
		Vertex 인천 = new Vertex("인천");
		대한민국.addVertex(인천);
		Vertex 원주 = new Vertex("원주");
		대한민국.addVertex(원주);		
		Vertex 강릉 = new Vertex("강릉");
		대한민국.addVertex(강릉);
		Vertex 춘천 = new Vertex("춘천");
		대한민국.addVertex(강릉);
		Vertex 수원 = new Vertex("수원");
		대한민국.addVertex(강릉);
		Vertex 제천 = new Vertex("제천");
		대한민국.addVertex(제천);
		Vertex 삼척 = new Vertex("삼척");
		대한민국.addVertex(삼척);
		
		Edge e1 = new Edge(서울, 인천, 1);
		Edge e2 = new Edge(서울, 원주, 1.5f);
		Edge e3 = new Edge(서울, 춘천, 1.1f);
		Edge e4 = new Edge(서울, 수원, 0.5f);
		Edge e5 = new Edge(인천, 수원, 0.7f);
		Edge e6 = new Edge(원주, 강릉, 2f);
		Edge e7 = new Edge(원주, 춘천, 1f);
		Edge e8 = new Edge(원주, 제천, 0.3f);
		Edge e9 = new Edge(강릉, 삼척, 1.1f);

		/** 서울에서 출발할 때 DFS Depth First Search */
		List<Vertex> dfsResult = 대한민국.dfs(서울);
		print(dfsResult);

		/** 서울에서 출발할 때 너비 우선 탐색 BFS, Breadth First Search */
		List<Vertex> bfsResult = 대한민국.bfs(서울);
		print(bfsResult);
}

	private static void print(List<Vertex> dfsResult) {
		for (Vertex vertex : dfsResult) {
			System.out.print(vertex.getName() + " ");
		}
		System.out.println();
	}
}
