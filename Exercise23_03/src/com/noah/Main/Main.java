package com.noah.Main;
/*
Author: 
Date: 

Description: 
*/
import java.util.Comparator;

public class Main {
  public static void main(String[] args) {
    Integer[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
    quickSort(list, 0, list.length - 1);
    for (int i = 0; i < list.length; i++) {
      System.out.print(list[i] + " ");
    }

    System.out.println();
    Circle[] list1 = {new Circle(2), new Circle(3), new Circle(2),
                     new Circle(5), new Circle(6), new Circle(1), new Circle(2),
                     new Circle(3), new Circle(14), new Circle(12)};
    quickSort(list1, 0, list.length - 1, new GeometricObjectComparator());
    for (int i = 0; i < list1.length; i++) {
      System.out.println(list1[i] + " ");
    }
  }
  public static <E extends Comparable<E>> int partition(E[] list, int low, int high) {
	  E pivot = list[high];
	  int s = low - 1;
	  
	  for(int i = low; i <= high - 1; i++) {
		  if(list[i].compareTo(pivot) < 0) {
			  s++;
			  E temp = list[i];
			  list[i] = list[s];
			  list[s] = temp;
		  }
	  }
	  E tmp = list[s + 1];
	  list[s + 1] = list[high];
	  list[high] = tmp;
	  
	  
	  return (s + 1);
  }
  public static <E> int partition(E[] list, int low, int high, Comparator<? super E> comparator) {
	  E pivot = list[high];
	  int s = low - 1;
	  
	  for(int i = low; i <= high - 1; i++) {
		  if(comparator.compare(list[i], pivot) < 0) {
			  s++;
			  E temp = list[i];
			  list[i] = list[s];
			  list[s] = temp;
		  }
	  }
	  E tmp = list[s + 1];
	  list[s + 1] = list[high];
	  list[high] = tmp;
	  
	  
	  return (s + 1);
  }
  public static <E extends Comparable<E>> void quickSort(E[] list, int low, int high) {
	  if(low < high) {
		  int p = partition(list, low, high);
		  quickSort(list, low, p - 1);
		  quickSort(list, p + 1, high);
	  }
  }
  public static <E> void quickSort(E[] list, int low, int high, Comparator<? super E> comparator) {
	  if(low < high) {
		  int p = partition(list, low, high, comparator);
		  quickSort(list, low, p - 1, comparator);
		  quickSort(list, p + 1, high, comparator);
	  }
  }
}