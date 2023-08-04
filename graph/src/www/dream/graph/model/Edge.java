package www.dream.graph.model;

import java.util.Objects;

/**
 * 길, 연결선. Link
 */
public class Edge implements Comparable<Edge>{
	private float cost;
	private Vertex start, end;

	public Edge(Vertex start, Vertex end, float cost) {
		this.start = start;
		this.end = end;
		this.cost = cost;
		
		this.start.addEdge(this);
		this.end.addEdge(this);
	}

	public Vertex getOtherVertex(Vertex vertex) {
		return vertex == start ? end : start;
	}

	@Override
	public int compareTo(Edge obj) {
		if (this == obj)
			return 0;
		if (obj == null)
			return 1;
		return ((Float)cost).compareTo(obj.cost);
	}
}
