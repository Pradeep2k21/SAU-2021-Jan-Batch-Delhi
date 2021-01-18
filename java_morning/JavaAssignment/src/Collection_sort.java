import java.util.*;


public class Collection_sort {

    void sortListUsingCollection(){
        ArrayList<Integer> listOfIntegers = new ArrayList<Integer>();
        listOfIntegers.add(31);
        listOfIntegers.add(287);
        listOfIntegers.add(76);
        listOfIntegers.add(38);
        listOfIntegers.add(452);
        listOfIntegers.add(001);
        System.out.println("Before Sorting our List is:");
        for(int loop: listOfIntegers){
            System.out.println(loop);
        }

        Collections.sort(listOfIntegers);

        System.out.println("List After Sorting:");
        for(int loop: listOfIntegers){
            System.out.println(loop);
        }
    }

    void sortUsingPQ(){
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(56);
        pq.add(7);
        pq.add(67);
        pq.add(123);
        pq.add(1);
        System.out.println("Using PQ");
        Iterator iterator = pq.iterator();

        while (iterator.hasNext()) {
            System.out.print(pq.poll() + " ");
        }
        System.out.println();
    }
    public static void main(String args[]){
        Collection_sort sc = new Collection_sort();
        sc.sortUsingPQ(); //one collection
        sc.sortListUsingCollection(); //another using arraylist
    }
}
