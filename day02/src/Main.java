public class Main {

    public static void main(String[] args) {

        //Новый зоопарк
        Zoo zoo = new Zoo("\"WhatTheZoo?!\"");
        System.out.println();

        //Завозим животных
        Herbivore.Panda panda = new Herbivore.Panda("Энди", 1);
        Herbivore.Giraffe giraffe1 = new Herbivore.Giraffe("Гари", 3);
        Herbivore.Giraffe giraffe2 = new Herbivore.Giraffe("Ники", 3);
        Herbivore.Lemur lemur = new Herbivore.Lemur("Тимми", 10);
        Herbivore.Duck duck = new Herbivore.Duck("Дашутка", 2);

        Carnivore.Tiger tiger = new Carnivore.Tiger("Иннокентий", 5);
        Carnivore.Wolf wolf = new Carnivore.Wolf("Степан", 15);
        Carnivore.Alligator alligator = new Carnivore.Alligator("Али", 0);

        //Достаем коробки с какой-то пищей
        Food[] boxOfFood1 = Food.giveBoxOfFood();
        Food[] boxOfFood2 = Food.giveBoxOfFood();

        //Кормим разной едой
        giraffe1.eat(boxOfFood1[3]);
        tiger.eat(boxOfFood2[0]);
        alligator.eat(boxOfFood1[4]);
        lemur.eat(boxOfFood2[1]);
        System.out.println();

        //Создаем клетки
        Cage cage1 = new Cage(2, zoo);
        Cage cage2 = new Cage(5, zoo);
        Cage cage3 = new Cage(1, zoo);
        Cage cage4 = new Cage(3, zoo);
        Cage cage5 = new Cage(10, zoo);
        System.out.println();

        //Сначала посадим хищника
        cage1.addAnimal(tiger);
        cage1.addAnimal(giraffe1);
        System.out.println();

        //Сначала посадим травоядного
        cage2.addAnimal(lemur);
        cage2.addAnimal(wolf);
        cage2.addAnimal(panda);
        cage2.addAnimal(duck);
        System.out.println();

        //Проверим тесную клетку на 1 животного
        cage3.addAnimal(giraffe1);
        cage3.addAnimal(giraffe2);
        System.out.println();

        //Попробуем сначала посадить того, кто уже сидит в другой клетке
        cage4.addAnimal(giraffe1);
        cage4.addAnimal(alligator);
        cage4.addAnimal(wolf);
        System.out.println();

        cage5.touchCage();
        System.out.println();

        //Взаимодействуем с клетками и животными в них
        cage1.touchCage();
        cage1.feedAnimal(tiger, Food.randomFood());
        System.out.println();

        cage2.touchCage();
        cage2.feedAnimal(tiger, Food.randomFood());
        cage2.feedAnimal(panda, Food.randomFood());
        cage2.feedAnimal(duck, new MeatFood.RawMeat());
        cage2.feedAnimal(duck, new MeatFood.LiveProtein());
        cage2.feedAnimal(duck, new PlantFood.Grass());
        System.out.println();

    }
}
