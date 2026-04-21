package bp.biblioteka.strategy.item;

//Tydzień 7, zasada otwarte - zamnkięte na abstrakcji 1
//dodanie nowego rodzaju kary za oddanie przedmiotu po
//terminie w specjalnych przypadkach
public class HighPenalty implements PenaltyStrategy {
    @Override
    public double calculatePenalty(int daysOverdue) {
        return 10.0 + daysOverdue * 5.0;
    }
}
//Koniec, Tydzień 7, zasada otwarte - zamnkięte na abstrakcji 1