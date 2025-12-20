package In.ArraysNHashing;
public class Strings {
    public static void main(String[] args) {
        String str = "abcde";
        str = "bdc";
        String st = "abcde";
        st.concat("hc");
      
        //immutable string abcde will remain same
        /*
        Why? The .concat() method didn't change s1. It created a brand new String object "Hello World" in the heap, 
        but because you didn't assign it to anything, it was immediately lost. s1 still points to the original "Hello". */
        System.out.println(str);//bdc
        System.out.println(st);//abcde

        String s1 = "Java";
       s1 =s1 + "Rules";
         System.out.println(s1); // Output: "JavaRules"
         /*
         Original object "Java" sits in the pool.
         s1 + "Rules" creates a new object "JavaRules" in the heap.
          The variable s1 is updated to point to the new object. The old "Java" object is still there, 
          unchanged, just no longer referenced by s1. 
          */
        st = st + "hc";//this will create new string object and assign to st so change will be reflected
        System.out.println(st);//abcdehc

  
        String s4 = "Hello";
        String part = "He";
        String s2 = part + "llo"; 
        System.out.println(s4 == s2);//false because s2 is created in heap not in string pool
        /*
        The Trick: This looks exactly like Q2, but it behaves differently. Because part is a variable, the compiler cannot guarantee its value will be "He" at runtime. Therefore, it cannot optimize the concatenation.Result: Java performs this concatenation at runtime (usually using StringBuilder), which creates a new object in the Heap, not the Pool. s1 is in the Pool; 
        s2 is in the Heap. Different addresses $\rightarrow$ false. */
        String s3 = "He" + "llo";
        System.out.println(s4 == s3);//true because both s3 and s4 are



        //Pass By Value
           /*       public static void main(String[] args) {
            String s = "Original";
            modify(s);
            System.out.println(s);
        }

        public static void modify(String str) {
            str = str + " Modified";
            }

            */
            //Output: Original ,the method gets a copy of the reference to "Original".

        // Inside modify, the line str = ... creates a new string "Original Modified" and points the local variable str to it.

        // Crucial Point: The original variable s in main still points to "Original". You cannot change where the caller's variable
        //  points from inside a method.



            /*
             String s1 = new String("Java");//created in heap
            String s2 = s1.intern();//reference from string pool
            String s3 = "Java";//reference from string pool

            System.out.println(s1 == s3);//false because s1 is in heap and s3 is in string pool
            System.out.println(s2 == s3); //true because both s2 and s3 are in string pool
            */

            }
}
