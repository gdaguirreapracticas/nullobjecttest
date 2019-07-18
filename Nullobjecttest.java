
package nullobjecttest;

import java.io.OutputStream;
import java.io.PrintStream;

class NullOutputStream extends OutputStream {
    public void write(int b) {

    }
}

class NullPrintStream extends PrintStream {
    public NullPrintStream() {
        super(new NullOutputStream());
    }
}

class Application {
    private PrintStream debugOut;
    public Application(PrintStream debugOut) {
        this.debugOut = debugOut;
    }

    public void doSomething() {
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += i;
            debugOut.println("i = " + i);
        }
        System.out.println("sum = " + sum);
    }
}
//program uses null method when it doesn't need anything to be printed,
//then the actual working method when it becomes necessary
public class Nullobjecttest {
    public static void main(String[] args) {
        Application app = new Application(new NullPrintStream());
        app.doSomething();
    }
}
