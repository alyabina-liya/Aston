package Animal;

public class Main {

    public static void main(String[] args) {

        System.out.println("    Бег и плавание    ");

        Cat cat1 = new Cat("Мурзик");
        Cat cat2 = new Cat("Барсик");
        Cat cat3 = new Cat("Пушок");

        Dog dog1 = new Dog("Шарик");
        Dog dog2 = new Dog("Бобик");
        Dog dog3 = new Dog("Рыжик");

        cat1.run(200);
        cat2.run(300);
        cat3.run(5);

        cat1.swim(1);
        cat2.swim(2);
        cat3.swim(3);

        dog1.run(500);
        dog2.run(600);
        dog3.run(1000);

        dog1.swim(10);
        dog2.swim(15);
        dog3.swim(2);

        System.out.println();
        System.out.println("    Счётчики    ");

        System.out.println(
                "Всего животных: " +
                        Animal.getAnimalCount());

        System.out.println(
                "Котов: " +
                        Cat.getCatCount());

        System.out.println(
                "Собак: " +
                        Dog.getDogCount());

        System.out.println();
        System.out.println("    Кормление котов    ");

        Cat[] cats = {cat1, cat2, cat3};

        Plate plate = new Plate(20);

        System.out.println(
                "Изначально в миске еды: " +
                        plate.getFood());

        cats[0].eat(plate, 15);
        cats[1].eat(plate, 20);
        cats[2].eat(plate, 10);

        plate.addFood(25);

        cats[1].eat(plate, 20);
        cats[2].eat(plate, 10);

        System.out.println();
        System.out.println("    Сытость котов    ");

        for (Cat cat : cats) {
            System.out.println(
                    cat.getName() +
                            " сыт? " +
                            cat.isSatiated());
        }

        System.out.println();
        System.out.println(
                "Остаток еды в миске: " +
                        plate.getFood());
    }
}