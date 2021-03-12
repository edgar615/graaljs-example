package com.github.edgar615.js;

import org.graalvm.polyglot.Context;

public class JSCallJava {
    public static void main(String[] args) {
        Context context = Context.create();
        context.getBindings("js").putMember("user", new User());
         context.eval("js", "print(user.getName());console.log(user.getName())");
        context.eval("js", "user.sayHello('Edgar')");
    }

//    private static Value runScript(String script, Context context) {
//        return context.eval("js", script);
//    }
}
