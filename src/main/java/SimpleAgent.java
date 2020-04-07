import java.lang.instrument.Instrumentation;

public class SimpleAgent {
    public static void premain(String agentArgument,
                               Instrumentation instrumentation){
        System.setProperty("agentinjected", "true");
    }

    public static void agentmain(String agentArgument, Instrumentation instrumentation){
        System.out.println("Injected!");
    }
}
