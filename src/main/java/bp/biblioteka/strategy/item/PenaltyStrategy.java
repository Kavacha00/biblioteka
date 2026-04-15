package bp.biblioteka.strategy.item;

//Tydzień 6, Wzorzec Strategy 3
//Wprowadzenie różnych kar za opóźnienie w oddaniu
//zwykłej książki oraz bestsellera
public interface PenaltyStrategy {
    double calculatePenalty(int daysOverdue);
}
