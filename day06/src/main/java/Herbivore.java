public abstract class Herbivore extends Animal implements Touch, Sound {

    @Override
    public void eat(Food food) throws WrongFoodException {
        if (food instanceof PlantFood) {
            return;
//            LOG.info("{} ест {}", this.name, food.name);
        } else {
            throw new WrongFoodException("НЕПОДХОДЯЩЕЕ ПИТАНИЕ. " + this.name + " не ест " + food.name);
        }
    }

    public void call() {
        System.out.println("Вы подозвали " + this.name + " . Он дрессирован :)");
    }

    public void touch() {
        System.out.println("Погладьте " + this.name + " или угостите. Он это любит!");
    }
}
