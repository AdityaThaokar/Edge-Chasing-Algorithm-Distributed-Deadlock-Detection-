package com.AOS;


import daj.Message;

//probe message format which includes initiator, sender and receiver
class ProbeMessage extends Message {
    //initiator initiates the probe message
    private int initiator;
    //sender sends the probe message from one node to the another
    private int sender;
    //receiver receives the probe message on a node
    private int receiver;

    public ProbeMessage(int initiator, int sender, int receiver) {
        this.initiator = initiator;
        this.sender = sender;
        this.receiver = receiver;
    }

    //getter function for initiator, to get the initiator in a particular probe message
    public int getInitiator() {
        return initiator;
    }

    //getter function for sender, to get the sender of a particular probe message
    public int getSender() {
        return sender;
    }

    //getter function for receiver, to get the receiver of a particular probe message
    public int getReceiver() {
        return receiver;
    }

    public String getText() {
        if (initiator == receiver) {
            return "Deadlock detected :" + "(" + initiator + "," + sender + "," + receiver + ")";
        }
        return "Probe received = " + "(" + initiator + "," + sender + "," + receiver + ")";
    }
}