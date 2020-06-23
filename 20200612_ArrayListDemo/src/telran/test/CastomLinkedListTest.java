package telran.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import telran.data.CustomArrayList;
import telran.data.CustomLinkedList;

public class CustomLinkedListTest {
    CustomLinkedList list;

    @Before
    public void init() {
        list = new CustomLinkedList();
    }

    @Test
    public void testSizeZero(){
        // CustomLinkedList<Integer> listNumbers = new CustomLinkedList();
        Assert.assertEquals(0, list.size());
    }

    @Test
    public void testSizeNotZero(){
        int[] numbers = {1,2,3};
        //CustomLinkedList<Integer> listNumbers = new CustomLinkedList();
        for (int num:numbers) {
            list.add(num);
        }
        Assert.assertEquals(3,list.size());
    }

    @Test
    public void testAddCorrectOrder(){
        int[] numbers = {1,2,3};
        //CustomLinkedList<Integer> listNumbers = new CustomLinkedList();
        for (int num:numbers) {
            list.add(num);
        }
        for (int i = 0; i <numbers.length ; i++) {
            Assert.assertEquals(numbers[i], (int)list.get(i));
        }
    }

    @Test
    public void testRemoveByIndex(){
        int[] numbers = {1,2,3,4};  //  "aa", "bb", "cc", "dd"
        // CustomArrayList<Integer> listNumbers = new CustomArrayList();
        for (int num:numbers) {
            list.add(num);  // 1,2,3,4
        }
        Integer actualDeletedNumber = (int)list.removedByIndex(2); // 3 -> 1,2,4; 1,2,3,4
        int[] expected = {1,2,4};
        for (int i = 0; i <expected.length ; i++) {
            Assert.assertEquals(expected[i], (int)list.get(i));
        }
        Assert.assertEquals(3,list.size());
        Assert.assertEquals(3, actualDeletedNumber.intValue());

    }

    @Test
    public void testRemoveByElement(){
        String [] input = {"aa", "bb", "cc", "dd"};
        //CustomArrayList<String> listString = new CustomArrayList<>();

        for(String s : input){
            list.add(s);
        }
        boolean isRemoved = list.remove("aa");
        String[] expected = {"bb", "cc", "dd"};

        boolean isNotRemoved = list.remove("ff");

        Assert.assertTrue(isRemoved);
        Assert.assertFalse(isNotRemoved);
        for (int i = 0; i < expected.length; i++) {
            Assert.assertEquals(expected[i], list.get(i));
        }
        Assert.assertEquals(3, list.size());
    }
}