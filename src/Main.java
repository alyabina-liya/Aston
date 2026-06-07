import java.time.LocalTime;
public class Main {
    public static void main(String[] args) {

        Product product = new Product(
                "Doll",
                "01.01.2026",
                "Фабрика игрушек",
                "Russia",
                1000,
                true
        );
        product.printInfo();
        System.out.println("-----");

        Product[] productsArray = new Product[5];
        {
            productsArray[0] = new Product("Samsung S25 Ultra", "01.02.2025", "Samsung Corp.", "Korea", 5599, true);
            productsArray[1] = new Product("Samsung S25 Ultra", "01.03.2025", "Samsung Corp.", "Korea", 5599, true);
            productsArray[2] = new Product("Samsung S25 Ultra", "01.04.2025", "Samsung Corp.", "Korea", 5599, true);
            productsArray[3] = new Product("Samsung S25 Ultra", "01.05.2025", "Samsung Corp.", "Korea", 5599, true);
            productsArray[4] = new Product("Samsung S25 Ultra", "01.06.2025", "Samsung Corp.", "Korea", 5599, true);
            for (int i = 0; i < productsArray.length; i++) {
                productsArray[i].printInfo();
                System.out.println();
                System.out.println("-----");
            }
        }

                Park park = new Park("Центральный Парк Горького");
                Park.Attraction rollerCoaster = park.new Attraction("Американские горки", "10:00 - 22:00", 1000);
                Park.Attraction ferrisWheel = park.new Attraction("Колесо обозрения", "10:00 - 22:00", 2000);

                rollerCoaster.printAttractionInfo();
                ferrisWheel.printAttractionInfo();
            }
        }



