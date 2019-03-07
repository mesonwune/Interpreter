package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class FalseBranchCode extends ByteCode
{
    private String data;

    @Override
    public void execute(VirtualMachine vm)
    {

    }

    @Override
    public String toString()
    {

        return "FALSEBRANCH";
    }

    @Override
    public void init(ArrayList<String> list)
    {
        data = list.get(0);
    }

    public String getAddress()
    {
        return data;
    }

    public void setAddress(int i)
    {
        data = Integer.toString(i);
    }
}
