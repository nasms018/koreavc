package www.dream.graph.model;

import java.util.Set;
import java.util.TreeSet;

/**
 * Node. 도시. 갈랫길 
 */
public class Vertex {
	private String name;
	private Set<Edge> setEdge = new TreeSet<>();

	public Vertex(String string) {
		name = string;
	}

	public String getName() {
		return name;
	}

	/** 도시에서 연결된 모든 길 */
	public Set<Edge> getSetEdge() {
		return setEdge;
	}

	/**
	 * 도시에서 연결된 길 
	 * @param edge
	 */
	public void addEdge(Edge edge) {
		setEdge.add(edge);
	}
	
	
}
