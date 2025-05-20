package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.example.demo.business.data.SomeDataService;
import com.example.demo.unittesting.business.SomeBusinessImpl;

class SomeDataService implements  SomeBusinessImpl {
	@Override
	public int[] retrieveAllData() {
		return new int[] { 1, 2, 3 };
	}
}

	public class SomeBusinessStubTest {

		@Test
		public void calculateSumUsingDataService_basic() {
			SomeBusinessImpl business = new SomeBusinessImpl();
			business.setSomeDataService(new SomeDataServiceStub());
			int actualResult = business.calculateSumUsingDataService();
			int expectedResult = 6;
			assertEquals(expectedResult, actualResult);
		}

}
