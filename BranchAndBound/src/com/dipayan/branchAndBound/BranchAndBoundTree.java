/*
	Author:Dipayan Das
	Project:Branch and Bound Algorithm/Feature selection
	Date:Sep 18, 2018
	Roll:CS1726
	Place:ISI-Kolkata
	Be-Happy
*/
package com.dipayan.branchAndBound;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;


import com.dipayan.constant.Constant;
import com.dipayan.jFunction.JFunction;
import com.dipayan.node.Node;



public class BranchAndBoundTree {
	private Node root;
	private double maxJvalue;
	private Node maxNode;
	private boolean bSizeSetCreated=false;
	
	
	

	public Node getMaxNode() {
		return maxNode;
	}
	public void setMaxNode(Node maxNode) {
		this.maxNode = maxNode;
	}
	
	public  BranchAndBoundTree() {
		this.root=new Node();
		this.maxJvalue=-Double.MAX_VALUE;
		this.maxNode=new Node();
	}
	public  BranchAndBoundTree(Node root) {
		this.root=root;
		this.maxNode=new Node();
	}
	public BranchAndBoundTree(List<Double> input) {
		this.root=new Node();
		this.root.setData(input);
		this.maxNode=new Node();
	}
	
	/*Root is set up */
	public void createtree(Node node, JFunction function, List<Double> preserveList) {
		
		//////////////////*checking conditions*/////////////////////////////////
		
		
		
		
		if(Constant.numberOfFeaturesD==node.getData().size()) {
			if(maxJvalue<node.getjValue()) {
				maxJvalue=node.getjValue();
				this.maxNode=node;
				this.bSizeSetCreated=true;
				
			}
			
				return;
			
		}
		
		
		if(Constant.numberOfFeaturesD>=node.getData().size()) {
			return;
		}
		
		
		///////////////////////////////////////////////////////////////////////////////////

		/*Setting up number of branches */
		int numberofBranches=Constant.numberOfFeaturesD+1-node.getDataToPreserve().size();
		node.setNumberOfBranches(numberofBranches);
		
		List<Double> data=node.getData();
		List<Double> randomFeature=getRandomData(data,numberofBranches,preserveList);
		
		
		Collections.sort(randomFeature);
		
		
		node=setUpNodes(node,randomFeature,function,node.getDataToPreserve());
		
		List<Double> preserveListForChild;
		
		Node tempChild;
		List<Node> tempChildList;
		for(int i=0;i<node.getChildNode().size();i++) {
			preserveListForChild=createPreservationListForChild(i,node.getDataToPreserve(),randomFeature);
			//node.getChildNode().get(i).setNumberOfBranches(numberOfBranches);
			tempChildList=node.getChildNode();
			tempChild=node.getChildNode().get(i);
			tempChild.setDataToPreserve(preserveListForChild);
		
			
			if(bSizeSetCreated) {
				if(maxJvalue>=tempChild.getjValue()) {
					return;
											
				}
			}
			
			
			
			
			createtree(tempChild, function, preserveListForChild);
			tempChildList.set(i,tempChild);
			node.setChildNode(tempChildList);
			
			
		}
		
		
	}
	
	
	private List<Double> createPreservationListForChild(int start, List<Double> preserveList, List<Double> randomFeature) {
		List<Double> result=new ArrayList<Double>();
		for(int i=0;i<preserveList.size();i++) {
			result.add(preserveList.get(i));
		}
		
		for(int i=start+1;i<randomFeature.size();i++) {
			result.add(randomFeature.get(i));
		}
		return result;
	}
	/*This will setup the child nodes*/
	private Node setUpNodes(Node root2, Collection<Double> randomFeature,JFunction function, List<Double> preserveList) {

		double jfunctionvalueTemp=0;
		List<Double> nodeData;
		Node newTempNode;
		for(Double temp:randomFeature) {
			nodeData=makeNodeWithOutOne(root2.getData(),temp,preserveList);
			
			jfunctionvalueTemp=function.jfunction(nodeData);
			newTempNode=new Node(nodeData);
			newTempNode.setjValue(jfunctionvalueTemp);
			root2.getChildNode().add(newTempNode);
		}
		return root2;
	}
	/*this method will create crate a list/set/collection  from data with out the tempData*/
	private List<Double> makeNodeWithOutOne(List<Double> data, Double removeData, Collection<Double> preserveList) {
		List<Double> result=new ArrayList<Double>();
		for(Double tempData:data) {
			if(tempData!=removeData ) {
				result.add(tempData);
			}
		}
		return result;
	}
	
	
	/*this will get the random data from data*/
	private List<Double> getRandomData(List<Double> data, int numberOfBranches, List<Double> preserveList) {
	
		List<Double> result=new ArrayList<Double>();
		int size = data.size();
		int item=new Random().nextInt(size);
		int i=0;
		while(result.size()<numberOfBranches && i<numberOfBranches) {
			item=new Random().nextInt(size);
			    if ( !result.contains(data.get(item)) && !preserveList.contains(data.get(item))) {
			    	result.add(data.get(item));
			    	
			    	i++;
			    }	
			   
			
		}
		return result;
	}
	public void printInOrder() {
		this.root.printInOrder(root);
		System.out.println();
		
	}
	public void printPreOrder() {
		this.root.printPreOrder(root);
		System.out.println();
		
	}
	public void printPostOrder() {
		this.root.printPostOrder(root);
		System.out.println();
		
	}
	public Node getRoot() {
		return root;
	}
	public void setRoot(Node root) {
		this.root = root;
	}
	public double getMaxJvalue() {
		return maxJvalue;
	}
	public void setMaxJvalue(double maxJvalue) {
		this.maxJvalue = maxJvalue;
	}
	
		
	public void setVisualizationNode(Node root2) {
		
		
		for(Node temp:root2.getChildNode()) {
			setVisualizationNode(temp);
		}
		
	}
	
	

	
}
