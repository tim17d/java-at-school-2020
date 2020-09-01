public class Zoo {

    String name;
    public int totalAnimals = 0;
    private int totalCages = 0;

    public Zoo(String name) {
        this.name = name;
        System.out.println("Добро пожаловать в " + name);
    }

    public void incCagesQuantity() {
        this.totalCages++;
    }

    public int getCagesQuantity() {
        return this.totalCages;
    }

}