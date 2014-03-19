package com.lancope.node;

import java.util.ArrayList;
import java.util.List;


public class GNodeGraph implements GNode {

	private List<GNode> childrenNode = new ArrayList<GNode>();
	private String name = new String();

	public GNodeGraph(String name, List<GNode> children) {

		if (name != null)
			this.name = name;

		if (children != null && children.size() > 0)
			this.childrenNode = children;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public GNode[] getChildren() {
		return this.childrenNode.toArray(new GNode[0]);
	}

	public void addChild(GNode graph) {
		if (isGraphAcyclic(graph)) {
			this.childrenNode.add(graph);
		}
	}

	private boolean isGraphAcyclic(GNode graph) {
		boolean isAcyclic = true;
		if (graph != null) {
			for (GNode child : this.childrenNode) {
				if (graph.getName().equals(child.getName()))
					isAcyclic = false;
			}
		} else
			isAcyclic = false;
		return isAcyclic;

	}

}