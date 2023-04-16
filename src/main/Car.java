import java.util.Random;

public class Car extends Thread implements Comparable<Car>{

    private int completedlaps;
    private int totalTime;
    private String name;
    private int neededLaps;
    private String platzierung;

    public Car(int carnumber,int neededLaps) {
        this.neededLaps = neededLaps;
        name = "Wagen " + carnumber;
      }



    @Override
    public void run() {
        while(completedlaps < neededLaps){
            drive();
        } 
    }

    public void drive(){
        int time = new Random().nextInt(101);
        totalTime += time;
        completedlaps++;
        try {
            sleep(time);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public int getTotalTime() {
        return totalTime;
    }

    @Override
    public int compareTo(Car o) {
        return Integer.compare(getTotalTime(), o.getTotalTime());
    }



    @Override
    public String toString() {
        return platzierung + name + " Zeit: " + totalTime;
    }

    public void setPlatzierung(String platzierung) {
        this.platzierung = platzierung;
    }
}