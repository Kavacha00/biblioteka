package bp.biblioteka.strategy.item;

public class StandardPenalty implements PenaltyStrategy {
    @Override
    public double calculatePenalty(int daysOverdue) {
        return daysOverdue * 2.0;
    }
}
//Koniec, Tydzień 6, Wzorzec Strategy 3