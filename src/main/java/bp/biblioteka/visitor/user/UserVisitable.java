package bp.biblioteka.visitor.user;

public interface UserVisitable {
    String accept(UserVisitor visitor);
}
