package com.github.edgar615.js;

import org.graalvm.polyglot.Context;

import java.util.concurrent.Callable;

public class AccessJavaFromJS {

    public static class MyClass {
        public int               id    = 42;
        public String            text  = "42";
        public int[]             arr   = new int[]{1, 42, 3};
        public Callable<Integer> ret42 = () -> 42;
    }

    public static void main(String[] args) {
        try (Context context = Context.newBuilder()
                                   .allowAllAccess(true)
                               .build()) {
            context.getBindings("js").putMember("javaObj", new MyClass());
            boolean valid = context.eval("js",
                   "    javaObj.id         == 42"          +
                   " && javaObj.text       == '42'"        +
                   " && javaObj.arr[1]     == 42"          +
                   " && javaObj.ret42()    == 42")
               .asBoolean();
            System.out.println("Valid " + valid);
        }
    }
}