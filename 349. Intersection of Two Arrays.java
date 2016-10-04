public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
        List<Integer> result = new ArrayList<Integer>();

        for(int i = 0; i < nums1.length; i++){
        	if(!hm.containsKey(nums1[i]))
        		hm.put((Integer)nums1[i], (Integer)nums1[i]);
        }

        for(int i = 0; i < nums2.length; i++){
        	if(hm.containsKey(nums2[i]) && !result.contains(nums2[i]))
        		result.add(nums2[i]);
        }

        int[] result2 = new int[result.size()];
        for(int i = 0; i < result2.length; i++){
        	result2[i] = result.get(i);
        }
        
        return result2; 
    }
}

/*More clear solutions
Use two hash sets

Time complexity: O(n)

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> intersect = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                intersect.add(nums2[i]);
            }
        }
        int[] result = new int[intersect.size()];
        int i = 0;
        for (Integer num : intersect) {
            result[i++] = num;
        }
        return result;
    }
}
Sort both arrays, use two pointers

Time complexity: O(nlogn)

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                set.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] result = new int[set.size()];
        int k = 0;
        for (Integer num : set) {
            result[k++] = num;
        }
        return result;
    }
}
Binary search

Time complexity: O(nlogn)

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums2);
        for (Integer num : nums1) {
            if (binarySearch(nums2, num)) {
                set.add(num);
            }
        }
        int i = 0;
        int[] result = new int[set.size()];
        for (Integer num : set) {
            result[i++] = num;
        }
        return result;
    }
    
    public boolean binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
}
*/

/*Java8 IntStream?
public int[] intersection(int[] nums1, int[] nums2) {
    Set<Integer> intersect = IntStream.of(nums1).boxed()
        .collect(Collectors.toSet());
    intersect
        .retainAll(IntStream.of(nums2).boxed().collect(Collectors.toSet()));
    return intersect.stream().mapToInt(x -> x).toArray();
}
*/