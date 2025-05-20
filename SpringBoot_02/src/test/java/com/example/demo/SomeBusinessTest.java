package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.example.demo.unittesting.business.SomeBusinessImpl;
import com.example.demo.unittesting.data.SomeDataService;

class SomeBusinessTest {
	
	class SomeDataServiceStub implements SomeDataService{

		@Override
		public int[] retriveAllData() {
			// TODO Auto-generated method stub
			return new int[] {1,2,3};
		}
	}

	@Test
	public void calculateSum_empty()  {
		SomeBusinessImpl business = new SomeBusinessImpl();
		int actualResult = business.calculateSum(new int[] { });
		assertEquals(0, actualResult);
	}
	@Test
	public void calculateSumUsingDataService_basic() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		business.setSomeDataService(new SomeDataServiceStub());
		int actualResult = business.calculateSumUsingDataService();
		int expectedResult = 6;
		assertEquals(expectedResult, actualResult);
	}
	
	
}
