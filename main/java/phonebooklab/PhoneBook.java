package phonebooklab;

import java.util.*;

public class PhoneBook {
    //name : phoneNumber1, phoneNumber1 (multiple phone numbers, maybe work and home)
    //name: phoneNumber1 (one phone number)
    //String, ArrayList of String, Map
    //Map to hold name and phoneNumbers
    //Key is String and value is ArrayList of String

    private Map<String, List<String>> phoneBook;

    public PhoneBook() {
        this(new HashMap<>());
    }

    public PhoneBook(Map<String, List<String>> phoneBook) {
        this.phoneBook = phoneBook;
    }

    //Create a method to add a number to the phone book
    public void add(String name, String number) {
        List<String> numberList = new ArrayList<>();
        numberList.add(number);
        phoneBook.put(name, numberList);
    }


    public void addAll(String name, String... numbers) {
        List<String> numberList = phoneBook.getOrDefault(name, new ArrayList<>());
        numberList.addAll(Arrays.asList(numbers));
        phoneBook.put(name, numberList);
    }



    //Method to remove a person
    public void remove(String name) {
        phoneBook.remove(name);
    }


    //HasEntry - to check if entry exists
    public Boolean hasEntry(String name) {
        //check if name exist in record and return true or false
        return phoneBook.containsKey(name);
    }


    //lookUp (name) - return phone number(s)
    public List<String> lookUp(String name) {
        //return a list of phone numbers belonging to the name
        return phoneBook.getOrDefault(name, new ArrayList<>());
    }


    //reverse lookUp (phoneNumber) - return phone name
    public String reverseLookUp(String number) {
        //takes a phonenumber and returns the name attatached to it
        for (Map.Entry<String, List<String>> entry : phoneBook.entrySet()) {
            if (entry.getValue().contains(number)) {
                return entry.getKey();
            }
        }
        return "Not found";
    }


    //Get all our contacts in the phone book
    public List<String> getAllContactNames() {
        //need a list or container to store the names
        //need to iterate through the map
        //add each name to the list container
        //return the container
        List<String> names = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : phoneBook.entrySet()) {
            names.add(entry.getKey());
        }
        return names;
    }

    @Override
    public String toString() {
        return "PhoneBook{" +
                "phoneBook=" + phoneBook +
                '}';
    }

    public Map<String, List<String>> getPhoneBook() {
        return phoneBook;
    }

    public void setPhoneBook(Map<String, List<String>> phoneBook) {
        this.phoneBook = phoneBook;
    }
}
