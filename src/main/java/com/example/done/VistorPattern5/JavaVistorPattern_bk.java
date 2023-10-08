package com.example.done.VistorPattern5;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
//npstr

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
    private int sum = 0;

    public int getResult() {
        return sum;
    }

    public void visitNode(TreeNode node) {
        //nothing to do here
    }

    public void visitLeaf(TreeLeaf leaf) {
        sum += leaf.getValue();
    }
}

class ProductOfRedNodesVisitor extends TreeVis {
    private BigInteger product = BigInteger.valueOf(1);
    private int mod = (int) Math.pow(10, 9) + 7;

    public int getResult() {
        return product.mod(BigInteger.valueOf(mod)).intValue();
    }

    public void visitNode(TreeNode node) {
        if (node.getColor() == Color.RED) multiply(node.getValue());
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor() == Color.RED) multiply(leaf.getValue());
    }

    private void multiply(int value) {
        product = product.multiply(BigInteger.valueOf(value));
    }
}

class FancyVisitor extends TreeVis {
    private int evenNonLeafNodesSum = 0;
    private int greenLeafNodesSum = 0;

    public int getResult() {
        return Math.abs(evenNonLeafNodesSum - greenLeafNodesSum);
    }

    public void visitNode(TreeNode node) {
        if (node.getDepth() % 2 == 0) evenNonLeafNodesSum += node.getValue();
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor() == Color.GREEN) greenLeafNodesSum += leaf.getValue();
    }
}

public class JavaVistorPattern_bk {
	
    private static int[] colors;

    private static Color color(int c) {
        return colors[c] == 1 ? Color.GREEN : Color.RED;
    }

    private static Tree solve() {
        //read the tree from STDIN and return its root as a return value of this function
        Scanner in;
        try {
            in = new Scanner(new FileReader("src\\hackerrank\\java\\advanced\\javavisitorpattern\\testcase#9"));
        } catch (FileNotFoundException e) {
            in = new Scanner(System.in);
        }
        int n = in.nextInt();
        int[] values = new int[n];
        for (int i = 0; i < n; i++) values[i] = in.nextInt();
        int[] cs = new int[n];
        for (int i = 0; i < n; i++) cs[i] = in.nextInt();
        colors = cs;

        //a node is a node and not a leaf if it shows up more than once in the data
        Map<Integer, Set<Integer>> edges = new HashMap<>();
        for (int i = 1; i < n; i++) {
            int x = in.nextInt();
            int y = in.nextInt();

            //java 8
//            edges.putIfAbsent(x, new HashSet<>());
//            edges.putIfAbsent(y, new HashSet<>());
            //java 7
            if (edges.get(x) == null) edges.put(x, new HashSet<Integer>());
            if (edges.get(y) == null) edges.put(y, new HashSet<Integer>());

            edges.get(x).add(y);
            edges.get(y).add(x);
        }

        //start building the tree with the root
        Map<Integer, Tree> todo = new HashMap<>();
        Tree root;
        if (n > 1)
            root = new TreeNode(values[0], color(0), 0);
        else
            root = new TreeLeaf(values[0], color(0), 0);

        todo.put(1, root);

        while (!todo.isEmpty()) {

            int parentId = todo.keySet().iterator().next();
            Tree parent = todo.remove(parentId);

            Set<Integer> children = edges.get(parentId);
            for (int childId : children) {
                edges.get(childId).remove(parentId);
                Tree child;
                if (!edges.get(childId).isEmpty())
                    child = new TreeNode(values[childId - 1], color(childId - 1), parent.getDepth() + 1);
                else
                    child = new TreeLeaf(values[childId - 1], color(childId - 1), parent.getDepth() + 1);
                todo.put(childId, child);
                ((TreeNode) parent).addChild(child);
            }
        }

        return root;
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