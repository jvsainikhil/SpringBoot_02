package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.example.demo.unittesting.business.SomeBusinessImpl;
import com.example.demo.unittesting.data.SomeDataService;

class SomeBusinessSubTest {
	
	class SomeDataServiceStub implements SomeDataService{//--->all stubs got (SomeDataServiceStub) got error due to adding another method in interface 

		@Override
		public int[] retriveAllData() {
			// TODO Auto-generated method stub
			return new int[] {1,2,3};
		}
	}
	class SomeDataServiceEmptyStub implements SomeDataService{//-->all stubs got (SomeDataServiceEmptyStub) got error due to adding another method in interface 
		//--->This is the reason stubs are not maintainable so we are using mokito 

		@Override
		public int[] retriveAllData() {
			// TODO Auto-generated method stub
			return new int[] { };
		}
	}
	class SomeDataServiceBigStub implements SomeDataService{//-->all stubs got (SomeDataServiceBigStub) got error due to adding another method in interface 


		@Override
		public int[] retriveAllData() {
			// TODO Auto-generated method stub
			return new int[] {1,2,3,4};
		}
	}
	@Test
	public void calculateSum_empty()  {//covered 01  // test with after stabbing
		SomeBusinessImpl business = new SomeBusinessImpl();
		business.setSomeDataService(new SomeDataServiceStub());
		int actualResult = business.calculateSumUsingDataService();
		assertEquals(6, actualResult);
	}
	@Test
	public void calculateSumUsingDataService_basic() {//covered 01  // test with after stabbing
		SomeBusinessImpl business = new SomeBusinessImpl();
		business.setSomeDataService(new SomeDataServiceEmptyStub());
		int actualResult = business.calculateSumUsingDataService();
		assertEquals(0, actualResult);
	}
	@Test
	public void calculateSum_empty01()  {//covered 01  // test with after stabbing
		SomeBusinessImpl business = new SomeBusinessImpl();
		business.setSomeDataService(new SomeDataServiceBigStub());
		assertEquals(10, business.calculateSumUsingDataService());
	}
	@Test
	public void testCalculateSum() { //covered 01 // test with after stabbing 
		SomeBusinessImpl business = new SomeBusinessImpl();
		business.setSomeDataService(new SomeDataServiceBigStub());
		int actualResult = business.calculateSumUsingDataService();
		int expectedResult = 10;
		assertEquals(expectedResult, actualResult);
	}
	@Test
	public void testCalculateSum1() {//covered 00
		SomeBusinessImpl business = new SomeBusinessImpl();//inline 
		assertEquals(6, business.calculateSum(new int[] {1, 2, 3}));
	}
	@Test
	public void testCalculateSum2() {//covered 00
		SomeBusinessImpl business = new SomeBusinessImpl();
		int actualResult = business.calculateSum(new int[] {1, 2, 3, 4});
		int expectedResult = 10;
		assertEquals(expectedResult, actualResult);
	}
}
