import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 * The purpose of this class is to print all debug statements to a file.
 * @author jameschow, amartinez
 *
 */
public class Debugger {
	static File file;/**The file being opened for message output.*/
	static FileOutputStream fos; /**Needed to print to file.*/
	static PrintStream ps; /**Needed to switch from console to file.*/

	/**Constructor that creates a singleton object for debugging purposes.*/
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

	/**
	 * Writes a debug message to file.*/
	void writeToDebug(String s) {
		System.err.println(s);
	}

	/**
	 * Closes the filestream.
	 */
	void closeDebuggerStream() {
		try {
			Debugger.fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
