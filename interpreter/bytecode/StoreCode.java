package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class StoreCode extends ByteCode
{
    @Override
    public void execute(VirtualMachine vm)
    {

    }

    @Override
    public String toString()
    {

        return "STORE";
    }

    @Override
    public void init(ArrayList<String> list)
    {

    }
}
