/*
	Author:Dipayan Das
	Project:Branch and Bound Algorithm/Feature selection
	Date:Sep 18, 2018
	Roll:CS1726
	Place:ISI-Kolkata
	Be-Happy
*/
package com.dipayan.node;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import com.dipayan.constant.Constant;


public class Node {
		public Node() {
			this.dataToPreserve=new ArrayList<Double>();
			this.data=new ArrayList<Double>();
			this.childNode=new ArrayList<Node>();
			this.numberOfBranches=Constant.numberOfFeaturesD+1;
		}
		
		public Node(List<Double> nodeData) {
			this.dataToPreserve=new ArrayList<Double>();
			this.data=nodeData;
			this.childNode=new ArrayList<Node>();
			this.numberOfBranches=Constant.numberOfFeaturesD+1;
		}

		private List<Double> data;
		private List<Node> childNode;
		private List<Double> dataToPreserve;
		private int numberOfBranches;
		private double jValue;

		public List<Double> getData() {
			return data;
		}

		public void setData(List<Double> data) {
			this.data = data;
		}

		public List<Node> getChildNode() {
			return childNode;
		}

		public void setChildNode(List<Node> childNode) {
			this.childNode = childNode;
		}

		public void printInOrder(Node data) {
			int count =0;
			int midSize=data.getChildNode().size()/2;
			for(Node tempData:data.getChildNode()) {
				if(count==midSize) {
					//System.out.print("-"+tempData.getData()+"-");
					count++;
				}else {
					tempData.printInOrder(tempData);
					count++;
				}
			}
			
		}

		public void printPreOrder(Node data) {

		
			//System.out.print("-"+data.getData()+"-");
			for(Node tempData:data.getChildNode()) {
					tempData.printPreOrder(tempData);
			
			}
		}

		public void printPostOrder(Node data) {
			
			for(Node tempData:data.getChildNode()) {
					tempData.printPostOrder(tempData);			
			}
			//System.out.print("-"+data.getData()+"-");
			
		}

		public List<Double> getDataToPreserve() {
			return dataToPreserve;
		}

		public void setDataToPreserve(List<Double> dataToPreserve) {
			this.dataToPreserve = dataToPreserve;
		}

		public int getNumberOfBranches() {
			return numberOfBranches;
		}

		public void setNumberOfBranches(int numberOfBranches) {
			this.numberOfBranches = numberOfBranches;
		}

		public double getjValue() {
			return jValue;
		}

		public void setjValue(double jValue) {
			this.jValue = jValue;
		}
			

		public String toString() {
			StringBuffer str= new StringBuffer("");
			DecimalFormat df2 = new DecimalFormat("#");
			if(0==this.data.size()) {
				return "";
			}
			for( Double temp:this.data) {
				
				str.append("_"+df2.format(temp));
			}
			
			return str.toString();
		}
		
		
		
		

}
