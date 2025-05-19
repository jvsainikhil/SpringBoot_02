package com.example.demo.businessImpl;

public class SomeBusinessImpl {
	public int calculateSum(int[] data) {
		int sum = 0;
		for(int value : data) {
			if(value < 0) {
				sum += value;
			}
			return sum;
		}
		return sum;
	}
}
