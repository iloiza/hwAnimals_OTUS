package data;

public enum ColorsData {
    BLACK ("Черный"),
    WHITE ("Белый"),
    RED ("Рыжий"),
    ANOTHER ("Другой");

    private String name;
    ColorsData(String name) {

        this.name = name;
    }
    public String getName(){
        return this.name;
    }
}

