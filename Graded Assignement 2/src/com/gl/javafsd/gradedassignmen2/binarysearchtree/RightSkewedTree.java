package com.gl.javafsd.gradedassignmen2.binarysearchtree;

import java.util.Scanner;

public class RightSkewedTree {
	
	static class Node {
		int key;
		Node left, right;
		Node(int key){
			this.key = key;
		}
	}
	static Node newNode(int data) {
		Node temp = new Node(data);
		temp.left = null;
		temp.right = null;
		return temp;
	
		
	}
	static Node buildBST(Node root,int key)
	{
		
		if(root==null)
			root= newNode(key);
		else 
			insert(root,key);
		return root;
	}
	static Node insert(Node root,int key)
	{
		if(root == null) {
			Node newNode = newNode(key);
			return newNode;
		}
			
		if(key<root.key) {
			root.left = insert(root.left,key);
		}
		else
			root.right = insert(root.right,key);
		
		return root;
			
	}
	static void transform(Node root) {
		if(root==null)
			return;
		else {
			transform(root.left);
			skewTreeToRight(skewedRoot, root.key);
			transform(root.right);
			
			
		}
	}
	static Node skewedRoot;
	static Node tailNode;
	static Node skewTreeToRight(Node root,int key) {
		if(root==null) {
			Node tmp = newNode(key);
			if(skewedRoot == null) skewedRoot = tmp;
			return tmp;
		}
		root.right = skewTreeToRight(root.right, key);
		return root;
		
		
	}
	static void inorderForSkew(Node root) {
		if(root==null)
			return;
		else {
			System.out.print(root.key+" ");
			inorderForSkew(root.right);
		}
			
	}	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		Node root=null;
		
		int[]arr = {50,30,60,10,55};
		for(int i = 0; i<arr.length; i++) {
			root = buildBST(root,arr[i]);
	
		}		
		System.out.println("Right Skewed Tree values are : ");
		transform(root);
		inorderForSkew(skewedRoot);
		sc.close();
		}
		
	}