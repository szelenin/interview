package other;

import java.util.DoubleSummaryStatistics;

/**
 * Created by Sergii_Zelenin on 5/20/2016.
 * https://www.youtube.com/watch?v=twaGE43dbu0
 */
public class FromGuy48LSP {
    // Utility functions to get minimum of two integers
    static double min(double x, double y) {
        return x < y ? x : y;
    }

    // Utility functions to get maximum of two integers
    static double max(double x, double y) {
        return x > y ? x : y;
    }

    public static double lsp(double[] arr) {
        int n = arr.length;
        // max positive product ending at the current position
        double max_ending_here = 1;

        // min negative product ending at the current position
        double min_ending_here = 1;

        // Initialize overall max product
        double max_so_far = 1;

        /* Traverse through the array. Following
           values are maintained after the ith iteration:
           max_ending_here is always 1 or some positive product
                           ending with arr[i]
           min_ending_here is always 1 or some negative product
                           ending with arr[i] */
        for (int i = 0; i < n; i++) {
            /* If this element is positive, update max_ending_here.
                Update min_ending_here only if min_ending_here is
                negative */
            if (arr[i] > 0) {
                max_ending_here = max_ending_here * arr[i];
                min_ending_here = min(min_ending_here * arr[i], 1);
            }

            /* If this element is 0, then the maximum product cannot
               end here, make both max_ending_here and min_ending
              _here 0
               Assumption: Output is alway greater than or equal to 1. */
            else if (arr[i] == 0) {
                max_ending_here = 1;
                min_ending_here = 1;
            }

            /* If element is negative. This is tricky
               max_ending_here can either be 1 or positive.
               min_ending_here can either be 1 or negative.
               next min_ending_here will always be prev.
               max_ending_here * arr[i]
               next max_ending_here will be 1 if prev
               min_ending_here is 1, otherwise
               next max_ending_here will be
                           prev min_ending_here * arr[i] */
            else {
                double temp = max_ending_here;
                max_ending_here = max(min_ending_here * arr[i], 1);
                min_ending_here = temp * arr[i];
            }

            // update max_so_far, if needed
            if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;
        }

        return max_so_far;
    }

    static double MaxSubsequentProduct(double[] nums) {
        //as we discussed in slides, we need four support variables
        double globalMaxPos = 0;
        double currPos = 1;
        double currNeg = 1;
        //now we start processing the values in the array
        for (int i = 0; i < nums.length; i++) {
            //we process the K (nums[i]) based on its sign (pos/neg/zero)
            if (nums[i] > 0) {
                currPos *= nums[i];
                if (currNeg != 1)//only update it when it is set before
                    currNeg *= nums[i];
            } else if (nums[i] < 0) {
                //firstly check if the currNeg has been set or not
                if (currNeg == 1) {
                    //The positive value can be computed by using Neg*nums[i]
                    currNeg = currPos * nums[i];
                    //we need set neg value first otherwise we lost the postive so far
                    //in case of neg value not set, the current pos product can be reset!
                    currPos = 1;
                } else {
                    //as we discussed we need set neg=pos*current value and vice versa
                    double tempNeg = currNeg;
                    currNeg = currPos * nums[i];
                    currPos = tempNeg * nums[i];
                }
            } else { //it is 0
                currPos = 1;
                currNeg = 1;//reset both products
            }

            //now check if any current product can be set to global max pos/neg values
            if (currPos > globalMaxPos)
                globalMaxPos = currPos;

            //last step, we need discard the current product if it is less than 1!
            if (currPos < 1)
                currPos = 1;
        }
        //do not forget to return the value
        return globalMaxPos;
    }

}
