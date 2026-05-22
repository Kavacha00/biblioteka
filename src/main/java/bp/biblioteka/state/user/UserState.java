package bp.biblioteka.state.user;

// Tydzień 6, Wzorzec State 2
// Przechowujemy stan konta użytkownika
public interface UserState {
    String activate();
    String ban();
    String suspend();
    String getStateName();
}
//Koniec, Tydzień 6, Wzorzec State 2