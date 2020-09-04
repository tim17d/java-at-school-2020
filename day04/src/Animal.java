public abstract class Animal {

    public String name;
    public int age;
    boolean isCaged = false;
    Dimension suitableDim;

    public abstract void eat(Food food);

    protected void notifyWrongFood(Food food) throws WrongFoodException {
//        System.out.println(this.name + " такое не ест! " + food.name); - старый способ
        throw new WrongFoodException("НЕПОДХОДЯЩЕЕ ПИТАНИЕ. " + this.name + " не ест " + food.name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || this.getClass() != obj.getClass())
            return false;
        Animal animalObj = (Animal) obj;
        return this.name.equals(animalObj.name); // упрощенное сравнение по уникальному полю
    }

    @Override
    public int hashCode() {
        byte[] source = this.name.getBytes();
        int hashSum = 0;
        for (int i = 0; i < source.length; i++) {
            hashSum += source[i];
        }
        return hashSum;
    }

}
