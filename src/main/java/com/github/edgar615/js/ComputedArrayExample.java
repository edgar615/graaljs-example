package com.github.edgar615.js;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Value;
import org.graalvm.polyglot.proxy.ProxyArray;

public class ComputedArrayExample {
    static class ComputedArray implements ProxyArray {
        public Object get(long index) {
            return index * 2;
        }
        public void set(long index, Value value) {
            throw new UnsupportedOperationException();
        }
        public long getSize() {
            return Long.MAX_VALUE;
        }
    }

    public static void main(String[] args) {
        try (Context context = Context.create()) {
            ComputedArray arr = new ComputedArray();
            context.getBindings("js").putMember("arr", arr);
            long result = context.eval("js",
                    "arr[1] + arr[1000000000]")
                    .asLong();
            System.out.println(result);
        }
    }
}
