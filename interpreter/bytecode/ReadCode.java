package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class ReadCode extends ByteCode
{
    @Override
    public void execute(VirtualMachine vm)
    {

    }

    @Override
    public String toString()
    {

        return "READ";
    }

    @Override
    public void init(ArrayList<String> list)
    {

    }
}
