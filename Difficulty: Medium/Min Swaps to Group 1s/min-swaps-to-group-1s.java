class Solution {
    public int minSwaps(int[] arr) {
        int n = arr.length;
        int i = 0;
        int j = 0;
        int k = 0;
        for (int l = 0; l < n; l++) {
            if (arr[l] == 1) {
                k++;
            }
        }
         if (k == 1) return 0;
         if(k<=0) return -1;
        int minSwap = Integer.MAX_VALUE;
        int zeroCount = 0;
        while (j - i + 1 <= k) {
            if (arr[j] == 0) {
                zeroCount++;
            }
            j++;
        }
        minSwap = zeroCount;
        while (j < n) {
            if (arr[i] == 0) {
                zeroCount--;
            }
            if (arr[j] == 0) {
                zeroCount++;
            }

            minSwap = Math.min(minSwap, zeroCount);
            j++;
            i++;

        }
        return minSwap;
    }
}
