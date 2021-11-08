package programming.lab1;

public class Pie extends Food {
    private String fill;

    public Pie(String color){
        super("Пирог");
        this.fill = color;
    }

    public void consume(){
        System.out.println(this + "съедено");
    }

    public String getfill(){
        return fill;
    }

    public void setColor(String color){
        this.fill = color;
    }

    public boolean equals(Object arg0) {
        if (super.equals(arg0)) {
            if (!(arg0 instanceof Pie)) return false;
            return fill.equals(((Pie)arg0).fill);
        } else
            return false;
    }

    public String toString() {
        return super.toString() + " начинка '" + fill.toUpperCase() + "'";
    }
}


