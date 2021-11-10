package programming.lab1;

import org.w3c.dom.ls.LSOutput;

public  class Food implements Consumable{
    private String name;

    public String getName(){
        return name;
    }

    public Food(String name){
        this.name = name;
    }

    public String toString(){
        return name;
    }

    public boolean equals(Object obj){
        if(!(obj instanceof Food)){
            return false;
        }
        else if (name == null || ((Food)obj).name == null){
            return false;
        }
        return name.equals(((Food)obj).name);
    }
    public void consume(){
        System.out.println("Съедено");
    }
}


