package com.github.edgar615.js;

import org.graalvm.polyglot.HostAccess;

public class User {
    @HostAccess.Export
    public void sayHello(String name) {
        System.out.println("Hello " + name);
    }

    @HostAccess.Export
    public String getName() {
        return "Edagr";
    }
}
