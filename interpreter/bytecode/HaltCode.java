package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class HaltCode extends ByteCode
{
    @Override
    public void execute(VirtualMachine vm)
    {
        //if ()
    }

    @Override
    public String toString()
    {

        return "HALT";
    }

    @Override
    public void init(ArrayList<String> list)
    {
        //empty
    }
}
