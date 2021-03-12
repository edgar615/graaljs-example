package com.github.edgar615.js;

import javax.script.*;
import java.util.List;

public class HelloWorld {
    static String JS_CODE = "(function myFun(param){print('hello '+param);})";

    public static void main(String[] args) throws ScriptException, NoSuchMethodException {
        List<ScriptEngineFactory> engines = (new ScriptEngineManager()).getEngineFactories();
        for (ScriptEngineFactory f : engines) {
            System.out.println(f.getLanguageName() + " " + f.getEngineName() + " " + f.getNames().toString());
        }
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("graal.js");
        Object result = engine.eval("typeof(1)");
        System.out.println(result);

        // 传参
        String script = "print(msg)";
        engine.put("msg", "Hello graal.js");
        engine.eval(script);

        script = "print(msg.toUpperCase());print(msg.indexOf(\"a\"))";
        engine.put("msg", "graal.js");
        engine.eval(script);

        Object fn = engine.eval("(function() { return this; })");
        Invocable inv = (Invocable) engine;
        result = inv.invokeMethod(fn, "call", fn);
        System.out.println(result);

    }
}
