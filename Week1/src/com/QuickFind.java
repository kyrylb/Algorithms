package com;

/**
 * Created by sagittarius on 14.02.2016.
 */
public class QuickFind {
    private int[] objects;

    public static void main(String[] args) {
        QuickFind m = new QuickFind(10);

        // 7-9 7-0 9-6 8-0 2-6 2-1
        m.union(7, 9);
        m.union(7, 0);
        m.union(9, 6);
        m.union(8, 0);
        m.union(2, 6);
        m.union(2, 1);

        m.print();
    }

    public QuickFind(int number) {
        objects = new int[number];
        for (int i = 0; i < number; i++) {
            objects[i] = i;
        }
    }

    public void union(int p, int q) {
        int i = objects[p];
        int j = objects[q];

        for (int k = 0; k < objects.length; k++) {
            if (objects[k] == i) {
                objects[k] = j;
            }
        }
    }

    public boolean connected(int p, int q) {
        return objects[p] == objects[q];
    }

    public void print() {
        for (int i = 0; i < objects.length; i++) {
            System.out.println(objects[i]);
        }
    }
}

