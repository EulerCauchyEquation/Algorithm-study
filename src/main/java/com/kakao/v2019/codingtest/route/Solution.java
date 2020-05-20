package com.kakao.v2019.codingtest.route;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2019 KAKAO 블라인드 코딩 테스트 : 길 찾기 게임
 *
 * @author 송훤출
 * @since 20.05.20
 */
public class Solution {

    public static int[][] solution(int[][] nodeinfo) {
        final List<Place> placeList = new ArrayList<>();
        for (int i = 0; i < nodeinfo.length; i++) {
            final Place place = new Place(i + 1, nodeinfo[i][0], nodeinfo[i][1]);
            placeList.add(place);
        }
        placeList.sort((o1, o2) -> o2.y - o1.y);

        final Tree<Place> tree = new Tree<>();
        for (Place place : placeList) {
            tree.add(place);
        }

        final Object[] preOrder = tree.toArrayPreOder();
        final Object[] postOrder = tree.toArrayPostOder();
        final int[] formatPreOrder = Arrays.stream(preOrder)
                .mapToInt(place -> ((Place) place).no)
                .toArray();
        final int[] formatPostOrder = Arrays.stream(postOrder)
                .mapToInt(place -> ((Place) place).no)
                .toArray();
        final int[][] result = new int[2][];
        result[0] = Arrays.copyOf(formatPreOrder, formatPreOrder.length);
        result[1] = Arrays.copyOf(formatPostOrder, formatPostOrder.length);
        return result;
    }

    static class Place implements Comparable<Place> {
        final int no;
        final int x;
        final int y;

        Place(int no, int x, int y) {
            this.no = no;
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Place o) {
            return this.x - o.x;
        }
    }
}

class Tree<E> {
    private Node<E> root;

    public void add(E data) {
        if (root == null) {
            root = new Node<>(data);
            return;
        }

        Node<E> current = root;

        while (true) {
            final int comp = compare(data, current.node);
            if (comp < 0) {
                // to left child
                if (current.left == null) {
                    current.left = new Node<>(data);
                    break;
                }
                current = current.left;
            } else if (comp > 0) {
                // to right child
                if (current.right == null) {
                    current.right = new Node<>(data);
                    break;
                }
                current = current.right;
            } else {
                // value already exist
                throw new AssertionError();
            }
        }
    }

    @SuppressWarnings("unchecked")
    private int compare(E data1, E data2) {
        return ((Comparable<E>) data1).compareTo(data2);
    }

    public Object[] toArrayPreOder() {
        final List<Object> traversal = new ArrayList<>();
        Node<E> current = root;
        preOrder(traversal, current);
        return traversal.toArray();
    }

    private void preOrder(List<Object> traversal, Node<E> current) {
        if (current != null) {
            traversal.add(current.node);
            preOrder(traversal, current.left);
            preOrder(traversal, current.right);
        }
    }

    public Object[] toArrayPostOder() {
        final List<Object> traversal = new ArrayList<>();
        Node<E> current = root;
        postOrder(traversal, current);
        return traversal.toArray();
    }

    private void postOrder(List<Object> traversal, Node<E> current) {
        if (current != null) {
            postOrder(traversal, current.left);
            postOrder(traversal, current.right);
            traversal.add(current.node);
        }
    }

    private static class Node<E> {
        final E node;
        Node<E> left;
        Node<E> right;

        public Node(E node) {
            this(null, node, null);
        }

        Node(Node<E> left, E node, Node<E> right) {
            this.node = node;
            this.left = left;
            this.right = right;
        }
    }
}
