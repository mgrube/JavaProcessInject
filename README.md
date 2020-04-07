# Java Process Injection

This is a very quick demo to show that arbitrary process injection is possible in Oracle and OpenJDK's JVMs. This is apparently a somewhat known issue. The attack works like this:

1) Identify a target process. In my demo video, I do this manually using jps. However jps is written in Java so it stands to reason you can automate this.
2) Pass the pid of the target process to VirtualMachine.attach(pid)
3) Specify an agent(special code that usually legitimately instruments a java process) 
4) Your code is injected!

## Agents and Instrumentation

This code has 2 functions: It serves as the code that can attach to other processes and as the _java agent_. Java has an instrumentation API that is primarily accessible through a specific process. However, this process usually involves the code being instrumented specifying an agent to intercept and manipulate the code as its running. The code in this repository bypasses that requirement.

It turns out, there is a real-world [example](https://yoroi.company/research/java-amt-malware-the-insider-threat-phantom/) of this that I found after some digging.


## Using this POC

To use this demo, download this code and type ./gradlew jar. This will create the agent jar you need in the build/libs folder. Then specify the path of the jar to AttachDemo in the code (or make it a command line argument).

You should get a result similar to the following:

[![ProcessInjector](https://img.youtube.com/vi/Jsgc_FfTeYc/0.jpg)](https://www.youtube.com/watch?v=Jsgc_FfTeYc)


