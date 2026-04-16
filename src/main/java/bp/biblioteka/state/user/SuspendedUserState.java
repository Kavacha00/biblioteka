package bp.biblioteka.state.user;

public class SuspendedUserState implements UserState {
    @Override
    public String activate() { return "User has been reactivated"; }

    @Override
    public String ban() { return "User has been banned"; }

    @Override
    public String suspend() { return "User is already suspended"; }

    @Override
    public String getStateName() { return "SUSPENDED"; }
}
