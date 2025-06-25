class Solution {
    public int maximumPopulation(int[][] logs) {
        int[] res = new int[101];

        Arrays.fill(res, 0);

        for(int i=0; i<logs.length; i++){
            int birthIndex = logs[i][0] - 1950;
            int deathIndex = logs[i][1] - 1950;
            res[birthIndex]++;
            res[deathIndex]--;
        }

        int maxYear = 1950, maxPop = res[0];
        for(int i=1; i<res.length; i++){
            res[i] += res[i-1];
            if(res[i] > maxPop){
                maxPop = res[i];
                maxYear = i + 1950;
            }
        }
        return maxYear;

    }
}