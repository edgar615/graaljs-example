package com.github.edgar615.js;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Source;
import org.graalvm.polyglot.Value;

import javax.script.ScriptException;
import java.io.File;
import java.io.IOException;

public class LoadObject {

    public static void main(String[] args) throws ScriptException, NoSuchMethodException, IOException {
        String scriptPath = "D:/workspace/graaljs-example/src/main/resources/calculator.js";
        File file = new File(scriptPath);
        Source source = Source.newBuilder("js", file).build();
        Context context =  Context.newBuilder()
                .allowAllAccess(true)
                .build();
        context.eval(source);

        Value calculator = context.getBindings("js").getMember("calculator");

        System.out.println(calculator);
        Integer result = calculator.invokeMember("add", 1, 2).asInt();
        System.out.println(result);

        Double result2 = calculator.invokeMember("subtract", 5.3, 2).asDouble();
        System.out.println(result2);
    }
}
