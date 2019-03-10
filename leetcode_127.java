import java.beans.Expression;

public class leetcode_127 {
    /**
     * 给定一个整数数组 A，我们只能用以下方法修改该数组：我们选择某个个索引 i 并将 A[i] 替换为 -A[i]，然后总共重复这个过程 K 次。（我们可以多次选择同一个索引 i。）
     *
     * 以这种方式修改数组后，返回数组可能的最大和.
     * 输入：A = [4,2,3], K = 1
     * 输出：5
     * 解释：选择索引 (1,) ，然后 A 变为 [4,-2,3]。
     * 思路：既然要获得最大和每次遍历一遍数组找出最小的数将其反转，最后计算数组和
     * */
    public static int largestSumAfterKNegations(int[] A, int K) {
        while(K>0){
            int flag=A[0];
            int j =0;
            for(int i =1;i<A.length;i++){
                if(A[i]<flag){
                    j=i;
                    flag=A[i];
                }
            }
            A[j] = -A[j];
            K--;
        }
        int res =0;
        for(int i=0;i<A.length;i++){
            res = res+A[i];
        }
        return res;
    }
    /**
     *通常，正整数 n 的阶乘是所有小于或等于 n 的正整数的乘积。例如，factorial(10) = 10 * 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1。
     *
     * 相反，我们设计了一个笨阶乘 clumsy：在整数的递减序列中，我们以一个固定顺序的操作符序列来依次替换原有的乘法操作符：乘法(*)，除法(/)，加法(+)和减法(-)。
     *
     * 例如，clumsy(10) = 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1。然而，这些运算仍然使用通常的算术运算顺序：我们在任何加、减步骤之前执行所有的乘法和除法步骤，并且按从左到右处理乘法和除法步骤。
     *
     * 另外，我们使用的除法是地板除法（floor division），所以 10 * 9 / 8 等于 11。这保证结果是一个整数。
     *
     * 实现上面定义的笨函数：给定一个整数 N，它返回 N 的笨阶乘。
     * 输入：10
     * 输出：12
     * 解释：12 = 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1
     *
     * 思路：递归求解，先找出递归的递归体选取7 - 6 * 5 / 4，分两个函数一个加上前置条件（N*(N-1)/(N-2)）,后续执行递归
     * */
    public static int clumsy2(int N){

        if(N==1)return 1;
        if(N==2)return 1;
        if(N==3)return 1;
        if(N==4) return -2;


        int res =N-(N-1)*(N-2)/(N-3);
        N=N-4;
        return res+clumsy2(N);
    }
    public static int clumsy4(int N) {
        if(N==1)return 1;
        if(N==2)return 2;
        if(N==3)return 6;
        if(N==4) return 7;
        int res =N*(N-1)/(N-2)+clumsy2(N-3);
        return res;
    }

/**
 * 别人的写法
 * */
    public static int clumsy3(int N){
        if(N==1)return 1;
        if(N==2)return 2;
        if(N==3)return 6;
        int head=N*(N-1)/(N-2);
        int pos=0,neg=0;
        N-=3;
        int cur=0;
        while (cur<N){
            if(cur%4==0){
                pos+=N-cur;
                cur++;
                continue;
            }
            int p=0;
            while(cur<N&&cur%4!=0){
                if(cur%4==1){
                    p+=N-cur;
                    cur++;
                }else if(cur%4==2){
                    p*=(N-cur);
                    cur++;
                }else {
                    p/=(N-cur);
                    cur++;
                }
            }
            neg+=p;
        }
        return head-neg+pos;
    }


    public static void main(String[] args){
        int[] A = {2,-3,-1,5,-4};
        int K=2;
        int out =largestSumAfterKNegations(A,K);
        int out2 = 10*9/8+clumsy2(10);
        int out3 = clumsy4(10);
        System.out.println(out2);
    }
}
