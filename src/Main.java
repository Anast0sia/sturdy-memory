import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> set = new HashSet<>();
        Map<Address, Integer> costPerAddress = new HashMap<>();
        costPerAddress.put(new Address("Россия", "Казань"), 200);
        costPerAddress.put(new Address("Россия", "Санкт-Петербург"), 300);
        costPerAddress.put(new Address("Россия", "Москва"), 100);
        costPerAddress.put(new Address("Россия", "Владивосток"), 900);
        costPerAddress.put(new Address("США", "Нью-Йорк"), 1200);
        costPerAddress.put(new Address("Испания", "Мадрид"), 1100);
        costPerAddress.put(new Address("Австралия", "Сидней"), 1000);
        var sumTotal = 0;
        while (true) {
            System.out.println("Заполнение нового заказа.");
            System.out.print("Введите страну: ");
            String country = scanner.next();
            if (country.equals("end")) {
                break;
            }
            System.out.print("Введите город: ");
            String city = scanner.next();
            if (city.equals("end")) {
                break;
            }
            System.out.print("Введите вес (кг): ");
            String text = scanner.next();
            if (text.equals("end")) {
                break;
            }
            Address address = new Address(country, city);
            int weight = Integer.parseInt(text);
            if (costPerAddress.containsKey(address)) {
                int sum = costPerAddress.get(address) * weight;
                sumTotal += sum;
                set.add(country);
                System.out.println("Стоимость доставки составит: " + sum);
                System.out.println("Общая стоимость всех доставок: " + sumTotal);
                System.out.println("Количество уникальных стран: " + set.size());
            } else {
                System.out.println("Доставки по этому адресу нет");
            }
            System.out.println();
        }
    }
}