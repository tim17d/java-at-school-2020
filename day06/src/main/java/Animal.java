import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class Animal {

    protected final Logger LOG = LoggerFactory.getLogger(Animal.class);

    public String name;
    public int age;
    boolean isCaged = false;
    Dimension suitableDim;

    public abstract void eat(Food food) throws WrongFoodException;

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
