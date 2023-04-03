package animals;

public abstract class AbsAnimal {
    private String name = "";
    private int age = -1;
    private double weight = -1;
    private String color = "";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public void say(){
        System.out.println("Я говорю");
    }
    public void go(){
        System.out.println("Я иду");
    }
    public void drink(){
        System.out.println("Я пью");
    }
    public void eat(){
        System.out.println("Я ем");
    }

    @Override
    public String toString() {
        String cases = "";
        if (age % 10 == 1){
            cases = "год";
        } else if ((age % 10 >= 2) && (age % 10 <= 4)){
            cases = "года";
        } else {
            cases = "лет";
        }
        return "Привет! меня зовут " + name + ", мне " + age + " " + cases + ", я вешу - " + weight + " кг, мой цвет - " + color;
    }
}
