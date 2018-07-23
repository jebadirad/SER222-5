package jsjf;

/**
 * jsjf.DoubleOrderedList testing area.
 * 
 * @author JonDavid Ebadirad, Acuna
 * @version 1.0
 */
public class Driver {
    public static void main(String [] args) {
        DoubleOrderedList<Integer> list = new DoubleOrderedList<Integer>();
        
        //RA: These are _extremely_ simple tests - do not use them when doing
        //    your writeup.


        list.add(23);
        list.add(24);
        list.add(16);
        list.add(3);	
        list.add(7);
        list.add(17);	
        list.add(9);	
        list.add(13);	
        list.add(14);	
        list.add(1);

        System.out.println(list);
        
        list.remove(7);
        list.removeFirst();
        list.remove(17);
        list.removeLast();
        list.remove(14);
        list.removeLast();
        
        System.out.println(list);
        
        /* Test Results:
            1 3 7 9 13 14 16 17 23 24 
            3 9 13 16 
        */
        System.out.println("Starting custom tests");
        System.out.println("Adding tests");
        System.out.println("New list");
        DoubleOrderedList<Integer> customList = new DoubleOrderedList<Integer>();
        //add empty,
        System.out.println("Adding 1 on empty list");
        customList.add(1);
        System.out.println("Expected: 1");
        print(customList);
        System.out.println("New list");
        //add 1 before
        customList = new DoubleOrderedList<Integer>();
        customList.add(1);
        customList.add(0);
        System.out.println("Adding 1, then adding 0 on empty list");
        System.out.println("Expected: 0 1");
        print(customList);

        System.out.println("New list");
        //add 1 after
        customList = new DoubleOrderedList<Integer>();
        customList.add(0);
        customList.add(1);
        System.out.println("Adding 0, then adding 1 on empty list");
        System.out.println("Expected: 0 1");
        print(customList);

        System.out.println("New list");
        //add after
        customList = new DoubleOrderedList<Integer>();
        customList.add(0);
        customList.add(55);
        customList.add(1);
        System.out.println("Adding 0, then adding 55, then adding 1 on empty list");
        System.out.println("Expected: 0 1 55");
        print(customList);

        System.out.println("New list");
        //add before
        customList = new DoubleOrderedList<Integer>();
        customList.add(1);
        customList.add(55);
        customList.add(0);
        System.out.println("Adding 1, then adding 55, then adding 0 on empty list");
        System.out.println("Expected: 0 1 55");
        print(customList);

        System.out.println("New list");
        //add any
        customList = new DoubleOrderedList<Integer>();
        customList.add(1);
        customList.add(55);
        customList.add(0);
        customList.add(5);
        System.out.println("Adding 1, then adding 55, then adding 0, then adding 5 on empty list");
        System.out.println("Expected: 0 1 5 55");
        print(customList);
        System.out.println(" ");
        System.out.println("Starting Remove Tests");
        System.out.println("New list");
        //remove any
        customList = new DoubleOrderedList<Integer>();
        customList.add(1);
        customList.add(2);
        customList.add(3);
        customList.add(4);
        customList.add(5);
        System.out.println("Adding 1,2,3,4,5 on empty list");
        System.out.println("Removing 3");
        customList.remove(3);
        System.out.println("Expected: 1 2 4 5");
        print(customList);


        System.out.println("New list");
        //remove head with remove and removefirst
        customList = new DoubleOrderedList<Integer>();
        customList.add(1);
        customList.add(2);
        customList.add(3);
        customList.add(4);
        customList.add(5);
        System.out.println("Adding 1,2,3,4,5 on empty list");
        System.out.println("Removing using removeFirst");
        customList.removeFirst();
        System.out.println("Expected: 2 3 4 5");
        print(customList);
        System.out.println("Removing 2");
        customList.remove(2);
        System.out.println("Expected: 3 4 5");
        print(customList);

        System.out.println("New list");
        //remove tail with remove and removelast
        customList = new DoubleOrderedList<Integer>();
        customList.add(1);
        customList.add(2);
        customList.add(3);
        customList.add(4);
        customList.add(5);
        System.out.println("Adding 1,2,3,4,5 on empty list");
        System.out.println("Removing using removeLast");
        customList.removeLast();
        System.out.println("Expected: 1 2 3 4");
        print(customList);
        System.out.println("Removing 4");
        customList.remove(4);
        System.out.println("Expected: 1 2 3");
        print(customList);

        System.out.println("New list");
        //remove head size 1 with remove and removefirs
        customList = new DoubleOrderedList<Integer>();
        customList.add(1);
        System.out.println("Adding 1 on empty list");
        System.out.println("Removing using removeFirst");
        customList.removeFirst();
        System.out.println("Expected: ");
        print(customList);
        System.out.println("Adding 1");
        customList.add(1);
        System.out.println("Removing 1");
        customList.remove(1);
        System.out.println("Expected: ");
        print(customList);

        System.out.println("New list");
        //remove tail size 1 with remove and removelast
        customList = new DoubleOrderedList<Integer>();
        customList.add(1);
        System.out.println("Adding 1 on empty list");
        System.out.println("Removing using removeLast");
        customList.removeLast();
        System.out.println("Expected: ");
        print(customList);
        System.out.println("Adding 1");
        customList.add(1);
        System.out.println("Removing 1");
        customList.remove(1);
        System.out.println("Expected: ");
        print(customList);

        System.out.println("New list");
        //remove head with size 2
        customList = new DoubleOrderedList<Integer>();
        customList.add(1);
        customList.add(2);
        System.out.println("Adding 1,2 on empty list");
        System.out.println("Removing using removeFirst");
        customList.removeFirst();
        System.out.println("Expected: 2");
        print(customList);
        System.out.println("Adding 1");
        customList.add(1);
        System.out.println("Removing 1");
        customList.remove(1);
        System.out.println("Expected: 2");
        print(customList);

        System.out.println("New list");
        //remove tail with size 2
        customList = new DoubleOrderedList<Integer>();
        customList.add(1);
        customList.add(2);
        System.out.println("Adding 1,2 on empty list");
        System.out.println("Removing using removeLast");
        customList.removeLast();
        System.out.println("Expected: 1");
        print(customList);
        System.out.println("Adding 2");
        customList.add(2);
        System.out.println("Removing 2");
        customList.remove(2);
        System.out.println("Expected: 1");
        print(customList);


    }
    public static void print(DoubleOrderedList<Integer> list){
        System.out.println("Actual: " + list.toString());

    }
}
