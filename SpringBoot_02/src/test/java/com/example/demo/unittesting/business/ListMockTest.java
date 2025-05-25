package com.example.demo.unittesting.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.*;

public class ListMockTest {
	
	List<String> mock = Mockito.mock(List.class);
	
	@Test
	public void size_basic() {
		List mock = Mockito.mock(List.class);
		when(mock.size()).thenReturn(5);
		assertEquals(5, mock.size());
	}
	
	@Test
	public void returnDiferentValues() {
		List mock = Mockito.mock(List.class);
		when(mock.size()).thenReturn(5).thenReturn(10);
		assertEquals(5, mock.size());
		assertEquals(10, mock.size());
	}
	
	@Test
	public void returnWithParameters() {
		when(mock.get(0)).thenReturn("Nikhil");
		assertEquals("Nikhil", mock.get(0));
	}
	
	@Test
	public void returnWithGenericParameters() {
		when(mock.get(anyInt())).thenReturn("Nikhil");
		assertEquals("Nikhil", mock.get(0));
		assertEquals("Nikhil", mock.get(1));
	}
	
	@Test
	public void verificationBasics() {
		//let's say this is part of system under test
		String value1 = mock.get(0);
		String value2 = mock.get(1);

		//Verify
		verify(mock).get(0);
		verify(mock, times(2)).get(anyInt());
		verify(mock, atLeast(1)).get(anyInt());
		verify(mock, atLeastOnce()).get(anyInt());
		verify(mock, atMost(2)).get(anyInt());
		verify(mock, never()).get(2);	
	}
	//how to capture an argument that is passed to a method call
	@Test
	public void argumentCapturing() {
		//SUT-->system under test
		mock.add("SomeString1");
		mock.add("SomeString2");
		
		//Verification --> find the argument is
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(mock, times(2)).add(captor.capture());
		List<String> allValues = captor.getAllValues();
		
		assertEquals("SomeString1", allValues.get(0));
		assertEquals("SomeString2", allValues.get(1));
	}
	
	@Test
	public void mocking() {
		ArrayList arrayListMock =Mockito.mock(ArrayList.class);
		arrayListMock.get(0);//null
		System.out.println(arrayListMock.size());//0
		arrayListMock.add("Test");
		arrayListMock.add("Test2");
		System.out.println(arrayListMock.size());//0
		when(arrayListMock.size()).thenReturn(5);
		System.out.println(arrayListMock.size());//5
	}
	//spying
	@Test
	public void spying() {
		ArrayList arrayListSpy =Mockito.spy(ArrayList.class);
		arrayListSpy.add("Test0");//null
		System.out.println(arrayListSpy.get(0));//Test0
		System.out.println(arrayListSpy.size());//1
		arrayListSpy.add("Test");
		arrayListSpy.add("Test2");
		System.out.println(arrayListSpy.size());//3
		
		when(arrayListSpy.size()).thenReturn(5);
		System.out.println(arrayListSpy.size());//5

		arrayListSpy.add("Test4");
		System.out.println(arrayListSpy.size());//5
		
		verify(arrayListSpy).add("Test4");
	}
}
