public abstract class Carnivore extends Animal implements Call, Sound {

    @Override
    public void eat(Food food) throws WrongFoodException {
        if (food instanceof MeatFood) {
            return;
 //           LOG.info("{} ест {}", this.name, food.name);
        } else {
            throw new WrongFoodException("НЕПОДХОДЯЩЕЕ ПИТАНИЕ. " + this.name + " не ест " + food.name);
        }
    }

    public void call() {
        System.out.println(this.name + " не реагирует на попытки подозвать. И слава богу!");
    }

}
