public class CoffeeShop {
    private String name;

    public CoffeeShop(String name) {
        this.name = name;
    }

    public class Drink {
        private String name;
        private int cost;
        private boolean milk;

        public Drink(
                String name,
                int cost,
                boolean milk) {
            this.name = name;
            this.cost = cost;
            this.milk = milk;
        }
                public void printDrinkInfo() {
                    System.out.println("Кофе: " + name + ", Стоимость: " + cost + ", С молоком: " + milk);

                }
            }


}
