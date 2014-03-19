package com.lancope.node;

import java.util.ArrayList;

public class GNodeGraphWalker {

	public ArrayList<GNode> walkGraph(GNode node) {
		ArrayList<GNode> list = new ArrayList<GNode>();
		if (node.getChildren().length == 0) {
			list.add(node);
		} else {
			for (GNode child : node.getChildren()) {
				list.addAll(walkGraph(child));
			}
			list.add(node);
		}
		return list;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ArrayList paths(GNode node) {
		ArrayList<ArrayList> path = new ArrayList<ArrayList>();
		if (node.getChildren().length == 0) {
			ArrayList<String> singleNode = new ArrayList<String>();
			singleNode.add(node.getName());
			path.add(singleNode);
		} else {
			for (GNode child : node.getChildren()) {
				ArrayList<ArrayList> childPaths = paths(child);
				for (ArrayList<String> childPath : childPaths) {
					childPath.add(0, node.getName());
					path.add(childPath);
				}
			}
		}
		return path;
	}

	public void printWalkGraph(ArrayList<GNode> walkedGraph)

	{
		for (GNode graph : walkedGraph) {
			System.out.println(graph.getName());
		}
	}

	@SuppressWarnings("rawtypes")
	public void printWalkPath(ArrayList<ArrayList> paths)

	{
		StringBuilder pathOutputString = new StringBuilder();
		pathOutputString.append("Paths(");
		pathOutputString.append(paths.get(0).get(0).toString());
		pathOutputString.append(") = ( ");
		for (ArrayList path : paths) {
			pathOutputString.append("(");
			for (Object nodeName : path) {
				pathOutputString.append(nodeName);
				pathOutputString.append(" ");
			}
			pathOutputString.append(") ");
		}
		pathOutputString.append(" )");

		System.out.println(pathOutputString.toString());
	}

}
