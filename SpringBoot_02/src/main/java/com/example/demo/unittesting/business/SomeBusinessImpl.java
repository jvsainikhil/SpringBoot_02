package com.example.demo.unittesting.business;
//sample-01
import com.example.demo.unittesting.data.SomeDataService;

public class SomeBusinessImpl {
	
	private SomeDataService someDataService;
	
	public void setSomeDataService(SomeDataService someDataService) {
		this.someDataService = someDataService;
	}

	public int calculateSum(int[] data) { //covered 00
		int sum = 0;
		for(int value : data) {
			sum += value;
		}
		return sum;		
	}
	
	public int calculateSumUsingDataService() { //covered 01
		int sum = 0;
		int[] data= someDataService.retriveAllData();
		for(int value : data) {
			sum += value;
		}
		return sum;		
	}
}
