package com.sparta.rp.sorters.binarytree;

import com.sparta.rp.exceptions.ChildNotFoundException;
import com.sparta.rp.sorters.Sorter;

import java.util.Arrays;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BinaryTreeImpl implements BinaryTree, Sorter {
    private static final Logger logger = Logger.getLogger("BinaryTree logger");
    private static ConsoleHandler handler = new ConsoleHandler();


    public static void main(String[] args) {
        logger.addHandler(handler);
        handler.setLevel(Level.OFF);
        logger.setLevel(Level.OFF);

//        int[] unsortedArray = {-1, -14, 6, 21, -65, 15, 3, 100, -10};
//        BinaryTreeImpl binaryTree = new BinaryTreeImpl();
//        int[] sortedArray = binaryTree.sortArray(unsortedArray);


    }

    private Node rootNode;


    public BinaryTreeImpl(int element) {
        rootNode = new Node(element);
    }

    public BinaryTreeImpl() {
    }

    public void addElementToTree(int element) {
        addNodeToTree(rootNode, element);
    }

    @Override
    public int getRootElement() {
        return rootNode.getValue();
    }

    @Override
    public int getNumberOfElements() {
        return countNumberOfElements(rootNode);


    }

    private int countNumberOfElements(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + countNumberOfElements(node.getLeftChild()) + countNumberOfElements(node.getRightChild());


    }

    @Override
    public void addElement(int element) {
        if (rootNode == null) {
            rootNode = new Node(element);

        } else {
            addNodeToTree(rootNode, element);
        }


    }

    @Override
    public void addElements(int[] elements) {
        if (rootNode == null && elements.length >= 1) {
            rootNode = new Node(elements[0]);
        } else if (elements.length >= 1) {
            addNodeToTree(rootNode, elements[0]);
        }
        if (elements.length > 1) {
            for (int element = 1; element < elements.length; element++) {
                addNodeToTree(rootNode, elements[element]);

            }
        }

    }

    public boolean findElement(int element) {
        Node node = findNode(element);
        return node != null;

    }

    @Override
    public int getLeftChild(int element) throws ChildNotFoundException {
        Node node = findNode(element);
        if (node == null) {
            throw new ChildNotFoundException();
        }
        Node leftChild = node.getLeftChild();
        return leftChild.getValue();
    }

    @Override
    public int getRightChild(int element) throws ChildNotFoundException {
        Node node = findNode(element);
        if (node == null) {
            throw new ChildNotFoundException();
        }
        Node rightChild = node.getRightChild();
        return rightChild.getValue();

    }

    @Override
    public int[] getSortedTreeAsc() {
        int[] sortedAscArray = new int[getNumberOfElements()];
        orderAsc(rootNode, sortedAscArray, 0);


        return sortedAscArray;
    }

    public int orderAsc(Node node, int[] array, int index) {
        if (node != null) {
            index = orderAsc(node.getLeftChild(), array, index);
            array[index] = node.getValue();

            if (index < array.length - 1) {
                index++;
                index = orderAsc(node.getRightChild(), array, index);
            }
        }
        return index;

    }

    public int orderDesc(Node node, int[] array, int index) {
        if (node != null) {
            index = orderDesc(node.getRightChild(), array, index);
            logger.log(Level.FINER, "This is the index " + index);

            //System.out.println(node.getValue());
            logger.log(Level.FINER, "This is the value to be inserted at the index " + node.getValue());

            array[index] = node.getValue();
            index++;
            index = orderDesc(node.getLeftChild(), array, index);
        }
        return index;

    }


    @Override
    public int[] getSortedTreeDesc() {
        int[] sortedDescArray = new int[getNumberOfElements()];
        orderDesc(rootNode, sortedDescArray, 0);


        return sortedDescArray;

    }

    private void addNodeToTree(Node node, int element) {
        if (element <= node.getValue()) {
            addToLeftSideOfNode(node, element);
        } else if (element > node.getValue()) {
            addToRightSideOfNode(node, element);
        }
    }

    private void addToRightSideOfNode(Node node, int element) {
        if (node.isRightChildEmpty()) {
            node.setRightChild(new Node(element));
        } else {
            addNodeToTree(node.getRightChild(), element);
        }
    }

    private void addToLeftSideOfNode(Node node, int element) {
        if (node.isLeftChildEmpty()) {
            node.setLeftChild(new Node(element));
        } else {
            addNodeToTree(node.getLeftChild(), element);
        }
    }

    private Node findNode(int element) {
        Node node = rootNode;
        while (node != null) {
            if (element == node.getValue()) {
                return node;
            }
            if (element < node.getValue()) {
                node = node.getLeftChild();
            } else if (element > node.getValue()) {
                node = node.getRightChild();
            }
        }
        return null;
    }

    @Override
    public int[] sortArray(int[] arrToSort) {
        addElements(arrToSort);
        int[] sortedAscArray = new int[arrToSort.length];
        //System.out.println(getNumberOfElements());

        orderAsc(rootNode, sortedAscArray, 0);
        logger.log(Level.INFO, "This is the array to sort" + Arrays.toString(arrToSort));
        logger.log(Level.INFO, "This is the sorted array" + Arrays.toString(sortedAscArray));
        //System.out.println(Arrays.toString(sortedAscArray));

        return sortedAscArray;
    }
}
