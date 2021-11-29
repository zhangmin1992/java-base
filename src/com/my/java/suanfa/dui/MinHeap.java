package com.my.java.suanfa.dui;

public class MinHeap {

    // 堆的存储结构 - 数组
    private int[] data;

    //将一个数组传入构造函数， 并转换成一个最小堆，最小的那个元素在堆头
    public MinHeap(int[] data) {
        this.data = data;
        buildHeap();
    }

    /**
     * 完全二叉树只有数组下标小于或等于 (data.length) / 2 - 1 的元素有孩子结点，遍历这些结点。
     * 比如上面的图中，数组有10个元素， (data.length) / 2 - 1的值为4，a[4]有孩子结点，但a[5]没有
     */
    private void buildHeap() {
        for (int i = (data.length / 2) - 1; i >= 0; i--) {
            heapify(i);
        }
    }

    private void heapify(int i) {
        int right = (i + 1) << 1;  //获取右节点数组下标，<< 1相当于乘以2
        int left = ((i + 1) << 1) - 1; //获取左节点数组下标

        int smallest = i;

        // 存在左结点，且左结点的值小于根结点的值
        if (left < data.length && data[left] < data[i]) {
            smallest = left;
        }

        // 存在右结点，且右结点的值小于以上比较的较小值
        if (right < data.length && data[right] < data[smallest]) {
            smallest = right;
        }

        if (i == smallest) {
            return;
        }
        // 交换根节点和左右结点中最小的那个值，把根节点的值替换下去
        int tmp = data[i];
        data[i] = data[smallest];
        data[smallest] = tmp;
        // 由于替换后左右子树会被影响，所以要对受影响的子树再进行heapify
        heapify(smallest);
    }

    /**
     * 获取堆中最小的元素， 根元素
     */
    private int getRoot() {
        if (data.length != 0) {
            return data[0];
        }
        return -1;
    }

    /**
     * 替换根元素并重新heapify
     */
    private void setRoot(int root) {
        data[0] = root;
        heapify(0);
    }

    public static void main(String[] args) {
        //<< 1相当于乘以2
        System.out.println((13 +1) << 1);
        int[] data = new int[]{12, 23, 4, 2, 3, 32, 42, 1, 33, 55, 2, 88, 18, 5, 12};
        int[] topK = topK(data, 8);
        for (int tmp : topK) {
            System.out.println(tmp);
        }
    }

    // 当数据大于堆中最小的数（根节点）时，替换堆中的根节点，再转换成堆
    private static int[] topK(int[] data, int k) {
        int[] topK = new int[k];
        //取前K个元素放到tok 数组中
        System.arraycopy(data, 0, topK, 0, k);
        MinHeap heap = new MinHeap(topK);

        for (int i = k; i < data.length; i++) {
            int root = heap.getRoot();
            if (data[i] > root) {
                heap.setRoot(data[i]);
            }
        }
        return topK;
    }

}
