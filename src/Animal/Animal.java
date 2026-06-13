package Animal;

public class Animal {

    private final String name;
    private final int run;
    private final int swim;

    private static int animalCount = 0;

    public Animal(String name, int run, int swim) {
        this.name = name;
        this.run = run;
        this.swim = swim;
        animalCount++;
    }

    public String getName() {
        return name;
    }

    public int getRun() {
        return run;
    }

    public int getSwim() {
        return swim;
    }

    public static int getAnimalCount() {
        return animalCount;
    }
}