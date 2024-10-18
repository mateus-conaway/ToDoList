public class Task {
    private int id;
    private String name;
    private boolean isMarked;

    public Task(int id, String name, boolean isMarked) {
        this.id = id;
        this.name = name;
        this.isMarked = false;
    }

    public int getId(){
        return this.id;
    }

    public void setId(int newId){
        this.id = newId;
    }

    public String getName(){
        return this.name;
    }

    public boolean getMarked(){
        return this.isMarked;
        }

    public void setMarked(){
        this.isMarked = true;
    }

    public String isMarked(){
        if (this.isMarked == true){
            return "This task is complete.    ";
        } else {
            return "This task is not complete.";
        }
    }

    @Override
    public String toString(){
        return this.id + ") " + this.isMarked() + " | " + this.getName();
    }
}