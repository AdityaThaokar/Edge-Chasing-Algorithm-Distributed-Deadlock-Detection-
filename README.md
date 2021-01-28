# Edge-Chasing-Algorithm-Distributed-Deadlock-Detection-

## 1. About Algorithm :
Edge-chasing algorithm is the implementation of Chandy-Misra-Haas’s algorithm for AND request model and it is useful in detecting deadlock in a distributed Systems.This algorithm makes use of a unique message on every occasion, impasse detection is initiated by process Pi and it’s triplet being sent by means of site of process Pi to site of process Pk.
	
  ## 2. About the Toolkit :
  To run the classes in the project,DAJ toolikit will be required.
	
  ### 2.1. How to use the toolkit : 
  Download the Toolkit for JDK 6.0 : https://www3.risc.jku.at/software/daj/  		
  
  Read the pdf : https://github.com/motib/daj/tree/master/docs 
  ## 3. Implementation :
  We have simulated the Edge Chasing Algorithm for deadlock detection
using Java and DAJ toolkit. DAJ toolkit is a tool for designing, implementing,
simulating, and visualizing distributed algorithms.
We have implemented the algorithm using 5 classes in Java:
### a. ECApplication 
This is the main class that has the java main function in it
and it is also responsible for creating the network and running the simulation.
### b. NodeProgram
This class contains the implementation of Edge Chasing
algorithm. Each node in the network runs this algorithm.
### c. ProbeMessage 
This class gives the format of probe messages which are transmitted.
It contains three attributes, initiator, sender and receiver.   
### d. DeadlockDetection
This class is used to detect the deadlock at any point
of time. It extends the GlobalAssertion class provided by DAJ toolkit.
### e. NodeProgramTest
Unit tests are added in this class for testing of NodeProgram class.
## 4. Contributers :
Vishal John Varghese : https://github.com/VishalJohnVarghese1996


