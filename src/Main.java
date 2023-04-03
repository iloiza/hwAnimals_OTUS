import animals.AbsAnimal;
import animals.birds.IFlying;
import data.ColorsData;
import data.CommandData;
import data.TypeAnimalData;
import factories.AnimalFactory;
import java.util.ArrayList;
import java.util.Scanner;



public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        ArrayList<AbsAnimal> animals = new ArrayList<>();
        while (true) {
            String commandStr = "";
            do {
                System.out.println("Введите команду add/list/exit");
                commandStr = scanner.next().toUpperCase().trim();
            } while (!commandStr.equals("ADD") && !commandStr.equals("LIST") && !commandStr.equals("EXIT"));
            CommandData commandData = CommandData.valueOf(commandStr);
            switch (commandData) {
                case ADD -> {
                    String animalStr = "";
                    do {
                        System.out.println("Введите тип животного cat/dog/duck");
                        animalStr = scanner.next().toUpperCase().trim();
                    } while (!animalStr.equals("CAT") && !animalStr.equals("DOG") && !animalStr.equals("DUCK"));
                    TypeAnimalData typeAnimalData = TypeAnimalData.valueOf(animalStr);
                    AnimalFactory animalFactory = new AnimalFactory();
                    AbsAnimal absAnimal = animalFactory.createAnimal(typeAnimalData);
                    
                        if (absAnimal instanceof IFlying) {
                        ((IFlying) absAnimal).fly();
                    }
                    AbsAnimal animal = newAnimalData(absAnimal);
                    animals.add(animal);
                    absAnimal.say();
                }
                case LIST -> {
                    if(animals.size() == 0){
                        System.out.println("Вы не добавили ни одного животного.");
                    }else{
                        System.out.println(animals.toString());
                    }
                }
                case EXIT -> System.exit(0);
            }
        }
    }
    private static AbsAnimal newAnimalData(AbsAnimal animals){

        System.out.println("Введите имя животного");
        String name = scanner.next();
        animals.setName(name);

        String ageStr;
        do{
            System.out.println("Введите возраст животного от 1 до 30");
            ageStr = scanner.next();
            if (ageStr.matches("[+-]?\\d+")) {
                if (Integer.parseInt(ageStr) > 0 && Integer.parseInt(ageStr) < 31) break;
            }
        } while (true);
        animals.setAge(Integer.parseInt(ageStr));

        String weightStr;
        do{
            System.out.println("Введите вес животного (например, 2.0) ");
            weightStr = scanner.next();
            if ((weightStr.matches("[+-]?\\d+[.]?\\d+"))||(weightStr.matches("[+-]?\\d+"))) {
                if (Double.parseDouble(weightStr) > 0 && Double.parseDouble(weightStr) < 99) break;
            }
        } while (true);
        animals.setWeight(Double.parseDouble(weightStr));

        String colorStr = "";
        do {
            System.out.println("Выберите цвет животного: BLACK/WHITE/RED/ANOTHER");
            colorStr = scanner.next().toUpperCase().trim();
        } while (!colorStr.equals("BLACK") && !colorStr.equals("WHITE") && !colorStr.equals("RED")
                && !colorStr.equals("ANOTHER"));
        ColorsData colorsData = ColorsData.valueOf(colorStr);
        animals.setColor(colorsData.getName());
        return animals;
    }

}
