//TIME COMPLEXITY=O(N)
//SPACE =O(n+1)


class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int c[] = new int[n];
        int freq[]=new int[n+1];
        int count = 0;
        for(int i =0;i<n;i++)
        {
            freq[A[i]]++;
            if(freq[A[i]]==2) count++;

             freq[B[i]]++;
            if(freq[B[i]]==2) count++;

            c[i]=count;
        }
      return c;  
    }
}
