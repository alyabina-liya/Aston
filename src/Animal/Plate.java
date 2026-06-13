package Animal;

public class Plate {

    private int food;

    public Plate(int food) {
        this.food = Math.max(food, 0);
    }

    public int getFood() {
        return food;
    }

    public void addFood(int amount) {

        if (amount <= 0) {
            throw new IllegalArgumentException(
                    "Количество еды должно быть больше нуля");
        }

        food += amount;

        System.out.println(
                "В миску добавили " +
                        amount +
                        " еды. Теперь в миске " +
                        food);
    }

    public void decreaseFood(int amount) {
        if (food >= amount) {
            food -= amount;
        }
    }
}