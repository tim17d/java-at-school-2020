public abstract class Carnivore extends Animal implements Call, Sound {

    @Override
    public void eat(Food food) {
        try {
            if (food instanceof MeatFood) {
                System.out.println(this.name + " ест " + food.name);
            } else {
                this.notifyWrongFood(food);
            }
        } catch (WrongFoodException e) {
            e.printStackTrace();
        }
    }

    public void call() {
        System.out.println(this.name + " не реагирует на попытки подозвать. И слава богу!");
    }

}
