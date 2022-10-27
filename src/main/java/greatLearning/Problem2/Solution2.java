package greatLearning.Problem2;

import java.util.Stack;

public class Solution2 {

    //static Deque<Integer> stack = new ArrayDeque<Integer>();
    static Stack<Integer> stack = new Stack<>();

    public Solution2(int[] data, int targetSum) {
        Node root = null;
        root = insertNode(root, data[0]);
        for (int i = 1; i < data.length; i++) {
            insertNode(root, data[i]);
        }
        inOrder(root);
        pairExist(targetSum);
        //System.out.println(pairExist());

    }

    static Node createNode(int data) {
        Node newNode = new Node();

        newNode.data = data;
        newNode.left = null;
        newNode.right = null;

        return newNode;
    }

    Node insertNode(Node root, int data) {
        Node newNode = createNode(data);
        Node movingNode = root;
        Node refToPrev = null;
        while (movingNode != null) {
            refToPrev = movingNode;
            if (data < movingNode.data) {
                movingNode = movingNode.left;
            } else if (data > movingNode.data) {
                movingNode = movingNode.right;
            } else {
                System.out.println("Duplicate Value");
            }
        }
        if (refToPrev == null) {
            refToPrev = newNode;
        } else if (data < refToPrev.data) {
            refToPrev.left = newNode;
        } else {
            refToPrev.right = newNode;
        }
        return refToPrev;
    }

    public void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            stack.add(node.data);
            //System.out.print(node.data + " ");
            inOrder(node.right);
        }
    }

    void pairExist(int targetSum) {
        //iterate over stack
        int front = 0;
        int rear = stack.size() - 1;
        while (front < rear) {
            int val1 = stack.elementAt(front);
            int val2 = stack.elementAt(rear);
            if ((val1 + val2 == targetSum) && (val1 != val2)) {
                System.out.println("Pair is (" + val1 + "," + val2 + ")");
                return;
            } else if ((val1 + val2 < targetSum) && (val1 != val2)) {
                //increase index for front
                front += 1;
            } else if ((val1 + val2 > targetSum) && (val1 != val2)) {
                //decrease index for rear
                rear -= 1;
            }
        }
        System.out.println("Nodes are not found");
    }

    static class Node {
        int data;
        Node left;
        Node right;
    }
}
