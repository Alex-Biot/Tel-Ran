package telran.test;

import org.junit.Assert;
import org.junit.Test;
import telran.data.CustomArrayList;

public class CustomArrayListTest {

    @Test
    public void testSizeZero(){
        CustomArrayList list = new CustomArrayList();
        Assert.assertEquals(0, list.size());
    }

    @Test
    public void testSizeNotZero(){
        int[] numbers = {1,2,3};
        CustomArrayList<Integer> listNumbers = new CustomArrayList();
        for (int num:numbers) {
            listNumbers.add(num);
        }
        Assert.assertEquals(3,listNumbers.size());
    }

    @Test
    public void testAddCorrectOrder(){
        int[] numbers = {1,2,3};
        CustomArrayList<Integer> listNumbers = new CustomArrayList();
        for (int num:numbers) {
            listNumbers.add(num);
        }
        for (int i = 0; i <numbers.length ; i++) {
            Assert.assertEquals(numbers[i], listNumbers.get(i).intValue());
        }
    }

    @Test
    public void testRemoveByIndex(){
        int[] numbers = {1,2,3,4};  //  "aa", "bb", "cc", "dd"
        CustomArrayList<Integer> listNumbers = new CustomArrayList();
        for (int num:numbers) {
            listNumbers.add(num);  // 1,2,3,4
        }
        Integer actualDeletedNumber = listNumbers.removedByIndex(2); // 3 -> 1,2,4; 1,2,3,4
        int[] expected = {1,2,4};
        for (int i = 0; i <expected.length ; i++) {
            Assert.assertEquals(expected[i], listNumbers.get(i).intValue());
        }
        Assert.assertEquals(3,listNumbers.size());
        Assert.assertEquals(3, actualDeletedNumber.intValue());

    }
}
