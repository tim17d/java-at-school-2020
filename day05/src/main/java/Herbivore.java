public abstract class Herbivore extends Animal implements Touch, Sound {

    @Override
    public void eat(Food food) {
        try {
            if (food instanceof PlantFood) {
                LOG.info("{} ест {}", this.name, food.name);
            } else {
                this.notifyWrongFood(food);
            }
        } catch (WrongFoodException e) {
            LOG.error(String.valueOf(e));
        }
    }

    public void call() {
        System.out.println("Вы подозвали " + this.name + " . Он дрессирован :)");
    }

    public void touch() {
        System.out.println("Погладьте " + this.name + " или угостите. Он это любит!");
    }
}
