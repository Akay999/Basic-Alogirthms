package DynamicProgrammingAlgo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class DynamicProgrammingAlgo {
	static class FastReader {
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader()
        {
            br = new BufferedReader(
                new InputStreamReader(System.in));
        }
 
        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int nextInt() { return Integer.parseInt(next()); }
 
        long nextLong() { return Long.parseLong(next()); }
 
        double nextDouble()
        {
            return Double.parseDouble(next());
        }
 
        String nextLine()
        {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }


	public static void main(String[] args) throws IOException{

		FastReader Scanner = new FastReader();

		// FOR GETTING THE TEST CASES
		// int testCases = Scanner.nextInt();

		// while(testCases-- > 0){
		// 	//solve();
		// }
		
		System.out.println("Enter number of elements in the array : ");
		int n = Scanner.nextInt();
		System.out.println("Enter " + n + " elements");
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = Scanner.nextInt();
		}
		System.out.println("Enter the target Sum  : ");
		int targetSum = Scanner.nextInt();
		
//		int[][] dp = new int[n + 1][targetSum + 1];
		int[][] map = new int[n][targetSum + 1];
		for(int[] row : map)	Arrays.fill(row, -1);
		System.out.println("Your Answer is : " + funcWithMemoize(arr, targetSum, n - 1, map));
		
	
	}
	
	private static boolean funcWithoutMemoize(int[] arr, int tg, int index) {
		if(index < 0 && tg != 0) return false;
		if(tg == 0) return true;
		if(arr[index] > tg) return funcWithoutMemoize(arr, tg, index - 1);
		else return (funcWithoutMemoize( arr, tg, index - 1 ) || funcWithoutMemoize(arr, tg - arr[index], index - 1) );
	}
	
	private static boolean funcWithMemoize(int[] arr, int tg, int index, int[][] map) {
		
		if(index < 0 && tg != 0) return false;
		
		if(tg == 0) return true;
		
		if(map[index][tg] != -1) {
			if(map[index][tg] == 1) {
				return true;
			}
			else return false;
		}
		
		boolean ans;
		if(arr[index] > tg) ans = funcWithMemoize(arr, tg, index - 1,map);
		else {
			ans = (funcWithMemoize( arr, tg, index - 1, map) || funcWithMemoize(arr, tg - arr[index], index - 1, map) );
		}
		
		map[index][tg] = (ans) ? 1 : 0;
		
		return ans;
	}

	private static void PrintArr(int[] array){
		for(int i : array){
			System.out.print(i + " ");
		}
		System.out.println();
	}
}