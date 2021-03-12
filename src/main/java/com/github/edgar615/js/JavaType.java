package com.github.edgar615.js;

import org.graalvm.polyglot.Context;

import java.math.BigDecimal;

public class JavaType {
    public static void main(String[] args) {
        Context context =  Context.newBuilder()
                .allowAllAccess(true)
                .build();
        BigDecimal v = context.eval("js",
                "var BigDecimal = Java.type('java.math.BigDecimal');" +
                        "BigDecimal.valueOf(10).pow(20)")
                .asHostObject();
        System.out.println(v);
    }

}
