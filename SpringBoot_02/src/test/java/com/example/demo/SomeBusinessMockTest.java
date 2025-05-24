package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.demo.unittesting.business.SomeBusinessImpl;
import com.example.demo.unittesting.data.SomeDataService;

class SomeBusinessMockTest {	
	SomeBusinessImpl business = new SomeBusinessImpl();//This line in common in all the test cases
	SomeDataService dataServiceMock= mock(SomeDataService.class);//This line in common in all the test cases
	
	@BeforeEach
	//business.setSomeDataService(dataServiceMock);//to add this line we need to use @BeforeEach
	public void before(){
		business.setSomeDataService(dataServiceMock);
	}

	
	@Test
	public void calculateSum_empty()  {
		//we want return this --> dataServiceMock retriveAllData new int[] {1,2,3} --> need to define it 
		when(dataServiceMock.retriveAllData()).thenReturn(new int[] {1,2,3});
		//business.setSomeDataService(dataServiceMock);//to add this for all is @BeforeEach 
		assertEquals(6, business.calculateSumUsingDataService());
	}
	@Test
	public void calculateSumUsingDataService_basic() {
		when(dataServiceMock.retriveAllData()).thenReturn(new int[] { });//we want return
		//business.setSomeDataService(dataServiceMock);
		assertEquals(0, business.calculateSumUsingDataService());
	}
	@Test
	public void calculateSum_empty01()  {
		when(dataServiceMock.retriveAllData()).thenReturn(new int[] {4});
		//business.setSomeDataService(dataServiceMock);
		assertEquals(4, business.calculateSumUsingDataService());
	}
	
	// have used
	// --> Hover or click on object and then --> Refactor --> inline --> (Alt+Shift+I).
	@Test
	public void testCalculateSum() { // test with after stabbing 
		when(dataServiceMock.retriveAllData()).thenReturn(new int[] {1,2,3,4,1});
		//business.setSomeDataService(dataServiceMock);
		int actualResult = business.calculateSumUsingDataService();
		int expectedResult = 11;
		assertEquals(expectedResult, actualResult);
	}	
}

//observation:
//