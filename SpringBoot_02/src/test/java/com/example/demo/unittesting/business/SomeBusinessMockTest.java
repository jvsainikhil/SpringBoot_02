package com.example.demo.unittesting.business;
//sample-01
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.unittesting.business.SomeBusinessImpl;
import com.example.demo.unittesting.data.SomeDataService;

@ExtendWith(MockitoExtension.class)
public class SomeBusinessMockTest {
	
	@InjectMocks
	SomeBusinessImpl business; //Changing as per mock
	
	@Mock
	SomeDataService dataServiceMock;//changing as per mock
	
   /*---> Changed According to Mokito Frame Work <---*/
	
	
/*  SomeBusinessImpl business = new SomeBusinessImpl(); //This line in common in all the test cases	
    SomeDataService dataServiceMock= mock(SomeDataService.class); //This line in common in all the test cases
	
	@BeforeEach
	business.setSomeDataService(dataServiceMock); //to add this line we need to use @BeforeEach
	public void before(){
		business.setSomeDataService(dataServiceMock);
	} 
*/

	@Test
	 public void calculateSum_basic() {
        when(dataServiceMock.retriveAllData()).thenReturn(new int[] {1, 2, 3});
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
	
	@Test
	public void testCalculateSum01() { // test with after stabbing ----> can refer as 2nd step 		
		SomeBusinessImpl business = new SomeBusinessImpl(); //This line in common in all the test cases	
	    SomeDataService dataServiceMock= mock(SomeDataService.class); //This line in common in all the test cases
	    when(dataServiceMock.retriveAllData()).thenReturn(new int[] {1,2,4,8});
		business.setSomeDataService(dataServiceMock);
		assertEquals(15, business.calculateSumUsingDataService());
	}	
	
	// have used
	// --> Hover or click on object and then --> Refactor --> inline --> (Alt+Shift+I).
	@Test
	public void testCalculateSum() { // test with after stabbing 
		SomeBusinessImpl business = new SomeBusinessImpl(); //This line in common in all the test cases	
	    SomeDataService dataServiceMock= mock(SomeDataService.class); //This line in common in all the test cases
	    when(dataServiceMock.retriveAllData()).thenReturn(new int[] {1,2,3,4,1});
		business.setSomeDataService(dataServiceMock);
		int actualResult = business.calculateSumUsingDataService();
		int expectedResult = 11;
		assertEquals(expectedResult, actualResult);
	}	
}

/*If you are using JUnit 5, in the next lecture use

@ExtendWith(MockitoExtension.class)

instead of @RunWith (MockitoJUnitRunner.class)*/