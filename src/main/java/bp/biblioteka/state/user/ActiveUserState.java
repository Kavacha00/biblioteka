package bp.biblioteka.state.user;

public class ActiveUserState implements UserState {
    @Override
    public String activate() { return "User is already active"; }

    @Override
    public String ban() { return "User has been banned"; }

    @Override
    public String suspend() { return "User has been suspended"; }

    @Override
    public String getStateName() { return "ACTIVE"; }
}
