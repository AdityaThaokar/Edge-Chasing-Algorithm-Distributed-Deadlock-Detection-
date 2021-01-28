package com.AOS;

import daj.Application;
import daj.Node;

//main application class where network is built and simulation starts
public class ECApplication extends Application {

    public ECApplication() {
        super("Edge Chasing Algorithm", 900, 600);
    }

    public static void main(String[] args) {
        new ECApplication().run();
    }

    @Override
    public void resetStatistics() {
    }

    //creating the networks for running the algorithm
    public void construct() {
 //       network1();
//        network2();
       network3();
    }

    //network1
    private void network1() {
        //nodes in the network are created below
        Node node0 = node(new NodeProgram(0, new int[]{1}, 1, true), "0", 100, 100);
        Node node1 = node(new NodeProgram(1, new int[]{2}, 1, false), "1", 200, 100);
        Node node2 = node(new NodeProgram(2, new int[]{3}, 1, false), "2", 300, 100);
        Node node5 = node(new NodeProgram(5, new int[]{0}, 2, false), "5", 100, 300);
        Node node4 = node(new NodeProgram(4, new int[]{5}, 2, false), "4", 200, 300);
        Node node3 = node(new NodeProgram(3, new int[]{4}, 2, false), "3", 300, 300);

        //links or channels between these nodes are also created
        link(node0, node1);
        link(node1, node2);
        link(node2, node3);
        link(node3, node4);
        link(node4, node5);
        link(node5, node0);
    }

    //network2
    private void network2() {
        //nodes in the network are created below
        Node node1 = node(new NodeProgram(1, new int[]{3}, 1, false), "1", 100, 100);
        Node node2 = node(new NodeProgram(2, new int[]{1, 3}, 1, false), "2", 130, 180);
        Node node3 = node(new NodeProgram(3, new int[]{5}, 2, false), "3", 240, 140);
        Node node5 = node(new NodeProgram(5, new int[]{}, 3, false), "5", 340, 140);
        Node node4 = node(new NodeProgram(4, new int[]{2}, 4, true), "4", 50, 180);

        //links or channels between these nodes are also created
        link(node1, node3);
        link(node3, node5);
        link(node2, node1);
        link(node2, node3);
        link(node4, node2);
    }

    //Network of the example given in the slides
    private void network3() {
        //nodes in the network are created below
        Node node0 = node(new NodeProgram(0, new int[]{1}, 1, true), "0", 100, 200);
        Node node1 = node(new NodeProgram(1, new int[]{2}, 1, false), "1", 100, 300);
        Node node2 = node(new NodeProgram(2, new int[]{3}, 1, false), "2", 200, 300);
        Node node3 = node(new NodeProgram(3, new int[]{4, 5}, 2, false), "3", 500, 300);
        Node node4 = node(new NodeProgram(4, new int[]{6}, 2, false), "4", 600, 250);
        Node node5 = node(new NodeProgram(5, new int[]{7}, 2, false), "5", 600, 350);
        Node node6 = node(new NodeProgram(6, new int[]{8}, 3, false), "6", 800, 250);
        Node node7 = node(new NodeProgram(7, new int[]{}, 3, false), "7", 800, 350);
        Node node8 = node(new NodeProgram(8, new int[]{0}, 3, false), "8", 800, 200);

        //links or channels between these nodes are also created
        link(node0, node1);
        link(node1, node2);
        link(node2, node3);
        link(node3, node4);
        link(node3, node5);
        link(node4, node6);
        link(node5, node7);
        link(node6, node8);
        link(node8, node0);
    }
}
