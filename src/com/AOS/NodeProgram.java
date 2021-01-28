package com.AOS;

import daj.Program;

//class which stores information of each node and the message passed
public class NodeProgram extends Program {

    //dependent is used to store the dependant of a particular node
    boolean[] dependant = new boolean[9];

    //each node is given a unique number
    private int number;

    //index of the incoming channel
    public int inIndex;

    //index of the outgoing channel
    public int outIndex;

    //count of outgoing channels
    public int outChannelsSize;

    //count of incoming channels
    public int inChannelsSize;

    //probe message to be handled at each node
    public ProbeMessage probeMessage;

    //to check if the probe message had been sent or not
    public boolean sent;

    //specifies the site number in which a particular node resides
    public int site;

    //to check if the current node is initiator of the probe message
    public boolean isInitiator;


    //initialization of program
    public NodeProgram(int number, int[] dep, int siteNo, boolean isInitiator) {
        //dependant array is updated according to the values provided while creating the node
        for (int next : dep) {
            this.dependant[next] = true;
        }
        this.number = number;

        //probe message is set as null initially
        this.probeMessage = null;

        //sent is kept as false initially since no probe message is being sent by any node
        this.sent = false;
        this.site = siteNo;
        this.isInitiator = isInitiator;
    }

    //default constructor
    public NodeProgram() {
    }

    //each node in the network executes this code
    public void main() {
        nodeProg();
    }

    //controls the creation and sending of messages in initiator node
    private void nodeProg() {
        //to get the count of total outgoing channels
        try {
            outChannelsSize = out().getSize();
        } catch (NullPointerException ex) {
        }

        //to get the count of total incoming channels
        try {
            inChannelsSize = in().getSize();
        } catch (NullPointerException ex) {
        }

        //initial outgoing channel index if any
        outIndex = 0;

        //initial incoming channel index if any
        inIndex = 0;

        //checks if the current node is an initiator node
        if (isInitiator) {

            //forward the probe message to dependants
            forwardMessageToDependants(true);
        }
        //receives the message from each input channel
        for (int j = 0; j < inChannelsSize && inIndex < inChannelsSize; j++) {

            //determines which of the input channels is not empty
            inIndex = in().select();

            //receives the message contained in this channel
            probeMessage = (ProbeMessage) in(inIndex).receive();

            //global assertion to check if deadlock is detected
            DeadlockDetection assertion = new DeadlockDetection();
            test(assertion);

            //forward probe message to dependants
            forwardMessageToDependants(isInitiator);
        }

    }

    public void forwardMessageToDependants(boolean isInitiator) {
        //for each dependant the message is sent through the corresponding channel
        //variable i represents the dependant of the current node
        for (int i = 0; (i < dependant.length) && (outIndex < outChannelsSize); i++) {
            if (dependant[i] == true) {

                //sent the message to the outgoing channel
                out(outIndex).send(new ProbeMessage(isInitiator ? number : probeMessage.getInitiator(), number, i));

                //set the sent parameter as true since the message is sent from the current node to the dependant node
                sent = true;

                //increments the channel for the next dependant
                outIndex++;
            }
        }
    }

    //displays the program state for each node
    public String getText() {
        String msgString;
        if (probeMessage == null)
            msgString = "(null)";
        else
            msgString = probeMessage.getText();
        return "sent: " + String.valueOf(sent) + "\nmsg: " + msgString;
    }
}
