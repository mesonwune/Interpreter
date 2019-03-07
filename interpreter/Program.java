package interpreter;

import interpreter.bytecode.*;

import java.util.ArrayList;
import java.util.HashMap;

public class Program {

    private ArrayList<ByteCode> program;

    public Program() {
        program = new ArrayList<>();
    }

    protected ByteCode getCode(int pc) {
        return this.program.get(pc);
    }

    public int getSize() {
        return this.program.size();
    }

    //adding the list of bytecodes to program
    protected void addByteCodes(ArrayList<ByteCode> bc)
    {
        program = bc;
    }
    /**
     * This function should go through the program and resolve all addresses.
     * Currently all labels look like LABEL <<num>>>, these need to be converted into
     * correct addresses so the VirtualMachine knows what to set the Program Counter(PC)
     * HINT: make note what type of data-stucture bytecodes are stored in.
     *
     * @param //program Program object that holds a list of ByteCodes
     */
    public void resolveAddrs() {
        HashMap<String, Integer> labelAddresses = new HashMap<>();

        //parsing through the program to get all indices of LabelCode
        for (int i = 0; i < getSize(); i++)
        {
            ByteCode codes;
            codes = program.get(i);

            if (codes.toString().equals("LABEL"))
            {
                LabelCode code = (LabelCode) codes;
                labelAddresses.put(code.getAddress(), i);
            }
        }

        //parsing through the program to get all indices of FalseBranchCode,
        // CallCode, and GoToCode
        for (int i = 0; i < getSize(); i++)
        {
            ByteCode codes;
            String addressSymbolic;
            codes = program.get(i);

            //if bytecode is falsebranch, get the symbolic address
            if (codes.toString().equals("FALSEBRANCH"))
            {
                FalseBranchCode code = (FalseBranchCode)codes;
                addressSymbolic = code.getAddress();

                //convert symbolic address to index
                if (addressSymbolic.equals(labelAddresses))
                {
                    int index = labelAddresses.get(addressSymbolic);
                    code.setAddress(index);
                }
            }
            //if bytecode is callcode, get the symbolic address
            else if (codes.toString().equals("CALL"))
            {
                CallCode code = (CallCode)codes;
                addressSymbolic = code.getAddress();

                if (addressSymbolic.equals(labelAddresses))
                {
                    int index = labelAddresses.get(addressSymbolic);
                    code.setAddress(index);
                }
            }
            //if bytecode is gotocode, get the symbolic address
            else if (codes.toString().equals("GOTO"))
            {
                GotoCode code = (GotoCode)codes;
                addressSymbolic = code.getAddress();

                if (addressSymbolic.equals(labelAddresses))
                {
                    int index = labelAddresses.get(addressSymbolic);
                    code.setAddress(index);
                }
            }
        }
    }




}
