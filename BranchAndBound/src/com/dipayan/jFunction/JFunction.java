/*
	Author:Dipayan Das
	Project:Branch and Bound Algorithm/Feature selection
	Date:Sep 16, 2018
	Roll:CS1726
	Place:ISI-Kolkata
	Be-Happy
*/
package com.dipayan.jFunction;

import java.util.Collection;
import java.util.Comparator;

import com.dipayan.node.Node;

/*All functions that will is used in this algo must implement this function */
public interface JFunction extends  Comparator<Node>{
	/*For this every one has to implement this method according to their function*/
	public Double jfunction(Collection<Double> input);
	
	 public int compare(Node node1, Node Node2); 
	
}
