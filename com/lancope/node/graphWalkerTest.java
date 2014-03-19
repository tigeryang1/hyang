package com.lancope.node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class graphWalkerTest {

	GNode node_graph = buildGraph();
	GNodeGraphWalker graphWalker = new GNodeGraphWalker();

	@Test
	public void testwalkGraph() {

		ArrayList<GNode> walkedGraph = graphWalker.walkGraph(node_graph);

		graphWalker.printWalkGraph(walkedGraph);

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testwalkPath() {

		ArrayList<ArrayList> paths = graphWalker.paths(node_graph);
		graphWalker.printWalkPath(paths);

	}

	public GNode buildGraph() {
		List<GNode> emptyChildren = Collections.emptyList();
		GNode node_D = new GNodeGraph("node-D", emptyChildren);
		GNode node_E = new GNodeGraph("node-E", emptyChildren);
		GNode node_F = new GNodeGraph("node-F", emptyChildren);
		GNode node_G = new GNodeGraph("node-G", emptyChildren);
		GNode node_H = new GNodeGraph("node-H", emptyChildren);

		List<GNode> node_B_Children = new ArrayList<GNode>();
		node_B_Children.add(node_E);
		node_B_Children.add(node_F);
		GNode node_B = new GNodeGraph("node-B", node_B_Children);

		List<GNode> node_C_Children = new ArrayList<GNode>();
		node_C_Children.add(node_G);
		node_C_Children.add(node_H);
		GNode node_C = new GNodeGraph("node-C", node_C_Children);

		List<GNode> rootChildren = Arrays.asList(node_B, node_C, node_D);

		GNode root = new GNodeGraph("node_A", rootChildren);

		return root;
	}

}
