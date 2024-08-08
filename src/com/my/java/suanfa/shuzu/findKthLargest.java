package com.my.java.suanfa.shuzu;

import com.alibaba.fastjson.JSONObject;

/**
 * 功能描述: 找到数据中第K大的数，因为从0开始排序，所以第K大实际上是K-1大的数字
 */
public class findKthLargest {
    public static void main(String args[]) {
        int[] nums = {13, 9, 5, 9, 5,8, 6, 1, 3};
        quick(nums,0,nums.length-1);
        System.out.println(JSONObject.toJSONString(nums));

        //[1,3,5,5,6,8,9,9,13]
//        int tt = findKthLargest(nums,8);
//        System.out.println(tt);

//        quickSort(nums,0,nums.length-1);
//        (nums);
//        System.out.println(JSONObject.toJSONString(nums));
       // System.out.println(findKthLargestV2(nums,4));
//        System.out.println(JSONObject.toJSONString(findKthLargest(nums, 4)));
    }

    /**
     * 功能描述: 快速排序
     */
    public static void quickSort(int[] arr, int low, int high) {
        int i, j, temp, t;
        //这一段必须有
        if (low > high) {
            return;
        }
        i = low;
        j = high;
        //temp就是基准位
        temp = arr[low];

        while (i < j) {
            //先看右边，依次往左递减
            while (temp <= arr[j] && i < j) {
                j--;
            }
            //再看左边，依次往右递增
            while (temp >= arr[i] && i < j) {
                i++;
            }
            //如果满足条件则交换
            if (i < j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }
            System.out.println(JSONObject.toJSONString(arr));
        }
        //最后将基准为与i和j相等位置的数字交换
        arr[low] = arr[i];
        arr[i] = temp;
        //递归调用左半数组
        quickSort(arr, low, j - 1);
        //递归调用右半数组
        quickSort(arr, j + 1, high);
    }

    //冒泡排序算法
    public static void sort(int[] numbers) {
        //需进行length-1次冒泡
        for(int i=0;i<numbers.length-1;i++)
        {
            for(int j=0;j<numbers.length-1-i;j++)
            {
                if(numbers[j]>numbers[j+1])
                {
                    int temp=numbers[j];
                    numbers[j]=numbers[j+1];
                    numbers[j+1]=temp;
                }
            }
            System.out.println("----" + JSONObject.toJSONString(numbers));
        }
        System.out.println("从小到大排序后的结果是:");
        for(int i=0;i<numbers.length;i++)
            System.out.print(numbers[i]+" ");
    }

    public static int findKthLargestV2(int[] numbers,int k) {
        //需进行length-1次冒泡
        int result = 0;
        for(int i=0;i<numbers.length-1;i++)
        {
            for(int j=0;j<numbers.length-1-i;j++)
            {
                if (j == k) {
                    result = numbers[numbers.length-k];
                    break;
                }
                if(numbers[j]>numbers[j+1])
                {
                    int temp=numbers[j];
                    numbers[j]=numbers[j+1];
                    numbers[j+1]=temp;
                }
            }
            System.out.println("----" + JSONObject.toJSONString(numbers));
        }
        return result;
    }

    static int pation(int[] arr,int low,int high) {
        int temp = arr[low];
        while (low < high) {
            while (low<high && arr[high] >= temp) {
                high--;
            }
            arr[low] =arr[high];//高位的元素放到低位
            while (low<high && arr[low] < temp) {
                low++;
            }
            arr[high] =arr[low];//低位的元素放到高位
        }
        arr[low] = temp;//基准位置的元素放到low上
        return low;
    }

    static void quick(int[] arr,int low,int high) {
        //这句话必须有，否则会报错
        if (low < high) {
            int pation = pation(arr, low, high);
            quick(arr, low, pation - 1);
            quick(arr, pation + 1, high);
        }
    }

    static int quick(int[] arr,int low,int high,int k) {
        int i = low;
        int j = high;
        int temp = arr[low];
        while(i<j) {
            while (i<j && arr[j] >= temp) {
                j--;
            }
            while (i<j && arr[i] <= temp) {
                i++;
            }
            int t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
        }
        //最后将基准为与i和j相等位置的数字交换
        arr[low] = arr[i];
        arr[i] = temp;
        if (i == k) {
            return arr[i];
        } else if (i > k) {
            return quick(arr, low, i - 1, k);
        } else {
            return quick(arr, i + 1, high, k);
        }
    }

    /**
     * 功能描述: 找到数据中第K大的数，因为从0开始排序，所以第K大实际上是K-1大的数字
     */
    public static int findKthLargest(int[] nums, int k) {
        return quick(nums, 0, nums.length - 1, nums.length - k);
    }
}
