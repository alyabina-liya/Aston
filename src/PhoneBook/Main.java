package PhoneBook;

public class Main {

    public static void main(String[] args) {

        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Ivanov", "9150000000");
        phoneBook.add("Petrov", "9161111111");
        phoneBook.add("Sidorov", "9172222222");

        // Однофамильцы
        phoneBook.add("Ivanov", "9183333333");
        phoneBook.add("Ivanov", "9194444444");

        System.out.println("Телефоны Иванова:");
        System.out.println(phoneBook.get("Ivanov"));

        System.out.println();

        System.out.println("Телефоны Петрова:");
        System.out.println(phoneBook.get("Petrov"));

        System.out.println();

        System.out.println("Телефоны Сидорова:");
        System.out.println(phoneBook.get("Sidorov"));
    }
}



