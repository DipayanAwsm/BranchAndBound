/*
	Author:Dipayan Das
	Project:Branch and Bound Algorithm/Feature selection
	Date:Sep 16, 2018
	Roll:CS1726
	Place:ISI-Kolkata
	Be-Happy
*/
/**
 * 
 */
package com.dipayan.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.dipayan.branchAndBound.BranchAndBound;
import com.dipayan.constant.Constant;
import com.dipayan.function.Function1Summation;
import com.dipayan.jFunction.JFunction;

public class BranchAndBoundMain {

	
	public static void main(String[] args) {
		List<Double> input=new ArrayList<Double>();
		
		JFunction function=new Function1Summation();
		BranchAndBound brancheAndBound=new BranchAndBound();
	
		input=getInputsFromArguments(args);
		//System.out.println(input);
		/*must sort the input*/
		Collections.sort((List<Double>)input);
		setUpSomeThings();
		List<Double> result=brancheAndBound.getFeatures(input,function);
		System.out.println("Feature List:"+result);
		System.out.println("To generate the pic Use:"+Constant.GraphVis_Command_For_Generate_PNG);
	}
	




	private static void setUpSomeThings() {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int numberOfFeatures=Constant.numberOfFeaturesD;
		System.out.println("Pldease dont play with this software hadle your input output Exception");
		
		try {
			System.out.println("How many features you want");
			numberOfFeatures=Integer.parseInt(br.readLine());
			Constant.numberOfFeaturesD=numberOfFeatures;
			
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	
		
		try {
			System.out.println("Enter where you want to generate dot File ** make sure file has dot extension");
			Constant.DOT_FILE=br.readLine();
			
		} catch (NumberFormatException | IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		
	}





	private static List<Double> getInputsFromArguments(String[] args) {

		List<Double> result=new ArrayList<Double>();
		
		for(String data:args) {
			try {
				result.add(Double.parseDouble(data));
			}catch(Exception e) {
				System.out.println("*This data is not Intege:'*"+data+"*',So I am skipping the data");
			}
		}
		
		return result;
	}

}
