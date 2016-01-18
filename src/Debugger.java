import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class Debugger {
	static File file;
	static FileOutputStream fos;
	static PrintStream ps;

	public Debugger() {
		Debugger.file = new File("err.txt");
		try {
			Debugger.fos = new FileOutputStream(file);
		} catch (Exception e) {
			System.err.println(e);
		}

		Debugger.ps = new PrintStream(fos);
		System.setErr(ps);
	}

	void writeToDebug(String s) {
		System.err.println(s);
	}

	void closeDebuggerStream() {
		try {
			Debugger.fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
