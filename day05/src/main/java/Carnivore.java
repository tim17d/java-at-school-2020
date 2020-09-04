public abstract class Carnivore extends Animal implements Call, Sound {

    @Override
    public void eat(Food food) {
        try {
            if (food instanceof MeatFood) {
                LOG.info("{} ест {}", this.name, food.name);
            } else {
                this.notifyWrongFood(food);
            }
        } catch (WrongFoodException e) {
            LOG.error(String.valueOf(e));
        }
    }

    public void call() {
        System.out.println(this.name + " не реагирует на попытки подозвать. И слава богу!");
    }

}
