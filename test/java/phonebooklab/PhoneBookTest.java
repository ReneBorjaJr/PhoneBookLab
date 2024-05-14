package phonebooklab;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class PhoneBookTest {
    private PhoneBook phoneBook;

    @BeforeEach
    void setUp() {
        phoneBook = new PhoneBook();
    }

    // test for reverseLookup method
    @Test
    void phoneBookDefaultTest() {
        //given
//        PhoneBook phoneBook = new PhoneBook();

        //expected
        boolean expected = true;

        //actual
        boolean actual = phoneBook.getPhoneBook() instanceof HashMap<String, List<String>>;
        assertEquals(expected, actual);
    }

    // test the remove method
    @Test
    void removeTest() {
        //given
//        PhoneBook phoneBook = new PhoneBook();
        //add some entries to the phone book
        phoneBook.add("John", "123-456-7890");
        phoneBook.add("Jane", "987-654-3210");

        // remove an entry
        phoneBook.remove("John");

        //expected
        boolean expected = true;

        //actual
        boolean actual = phoneBook.hasEntry("Jane");
        assertEquals(expected, actual);
    }

    @Test
    void testConstructor() {
        Map<String, List<String>> phoneBook = new HashMap<>();
        phoneBook.put("John", List.of("123-456-7890", "987-654-3210"));
        phoneBook.put("Jane", List.of("555-555-5555"));
        PhoneBook testPhoneBook = new PhoneBook(phoneBook);
        assertEquals(phoneBook, testPhoneBook.getPhoneBook());
    }

    //AddAll tests
    @Test
    void testAddAllWithExistingName() {
//        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("John", "123-456-7890");
        phoneBook.addAll("John", "987-654-3210", "555-555-5555");
        List<String> expected = List.of("123-456-7890", "987-654-3210", "555-555-5555");
        assertEquals(expected, phoneBook.lookUp("John"));
    }

    @Test
    void testAddAllWithNewName() {
//        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addAll("Jane", "555-555-5555", "123-456-7890");
        List<String> expected = List.of("555-555-5555", "123-456-7890");
        assertEquals(expected, phoneBook.lookUp("Jane"));
    }

    @Test
    void testAddAllWithEmptyList() {
        phoneBook.addAll("John", new String[]{});
        List<String> expected = List.of();
        assertEquals(expected, phoneBook.lookUp("John"));
    }

    //reverse lookUp tests
    @Test
    void testReverseLookUpExistingNumber() {
        phoneBook.add("John", "123-456-7890");
        phoneBook.add("Jane", "987-654-3210");
        assertEquals("John", phoneBook.reverseLookUp("123-456-7890"));
    }

    @Test
    void testReverseLookUpNonExistingNumber() {
        phoneBook.add("John", "123-456-7890");
        phoneBook.add("Jane", "987-654-3210");
        assertEquals("Not found", phoneBook.reverseLookUp("000-000-0000"));
    }
}