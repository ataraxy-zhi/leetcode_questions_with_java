package com.solution.simple.besttimetobuyandsellstock121;

/**
 * @className: BestTimeToBuyAndSellStock
 * @description:
 * @author: j
 * @date: 2020/3/9 21:54
 */
public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {

        int[] arr1={7,1,5,3,6,4};
        int[] arr2={7,6,4,3,1};
        int[] arr3={1};
        int[] arr4={1,4,2};
        int[] arr5={3,2,6,5,0,3};
        int[] arr6={2,1};
        System.out.println(maxProfit(arr6));
    }


    public static int maxProfit(int[] prices) {

        if(prices==null || prices.length==0){
            return 0;
        }

        if(prices.length==2){
            if(prices[0]>prices[1]){
                return 0;
            }else {
                return prices[1]-prices[0];
            }
        }

        int min=prices[0];
        int max=prices[prices.length-1];

        for(int p=1,q=prices.length-2;p-q<=1;p++,q--){
            if(prices[p]<min){
                min=prices[p];
            }
            if(prices[q]>max){
                max=prices[q];
            }
        }

        if(max<=min){
            return 0;
        }else {
            return max-min;
        }

    }

    public static int max(int[] arr){
        int max=arr[0];
        for (int i = 1; i <arr.length-1 ; i++) {
            if(arr[i]>max){
                max=arr[i];
            }

        }
        return max;
    }

    //判断数据是否递减
    public static boolean isDecrease(int[] arr){
        int flag=1;

        for (int i = 0; i <arr.length-2 ; i++) {
            if (arr[i] < arr[i + 1]) {
                flag = 0;
                break;
            }
        }

        if(arr[arr.length-2]<arr[arr.length-1]){
            flag=0;
        }

        return flag == 1;
    }
}
