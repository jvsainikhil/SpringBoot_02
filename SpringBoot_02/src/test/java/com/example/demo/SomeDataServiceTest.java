package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.example.demo.businessImpl.SomeBusinessImpl;

class SomeDataServiceTest {

	@Test
	public void testCalculateSum1() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		int actualResult = business.calculateSum(new int[] {1, 2, 3});
		assertEquals(6, actualResult);
	}
	@Test
	public void testCalculateSum2() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		int actualResult = business.calculateSum(new int[] {1, 2, 3, 4});
		int expectedResult = 10;
		assertEquals(expectedResult, actualResult);
	}
	
}
