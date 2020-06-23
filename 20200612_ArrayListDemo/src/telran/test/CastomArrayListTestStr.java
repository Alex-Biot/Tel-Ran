package telran.test;

import org.junit.Assert;
import org.junit.Test;
import telran.data.CustomArrayList;

public class CastomArrayListTestStr {
    @Test
    public void testSizeZero(){
        CustomArrayList list = new CustomArrayList();
        Assert.assertEquals(0, list.size());
    }

    @Test
    public void testSizeNotZero(){
        String[] numbers = {"aa", "bb", "cc","dd"};
        CustomArrayList<String> listNumbers = new CustomArrayList();
        for (int i = 0; i < numbers.length; i++) {
            listNumbers.add(numbers[i]);

        }
        Assert.assertEquals(3,listNumbers.size());
    }

    @Test
    public void testAddCorrectOrder(){
        String[] numbers = {"aa", "bb", "cc","dd"};
        CustomArrayList<String> listNumbers = new CustomArrayList();

        for (int i = 0; i <numbers.length ; i++) {
            listNumbers.add(numbers[i]);
            System.out.println(numbers[i]+"  "+listNumbers.get(i));
            Assert.assertEquals(numbers[i], listNumbers.get(i));

        }
       /*for (int i = 0; i <numbers.length ; i++) {


        }*/
    }

    @Test
    public void testRemoveByIndex(){
        String[] numbers = {"aa", "bb", "cc","dd"};  //  "aa", "bb", "cc", "dd"
        CustomArrayList<String> listNumbers = new CustomArrayList();


        for (String num:numbers) {
            listNumbers.add(num);  // 1,2,3,4
        }
        String actualDeletedNumber = listNumbers.removedByIndex(2); // "aa", "bb", "cc", "dd" -> "aa", "bb", "dd"
        String[] expected = {"aa", "bb", "dd"};
        for (int i = 0; i <expected.length ; i++) {
            Assert.assertEquals(expected[i], listNumbers.get(i));
        }
        Assert.assertEquals(3,listNumbers.size());
        Assert.assertEquals("cc", actualDeletedNumber);

    }
    @Test
    public void testRemoveByData() {
        String[] numbers = {"aa", "bb", "cc", "dd"};  //
        CustomArrayList<String> listNumbers = new CustomArrayList();


        for (String num : numbers) {
            listNumbers.add(num);  // 1,2,3,4
        }
        boolean actualDeletedBoolean = listNumbers.removeByDate("cc"); // "aa", "bb", "cc", "dd" -> "aa", "bb", "dd"
        String[] expected = {"aa", "bb", "dd"};
        for (int i = 0; i < expected.length; i++) {
            Assert.assertEquals(expected[i], listNumbers.get(i));
        }
        Assert.assertEquals(3, listNumbers.size());
        Assert.assertEquals(true, actualDeletedBoolean);
        System.out.println(actualDeletedBoolean);
    }
    @Test
    public void testRemoveByDataFalse() {
        String[] numbers = {"aa", "bb", "cc", "dd"};  //
        CustomArrayList<String> listNumbers = new CustomArrayList();


        for (String num : numbers) {
            listNumbers.add(num);  //
        }
        boolean actualDeletedBoolean = listNumbers.removeByDate("cc"); // "aa", "bb", "cc", "dd" -> "aa", "cc", "dd"
        String[] expected = {"aa", "cc", "dd"};                           // exp cc act bb
        for (int i = 0; i < expected.length; i++) {
            Assert.assertEquals(expected[i], listNumbers.get(i));
        }
        Assert.assertEquals(3, listNumbers.size());
        Assert.assertEquals(true, actualDeletedBoolean);

    }

}
