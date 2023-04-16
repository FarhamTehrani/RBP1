import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SimRace {

    private final int anzahlAutos;
    private final int streckenLänge;
    private Queue<Car> track;

    public SimRace(int anzahl, int länge){
        anzahlAutos = anzahl;
        streckenLänge = länge;
        track = new LinkedList<>();
    }

    public void startRace(){
        for(int i = 0; i <anzahlAutos; i++){
            Car wagen = new Car(i, streckenLänge);
            track.add(wagen);
            wagen.start();
        }
        
        track.forEach(wagen -> {
            try {
                wagen.join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });

        
        Object[] autos = track.stream().sorted(Car::compareTo).toArray();
        for(int i = 0; i < anzahlAutos; i++){
            Car auto = (Car) autos[i];
            auto.setPlatzierung(i+1 + ". Platz: ");
        }


        track.stream().sorted(Car::compareTo).forEach(wagen -> System.out.println(wagen.toString()));
    }
}
