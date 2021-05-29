package tyro;

import java.util.Arrays;

/**
 * 选择排序
 *
 * @author 金聖聰
 * @version v1.0
 * @email jinshengcong@163.com
 * @date Created in 2021/05/29 23:06
 */
public class Code02_AboutSort {
    // 两个值作交换
    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * 选择排序
     *
     * @param arr 需要排序的数组
     * @author 金聖聰
     * @email jinshengcong@163.com
     * Modification History:
     * Date         Author        Description        version
     * --------------------------------------------------------*
     * 2021/05/29 23:39    金聖聰     修改原因            1.0
     */
    private static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 0 ~ n-1 看一遍 把最小的放到下标0
        // 1 ~ n-1 看一遍 把最小的放到下标1
        // 2 ~ n-1 看一遍 把最小的放到下标2
        int length = arr.length;
        for (int i = 0; i < length - 1; i++) { // i是左侧的范围的
            // 0 ~ n-1
            // 1 ~ n-1
            // 2 ~ n-1
            // i ~ n-1
            // 找到最小值的下标,假设第一个是最小的
            int minValueIndex = i;
            // i往后所有的元素都看一遍
            for (int j = i + 1; j < length; j++) {
                // 如果j小于之前的最小值,那最小值的下标就是j,否则不变
                minValueIndex = arr[j] < arr[minValueIndex] ? j : minValueIndex;
            }
            // 最小值找到了 做交换 arr: 数组, i:当前下标, minValueIndex: 最小下标
            swap(arr, i, minValueIndex);
        }
    }

    /**
     * 冒泡排序
     *
     * @param arr 需要排序的数组
     * @author 金聖聰
     * @email jinshengcong@163.com
     * Modification History:
     * Date         Author        Description        version
     * --------------------------------------------------------*
     * 2021/05/29 23:39    金聖聰     修改原因            1.0
     */
    private static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 0 ~ n-1
        // 0 ~ n-2
        // 0 ~ n-3
        // 0 ~ end
        int length = arr.length;
        for (int end = length - 1; end >= 0; end--) { // 确定干事的范围
            // 0 ~ end上干事------
            // 0 1 要不要换;
            // 1 2要不要换;
            // 2 3要不要换;
            // end-1 end 要不要换
            for (int second = 1; second <= end; second++) {
                if (arr[second - 1] > arr[second]) {//第一个数大于第二个数,就交换
                    swap(arr, second - 1, second);
                }
            }
        }
    }

    /**
     * 插入排序 打牌 抽牌插入
     * 第一版
     *
     * @param arr 需要排序的数组
     * @author 金聖聰
     * @email jinshengcong@163.com
     * Modification History:
     * Date         Author        Description        version
     * --------------------------------------------------------*
     * 2021/05/30 0:00    金聖聰     修改原因            1.0
     */
    private static void insertSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 0~0 有序
        // 0~1 有序
        // 0~2 有序
        // 0~length-1 有序
        // 所以描述一个结尾
        int length = arr.length;
        for (int end = 1; end < length; end++) {
            // 新来的数在哪个位置
            int newNumIndex = end;
            while (newNumIndex - 1 >= 0 && arr[newNumIndex - 1] > arr[newNumIndex]) {//左边有数 并且左边的数比自己大 就交换
                swap(arr, newNumIndex - 1, newNumIndex);
                newNumIndex--;
            }
        }
    }

    /**
     * 插入排序第二版
     *
     * @param arr 需要排序的数组
     * @author 金聖聰
     * @email jinshengcong@163.com
     * Modification History:
     * Date         Author        Description        version
     * --------------------------------------------------------*
     * 2021/05/30 0:26    金聖聰     修改原因            1.0
     */
    private static void insertSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 0~0 有序
        // 0~1 有序
        // 0~2 有序
        // 0~length-1 有序
        // 所以描述一个结尾
        int length = arr.length;
        for (int end = 1; end < length; end++) {
            // pre 新数的前一个位置;新数一开始就在end上;前一个数没有越界并且前一个数的值大于后一个数的值
            for (int pre = end - 1; pre >= 0 && arr[pre] > arr[pre + 1]; pre--) {
                swap(arr, pre, pre + 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {9, 1, 5, 3, 0, 6, 7, 4};
        System.out.println("***********选择排序***********");
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println("***********冒泡排序***********");
        arr = new int[]{9, 1, 5, 3, 0, 6, 7, 4};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println("*******插入排序 第 1 版********");
        arr = new int[]{9, 1, 5, 3, 0, 6, 7, 4};
        insertSort1(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println("*******插入排序 第 2 版********");
        arr = new int[]{9, 1, 5, 3, 0, 6, 7, 4};
        insertSort2(arr);
        System.out.println(Arrays.toString(arr));
    }


}
