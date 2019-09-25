package array;

// 19.盛最多水的容器
// 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
//
//说明：你不能倾斜容器，且 n 的值至少为 2。
public class ContainerWithMostWater_11 {
    public int MaxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int a;
        int b;
        int max = 0;

        while (left < right) {
            a = right - left;
            if (height[left] <= height[right]) {
                b = height[left];
                int s = a * b;
                if (s > max) {
                    max = s;
                }
                left++;
            } else {
                b = height[right];
                int s = a * b;
                if (s > max) {
                    max = s;
                }
                right--;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] height = new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(new ContainerWithMostWater_11().MaxArea(height));
    }
}
