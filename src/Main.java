import java.util.*;

public class Main {
    /*
     * Реализовать телефонный справочник.
     * В справочнике есть фамилии и номера телефонов.
     * В справочнике обычно ищем номер по фамилии.
     * При этом могут быть однофамильцы -> за одной фамилией скрывается несколько номеров
     * <p>
     * Пример
     * "Иванов", "123456"
     * "Васильев", "321456"
     * "Петрова", "234561"
     * "Иванов", "234432"
     * "Петрова", "654321"
     * "Иванов", "345678"
     * <p>
     * Вывести номера по фамилии Иванов.
     */
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Иванов", "123456"); // !
        phoneBook.add("Васильев", "321456");
        phoneBook.add("Петрова", "234561");
        phoneBook.add("Иванов", "234432"); // !
        phoneBook.add("Петрова", "654321");
        phoneBook.add("Иванов", "345678"); // !

        System.out.println(phoneBook.getBySurname("Иванов"));
        System.out.println(phoneBook.getBySurname("Петрова"));
        System.out.println(phoneBook.getBySurname("Честнов"));
    }
}

class PhoneBook {

    private final Map<String, List<String>> storage = new HashMap<>();

    public void add(String surname, String phoneNumber) {
        if (!storage.containsKey(surname)) {
            List<String> phoneNumberList = new ArrayList<>();
            phoneNumberList.add(phoneNumber);
            storage.put(surname, phoneNumberList);
        } else {
            List<String> phoneNumberList = storage.get(surname);
            phoneNumberList.add(phoneNumber);
            storage.put(surname, phoneNumberList);
        }
    }

    public Collection<List<String>> getBySurname(String surname) {
        for (int i = 0; i < storage.size(); i++) {
            if (storage.containsKey(surname)) {
                return Collections.singleton(storage.get(surname));
            }
        }
        return null;
    }
}