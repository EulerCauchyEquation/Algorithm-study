package com.backjoon.tree.p1269;

import java.util.*;

/**
 * 백준 1269 : 차집합
 *
 * @author hwun chul
 * @since 20.04.29
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String line = in.nextLine();
        StringTokenizer stk = new StringTokenizer(line);
        int n1 = Integer.parseInt(stk.nextToken());
        int n2 = Integer.parseInt(stk.nextToken());

        line = in.nextLine();
        stk = new StringTokenizer(line);
        int[] a = new int[n1];
        for (int i = 0; i < n1; i++) {
            a[i] = Integer.parseInt(stk.nextToken());
        }

        line = in.nextLine();
        stk = new StringTokenizer(line);
        int[] b = new int[n2];
        for (int i = 0; i < n2; i++) {
            b[i] = Integer.parseInt(stk.nextToken());
        }

        System.out.println(solve(a, b));
    }

    public static int solve(int[] a, int[] b) {
        int n1 = a.length;
        int n2 = b.length;
        Tree<Integer> tree1 = new Tree<>();
        Tree<Integer> tree2 = new Tree<>();

        for (int element : a) {
            tree1.insert(element);
        }
        for (int element : b) {
            tree2.insert(element);
        }

        int count1 = n1;
        for (int element : b) {
            count1 = tree1.search(element) ? --count1 : count1;
        }
        int count2 = n2;
        for (int element : a) {
            count2 = tree2.search(element) ? --count2 : count2;
        }

        return count1 + count2;
    }

    static class Tree<E> {
        private Node<E> root;
        private Comparator<? super E> comparator;
        private int size;

        public Tree() {
            this(null);
        }

        public Tree(Comparator<? super E> comparator) {
            this.comparator = comparator;
        }

        public boolean isEmpty() {
            return size() == 0;
        }

        public int size() {
            return size;
        }

        public void insert(E data) {
            if (root == null) {
                root = new Node<>(data);
                size++;
                return;
            }

            explicitInsert(data);
        }

        private void explicitInsert(E data) {
            Node<E> current = root;

            while (current != null) {
                int comp = compare(data, current.data);

                if (comp < 0) {
                    // to left
                    if (current.left == null) {
                        current.left = new Node<>(data);
                        break;
                    }
                    current = current.left;
                } else if (comp > 0) {
                    // to right
                    if (current.right == null) {
                        current.right = new Node<>(data);
                        break;
                    }
                    current = current.right;
                } else {
                    // already exist value.
                    return;
                }
            }
            size++;
        }

        public boolean search(E data) {
            if (isEmpty()) {
                return false;
            }

            Node<E> current = root;

            while (true) {
                if (current == null) {
                    return false;
                }
                int comp = compare(data, current.data);

                if (comp < 0) {
                    current = current.left;
                } else if (comp > 0) {
                    current = current.right;
                } else {
                    return true;
                }
            }
        }

        @SuppressWarnings("unchecked")
        private int compare(E data1, E data2) {
            return comparator == null
                    ? ((Comparable<? super E>) data1).compareTo(data2)
                    : comparator.compare(data1, data2);
        }

        public void remove(E data) {
            if (isEmpty()) {
                return;
            }

            explicitRemove(data);
        }

        private void explicitRemove(E data) {
            Node<E> current = root;
            Node<E> parent = null;
            boolean isLeftChild = false;

            while (true) {
                if (current == null) {
                    throw new NoSuchElementException();
                }
                int comp = compare(data, current.data);

                if (comp < 0) {
                    parent = current;
                    current = current.left;
                    isLeftChild = true;
                } else if (comp > 0) {
                    parent = current;
                    current = current.right;
                    isLeftChild = false;
                } else {
                    break;
                }
            }

            // transplant(tree, data)
            final Node<E> successor;

            if (current.left == null) {
                successor = current.right;
            } else if (current.right == null) {
                successor = current.left;
            } else {
                successor = getSuccessor(current);
            }

            if (parent == null) {
                root = successor;
            } else if (isLeftChild) {
                parent.left = successor;
            } else {
                parent.right = successor;
            }
            size--;
        }

        private Node<E> getSuccessor(Node<E> delete) {
            Node<E> successor = delete.right;
            Node<E> successorParent = successor;

            while (successor.left != null) {
                successorParent = successor;
                successor = successor.left;
            }

            if (successor != delete.right) {
                successorParent.left = successor.right;
                successor.right = successorParent;
            }
            successor.left = delete.left;

            return successor;
        }

        public Object[] toArrayInOrder() {
            List<Object> list = new ArrayList<>();
            inOrder(root, list);
            return list.toArray();
        }

        private void inOrder(Node<E> node, List<Object> list) {
            // L - D - R
            if (node != null) {
                inOrder(node.left, list);
                list.add(node.data);
                inOrder(node.right, list);
            }
        }

        public Object[] toArrayPreOrder() {
            List<Object> list = new ArrayList<>();
            preOrder(root, list);
            return list.toArray();
        }

        private void preOrder(Node<E> node, List<Object> list) {
            // D - L - R
            if (node != null) {
                list.add(node.data);
                preOrder(node.left, list);
                preOrder(node.right, list);
            }
        }

        private class Node<E> {
            private E data;
            private Node<E> left;
            private Node<E> right;

            public Node(E data) {
                this(data, null, null);
            }

            public Node(E data, Node<E> left, Node<E> right) {
                this.data = data;
                this.left = left;
                this.right = right;
            }
        }
    }
}
