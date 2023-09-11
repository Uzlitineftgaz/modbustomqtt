package uz.maniac4j;

import javax.script.*;
import java.util.function.Predicate;

public class Loading {
    public static void main(String[] args) throws ScriptException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("java");

        int a=0;

        Object result = engine.eval("""
                public class Script{
                    public String getMessage(){
                        return "Hello world";
                    }
                }
                """);

//        Object result = engine.eval("" +
//                "public class Script {" +
//                "   public String getMessage() {" +
//                "       return \"Hello World\";" +
//                "   } " +
//                "}");
        System.out.println("Result: " + result);

//        ScriptEngine engine = new ScriptEngineManager().getEngineByName("graal.js");
//        Bindings bindings = engine.getBindings(ScriptContext.ENGINE_SCOPE);
//        bindings.put("polyglot.js.allowHostAccess", true);
//        bindings.put("polyglot.js.allowHostClassLookup", (Predicate<String>) s -> true);
//        bindings.put("javaObj", new Object());
//        engine.eval("(javaObj instanceof Java.type('java.lang.Object'));"); // it will not work without allowHostAccess and allowHostClassLookup
    }
}
