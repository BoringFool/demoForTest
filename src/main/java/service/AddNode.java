package service;

import java.util.Arrays;

public class AddNode {
    public class Node {
        private Node pre;
        private Node next;

        private int value;

        public Node(Node pre, Node next, int value) {
            this.pre = pre;
            this.next = next;
            this.value = value;
        }
    }

    public Node subtraction(Node first, Node second) {
        Node l1, l2;

        for (l1 = getTailNode(first), l2 = getTailNode(second); l1 != null; ) {
            int diff = l1.value - l2.value;

            //l1为负数或者差值小于0，需要向上借一位
            if (l1.value == -1 || diff < 0) {
                l2.value = diff + 10;
                l1 = l1.pre;
                l1.value--;
            } else {
                l2.value = diff;
                l1 = l1.pre;
            }
            //第二个数可能比第一个数少位数，补0
            l2 = l2.pre == null ? new Node(null, l2, 0) : l2.pre;
        }

        return removeZero(l2);
    }


    public Node getTailNode(Node node) {
        //获取最后一个节点
        return node.next == null ? node : getTailNode(node.next);
    }

    public Node removeZero(Node node) {
        if (node.value == 0 && node.next != null) {
            node = node.next;
            node.pre = null;
        } else {
            return node;
        }
        //移除0节点
        return removeZero(node);
    }

    public static void main(String[] args) {
        int f = 1;
        int s = 5;
        int limit = 5;//生成数大小控制
        AddNode addNode = new AddNode();
        Node first = addNode.new Node(null, null, f);
        Node second = addNode.new Node(null, null, s);
        Node temp1 = first;
        Node temp2 = second;

        //填充数字
        for (int i = limit; i > 0; i--) {
            temp1.next = addNode.new Node(temp1, null, (int) (1 + Math.random() * 9));
            f = f * 10 + temp1.next.value;
            temp1 = temp1.next;
            if (i == limit)
                continue;
            temp2.next = addNode.new Node(temp2, null, (int) (1 + Math.random() * 9));
            s = s * 10 + temp2.next.value;
            temp2 = temp2.next;
        }

        //计算
        temp1 = addNode.subtraction(first, second);

        //遍历结果节点，转为数字
        int r = 0;
        while (temp1 != null) {
            r = r * 10 + temp1.value;
            temp1 = temp1.next;
        }
        System.out.println("f:" + f);//第一个数
        System.out.println("s:" + s);//第二个数
        System.out.println("r:" + r);//结果
    }
}
