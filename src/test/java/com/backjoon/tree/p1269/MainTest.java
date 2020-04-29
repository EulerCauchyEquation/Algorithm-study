package com.backjoon.tree.p1269;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

/**
 * @author 송훤출
 * @since 20.04.29
 */
public class MainTest {
    private Main.Tree<Integer> tree;

    @Before
    public void setUp() {
        tree = new Main.Tree<>();
    }

    @Test
    public void init() {
        Assert.assertThat(tree.isEmpty(), is(true));
        Assert.assertThat(tree.size(), is(0));
    }

    @Test
    public void testInsert() {
        addElements();

        Assert.assertThat(tree.toArrayInOrder(), is(new Object[]{1, 2, 3, 5}));
        Assert.assertThat(tree.toArrayPreOrder(), is(new Object[]{3, 2, 1, 5}));
        Assert.assertThat(tree.size(), is(4));
    }

    private void addElements() {
        tree.insert(3);
        tree.insert(2);
        tree.insert(5);
        tree.insert(1);
    }

    @Test
    public void testRemove() {
        addElements();
        tree.remove(3);

        Assert.assertThat(tree.toArrayInOrder(), is(new Object[]{1, 2, 5}));
        Assert.assertThat(tree.toArrayPreOrder(), is(new Object[]{5, 2, 1}));
        Assert.assertThat(tree.size(), is(3));
    }

    @Test
    public void 예제1() {
        int[] a = {1, 2, 4};
        int[] b = {2, 3, 4, 5, 6};

        Assert.assertThat(Main.solve(a, b), is(4));
    }
}
