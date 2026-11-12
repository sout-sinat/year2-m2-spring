package kh.edu.istad.b02m2restapi.repository;

import kh.edu.istad.b02m2restapi.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class UserRepository {
    private List<User> users;
    public  UserRepository(){
        users = new ArrayList<>();
        User userAdmin = new User(UUID.randomUUID(), "Administrator", "admin", "qwer",true);

        User userEdits = new User(UUID.randomUUID(), "Editor", "edit", "qwer",false);
        User userCustomer = new User(UUID.randomUUID(), "Customer", "Sinat", "sinat",true);

        users.add(userAdmin);
        users.add(userEdits);
        users.add(userCustomer);
    }

    public List<User> selectAll(){
        return users;
    }

    public Optional<User> selectById(UUID id){
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
    }

    public User insert(User user) {
        user.setId(UUID.randomUUID());
        users.add(user);
        return user;
    }

    public void deleteById(UUID id) {
        users.removeIf(user -> user.getId().equals(id));
    }

}
