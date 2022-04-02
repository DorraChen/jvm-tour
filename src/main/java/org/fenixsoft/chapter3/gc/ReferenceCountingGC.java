package org.fenixsoft.chapter3.gc;

/**
 * @author Dorra
 * @date 2021/11/29 17:51
 * @description testGC()方法执行后，objA和objB会不会被GC呢?
 * vm 参数设置:-XX:+PrintGCDetails
 */
public class ReferenceCountingGC {
    public Object instance = null;
    private static final int _1MB = 1024 * 1024;
    /**
     * 这个成员属性的唯一意义就是占点内存，以便能在GC日志中看清楚是否有回收过
     */
    private byte[] bigSize = new byte[2 * _1MB];

    public static void testGC() {
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();
        objA.instance = objB;
        objB.instance = objA;
        objA = null;
        objB = null;
        // 假设在这行发生GC，objA和objB是否能被回收？
        System.gc();
    }

    public static void main(String[] args) {
        testGC();

        /* 查看gc.log(gc日志), 发现虚拟机并没有因为这两个对象互相引用就放弃回收它们，
        这也从侧面说明了Java虚拟机并不是通过引用计数算法来判断对象是否存活的。 */
    }
}
