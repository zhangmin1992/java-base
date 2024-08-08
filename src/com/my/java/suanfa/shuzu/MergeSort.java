package com.my.java.suanfa.shuzu;

public class MergeSort {

    public void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        sort(arr, 0, arr.length - 1);
    }

    private void sort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        sort(arr, left, mid);
        sort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
        }

        for (i = 0; i < k; i++) {
            arr[left + i] = temp[i];
        }
    }

    // 测试
    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] arr = {4, 3, 2, 10, 12, 1, 5, 6};
        mergeSort.mergeSort(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}

