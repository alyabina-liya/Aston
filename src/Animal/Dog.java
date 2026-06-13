package Animal;

public class Dog extends Animal {

    private static int dogCount = 0;

    public Dog(String name) {
        super(name, 500, 10);
        dogCount++;
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
        if (distance <= getSwim()) {
            System.out.println(getName() + " проплыл " + distance + " м.");
        } else {
            System.out.println(
                    getName() +
                            " не смог проплыть " +
                            distance +
                            " м. (Лимит " +
                            getSwim() +
                            " м.)");
        }
    }

    public static int getDogCount() {
        return dogCount;
    }
}