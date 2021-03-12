package com.github.edgar615.js;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Source;
import org.graalvm.polyglot.Value;

import javax.script.ScriptException;
import java.io.File;
import java.io.IOException;

public class LoadFiles {

    public static void main(String[] args) throws ScriptException, NoSuchMethodException, IOException {
        String scriptPath = "D:/workspace/graaljs-example/src/main/resources/calculator2.js";
        File file = new File(scriptPath);
        Source source = Source.newBuilder("js", file).build();
        Context context = Context.create();
        context.eval(source);

        Value addFunc = context.getBindings("js").getMember("add");
        Integer result = addFunc.execute(1, 2).asInt();
        System.out.println(result);

        Value subFunc = context.getBindings("js").getMember("subtract");
        Double result2 = subFunc.execute(5.3, 2).asDouble();
        System.out.println(result2);
    }
}
