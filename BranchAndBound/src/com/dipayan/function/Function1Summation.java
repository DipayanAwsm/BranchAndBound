/*
	Author:Dipayan Das
	Project:Branch and Bound Algorithm/Feature selection
	Date:Sep 16, 2018
	Roll:CS1726
	Place:ISI-Kolkata
	Be-Happy
*/
package com.dipayan.function;

import java.util.Collection;

import com.dipayan.jFunction.JFunction;
import com.dipayan.node.Node;

public class Function1Summation implements JFunction {

	/*This will do what it supposed to do.
	 * this function will return the  summation of all the numbers in the collection
	 * */
	@Override
	public Double jfunction(Collection<Double> input) {
		Double resut=(double) 0;
		for(Double data:input) {
			resut=resut+data;
		}
		return resut;
	}

	@Override
	public int compare(Node node1, Node node2) {
		
		return (int)(node1.getjValue()-node2.getjValue());
	}

}
