import com.sun.tools.attach.AgentInitializationException;
import com.sun.tools.attach.AgentLoadException;
import com.sun.tools.attach.AttachNotSupportedException;
import com.sun.tools.attach.VirtualMachine;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class AttachDemo {
    public static void main(String[] args) throws IOException, AttachNotSupportedException, AgentLoadException, AgentInitializationException {
        VirtualMachine vm = VirtualMachine.attach(args[0]);

        Properties props = vm.getSystemProperties();

        vm.loadAgent("/home/mike/simpleagent.jar");

        System.out.println("Target is running as user: " + props.getProperty("user.name"));

        vm.detach();
    }
}
