package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import com.example.demo.unittesting.business.SomeBusinessImpl;
import com.example.demo.unittesting.data.SomeDataService;

class SomeBusinessMockTest {	
	
	@Test
	public void calculateSum_empty()  {
		SomeBusinessImpl business = new SomeBusinessImpl();
		SomeDataService dataServiceMock= mock(SomeDataService.class);
		//we want return this --> dataServiceMock retriveAllData new int[] {1,2,3} --> need to define it 
		when(dataServiceMock.retriveAllData()).thenReturn(new int[] {1,2,3});
		business.setSomeDataService(dataServiceMock);
		int actualResult = business.calculateSumUsingDataService();
		assertEquals(6, actualResult);
	}
	@Test
	public void calculateSumUsingDataService_basic() {
		SomeBusinessImpl business = new SomeBusinessImpl();	
		SomeDataService dataServiceMock= mock(SomeDataService.class);
		when(dataServiceMock.retriveAllData()).thenReturn(new int[] { });//we want return
		business.setSomeDataService(dataServiceMock);
		int actualResult = business.calculateSumUsingDataService();
		assertEquals(0, actualResult);
	}
	@Test
	public void calculateSum_empty01()  {
		SomeBusinessImpl business = new SomeBusinessImpl();
		SomeDataService dataServiceMock= mock(SomeDataService.class);
		when(dataServiceMock.retriveAllData()).thenReturn(new int[] {4});
		business.setSomeDataService(dataServiceMock);
		int actualResult = business.calculateSumUsingDataService();
		assertEquals(4, actualResult);
	}
	@Test
	public void testCalculateSum() { // test with after stabbing 
		SomeBusinessImpl business = new SomeBusinessImpl();
		SomeDataService dataServiceMock= mock(SomeDataService.class);
		when(dataServiceMock.retriveAllData()).thenReturn(new int[] {1,2,3,4,1});
		business.setSomeDataService(dataServiceMock);
		int actualResult = business.calculateSumUsingDataService();
		int expectedResult = 11;
		assertEquals(expectedResult, actualResult);
	}	
}

//observation:
//