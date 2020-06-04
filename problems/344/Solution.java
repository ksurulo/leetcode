class Solution {
   public void reverseString(char[] s) {
      for(int i=0;i<s.length/2;i++){
         char tmp=s[i];
         s[i]=s[s.length-i-1];
         s[s.length-i-1]=tmp;
      }
   }
   public static void main(String[] args)
   {
      char[] string = {'h','e','l','l','o'};
      Solution solution = new Solution();
      solution.reverseString(string);
   }
}
