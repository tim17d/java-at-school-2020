public class Duck extends Herbivore {

    public Duck(String nick, int age) {
        this.name = "Утка " + nick;
        this.age = age;
        this.suitableDim = Dimension.SMALL;
    }

    @Override
    public void eat(Food food) {
        try {
            if (food instanceof PlantFood) {
                LOG.info("{} ест {}", this.name, food.name);
            } else {
                if (food instanceof MeatFood.LiveProtein) {
                    LOG.info("{} и такое ест!:) {}", this.name, food.name);
                } else {
                    this.notifyWrongFood(food);
                }
            }
        } catch (WrongFoodException e) {
            LOG.error(String.valueOf(e));
        }
    }


    public void call() {
        System.out.println("Эти утки никого не слушают! Даже " + this.name);
    }

    public void touch() {
        this.soundBad();
    }

    public void soundOk() {
        this.soundBad();
    }

    public void soundBad() {
        System.out.println("КРЯ-КРЯК!");
    }

}
