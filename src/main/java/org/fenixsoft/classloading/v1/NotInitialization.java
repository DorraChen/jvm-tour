package org.fenixsoft.classloading.v1;

/**
 * @author dorra
 * @date 2021/3/30 14:47
 * @description 非主动使用类字段演示
 */
public class NotInitialization {
    public static void main(String[] args) {
        System.out.println(SubClass.value);
        /*
        通过子类引用父类的静态字段，不会导致子类初始化
        -------------------------------------
        执行结果:
        SuperClass init！
        123
        -------------------------------------
        */
    }
}