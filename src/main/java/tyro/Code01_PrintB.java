package tyro;

/**
 * 新手班
 * 打印整数32位状态
 *
 * @author 金聖聰
 * @version v1.0
 * @email jinshengcong@163.com
 * @date Created in 2021/05/29 18:20
 */
public class Code01_PrintB {
    /**
     * 打印整数的32位是啥
     *
     * @param num 传入的整数
     * @author 金聖聰
     * @email jinshengcong@163.com
     * Modification History:
     * Date         Author        Description        version
     * --------------------------------------------------------*
     * 2021/05/29 18:42    金聖聰     修改原因            1.0
     */
    public static void print(int num) {
        for (int i = 31; i >= 0; i--) {
            // & 运算,全1为1,有0即0
            // | 运算,有1为1,全0才0
            // n << x位 = n*2的x次方
            System.out.print((num & (1 << i)) == 0 ? "0" : "1");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // int底层是32位2进制
        // 在java中都是有符号整型,范围是-2^31 ~ (2^31) - 1
        int num = 1;
        print(num);
    }
}
