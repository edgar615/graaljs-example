package com.github.edgar615.js;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Value;

import javax.script.ScriptException;

public class HelloWorld2 {

    public static void main(String[] args) throws ScriptException, NoSuchMethodException {
        Context context = Context.create();
        context.eval("js", "print('Hello graal.js')");

        Value function = context.eval("js", "(function(name) {return 'Hello ' + name})");
        String result = function.execute("graal.js").asString();
        System.out.println(result);
    }
}
