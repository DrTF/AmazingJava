package sorts;


import jdk.internal.util.xml.impl.Input;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 冒泡、插入、选择
 */
public class Sorts {

    public static int[] bubbleSort(int[] array) {
        if (array.length <= 1) {
            return array;
        }
        for (int i = 0; i < array.length; i++) {

            // 优化: 提前退出标志位
            boolean flag = false;

            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j + 1] < array[j]) {

                    /* 交换变量1  */
//                    int tmp = array[j + 1];
//                    array[j + 1] = array[j];
//                    array[j] = tmp;

                    /* 交换变量2, 因精度问题不适用于浮点数 float、double  */
                    array[j+1] = array[j+1] ^ array[j];
                    array[j] = array[j+1] ^ array[j];
                    array[j+1] = array[j+1] ^ array[j];

                    // 此次冒泡有数据交换
                    flag = true;
                }
            }
            // 没有数据交换提前退出
            if(!flag) break;
        }
        return array;
    }

    // 选择排序，a表示数组，n表示数组大小
    public static void selectionSort(int[] a, int n) {
        if (n <= 1) return;

        for (int i = 0; i < n - 1; ++i) {
            // 查找最小值
            int minIndex = i;
            for (int j = i + 1; j < n; ++j) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            // 交换
            int tmp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = tmp;
        }
    }

    // 插入排序，a表示数组，n表示数组大小
    public static void insertionSort(int[] a, int n) {
        if (n <= 1) return;

        for (int i = 1; i < n; ++i) {
            int value = a[i];
            int j = i - 1;
            // 查找要插入的位置并移动数据
            for (; j >= 0; --j) {
                if (a[j] > value) {
                    a[j+1] = a[j];
                } else {
                    break;
                }
            }
            a[j+1] = value;
        }
    }


    public static int[] insertSort(int[] array){
        if(array.length <= 1){
            return array;
        }
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i];
            int j = i;
            for(; j > 0 && array[j-1] > tmp; j--){
                array[j] = array[j-1];
            }
            //减少交换次数
            array[j] = tmp;
        }
        return array;
    }


    private static int[] shellSort(int[] arr) {
        int len = arr.length;
        if (len == 1) return arr;

        int step = len / 2;
        while (step >= 1) {
            for (int i = step; i < len; i++) {
                int value = arr[i];
                int j = i - step;
                for (; j >= 0; j -= step) {
                    if (value < arr[j]) {
                        arr[j+step] = arr[j];
                    } else {
                        break;
                    }
                }
                arr[j+step] = value;
            }

            step = step / 2;
        }
        return arr;
    }


    public static void main(String[] args) {
        int[] array = {2, 1, 4, 7, 3, 6, 8};
        System.out.println(Arrays.toString(shellSort(array)));
    }
}
