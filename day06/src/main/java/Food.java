public abstract class Food {

    public String name;

    public static Food randomFood() {
        Food food = new PlantFood.Grass();
        int res = (int) Math.ceil(Math.random() * 10);
        switch (res) {
            case 1:
                food = new MeatFood.RawMeat();
                break;
            case 2:
                food = new MeatFood.DoneMeat();
                break;
            case 3:
                food = new MeatFood.LiveProtein();
                break;
            case 4:
                food = new PlantFood.CompoundFeed();
                break;
            case 5:
                food = new PlantFood.Fruit();
                break;
            case 6:
            case 7:
            case 8:
            case 9:
                randomFood();
                break;
        }
        return food;
    }

}
