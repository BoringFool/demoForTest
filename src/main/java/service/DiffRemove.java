package service;

import java.util.Arrays;
import java.util.Scanner;

public class DiffRemove {
    static class Node {
        public int value;
        public Node next;

        public Node(int value, Node node) {
            this.value = value;
            this.next = node;
        }
    }

    static Node diff(Node old) {
        Node result = new Node(0, null), cur = result;
        boolean flag = false;

        while (old != null) {
            if (old.next == null) {//结束
                if (!flag) {
                    cur.next = new Node(old.value, null);
                }
                break;
            } else {
                if (old.value == old.next.value) {
                    old.next = old.next.next;
                    flag = true;
                } else {
                    if (flag) {
                        flag = false;
                    } else {
                        cur.next = new Node(old.value, null);
                        cur = cur.next;
                    }

                    old = old.next;
                }
            }
        }

        return result.next;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] strings = in.nextLine().split(",");
        Node head = new Node(0, null), cur = head;

        for (String s : strings) {
            cur.next = new Node(Integer.parseInt(s), null);
            cur = cur.next;
        }

        Node result = diff(head.next);

        if (result == null)
            System.out.println("不存在不重复节点！");

        for (Node n = result; n != null; n = n.next) {
            System.out.println(n.value);
        }
    }
}
