package com.github.edgar615.js;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class IntfExample {
    public static void main(String[] args) throws ScriptException, NoSuchMethodException, IOException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("graal.js");
        String scriptPath = "D:/workspace/graaljs-example/src/main/resources/calculator2.js";

        Path path = new File(scriptPath).toPath();
        String calculatorScript = new String(Files.readAllBytes(path));
        System.out.println(calculatorScript);
        engine.eval(calculatorScript);

        Invocable inv = (Invocable) engine;
        Calculator calc = inv.getInterface(Calculator.class);
        System.out.println(calc);

        int x = 3;
        int y = 4;

        System.out.println(calc.add(x, y));
    }
}
