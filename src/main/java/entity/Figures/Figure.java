package entity.Figures;

public abstract class Figure  {
    private static int idCounter = 0;
    {idCounter++;}
    private int id = idCounter;
    public int getId() {
        return id;
    }

}
