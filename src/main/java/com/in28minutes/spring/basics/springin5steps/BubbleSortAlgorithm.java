package com.in28minutes.spring.basics.springin5steps;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
public class BubbleSortAlgorithm implements SortAlgorithm {
	public int[] sort(int[] numbers) {
		System.out.println("Inside Bubble Sort");
		return numbers;
	}
}
