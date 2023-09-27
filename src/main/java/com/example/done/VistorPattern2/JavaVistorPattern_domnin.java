package com.example.done.VistorPattern2;

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
    long sum = 0;

    public int getResult() {
        return (int) sum;
    }

    public void visitNode(TreeNode node) {
    }

    public void visitLeaf(TreeLeaf leaf) {
        sum += leaf.getValue();
    }
}

class ProductOfRedNodesVisitor extends TreeVis {
    BigInteger prod = BigInteger.ONE;

    public int getResult() {
        return prod.mod(BigInteger.valueOf(1000000007)).intValue();
    }

    public void visitNode(TreeNode node) {
        if (node.getColor() == Color.RED) {
            prod = prod.multiply(BigInteger.valueOf(node.getValue()));
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor() == Color.RED) {
            prod = prod.multiply(BigInteger.valueOf(leaf.getValue()));
        }
    }
}

class FancyVisitor extends TreeVis {
    long evenSum = 0;
    long greenSum = 0;

    public int getResult() {

        return (int) Math.abs(evenSum - greenSum);
    }

    public void visitNode(TreeNode node) {
        if (node.getDepth() % 2 == 0) {
            evenSum += node.getValue();
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor() == Color.GREEN) {
            greenSum += leaf.getValue();
        }
    }
}

public class JavaVistorPattern_domnin {

    public static Tree solve() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        ns = new Node[n + 1]; // ignore 0
        for (int i = 1; i < n + 1; i++) {
            ns[i] = new Node();
            ns[i].val = in.nextInt();
        }

        for (int i = 1; i < n + 1; i++) {
            ns[i].col = in.nextInt() == 1 ? Color.GREEN : Color.RED;
        }
        for (int i = 0; i < n - 1; i++) {
            int from = in.nextInt();
            int to = in.nextInt();
            ns[from].connections.add(to);
            ns[to].connections.add(from);
        }

        Tree ret = buildNode(1, 0, 0);
        return ret;
    }

    static Tree buildNode(int idx, int depth, int parent) {

        Node n = ns[idx];
        if (n.connections.contains(parent)) {
            n.connections.remove(parent);
        }
        if (n.connections.size() != 0) {
            TreeNode ret = new TreeNode(n.val, n.col, depth);
            for (int i : n.connections) {
                ret.addChild(buildNode(i, depth + 1, idx));
            }
            return ret;
        } else {
            return new TreeLeaf(n.val, n.col, depth);
        }
    }

    static Node[] ns;

    static class Node {
        int val;
        Color col;
        HashSet<Integer> connections = new HashSet<>();

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