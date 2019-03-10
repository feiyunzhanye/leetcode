import java.lang.reflect.Array;
import java.util.Arrays;

public class algorithm {

    /***
     * 快速排序
     * */
    public static void quickSort(int[] arr,int low,int high){
        int temp ,i,j,t;
        if(low>high){
            return;
        }
        i = low;
        j = high;
        temp = arr[i];
        while(i<j){
            while(arr[j]>=temp&&i<j){
                j--;
            }
            while(arr[i]<=temp&&i<j){
                i++;
            }
            if(i<j){
                t= arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }
        arr[low] = arr[i];
        arr[i] = temp;

        quickSort(arr,low,j-1);
        quickSort(arr,j+1,high);
    }
    /**
     * 二分查找
     *
     * */
    public static int search(int[] a,int x,int low,int high){

        while(low<=high){
            int middle = (low+high)/2;
            if(a[middle]==x){
                return middle;
            }
            if(a[middle]<x){
                low = middle+1;
            }
            else{
                high = middle-1;
            }
        }
        return -1;
    }

    public static int find(int a[],int value){
        int start=0;
        int end=a.length-1;
        while(end>=start){
            int index =(start + end )/2;
            if(a[index]==value){
                return index;
            }else if(a[index]>value){
                end=index-1;
            }else{
                start = index+1;
            }
        }
        return a.length;
    }


    public static void main(String[] args) {

        int[] a = {3,2,5,7,6,4,8};
        int[] b = {2,4,5,6,7,8,9};
        quickSort(a,0,a.length-1);
        int out =  search(b,4,0,b.length-1);
        int out2 = find(b,4);
        System.out.println(Arrays.toString(a));
        System.out.println(out2);
    }
}
