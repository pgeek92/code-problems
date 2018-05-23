/**
 * Write a class called User that is used to calculate the amount that a user will progress through a ranking system similar to the one Codewars uses.
 * 
 * Business Rules:
 * 
 * A user starts at rank -8 and can progress all the way to 8.
 * There is no 0 (zero) rank. The next rank after -1 is 1.
 * Users will complete activities. These activities also have ranks.
 * Each time the user completes a ranked activity the users rank progress is updated based off of the activity's rank
 * The progress earned from the completed activity is relative to what the user's current rank is compared to the rank of the activity
 * A user's rank progress starts off at zero, each time the progress reaches 100 the user's rank is upgraded to the next level
 * Any remaining progress earned while in the previous rank will be applied towards the next rank's progress (we don't throw any progress away). The exception is if there is no other rank left to progress towards (Once you reach rank 8 there is no more progression).
 * A user cannot progress beyond rank 8.
 * The only acceptable range of rank values is -8,-7,-6,-5,-4,-3,-2,-1,1,2,3,4,5,6,7,8. Any other value should raise an error.
 * 
 * The progress is scored like so:
 * 
 * Completing an activity that is ranked the same as that of the user's will be worth 3 points
 * Completing an activity that is ranked one ranking lower than the user's will be worth 1 point
 * Any activities completed that are ranking 2 levels or more lower than the user's ranking will be ignored
 * Completing an activity ranked higher than the current user's rank will accelerate the rank progression. The greater the difference between rankings the more the progression will be increased. The formula is 10 * d * d where d equals the difference in ranking between the activity and the user.
 * 
 * Logic Examples:
 * 
 * If a user ranked -8 completes an activity ranked -7 they will receive 10 progress
 * If a user ranked -8 completes an activity ranked -6 they will receive 40 progress
 * If a user ranked -8 completes an activity ranked -5 they will receive 90 progress
 * If a user ranked -8 completes an activity ranked -4 they will receive 160 progress, resulting in the user being upgraded to rank -7 and having earned 60 progress towards their next rank
 * If a user ranked -1 completes an activity ranked 1 they will receive 10 progress (remember, zero rank is ignored)
 * 
 * Code Usage Examples:
 * 
 * User user = new User();
 * user.rank; // => -8
 * user.progress; // => 0
 * user.incProgress(-7);
 * user.progress; // => 10
 * user.incProgress(-5); // will add 90 progress
 * user.progress; // => 0 // progress is now zero
 * user.rank; // => -7 // rank was upgraded to -7
 * Note: In Java some methods may throw an IllegalArgumentException.
 * 
 * Note: Codewars no longer uses this algorithm for its own ranking system. It uses a pure Math based solution that gives consistent results no matter what order a set of ranked activities are completed at.
 * 
 */

package basicProgramming;

import java.util.Map;
import java.util.TreeMap;
public class StyleRankingSystem {

	public static void main(String[] args) {
		User user = new User();
		user.incProgress(7);
		System.out.println(user.rank);
	}
}

class User {
    int rank, progress;
    
    private static final Map<Integer, Integer> rankMap;   
    static {
        rankMap = new TreeMap<>();
        rankMap.put(-8,0);
        rankMap.put(-7,1);
        rankMap.put(-6,2);
        rankMap.put(-5,3);
        rankMap.put(-4,4);
        rankMap.put(-3,5);
        rankMap.put(-2,6);
        rankMap.put(-1,7);
        rankMap.put(1,8);
        rankMap.put(2,9);
        rankMap.put(3,10);
        rankMap.put(4,11);
        rankMap.put(5,12);
        rankMap.put(6,13);
        rankMap.put(7,14);
        rankMap.put(8,15);
        
    }
    
    User() {
        rank = -8;
        progress = 0;
    }
    
    public void incProgress(int kataRank) {
        int difference = getValueFromRank(kataRank) - getValueFromRank(this.rank);
        
        if (difference > 0) this.progress += 10*difference*difference;
        else if (difference == 0) this.progress += 3;
        else if (difference == -1) this.progress += 1;
        
        updateRankAndProgress();
    }
    
    private void updateRankAndProgress() {
        if (this.rank == 8) this.progress = 0;        
        if (this.progress >= 100) {
            int ranksToAdd = (int)(this.progress / 100);
            int overkillProgress = this.progress - ranksToAdd*100;
            int currentRankValue = getValueFromRank(this.rank);
            int newRankValue = currentRankValue + ranksToAdd;
            int newRank = getRankFromValue(newRankValue);            
            
            this.rank = newRank;
            if (newRank == 8) this.progress = 0;
            else this.progress = overkillProgress;            
        }
    }
    
    private int getValueFromRank(int rank) {
        return rankMap.get(rank);
    }
    
    private int getRankFromValue(int value) {
        if (value > 15) return 8;
        
        Integer[] valuesArray = new Integer[rankMap.size()];
        valuesArray = rankMap.keySet().toArray(valuesArray);
        
        return valuesArray[value];
    }
}
