//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().trim().split(" ");
            int k = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);

            int[] ans = new Solution().printKClosest(arr, n, k, x);
            for (int xx : ans) {
                System.out.print(xx + " ");
            }
            System.out.println();
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


class Solution {
    int[] printKClosest(int[] arr, int n, int k, int x) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> {
            if (b[0] != a[0])
                return b[0] - a[0]; // sort by absolute difference descending
            else
                return a[1] - b[1]; // for equal diff, higher number first
        });

        for (int num : arr) {
            if (num == x) continue; // exclude x itself

            int diff = Math.abs(num - x);
            maxHeap.offer(new int[]{diff, num});
            if (maxHeap.size() > k) {
                maxHeap.poll(); // remove farthest
            }
        }

        List<Integer> list = new ArrayList<>();
        while (!maxHeap.isEmpty()) {
            list.add(maxHeap.poll()[1]);
        }

        // Now sort list again based on required order:
        list.sort((a, b) -> {
            int diffA = Math.abs(a - x);
            int diffB = Math.abs(b - x);
            if (diffA != diffB) return diffA - diffB;
            return b - a; // higher value first if same diff
        });

        // Convert to array
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}


