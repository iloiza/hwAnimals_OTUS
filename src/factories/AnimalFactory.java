package factories;

import animals.AbsAnimal;
import animals.birds.Duck;
import data.TypeAnimalData;
import animals.pets.Cat;
import animals.pets.Dog;

public class AnimalFactory {
    public AbsAnimal createAnimal(TypeAnimalData typeAnimal) {
        switch (typeAnimal) {
            case CAT -> {
                return new Cat();
            }
            case DOG -> {
                return new Dog();
            }
            case DUCK -> {
                return new Duck();
            }
            default -> {
                return null;
            }
        }
    }
}

