import java.util.Scanner;

public class SmallestArrayElement {

	public static int trap(int[] height) {
	    int n = height.length;

	    if (n < 3) {
	        return 0; // Not enough bars to trap water
	    }

	    int[] leftMax = new int[n];
	    int[] rightMax = new int[n];

	    // Compute the maximum height on the left of each bar
	    leftMax[0] = height[0];
	    for (int i = 1; i < n; i++) {
	        leftMax[i] = Math.max(leftMax[i - 1], height[i]);
	    }

	    // Compute the maximum height on the right of each bar
	    rightMax[n - 1] = height[n - 1];
	    for (int i = n - 2; i >= 0; i--) {
	        rightMax[i] = Math.max(rightMax[i + 1], height[i]);
	    }

	    int trappedWater = 0;

	    // Compute the amount of water trapped on each bar
	    for (int i = 1; i < n - 1; i++) {
	        int barHeight = height[i];
	        int waterHeight = Math.min(leftMax[i], rightMax[i]) - barHeight;
	        if (waterHeight > 0) {
	            trappedWater += waterHeight;
	        }
	    }

	    return trappedWater;
	}

	
	
	public static void main(String[] args)
	{
		
	Scanner sc = new Scanner(System.in);
	
	int a[]= {4,2,0,3,2,5};
	System.out.println(trap(a));
	
}

}

