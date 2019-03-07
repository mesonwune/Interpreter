package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class WriteCode extends ByteCode
{
    @Override
    public void execute(VirtualMachine vm)
    {

    }

    @Override
    public String toString()
    {

        return "WRITE";
    }

    @Override
    public void init(ArrayList<String> list)
    {

    }
}
