package bp.biblioteka.state.user;

public class BannedUserState implements UserState{
    @Override
    public String activate() { return "User has been reactivated"; }

    @Override
    public String ban() { return "User is already banned"; }

    @Override
    public String suspend() { return "User is banned, cannot suspend"; }

    @Override
    public String getStateName() { return "BANNED"; }
}
