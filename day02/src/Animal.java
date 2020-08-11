public abstract class Animal {

    public String name;
    public int age;
    boolean isCaged = false;
    int cageNum = 0; // safe initialization cheat
    boolean successfulMeal;

    public abstract String getType();

    public abstract void eat(Food food);

    protected void notifyWrongFood(Food food) {
        System.out.println(this.name + " такое не ест! " + food.name);
    }
}
