package com.zhw.leetcode.array;

/**
 * @author: zhaihongwei
 * @date: 2018/7/26 9:54
 * @Description:
 *
 * 题目：给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 *
 *  示例 1:
    输入: [1,2,3,4,5,6,7] 和 k = 3
    输出: [5,6,7,1,2,3,4]
    解释:
    向右旋转 1 步: [7,1,2,3,4,5,6]
    向右旋转 2 步: [6,7,1,2,3,4,5]
    向右旋转 3 步: [5,6,7,1,2,3,4]

    示例 2:
    输入: [-1,-100,3,99] 和 k = 2
    输出: [3,99,-1,-100]
    解释:
    向右旋转 1 步: [99,-1,-100,3]
    向右旋转 2 步: [3,99,-1,-100]

    说明:
    尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
    要求使用空间复杂度为 O(1) 的原地算法。
 *
 */
public class Rotate {

    public static void rotate(int[] nums, int k) {
        long first = System.currentTimeMillis();
        System.out.println(first);
        if (nums == null || k == 0 || k == nums.length) {
            return;
        }
        // 空间复杂度为O(1)
        int temp = 0;
        while ( k > 0) {
            // 每次将最后一位和前一位数值交换
            temp = nums[nums.length - 1];
            for (int i = nums.length - 2;i >= 0 ; i--) {
                nums[i + 1] = nums[i];
            }
            // 每次将最位的赋值为第一个
            nums[0] = temp;
            k --;
        }
        long last = System.currentTimeMillis();
        System.out.println(last);
        System.out.println(last-first);
        for (int num : nums) {
            System.out.print(num + ",");
        }
    }

    public static void rotate2(int[] nums, int k) {
        if (nums.length == 0) {
            return;
        }

        k = k % nums.length;//当k小于nums.length时，余数为k本身；相等时k为0
        //假设nums=[1,2,3,4,5,6,7] k=3
        reverse(nums, 0, nums.length - k - 1);//反转（不包含后面k位元素） nums=[4,3,2,1,5,6,7]
        reverse(nums, nums.length - k, nums.length - 1);//反转后面k位元素  nums=[4,3,2,1,7,6,5]
        reverse(nums, 0, nums.length - 1);//所有的数再来一次反转  nums=[5,6,7,1,2,3,4]

        for (int num : nums) {
            System.out.print(num + ",");
        }
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }


    public static void main(String[] args) {
        int[] nums = {-1,-100,3,99};
        int k = 2;
        rotate2(nums,k);
    }
}
