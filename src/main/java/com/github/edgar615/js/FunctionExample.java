package com.github.edgar615.js;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FunctionExample {
    public static void main(String[] args) throws ScriptException, NoSuchMethodException, IOException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("graal.js");
        String scriptPath = "D:/workspace/graaljs-example/src/main/resources/calculator.js";

        Path path = new File(scriptPath).toPath();
        String calculatorScript = new String(Files.readAllBytes(path));
        System.out.println(calculatorScript);

        Invocable inv = (Invocable) engine;

//        Context context = Context.create();
//        context.eval("js", calculatorScript);
//        result = inv.invokeMethod(fn, "call", fn);
//        System.out.println(result);

        engine.eval(calculatorScript);
        Object calculator = engine.get("calculator");
        System.out.println(calculator);

        int x = 3;
        int y = 4;
        Object addResult = inv.invokeMethod(calculator, "add", x, y);
        Object subResult = inv.invokeMethod(calculator, "subtract", x, y);
        Object mulResult = inv.invokeMethod(calculator, "multiply", x, y);
        Object divResult = inv.invokeMethod(calculator, "divide", x, y);

        System.out.println(addResult);
        System.out.println(subResult);
        System.out.println(mulResult);
        System.out.println(divResult);

        System.out.println(inv.invokeMethod(calculator, "testFile"));
    }
}
