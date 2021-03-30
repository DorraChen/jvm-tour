package org.fenixsoft.classloading.v1;

/**
 * @author dorra
 * @date 2021/3/30 14:48
 * @description
 */
public class SubClass extends SuperClass {
    static {
        System.out.println("SubClass init！");
    }
}