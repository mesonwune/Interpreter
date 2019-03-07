package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class ReturnCode extends ByteCode
{
    @Override
    public void execute(VirtualMachine vm)
    {

    }

    @Override
    public String toString()
    {

        return "RETURN";
    }

    @Override
    public void init(ArrayList<String> list)
    {

    }
}
