import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class InMemoryUserDatabase implements UserRepository {
    private static Set<User> users = new HashSet<>();

    @Override
    public void add(User user) {
        users.add(user);
    }

    @Override
    public Optional<User> find(String username) {
        users.stream().filter(user -> user.getUsername().equals(username)).findAny();
        return Optional.empty();
    }
}
