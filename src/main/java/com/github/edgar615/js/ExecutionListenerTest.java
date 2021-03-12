package com.github.edgar615.js;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.management.ExecutionListener;

public class ExecutionListenerTest {
    public static void main(String[] args) {
        try (Context context = Context.create("js")) {
            ExecutionListener listener = ExecutionListener.newBuilder()
                      .onEnter((e) -> System.out.println(
                              e.getLocation().getCharacters()))
                      .statements(true)
                      .attach(context.getEngine());
            context.eval("js", "for (var i = 0; i < 2; i++);");
            listener.close();
        }
    }
}