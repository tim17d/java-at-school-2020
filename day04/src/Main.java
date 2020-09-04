public class Main {

    public static void main(String[] args) {

        //Новый зоопарк
        Zoo zoo = new Zoo("\"WhatTheZoo?!\"");
        System.out.println();

        //Завозим животных
        Panda panda = new Panda("Энди", 1);
        Giraffe giraffe = new Giraffe("Гари", 3);
        Lemur lemur = new Lemur("Тимми", 10);
        Duck duck = new Duck("Дашутка", 2);

        Tiger tiger = new Tiger("Иннокентий", 5);
        Wolf wolf = new Wolf("Степан", 15);
        Alligator alligator = new Alligator("Алли", 0);

        //Создаем клетки
        Cage<Carnivore> cage1 = new Cage<>(2, "LARGE", zoo);
        Cage<Herbivore> cage2 = new Cage<>(5, "SMALL", zoo);
        Cage<Giraffe> cage3 = new Cage<>(1, "EXTRA_LARGE", zoo);
        Cage<Wolf> cage4 = new Cage<>(3, "MEDIUM", zoo);
        System.out.println();

        //Клетка для хищников, большая
        cage1.addAnimal(tiger);
        cage1.addAnimal(alligator);
        cage1.getAnimals();
        cage1.feedAnimal(tiger, new PlantFood.Grass());
        System.out.println();

        //Клетка для травоядных, маленькая
        cage2.addAnimal(lemur);
        cage2.addAnimal(panda);
        cage2.addAnimal(duck);
        cage2.addAnimal(giraffe);
        cage2.getAnimals();
        cage2.feedAnimal(duck, new PlantFood.Grass());
        cage2.feedAnimal(duck, new MeatFood.DoneMeat());
        cage2.feedAnimal(duck, new MeatFood.LiveProtein());
        System.out.println();

        //Клетка для жирафов, экстра-большая
        cage3.addAnimal(giraffe);
        cage3.getAnimals();
        System.out.println();

        //Клетка для волков, средняя
        cage4.addAnimal(wolf);
        cage4.getAnimals();
        System.out.println();

    }
}
