package com.github.edgar615.js;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.proxy.ProxyObject;

import java.util.HashMap;
import java.util.Map;

public class Java2JS {
    public static void main(String[] args) {
        Map<String, Object> params = new HashMap<>();
        params.put("name", "Edgar");
        params.put("expr", "2 * 3");
        Context context = Context.create();
        context.getBindings("js").putMember("proxyObj", ProxyObject.fromMap(params));
        context.eval("js", "print(proxyObj.name);" +
                "proxyObj.result = eval(proxyObj.expr)");
        System.out.println(params);

    }
}
