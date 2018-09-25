

###########################################################

Author  :   Dipayan Das;

Date    :   25-09-2018;

Implemented: Branch Bound Algorithm for Feature selection Please refer to link for Learning the  feature selection Concept 

https://nptel.ac.in/courses/106106046/29




###########################################################

 





===============================================
Some assumption 
Let us suppose it is a maximize problem;
Ths Code is based on Summation is our objective functionobjective function .
Thouugh  you can implement JFunction interface and its jfunction(Collection<Double> input) ,compare(Node node1, Node Node2) to modify the code in BranchAndBoundMain that will do the work.
===============================================


############################################
It uses graphVIZ for visualization

prerequisite
1. Its build on Java-8(so  install java please)
2. please install GraphViz
3. It creates a dot file which is rendered by graphviz for visualization.
4.Output is at the console in the end .


 ################### HOW TO RUN THE CODE #########################
 -----------------if you have the jar file then run---------------------------
 1.   $java -cp BranchAndBound.jar com.dipayan.main.BranchAndBoundMain 1 2 3 4 5 6 7 8 9 10 11
       
 		How many features you want
		2
		Enter where you want to generate dot File ** make sure file has dot extension
		/home/Desktop/dotFile.dot
==============================================================================================
-------------If you don't have jar file but pre compiled code then------------------
1.   $java  com.dipayan.main.BranchAndBoundMain 1 2 3 4 5 6 7 8 9 10 11
       
 		How many features you want
		2
		Enter where you want to generate dot File ** make sure file has dot extension
		/home/Desktop/dotFile.dot
	
----------------Java code completed working now just generate the pic -----------------------------
		
	Then generate png file using grapghviz
	$ dot -Tpng -O /home/Desktop/dotFile.dot 	
 		
Then just open up the png file dotFile.dot.png will be stored in your location

 
  ############################################
  
  Hope this Will Help you.
 
  Be Happy 
  
