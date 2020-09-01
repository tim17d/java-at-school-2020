public abstract class Herbivore extends Animal implements Touch, Sound {

    @Override
    public void eat(Food food) {
        if (food instanceof PlantFood) {
            System.out.println(this.name + " ест " + food.name);
            this.successfulMeal = true;
        } else {
            this.notifyWrongFood(food);
            this.successfulMeal = false;
        }
    }

    public void call() {
        System.out.println("Вы подозвали " + this.name + " . Он дрессирован :)");
    }

    public void touch() {
        System.out.println("Погладьте " + this.name + " или угостите. Он это любит!");
    }
}
