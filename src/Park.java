public class Park {

    private String parkName;

    public Park(String parkName) {
        this.parkName = parkName;
    }

    public class Attraction {
        private String name;
        private String workingHours;
        private int price;

        public Attraction(
                String name,
                String workingHours,
                int price) {
            this.name = name;
            this.workingHours = workingHours;
            this.price = price;
        }

        public void printAttractionInfo() {

            System.out.println("Парк: " + parkName);
            System.out.println("Аттракцион: " + name);
            System.out.println("Время работы: " + workingHours);
            System.out.println("Стоимость: " + price + " руб.");
            System.out.println("---------------------------");
        }
    }
}