public abstract class Herbivore extends Animal {

    @Override
    public String getType() {
        return "[травоядное]";
    }

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

    public static class Panda extends Herbivore {
        public Panda(String nick, int age) {
            this.name = "Панда " + nick;
            this.age = age;
        }
    }

    public static class Giraffe extends Herbivore {
        public Giraffe(String nick, int age) {
            this.name = "Жираф " + nick;
            this.age = age;
        }
    }

     public static class Lemur extends Herbivore {
         public Lemur(String nick, int age) {
             this.name = "Лемур " + nick;
             this.age = age;
         }
     }

    public static class Duck extends Herbivore {
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
    }

}
