
package interpreter;

import interpreter.bytecode.ByteCode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.StringTokenizer;

//import java.io.ClassNotFoundException;



public class ByteCodeLoader extends Object {

    private BufferedReader byteSource;
    private StringTokenizer tokenizer;

    
    /**
     * Constructor Simply creates a buffered reader.
     * YOU ARE NOT ALLOWED TO READ FILE CONTENTS HERE
     * THIS NEEDS TO HAPPEN IN LOADCODES.
     */
    public ByteCodeLoader(String file) throws IOException {
        this.byteSource = new BufferedReader(new FileReader(file));
    }
    /**
     * This function should read one line of source code at a time.
     * For each line it should:
     *      Tokenize string to break it into parts.
     *      Grab THE correct class name for the given ByteCode from CodeTable
     *      Create an instance of the ByteCode class name returned from code table.
     *      Parse any additional arguments for the given ByteCode and send them to
     *      the newly created ByteCode instance via the init function.
     */
    public Program loadCodes() {
        StringTokenizer tokens;
        ByteCode bc = null;
        String className = "";
        Program pr = new Program();;
        ArrayList<String> inputLine = new ArrayList<String>();
        ArrayList<ByteCode> byteCodes = new ArrayList<ByteCode>();
        try
        {
            String line;
            while ((line = byteSource.readLine()) != null)
            {
                tokens = new StringTokenizer(line," ");
                while (tokens.hasMoreTokens())
                {
                    className = CodeTable.getClassName((String) tokens.nextToken());
                    inputLine.add(className);
                }

                Class c = Class.forName("interpreter.bytecode." + inputLine.get(0));
                inputLine.remove(0);
                bc = (ByteCode) c.getDeclaredConstructor().newInstance();
                bc.init(inputLine);

                byteCodes.add(bc);
            }

            pr.addByteCodes(byteCodes);
            pr.resolveAddrs();
        }
        catch (IOException | ClassNotFoundException | NoSuchMethodException
                | InstantiationException | IllegalAccessException | InvocationTargetException e)
        { e.printStackTrace();}

        return pr;
    }
}
