class Solution {
    public int romanToInt(String s) {
        int num = 0;
        for(int i = 0 ; i< s.length(); i++){
            int curr = getValue(s.charAt(i));
            if(i+1 < s.length() && curr < getValue(s.charAt(i+1))){
                //any smaller value before a larger value means subtraction
                //eg IV = 4 , IX = 9 I  before V and X
                num -= curr;
            }else{
                num += curr;
            }
        }
        return num;
    }
    int getValue(char c){
         if (c == 'I') return 1;
        if (c == 'V') return 5;
        if (c == 'X') return 10;
        if (c == 'L') return 50;
        if (c == 'C') return 100;
        if (c == 'D') return 500;
        if (c == 'M') return 1000;
        return 0;
    }
}