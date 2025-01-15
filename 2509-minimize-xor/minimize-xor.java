class Solution {
    public int minimizeXor(int num1, int num2) {
        int setbit = Integer.bitCount(num2);//n to n-1
        int bit = 31;
        int res = 0;
        while(bit>=0 && setbit>0){
            if((num1 & (1 << bit))!= 0){
                res =res | (1 << bit);
                setbit--;
            }
            bit--;
        }

        bit = 0;
        while(setbit>0 && bit<32){
            if((num1 & (1 << bit)) == 0){
                res = res | (1 << bit);
                setbit--;
            }
            bit++;
        }


return res;


    }
}