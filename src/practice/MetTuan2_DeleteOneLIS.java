package practice;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: zjumic
 * @Date: created at 19:32 2020/3/21
 */
public class MetTuan2_DeleteOneLIS {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] input1 = new int[n];
        int result = 0;
        for(int i=0; i<n; i++) input1[i] = sc.nextInt(); //输入
        int[] dp = new int[n]; //dp[i] 代表包括第i位置元素的最长子串长度
        Arrays.fill(dp, 1);
        int max = 0;
        //先求出最长子串，再看看删除其他元素后有没有邻接的数字即可
        for(int i=0; i<n-1; i++){
            if(input1[i] < input1[i+1]){
                dp[i+1] += dp[i];
            }
        }
        for(int i=0; i<n; i++){
            if(i == n-1 || dp[i] > dp[i+1]){
                //看左侧有没有可以接上的上升字串
                int Start = i-dp[i]+1;
                int Len = dp[i];
                if(Start-2 >= 0 && input1[Start-2] < input1[Start]){
                    Len += dp[Start-2];
                }
                max = max>Len? max:Len;
                int Len3 = dp[i]-1;
                if(Start-1 >= 0 && Start+1<n && input1[Start-1] < input1[Start+1]){
                    Len3 += dp[Start-1];
                }
                max = max>Len3? max:Len3;
            }
        }
        System.out.println(max);
        //样例1
        //5
        //2 1 3 2 5
        //输出3

        //样例3
        //10
        //1 2 5 3 4 1 8 9 10 5
        //输出：5
    }
}
