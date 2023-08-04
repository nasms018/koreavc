package www.dream.graph.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Graph {
	/** 이 지도에 있는 모든 도시들 */
	private List<Vertex> listVertex = new ArrayList<>();

	public void addVertex(Vertex vertex) {
		listVertex.add(vertex);
	}

	public List<Vertex> dfs(Vertex vertex) {
		Stack<Vertex> 쌓여있는다음방문대상도시들 = new Stack<>();
		쌓여있는다음방문대상도시들.push(vertex);
		
		List<Vertex> 차례로방문한도시목록 = new ArrayList<>();

		while(!쌓여있는다음방문대상도시들.isEmpty()) {
			Vertex 다음도시 = 쌓여있는다음방문대상도시들.pop();
			if (차례로방문한도시목록.contains(다음도시))
				continue;
			차례로방문한도시목록.add(다음도시);
			
			Set<Edge> 모든길 =  다음도시.getSetEdge();
			for (Edge 길 : 모든길) {
				Vertex 다른도시 = 길.getOtherVertex(다음도시);
				if (!차례로방문한도시목록.contains(다른도시))
					쌓여있는다음방문대상도시들.push(다른도시);
			}
		}
		return 차례로방문한도시목록;
	}

	public List<Vertex> bfs(Vertex vertex) {
		Queue<Vertex> 줄지어기다리는다음방문대상도시들 = new LinkedList<>();
		줄지어기다리는다음방문대상도시들.offer(vertex);
		List<Vertex> 차례로방문한도시목록 = new ArrayList<>();

		while(!줄지어기다리는다음방문대상도시들.isEmpty()) {
			Vertex 다음도시 = 줄지어기다리는다음방문대상도시들.poll();
			if (차례로방문한도시목록.contains(다음도시))
				continue;
			차례로방문한도시목록.add(다음도시);

			Set<Edge> 모든길 =  다음도시.getSetEdge();
			for (Edge 길 : 모든길) {
				Vertex 다른도시 = 길.getOtherVertex(다음도시);
				if (!차례로방문한도시목록.contains(다른도시))
					줄지어기다리는다음방문대상도시들.offer(다른도시);
			}
		}

		return 차례로방문한도시목록;
	}
	
	
}
