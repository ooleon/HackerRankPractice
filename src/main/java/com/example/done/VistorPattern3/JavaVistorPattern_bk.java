package com.example.done.VistorPattern3;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

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
      	//implement this
        return result;
    }

    public void visitNode(TreeNode node) {
      	//implement this
    }

    public void visitLeaf(TreeLeaf leaf) {
      	//implement this
        result += leaf.getValue();
    }
}

class ProductOfRedNodesVisitor extends TreeVis {
    private static final long MOD = 1000000007;
    private long product = 1;
    
    public int getResult() {
      	//implement this
        return (int) (product % MOD);
    }

    public void visitNode(TreeNode node) {
      	//implement this
        if (node.getColor().equals(Color.RED)) {
            product = (product * node.getValue()) % MOD;
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
      	//implement this
        if (leaf.getColor().equals(Color.RED)) {
            product = (product * leaf.getValue()) % MOD;
        }
    }
}

class FancyVisitor extends TreeVis {
    private int greenLeafSum = 0;
    private int evenDepthSum = 0;
    
    public int getResult() {
      	//implement this
        return Math.abs(greenLeafSum - evenDepthSum);
    }

    public void visitNode(TreeNode node) {
    	//implement this
        if (node.getDepth() % 2 == 0) {
            evenDepthSum += node.getValue();
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
    	//implement this
        if (leaf.getColor().equals(Color.GREEN)) {
            greenLeafSum += leaf.getValue();
        }
    }
}

public class JavaVistorPattern_bk {

    private static void makeTree(TreeNode[] nodes, int parentId, int childId, HashMap links, int[] values, Color[] colors) {
        ArrayList<Integer> childLink = (ArrayList<Integer>) links.get(childId);
        
        if (childLink.size() == 1){
            nodes[parentId].addChild(new TreeLeaf(values[childId], colors[childId], nodes[parentId].getDepth() + 1));
        }
        else {
            nodes[childId] = new TreeNode(values[childId], colors[childId], nodes[parentId].getDepth() + 1);
            nodes[parentId].addChild(nodes[childId]);
            
            for (int nextChildId: childLink){
                if (nextChildId != parentId){
                    makeTree(nodes, childId, nextChildId, links, values, colors);
                }
            }
        }
    }
	
	public static Tree solve() {

        HashMap links = new HashMap();
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] values = new int[n + 1];
        Color[] colors = new Color[n + 1]; 
        TreeNode[] nodes = new TreeNode[n + 1];
        
        for (int i = 1; i <= n; i++){
            values[i] = scan.nextInt();
            links.put(i, new ArrayList<Integer>());
        }
        
        for (int i = 1; i <= n; i++){
            colors[i] = scan.nextInt() == 1 ? Color.GREEN : Color.RED;
        }
        
        for (int i = 1; i < n; i++){
            int u = scan.nextInt();
            int v = scan.nextInt();
            ArrayList<Integer> linksU = (ArrayList<Integer>) links.get(u);
            linksU.add(v);
            links.put(u, linksU);
            ArrayList<Integer> linksV = (ArrayList<Integer>) links.get(v);
            linksV.add(u);
            links.put(v, linksV);
        }
        
        nodes[1] = new TreeNode(values[1], colors[1], 0);
        ArrayList<Integer> childrenOfRoot = (ArrayList<Integer>) links.get(1);
        
        for (int childId : childrenOfRoot){
            makeTree(nodes, 1, childId, links, values, colors);
        }
        
        return nodes[1];
		
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