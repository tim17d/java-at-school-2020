public abstract class Carnivore extends Animal {

    @Override
    public String getType() {
        return "[хищник]";
    }

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

    public static class Tiger extends Carnivore {
        public Tiger(String nick, int age) {
            this.name = "Тигр " + nick;
            this.age = age;
        }
    }

    public static class Wolf extends Carnivore {
        public Wolf(String nick, int age) {
            this.name = "Волк " + nick;
            this.age = age;
        }
    }

    public static class Alligator extends Carnivore {
        public Alligator(String nick, int age) {
            this.name = "Аллигатор " + nick;
            this.age = age;
        }
    }

}
