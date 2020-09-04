public abstract class Herbivore extends Animal implements Touch, Sound {

    @Override
    public void eat(Food food) {
        try {
            if (food instanceof PlantFood) {
                System.out.println(this.name + " ест " + food.name);
            } else {
                this.notifyWrongFood(food);
            }
        } catch (WrongFoodException e) {
            e.printStackTrace();
        }
    }

    public void call() {
        System.out.println("Вы подозвали " + this.name + " . Он дрессирован :)");
    }

    public void touch() {
        System.out.println("Погладьте " + this.name + " или угостите. Он это любит!");
    }
}
