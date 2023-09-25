package service;

import java.util.*;

public class LockingTree {
    private final int[] parent;
    private final List<Integer>[] children;
    private final int[] lock;

    public LockingTree(int[] parent) {
        this.parent = parent;
        this.children = new List[parent.length];
        for (int i = 0; i < parent.length; i++) {
            children[i] = new ArrayList<>();
        }

        for (int i = 1; i < parent.length; i++) {
            children[0].add(i);
        }

        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == -1) {
                for (int j = 0; j < parent.length; j++) {
                    if (j != i) children[i].add(j);
                }
                continue;
            }

            children[parent[i]].add(i);
        }

        lock = new int[parent.length];
    }

    public boolean lock(int num, int user) {
        if (lock[num] == 0) {
            lock[num] = user;
            return true;
        }

        return false;
    }

    public boolean unlock(int num, int user) {
        if (lock[num] == user) {
            lock[num] = 0;
            return true;
        }

        return false;
    }

    public boolean upgrade(int num, int user) {
        if (lock[num] == 0) {
            int p = num;
            while ((p = parent[p]) != -1) {
                if (lock[p] != 0) return false;
            }

            if (!search(num)) {
                return false;
            }

            lock[num] = user;
            return true;
        }

        return false;
    }

    private boolean search(int num) {
        boolean flag = false;
        Queue<Integer> q = new LinkedList<>();
        q.offer(num);

        while (!q.isEmpty()) {
            int i = q.poll();

            if (lock[i] != 0) {
                lock[i] = 0;
                flag = true;
            }

            for (int child : children[i]) {
                q.offer(child);
            }
        }

        return flag;
    }
}
