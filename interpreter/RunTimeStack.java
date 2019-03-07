package interpreter;

import java.util.ArrayList;
import java.util.Stack;

public class RunTimeStack {

    private ArrayList<Integer> runTimeStack;
    private Stack<Integer> framePointer;
    private int size;

    public RunTimeStack() {
        runTimeStack = new ArrayList<>();
        framePointer = new Stack<>();
        // Add initial Frame Pointer, main is the entry
        // point of our language, so its frame pointer is 0.
        framePointer.add(0);
        size =  runTimeStack.size();
    }

    public void dump()
    {

    }

    public int peek()
    {
        return runTimeStack.get(size - 1);
    }

    public int pop()
    {
        int top = peek();
        runTimeStack.remove(size - 1);
        return top;
    }

    //i have no clue what this means
    public void newFrameAt(int offset)
    {

    }

    public void popFrame()
    {

    }

    public int store(int offset)
    {
        return 0;
    }

    public int load(int offset)
    {
        return 0;
    }

    public Integer push(Integer val)
    {
        return 0;
    }
}
