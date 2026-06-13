package Animal;

public class Cat extends Animal {

    private static int catCount = 0;

    private boolean satiated = false;

    public Cat(String name) {
        super(name, 200, 0);
        catCount++;
    }

    public void run(int distance) {
        if (distance <= getRun()) {
            System.out.println(getName() + " пробежал " + distance + " м.");
        } else {
            System.out.println(
                    getName() +
                            " не смог пробежать " +
                            distance +
                            " м. (Лимит " +
                            getRun() +
                            " м.)");
        }
    }

    public void swim(int distance) {
        System.out.println(getName() + " не умеет плавать!");
    }

    public void eat(Plate plate, int foodNeeded) {

        if (foodNeeded <= 0) {
            System.out.println(getName() + ": количество еды должно быть больше 0.");
            return;
        }

        if (satiated) {
            System.out.println(getName() + " уже сыт.");
            return;
        }

        if (plate.getFood() >= foodNeeded) {
            plate.decreaseFood(foodNeeded);
            satiated = true;

            System.out.println(
                    getName() +
                            " съел " +
                            foodNeeded +
                            " еды и теперь сыт.");
        } else {
            System.out.println(
                    getName() +
                            " хотел съесть " +
                            foodNeeded +
                            " еды, но еды недостаточно.");
        }
    }

    public boolean isSatiated() {
        return satiated;
    }

    public static int getCatCount() {
        return catCount;
    }
}