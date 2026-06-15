public class Main {
    public static void main(String[] args) {

    CoffeeShop coffeeShop = new CoffeeShop("Coffee Time");
    CoffeeShop.Drink Latte = coffeeShop.new Drink("Латте", 250, true);
    CoffeeShop.Drink Capuchino = coffeeShop.new Drink("Капучино", 230, true);
    CoffeeShop.Drink Raff = coffeeShop.new Drink("Раф", 270, true);
    CoffeeShop.Drink Cacao = coffeeShop.new Drink("Какао", 200, true);

        Latte.printDrinkInfo();
        Capuchino.printDrinkInfo();
        Raff.printDrinkInfo();
        Cacao.printDrinkInfo();
    }
}