public abstract class Carnivore extends Animal implements Call, Sound {

    @Override
    public void eat(Food food) {
        if (food instanceof MeatFood) {
            System.out.println(this.name + " ест " + food.name);
            this.successfulMeal = true;
        } else {
            this.notifyWrongFood(food);
            this.successfulMeal = false;
        }
    }

    public void call() {
        System.out.println(this.name + " не реагирует на попытки подозвать. И слава богу!");
    }

}
