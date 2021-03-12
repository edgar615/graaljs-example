package com.github.edgar615.js;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Source;
import org.graalvm.polyglot.Value;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class JS2Java {
    public static void main(String[] args) throws IOException {
        Context context = Context.create();
        context.eval("js", "var pi = 3.1415926");
        Double pi = context.getBindings("js").getMember("pi").asDouble();
        System.out.println(pi);

        String scriptPath = "D:/workspace/graaljs-example/src/main/resources/city.js";
        Source citySource = Source.newBuilder("js", new File(scriptPath)).build();
        context.eval(citySource);
        Value value = context.getBindings("js").getMember("city");
        if (value.hasArrayElements()) {
            for (int i = 0; i < value.getArraySize(); i ++) {
                Map map = value.getArrayElement(i).as(Map.class);
                System.out.println(map);
            }
        }
    }
}
