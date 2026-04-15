package bp.biblioteka.strategy.item;

public class HighPenalty implements PenaltyStrategy {
    @Override
    public double calculatePenalty(int daysOverdue) {
        return 10.0 + daysOverdue * 5.0;
    }
}
//Koniec, Tydzień 6, Wzorzec Strategy 3