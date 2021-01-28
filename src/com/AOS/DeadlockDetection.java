package com.AOS;

import daj.GlobalAssertion;
import daj.Program;

//assertion to check if deadlock is detected at any node
public class DeadlockDetection extends GlobalAssertion {

    //checks if the probe message corresponds to a deadlock condition
    public boolean test(Program[] programs) {
        for(Program prog : programs){

            //checks if initiator is same as receiver, if the condition is true then return false
            if(((NodeProgram)prog).probeMessage!=null && ((NodeProgram)prog).probeMessage.getInitiator()==((NodeProgram)prog).probeMessage.getReceiver()){
                return false;
            }
        }
        return true;
    }

    public String getText()
    {
        return "Deadlock Detected";
    }
}
