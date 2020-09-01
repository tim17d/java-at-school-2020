public class Duck extends Herbivore {

    public Duck(String nick, int age) {
        this.name = "Утка " + nick;
        this.age = age;
    }

    @Override
    public void eat(Food food) {
        if (food instanceof PlantFood) {
            System.out.println(this.name + " ест " + food.name);
            this.successfulMeal = true;
        } else {
            if (food instanceof MeatFood.LiveProtein) {
                System.out.println(this.name + " и такое ест!:) " + food.name);
                this.successfulMeal = true;
            } else {
                this.notifyWrongFood(food);
                this.successfulMeal = false;
            }
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
