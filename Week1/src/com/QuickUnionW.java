package com;

/**
 * Created by sagittarius on 14.02.2016.
 */
public class QuickUnionW {
    private int[] objects;
    private int[] sizes;

    public static void main(String[] args) {
        QuickUnionW m = new QuickUnionW(10);

        // 8-3 4-7 1-0 8-6 8-2 7-0 2-5 6-7 6-9
        m.union(8, 3);
        m.union(4, 7);
        m.union(1, 0);
        m.union(8, 6);
        m.union(8, 2);
        m.union(7, 0);
        m.union(2, 5);
        m.union(6, 7);
        m.union(6, 9);

        m.print();
    }

    public QuickUnionW(int number) {
        objects = new int[number];
        sizes = new int[number];
        for (int i = 0; i < number; i++) {
            objects[i] = i;
            sizes[i] = 1;
        }
    }

    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);

        if (sizes[i] < sizes[j]) {
            objects[i] = j;
            sizes[j] += sizes[i];
        } else {
            objects[j] = i;
            sizes[i] += sizes[j];
        }
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void print() {
        for (int i = 0; i < objects.length; i++) {
            System.out.println(objects[i]);
        }
    }

    private int root(int i) {
        while (objects[i] != i) {
            i = objects[i];
        }
        return i;
    }
}

