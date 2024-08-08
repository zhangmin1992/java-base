package com.my.java.suanfa.shuzu;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 功能描述: 数组中有一个数字出现次数超过数组长度的一半，请找出这个数字。
 *
 * 边界条件或异常：
 *
 * 数组为空或只有一个元素，或数组中没有数字超过数组长度的一半。
 *
 * 方法一：对数组排序，排序后如果数组存在这个数字，那么中位数必定是出现次数超过一半的数字。
 * 接下来去统计数组中跟arr[mid]值一样的元素，相等count++;如果count的值大于mid，则说明存在输出，否则返回0；
 */
public class moreThanHalfNum {

    public static void main(String[] args) {
        int[] arr = new int[] {1, 4, 31, 2, 67, 88, 32, 32, 4, 2, 2, 2, 2};
        System.out.println(solution4(arr));
    }

    public static int solution4(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        int index = partition(arr, low, high);
        while (index != arr.length / 2) {
            if (index < arr.length / 2) {
                low = index + 1;
                index = partition(arr, low, high);
            } else {
                high = index - 1;
                index = partition(arr, low, high);
            }
        }
        //统计找出来的数字的出现次数
        int num = arr[index];
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                count++;
            }
        }
        //出现的次数超过mid，则返回它；
        if (count > arr.length / 2) {
            return num;
        }
        return 0;
    }

    public static int solution1(int[] arr) {
        //利用map的key value模型来存放arr[i]和相对应出现的次数
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);//已经存在就给value加1
            } else {
                map.put(arr[i], 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > arr.length / 2) {
                return entry.getKey();
            }
        }
        return 0;
    }

    public static int partition(int[] arr, int low, int high) {
        int key = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= key) {
                high--;
            }
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            while (low < high && arr[low] <= key) {
                low++;
            }
            temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
        }
        return low;
    }

    public static int solution2(int[] arr) {
        //先对数组排序，如果这个数存在，那它一定在arr[mid]的位置，
        Arrays.sort(arr);
        int count = 0;
        int mid = arr.length / 2;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == arr[mid]) {
                count++;
            }
        }
        //出现的次数超过mid，则返回它；
        if (count > mid) {
            return arr[mid];
        }
        return 0;
    }
}
