/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo;

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

class SumInLeavesVisitor extends TreeVis {
	int result;

	public int getResult() {
		// implement this
		return result;
	}

	public void visitNode(TreeNode node) {
		result = result + node.getValue();
		// implement this
	}

	public void visitLeaf(TreeLeaf leaf) {
		// implement this
		result = result + leaf.getValue();

		System.out.println(leaf.getValue());
		System.out.println(leaf.getColor());
		System.out.println(leaf.getDepth());
	}
}

class ProductOfRedNodesVisitor extends TreeVis {
	int result;

	public int getResult() {
		// implement this
		return result;
	}

	public void visitNode(TreeNode node) {
		// implement this
	}

	public void visitLeaf(TreeLeaf leaf) {
		// implement this
	}
}

class FancyVisitor extends TreeVis {
	int result;

	public int getResult() {
		// implement this
		return result;
	}

	public void visitNode(TreeNode node) {
		// implement this
	}

	public void visitLeaf(TreeLeaf leaf) {
		// implement this
	}
}

public class JavaVistorPattern {
	static Scanner in;
	static int nNodes = 0;
	static int myDepth = 0;
	static Tree root = null;
	static TreeNode n;
	static TreeLeaf l;
	static List<Integer> valoresList = new ArrayList<Integer>(nNodes);
	static List<Color> colorsList = new ArrayList<Color>(nNodes);
	static List<Integer> uList = new ArrayList<Integer>(nNodes);
	static List<Integer> vList = new ArrayList<Integer>(nNodes);
	static List<Integer> differences;
	static Map<Integer, Set<Integer>> nodesRelationMap = new HashMap<>();

	public static Tree solve() {
		// read the tree from STDIN and return its root as a return value of this
		// function
		try {
			in = new Scanner(System.in);
			nNodes = in.nextInt();

			// adding values array
			for (int i = 0; i < nNodes; i++) {
				int num = in.nextInt();
				valoresList.add(num);
			}

			// adding color array
			for (int i = 0; i < nNodes; i++) {
				int num = in.nextInt();
				colorsList.add(num == 0 ? Color.RED : Color.GREEN);
			}

			// Tree Structure
			for (int i = 0; i < nNodes - 1; i++) {
				int u = in.nextInt();
				uList.add(u);

				int v = in.nextInt();
				vList.add(v);
			}
			differences = new ArrayList<>(vList);
			differences.removeAll(uList);

			if (nNodes == 1) {
				root = new TreeLeaf(valoresList.get(0), colorsList.get(0), 0);

			} else {

				TreeNode t = new TreeNode(valoresList.get(0), colorsList.get(0), 0);

				root = generateTree(t);
			}

		} finally {
		}

		in.close();
		/*
		 * TreeNode root = new TreeNode((int) vList.get(0), (Integer) nColors.get(0) ==
		 * 0 ? Color.GREEN : Color.RED, 1);
		 * // for (int i = 0; i < nNodes; i++) {
		 * // }
		 * 
		 * TreeNode n = new TreeNode(1, Color.GREEN, root.getDepth() + 1);
		 * TreeLeaf l = new TreeLeaf(3, Color.RED, root.getDepth() + 1);
		 * n.addChild(new TreeLeaf(2, Color.GREEN, root.getDepth() + 1));
		 * root.addChild(n);
		 * root.addChild(l);
		 * root.addChild(l);
		 */
		return root;
	}

	private static Tree generateTree(TreeNode tree) {
		int i = 0;
		do {
			// for (int j = i; j < uList.lastIndexOf(i); j++) {}

			System.out.println("u: " + uList.get(i) + "\t v: " + vList.get(i));
			i++;
		} while (i < (uList.size()));
		return tree;
	}

	private static Tree recurciveTree(int i, int valor, Color color, int depth) {
		System.out.println("vuelta: " + depth);
		if (differences.contains(depth)) {
			System.out.println(depth + " hoja");
		} else {
			if (depth == 0) {
				System.out.println(depth + " nodo raiz");
			} else {
				System.out.println(depth + " nodo");
			}
		}

		depth++;
		if (depth == nNodes - 1) {
			System.out.println(depth + " hoja final");
			return new TreeLeaf(
					(int) valoresList.get(depth),
					colorsList.get(depth),
					depth);

		} else {
			return recurciveTree(
					i,
					valoresList.get(depth),
					colorsList.get(depth),
					depth);
		}
	}

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