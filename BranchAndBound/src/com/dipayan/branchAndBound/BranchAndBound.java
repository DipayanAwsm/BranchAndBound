/*
	Author:Dipayan Das
	Project:Branch and Bound Algorithm/Feature selection
	Date:Sep 16, 2018
	Roll:CS1726
	Place:ISI-Kolkata
	Be-Happy
*/
package com.dipayan.branchAndBound;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import com.dipayan.constant.Constant;
import com.dipayan.jFunction.JFunction;
import com.dipayan.node.Node;


public class BranchAndBound {
	StringBuffer sampleData=new StringBuffer(""); 
	String result="";
	Node resultNode;
	

	public List<Double> getFeatures(List<Double> input, JFunction function) {
		List<Double> result=new ArrayList<Double>();
		BranchAndBoundTree tree=new BranchAndBoundTree(input);
		
		tree.createtree(tree.getRoot(),function,tree.getRoot().getDataToPreserve());
		
		result=tree.getMaxNode().getData();
		print(tree.getRoot());
		createDotFile(tree.getRoot(),Constant.DOT_FILE);
		return result;
	}


	private void createDotFile(Node root, String dotFileLocation) {
		createStart(dotFileLocation);
		
		putDataInDotFile(root,dotFileLocation);
		
		
		createEndFile(dotFileLocation);
		
	}

	private void putDataInDotFile(Node root,String dotFileLocation) {
		String data="";
		Node temp=null;
		int length=root.getChildNode().size()-1;
		String diff="";
		for(int i=length;i>=0;i--) {
			temp=root.getChildNode().get(i);
			if(isNotEmpty(temp)) {
				diff=getSetDifference(root.getData(),temp.getData());
				data="\n"+root.toString()+" -> "+temp.toString()+""+createLabel(diff)+";";
				writeToFile(data,dotFileLocation);
				putDataInDotFile(temp,dotFileLocation);
			}
		}
	}

	


	private String getSetDifference(List<Double> data, List<Double> data2) {
		String result="";
		for(Double tempData:data) {
			if(!data2.contains(tempData)) {
				result= result+"_"+getWithOutPointDouble(tempData);
			}
		}
		return result;
	}

	private String getWithOutPointDouble(Double temp) {
		StringBuffer str= new StringBuffer("");
		DecimalFormat df2 = new DecimalFormat("#");
		
		
			
			str.append(df2.format(temp));
				
		return str.toString();
	}

	private boolean isNotEmpty(Node temp) {
		if("".equals(temp.toString() )){
		return false;
		}else {
			return true;
		}
	}

	private String createLabel(String data) {
		String result="";
		result="[label="+data+"]";
		return result;
	}

	private void writeToFile(String data, String dotFileLocation) {

		BufferedWriter bw = null;
		FileWriter fw = null;

		try {

			

			fw = new FileWriter(dotFileLocation,true);
			bw = new BufferedWriter(fw);
			bw.append(data);

			//System.out.println("Done");

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}
			
		}
	}

	private void createEndFile(String dotFileLocation) {

		BufferedWriter bw = null;
		FileWriter fw = null;

		try {

			String content = "\n }";

			fw = new FileWriter(dotFileLocation,true);
			bw = new BufferedWriter(fw);
			bw.append(content);


		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}
			
		}
		
	}

	private void createStart(String dotFileLocation) {
		BufferedWriter bw = null;
		FileWriter fw = null;

		try {

			String content = " digraph Test{ ";

			fw = new FileWriter(dotFileLocation);
			bw = new BufferedWriter(fw);
			bw.write(content);

			

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}
			
		}
		
	}

	private void print(Node root) {
		
		//System.out.println("-"+root.toString()+"-");
		for(Node temp:root.getChildNode()) {
			print(temp);
		}
		
	}

	

}
