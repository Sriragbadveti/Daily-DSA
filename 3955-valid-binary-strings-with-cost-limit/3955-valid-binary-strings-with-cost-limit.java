class Solution {
      private List<String> ans = new ArrayList<>();
    public List<String> generateValidStrings(int n, int k) {
          solve(n , k , 0 , false , new StringBuilder() , 0 );
          return ans;
    }

    private void solve(int n , int k , int currLength , boolean oneTaken , StringBuilder sb , int cost ){
        
        if (cost > k) return;

        //base cases
        if(currLength == n){
            String s = sb.toString();
            ans.add(s);
            return ;
        }

        if(oneTaken == false){
            sb.append('1');
            solve(n , k , currLength+1 , true , sb  , cost+currLength );
            sb.deleteCharAt(sb.length()-1);

           
        }
        
        sb.append('0');
        solve(n , k , currLength+1 , false , sb , cost);
        sb.deleteCharAt(sb.length()-1);




    }
}