package com.gl.javafsd.gradedassignment2.floorsize;

import java.util.Scanner;
import java.util.Stack;

public class FloorSize {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the total no of floors in the building");
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 1; i <= n ; i++) {
			System.out.println("enter the floor size given on day : "+i);
			int floorSize = sc.nextInt();
			arr[i-1] = floorSize;
 		}
		SkyScrapper(arr);

	}
	
	public static void SkyScrapper(int[] arr) {
		Stack<Integer> stack = new Stack<>();
		
		for(int i= 0;i<arr.length;i++) {
			if(i!=0)
				System.out.println("Day: "+i);
			if(stack.empty()) {
				stack.add(arr[i]);
			}
			else {
				
				while(!stack.empty() && stack.peek()>arr[i]) {
					System.out.print(stack.pop()+" ");
				}
				stack.push(arr[i]);
			}
			System.out.println();
		}
		System.out.println("Day: "+arr.length);
		while(!stack.empty()) {
			System.out.print(stack.pop()+" ");
		}
	}

}