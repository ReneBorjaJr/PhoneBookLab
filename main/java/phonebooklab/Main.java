package phonebooklab;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        //objectName.methodName
        //add some phone records
        phoneBook.add("John", "123-456-8476");
        phoneBook.add("Jane", "123-456-7890");
        phoneBook.add("Jim", "123-456-1234");
        System.out.println("=======Print after add========");
        for (Map.Entry<String, List<String>> entry : phoneBook.getPhoneBook().entrySet()) {
            String name = entry.getKey();
            List<String> numbers = entry.getValue();

            for (String number : numbers) {
                System.out.println(name + ": " + number);
            }
        }
        //add all method
        phoneBook.addAll("Rene", "123-456-8476", "123-456-7890", "123-456-1234");
        //print the phone records out in this format "name : number". print all the numbers for each name
        System.out.println("=======Print after addAll========");
        for (Map.Entry<String, List<String>> entry : phoneBook.getPhoneBook().entrySet()) {
            String name = entry.getKey();
            List<String> numbers = entry.getValue();
            String numbersLine = String.join(", ", numbers);

            System.out.println(name + ": " + numbersLine);
        }
        //remove method
        phoneBook.remove("Jim");
        System.out.println("=======Print after remove Jim========");
        for (Map.Entry<String, List<String>> entry : phoneBook.getPhoneBook().entrySet()) {
            String name = entry.getKey();
            List<String> numbers = entry.getValue();
            String numbersLine = String.join(", ", numbers);

            System.out.println(name + ": " + numbersLine);
        }
        //hasEntry method
        System.out.println("=======hasEntry method========");
        System.out.println(phoneBook.hasEntry("Jim"));

        //lookUp method
        System.out.println("=======lookUp method========");
        System.out.println(phoneBook.lookUp("John"));

        //reverseLookUp method
        System.out.println("=======reverseLookUp method========");
        System.out.println(phoneBook.reverseLookUp("123-456-8476"));

        //getAllContactNames method
        System.out.println("=======getAllContactNames method========");
        System.out.println(phoneBook.getAllContactNames());
    }
}
