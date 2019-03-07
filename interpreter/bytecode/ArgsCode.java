package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class ArgsCode extends ByteCode
{
    @Override
    public void execute(VirtualMachine vm)
    {

    }

    @Override
    public String toString()
    {
        return "ARGS";
    }

    @Override
    public void init(ArrayList<String> list)
    {

    }
}
