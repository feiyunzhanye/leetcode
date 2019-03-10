import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class leetcode {
    public static int findJudge(int N, int[][] trust) {
        int[] trust2 = new int[N];
        int[] trust3 = new int[N];
        if(N==1&&trust.length==0){
            return 1;
        }
        for(int i=0;i<trust.length;i++){
            trust2[trust[i][1]] = trust2[trust[i][1]]+1;
            trust3[trust[i][0]] = trust3[trust[i][0]]+1;
        }
        for(int i = 0;i<trust2.length;i++){
            if(trust2[i]==N-1&&(trust3[i]==0)){
                return i;
            }
        }
        return -1;
    }

    public static int numRookCaptures(char[][] board) {
        char[][] uboard = new char[8][8];
        int rocki = -1;
        int rockj =-1;
        int count = 0;
        for(int i =0,j=7;i<8;i++){
            uboard[i][j] = board[j][i];
            if(board[i][j] == 'R'){
                rocki = i;
                rockj= j;
                int m=j-1;
                int n  = j+1;
                int x = i-1;
                int y = i+1;
                while(m>=0||n<=7||x>=0||y<=7){
                    if(m>=0){
                        if(board[i][m]=='p'){
                            count++;
                            m=-1;
                        }
                        if(board[i][m] == '.'){
                            m--;
                        }
                        else{
                            m=-1;
                        }
                    }
                    if(n<=7){
                        if(board[i][n]=='p'){
                            count++;
                            n=8;
                        }
                        if(board[i][n] == '.'){
                            n++;
                        }
                        else{
                            n=8;
                        }
                    }
                    if(x>=0){
                        if(board[x][j]=='p'){
                            count++;
                            x=-1;
                        }
                        if(board[x][j] == '.'){
                            x--;
                        }
                        else{
                            x=-1;
                        }
                    }
                    if(y<=7){
                        if(board[y][j]=='p'){
                            count++;
                            y=8;
                        }
                        if(board[y][j] == '.'){
                            y++;
                        }
                        else{
                            y=8;
                        }
                    }
                }
                return count;
            }
        }
        return 0;
    }

    public static List<String> commonChars(String[] A) {
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        List<String> ss = new ArrayList<String>();
        for(int i=0;i<A.length;i++){
            for(int j=0;j<A[i].length();j++){
                String s = A[i].substring(j,j+1);
                if(map.containsKey(s)){
                    map.put(s,map.get(s)+1);
                }else{
                    map.put(s,1);
                }
                if(map.get(s)==3){
                    map.put(s,0);
                    ss.add(s);
                    System.out.println(s);
                }
            }
        }
        return ss;
    }
    public static boolean isValid(String S) {

        return false;
    }
    public static void main(String[] args){
        int[][] trust = {};
        char [][] board={{'.','.','.','.','.','.','.','.'},{'.','.','.','p','.','.','.','.'},{'.','.','.','R','.','.','.','p'},{'.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.'},{'.','.','.','p','.','.','.','.'},{'.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.'}};
        String[] A  = {"d","c","b","b","a","d","b","d","c","a","c","d","c","c","d","a","b","a","c","d"};
        List<String> ss = commonChars(A);
    }

}
