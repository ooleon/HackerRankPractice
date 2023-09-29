/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.done.VistorPattern;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 *
 * @author leo
 *         https://www.hackerrank.com/challenges/java-vistor-pattern/problem
 */

enum Color {
	RED, GREEN
}

abstract class Tree {

	private int value;
	private Color color;
	private int depth;

	public Tree(int value, Color color, int depth) {
		this.value = value;
		this.color = color;
		this.depth = depth;
	}

	public int getValue() {
		return value;
	}

	public Color getColor() {
		return color;
	}

	public int getDepth() {
		return depth;
	}

	public abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree {

	private ArrayList<Tree> children = new ArrayList<>();

	public TreeNode(int value, Color color, int depth) {
		super(value, color, depth);
	}

	public void accept(TreeVis visitor) {
		visitor.visitNode(this);

		for (Tree child : children) {
			child.accept(visitor);
		}
	}

	public void addChild(Tree child) {
		children.add(child);
	}
}

class TreeLeaf extends Tree {

	public TreeLeaf(int value, Color color, int depth) {
		super(value, color, depth);
	}

	public void accept(TreeVis visitor) {
		visitor.visitLeaf(this);
	}
}

abstract class TreeVis {
	public abstract int getResult();

	public abstract void visitNode(TreeNode node);

	public abstract void visitLeaf(TreeLeaf leaf);

}

/* ---------- */
class SumInLeavesVisitor extends TreeVis {
	private int result = 0;

	public int getResult() {
		/*
		 * Requitement Part I, #1, paragraf 1.
		 * The SumInLeavesVisitor implementation must return the sum of the values in
		 * the tree's leaves only.
		 */
		return result;
	}

	public void visitNode(TreeNode node) {
	}

	public void visitLeaf(TreeLeaf leaf) {
		// implement this
		result = result + leaf.getValue();

		/*
		 * System.out.println(leaf.getValue());
		 * System.out.println(leaf.getColor());
		 * System.out.println(leaf.getDepth());
		 */
	}
}

class ProductOfRedNodesVisitor extends TreeVis {
	private static final long COMPUTED_MODULO = 1000000007;
	private long product = 1;

	public int getResult() {
		/*
		 * Requitement Part I, #1, paragraf 2.
		 * The ProductRedNodesVisitor implementation must return the product of values
		 * stored in all red nodes, including leaves, computed modulo 10^9 + 7. Note
		 * that the product of zero values is equal to 1.
		 */
		return (int) (product % COMPUTED_MODULO);
	}

	public void visitNode(TreeNode node) {
		if (node.getColor().equals(Color.RED)) {
			product = (product * node.getValue()) % COMPUTED_MODULO;
		}
	}

	public void visitLeaf(TreeLeaf leaf) {
		if (leaf.getColor().equals(Color.RED)) {
			product = (product * leaf.getValue()) % COMPUTED_MODULO;
		}
	}
}

class FancyVisitor extends TreeVis {
	private int sumEvenNodes = 0;
	private int sumGreenLeaf = 0;

	public int getResult() {
		/*
		 * Requitement Part I, #1, paragraf 3.
		 * The FancyVisitor implementation must return the absolute difference between
		 * the sum of values stored in the tree's non-leaf nodes at even depth and the
		 * sum of values stored in the tree's green leaf nodes. Recall that zero is an
		 * even number.
		 * Zero is a even number.
		 */
		return (int) Math.abs(sumEvenNodes - sumGreenLeaf);
	}

	public void visitNode(TreeNode node) {
		if (node.getDepth() % 2 == 0) {
			sumEvenNodes += node.getValue();
		}
	}

	public void visitLeaf(TreeLeaf leaf) {
		if (leaf.getColor() == Color.GREEN) {
			sumGreenLeaf += leaf.getValue();
		}
	}
}

public class JavaVistorPattern {
	static Map<Integer, Set<Integer>> nodesRelationMap = new HashMap<>();
	static int[] valuesArray;
	static Color colorsArray[];

	public static Tree solve() {
		int nNodes = 0;
		Tree root = null;

		Scanner in;
		// reading number nodes
		in = new Scanner(System.in);
		nNodes = in.nextInt();

		// adding values array
		valuesArray = new int[nNodes];
		for (int i = 0; i < nNodes; i++) {
			valuesArray[i] = in.nextInt();
		}

		colorsArray = new Color[nNodes];
		// adding color array
		for (int i = 0; i < nNodes; i++)
			colorsArray[i] = (in.nextInt() == 0) ? Color.RED : Color.GREEN;

		if (nNodes == 1) {
			root = new TreeLeaf(valuesArray[0], colorsArray[0], 0);

		} else {

			root = new TreeNode(valuesArray[0], colorsArray[0], 0);

			// Tree Structure
			for (int i = 0; i < nNodes - 1; i++) {

				int u = in.nextInt();
				int v = in.nextInt();
				Set<Integer> uListEdges = nodesRelationMap.get(u);

				if (uListEdges == null)
					uListEdges = new HashSet<>();

				uListEdges.add(v);
				nodesRelationMap.put(u, uListEdges);
				Set<Integer> vListEdges = nodesRelationMap.get(v);

				if (vListEdges == null)
					vListEdges = new HashSet<>();

				vListEdges.add(u);
				nodesRelationMap.put(v, vListEdges);

			}

			for (int nodeid : nodesRelationMap.get(1)) {
				nodesRelationMap.get(nodeid).remove(1);
				generateTree(root, nodeid);
			}
		}

		// close the in
		in.close();

		return root;
	}

	private static void generateTree(Tree parent, int nodeid) {
		Set<Integer> nodeEdges = nodesRelationMap.get(nodeid);
		boolean hasChild = nodeEdges != null && !nodeEdges.isEmpty();
		if (hasChild) {
			TreeNode node = new TreeNode(valuesArray[nodeid - 1], colorsArray[nodeid - 1], parent.getDepth() + 1);
			((TreeNode) parent).addChild(node);
			for (int neighborid : nodeEdges) {
				nodesRelationMap.get(neighborid).remove(nodeid);
				generateTree(node, neighborid);
			}
		} else {
			TreeLeaf leaf = new TreeLeaf(valuesArray[nodeid - 1], colorsArray[nodeid - 1], parent.getDepth() + 1);
			((TreeNode) parent).addChild(leaf);
		}
	}

	/* ---------- */
	public static void main(String[] args) {
		Tree root = solve();
		SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
		ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
		FancyVisitor vis3 = new FancyVisitor();

		root.accept(vis1);
		root.accept(vis2);
		root.accept(vis3);

		int res1 = vis1.getResult();
		int res2 = vis2.getResult();
		int res3 = vis3.getResult();

		System.out.println(res1);
		System.out.println(res2);
		System.out.println(res3);
	}
}