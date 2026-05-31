class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long massi = mass;
        for(int i = 0 ; i<asteroids.length ; i++){
            if(massi>=asteroids[i]){
                massi+=asteroids[i];
            }else{
                return false;
            }
        }
        return true;
    }
}