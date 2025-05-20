package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.example.demo.unittesting.business.SomeBusinessImpl;
import com.example.demo.unittesting.data.SomeDataService;

class SomeBusinessTest {
	
	class SomeDataServiceStub implements SomeDataService{//---

		@Override
		public int[] retriveAllData() {
			// TODO Auto-generated method stub
			return new int[] {1,2,3};
		}
	}
	class SomeDataServiceEmptyStub implements SomeDataService{//---

		@Override
		public int[] retriveAllData() {
			// TODO Auto-generated method stub
			return new int[] { };
		}
	}
	class SomeDataServiceBigStub implements SomeDataService{//--

		@Override
		public int[] retriveAllData() {
			// TODO Auto-generated method stub
			return new int[] {1,2,3,4};
		}
	}
	@Test
	public void calculateSum_empty()  {
		SomeBusinessImpl business = new SomeBusinessImpl();
		business.setSomeDataService(new SomeDataServiceStub());
		int actualResult = business.calculateSumUsingDataService();
		assertEquals(6, actualResult);
	}
	@Test
	public void calculateSumUsingDataService_basic() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		business.setSomeDataService(new SomeDataServiceEmptyStub());
		int actualResult = business.calculateSumUsingDataService();
		assertEquals(0, actualResult);
	}
	@Test
	public void calculateSum_empty01()  {
		SomeBusinessImpl business = new SomeBusinessImpl();
		business.setSomeDataService(new SomeDataServiceBigStub());
		int actualResult = business.calculateSumUsingDataService();
		assertEquals(10, actualResult);
	}
	@Test
	public void testCalculateSum() { // test with after stabbing 
		SomeBusinessImpl business = new SomeBusinessImpl();
		business.setSomeDataService(new SomeDataServiceBigStub());
		int actualResult = business.calculateSumUsingDataService();
		int expectedResult = 10;
		assertEquals(expectedResult, actualResult);
	}
	
	
}
