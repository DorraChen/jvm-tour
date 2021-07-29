package org.fenixsoft.oom;

/**
 * @author dorra
 * @date 2021/3/29 16:05
 * @description 虚拟机栈和本地方法栈测试
 * vm 参数设置:-Xss128k
 */
public class JavaVMStackSOF {
    private int stackLength = 1;
    public void stackLeak() {
        stackLength++;
        stackLeak();
    }
    public static void main(String[] args) throws Throwable {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length:" + oom.stackLength);
            throw e;
        }
        /*
        设置vm 参数之后运行结果:
        java.lang.StackOverflowError
         */
    }
}
