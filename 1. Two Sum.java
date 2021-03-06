public class Solution {
    public int[] twoSum(int[] nums, int target) {

		int i;
		int j;
		int[] result = new int[2];
		for(i = 0; i < nums.length-1; i++){
			for(j = i+1; j< nums.length; j++){
				if(nums[i] + nums[j] == target){
					result[0] = i;
					result[1] = j;
				}

			}
		}
		return result;

    }
}

/*Approach #3 (One-pass Hash Table) [Accepted]
public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
        int complement = target - nums[i];
        if (map.containsKey(complement)) {
            return new int[] { map.get(complement), i };
        }
        map.put(nums[i], i);
    }
    throw new IllegalArgumentException("No two sum solution");
}
*/
