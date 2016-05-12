# Java_Algorithm_Supporter
Java Algorithms

This API is a small bundle of some basic algorithm + data structures
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
MyComparator<Integer> myComparator = new MyBinaryTree<>(new MyComparator<Integer>() {
           @Override
           public boolean compare(Integer a, Integer b) {
               return a <= b;
           }

           @Override
           public boolean equals(Integer a, Integer b) {
               return a.equals(b);
           }
       });

MySorter<Integer> mySorter = new MyMergeSort<>(myComparator);

Integer[] input = new Integer[] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
Integer[] result = myMergeSort.sort(input);
```
   

 **Binary-Tree**

```java
MyBinaryTree<Integer> tree = new MyBinaryTree<>(new MyComparator<Integer>() {
            @Override
            public boolean compare(Integer a, Integer b) {
                return a <= b;
            }

            @Override
            public boolean equals(Integer a, Integer b) {
                return a.equals(b);
            }
        });

        tree.addNode(new MyNode<>(new Integer(3)));
        tree.addNode(new MyNode<>(new Integer(7)));
        tree.addNode(new MyNode<>(new Integer(6)));
        tree.addNode(new MyNode<>(new Integer(4)));
        tree.addNode(new MyNode<>(new Integer(1)));
        tree.addNode(new MyNode<>(new Integer(5)));
```

*...more to come*

