package com.wuyazhou.learn.sort;
/**
 * @author wuyzh
 * */
public class Sort {
    /**
     * 冒泡排序
     * */
    public static int[] bubbleSort(int[] array){
        if (array == null|| array.length == 0 || array.length ==1) {
            return array;
        }
        int temp = 0;
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array.length -i - 1; j++){
                if (array[j+1] < array[j]){
                    temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }


    /**
     * 选择排序
     * */
    public static int[] selectionSort(int[] array){
        if (array == null|| array.length == 0 || array.length ==1) {
            return array;
        }
        int minIndex;
        int temp;
        for (int i = 0; i < array.length; i++){
            minIndex = i;
            for (int j = i+1; j < array.length; j++){
                //找到最小的数
                if (array[minIndex] > array[j]){
                    //将最小数的索引保存
                    minIndex = j;
                }
            }
            temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;

        }
        return array;
    }

    /**
     * 直接插入排序
     * */
    public static int[] insertionSort(int[] array){
        if (array == null|| array.length == 0 || array.length ==1) {
            return array;
        }
        int size = array.length;
        int temp = 0;
        int j =0;
        for (int i = 0;i<size;i++){
            temp = array[i];
            for (j = i;j>0 && temp<array[j-1];j--){
                array[j] = array[j-1];
            }
            array[j] = temp;
        }
        return array;
    }

    /**
     * 二分法插入排序
     * */
    public static int[] erFenFaInsertionSort(int[] array){
        if (array == null|| array.length == 0 || array.length ==1) {
            return array;
        }
        for (int i = 0; i < array.length; i++){
            int temp = array[i];
            int left = 0;
            int right = i-1;
            int mid = 0;
            while (left<=right){
                mid = (left+right)/2;
                if (temp<array[mid]){
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }
            for (int j = i-1;j>=left;j--){
                array[j+1] = array[j];
            }

            if (left!= i){
                array[left] = temp;
            }
        }
        return array;
    }


    /**
     * 希尔排序
     * */
    public static int[] shellSort(int[] array){
        if (array == null|| array.length == 0 || array.length ==1) {
            return array;
        }
        int size = array.length;
        int gap = size;
        int temp = 0;
        int j =0;
        while (true){
            gap = gap/2;
            for (int x = 0; x < gap; x++){
                for (int i = x; i < size; i = i+gap){
                    temp = array[i];
                    for (j = i;j>=gap && temp<array[j-gap];j = j-gap){
                        array[j] = array[j-gap];
                    }
                    array[j] = temp;
                }
            }
            if (gap == 1){
                break;
            }
        }
        return array;
    }

    /**
     * 快速排序
     * */
    public static int[] quickSort(int[] array,int start,int end){
        if (array == null|| array.length == 0 || array.length ==1) {
            return array;
        }

        if (start < end){
            int mid = getMiddle(array,start,end);
            quickSort(array,start,mid-1);
            quickSort(array,mid+1,end);
        }
        return array;
    }

    private static int getMiddle(int[] array,int low,int high){
        int temp = array[low];
        while (low < high){
            while (low<high && temp<=array[high]){
                high--;
            }
            array[low] = array[high];
            while (low<high && temp >array[low]){
                low ++;
            }
            array[high] = array[low];
        }
        array[low] = temp;
        return low;
    }

    /**
     * 归并排序
     * */
    public static int[] mergeSort(int[] array,int low, int high){
        int mid = (low+high)/2;
        if (low < high){
            mergeSort(array,low,mid);
            mergeSort(array,mid+1,high);
            merge(array,low,mid,high);
        }
        return array;
    }
    private static int[] merge(int[] array, int low, int mid, int high){
        int temp[] = new int[high-low+1];
        int i = low;
        int j = mid+1;
        int k = 0;
        while (i <= mid && j <= high){
            if (array[i]<array[j]) {
                temp[k++] = array[i++];
            }else {
                temp[k++] = array[j++];
            }
        }
        while (i <= mid){
            temp[k++] = array[i++];
        }

        while (j <= high){
            temp[k++] = array[j++];
        }

        for (int l = 0; l < temp.length; l++){
            array[low+l] = temp[l];
        }

        return array;
    }

}

