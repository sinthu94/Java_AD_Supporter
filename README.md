# Java_Algorithm_Supporter
Java Algorithms

This API is a small bundle of some basic algorithm and data structures
and should help you to use them in your customized situation.

Just use it like:


 **Sort-Algorithm:**  
 + Merge Sort
 
 + Bubble Sort
 
 + Ripple Sort  
 
 + Insert Sort  
 
 
 At first, you have to create your own comparator with **MyComparator**.
 You can use here any Java-Object you want for the comparison.
 After that, just initialize the Sort-Algorithm you want with your custom comparator.
 
```java
private MyComparator<Integer> myComparator = (a, b) -> a <= b;
private MySorter<Integer> mySorter = new MyMergeSort<>(myComparator);

private Integer[] input = new Integer[] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
Integer[] result = myMergeSort.sort(input);
```

*...more to come*

