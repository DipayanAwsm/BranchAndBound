/*
	Author:Dipayan Das
	Project:Branch and Bound Algorithm/Feature selection
	Date:Sep 18, 2018
	Roll:CS1726
	Place:ISI-Kolkata
	Be-Happy
*/
package com.dipayan.comparator;

import java.util.Comparator;

import com.dipayan.node.Node;

public class CompareByJValue implements Comparator<Node> {

	@Override
	public int compare(Node o1, Node o2) {
		// TODO Auto-generated method stub
		return (int)(o1.getjValue()-o2.getjValue());
	}

}
