import java.util.ArrayList;
import java.util.List;

public class MergeTwoSortedList
{
    public static void main(String args[])
    {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> mergedList = new ArrayList<>();

        // Initialise the two lists
        for (int i = 0; i < 5; i++)
        {
            list1.add(i);
            //list2.add(i+1);
        }

        for (int i = 0; i < 10; i++)
            list2.add(i);

        System.out.println("List 1: " + list1);
        System.out.println("List 2: " + list2);

        // merge the two sorted lists
        MergeTwoSortedList(list1, list2, mergedList);

        System.out.println("Merged Sorted List: " + mergedList);
    }

    public static void MergeTwoSortedList(List<Integer> list1, List<Integer> list2, List<Integer> list3)
    {
        int pl1 = 0; // index to list1
        int pl2 = 0; // index to list2

        while(pl1 < list1.size() && pl2 < list2.size())
        {
            if (list1.get(pl1) <= list2.get(pl2))
            {
                list3.add(list1.get(pl1++));
            }
            else
            {
                list3.add(list2.get(pl2++));
            }
        }

        // copy rest of the elements of list 1
        while (pl1 < list1.size())
            list3.add(list1.get(pl1++));

        while (pl2 < list2.size())
            list3.add(list2.get(pl2++));
    }
}