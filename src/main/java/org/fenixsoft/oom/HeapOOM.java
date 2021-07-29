package org.fenixsoft.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dorra
 * @date 2021/3/29 14:47
 * @description Java堆内存溢出异常测试
 * vm 参数设置:-Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 */
public class HeapOOM {
    static class OOMObject {
    }
    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<OOMObject>();
        while (true) {
            list.add(new OOMObject());
        }
        /*
        设置vm 参数之后运行结果:
        java.lang.OutOfMemoryError: Java heap space
         */
    }
}
