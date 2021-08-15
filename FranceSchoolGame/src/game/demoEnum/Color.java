package game.demoEnum;

public enum Color {
    RED("red"),BLACK("black"),GREEN("green");
    private String color;
    Color(String color){
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

