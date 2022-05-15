package mk.ukim.finki.wp.eshop.repository;

import mk.ukim.finki.wp.eshop.model.Role;
import mk.ukim.finki.wp.eshop.model.User;
import mk.ukim.finki.wp.eshop.model.exceptions.UserNotFoundException;
import mk.ukim.finki.wp.eshop.model.projections.UserProjection;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindAll() {
        List<User> users=this.userRepository.findAll();
        Assert.assertEquals(1L, users.size());
    }

    @Test
    public void testFetchAll() {
        List<User> users=this.userRepository.fetchAll();
        Assert.assertEquals(1L, users.size());
    }

    @Test
    public void testLoadAll() {
        List<User> users=this.userRepository.loadAll();
        Assert.assertEquals(1L, users.size());
    }

    @Test
    public void testProjectUsernameAndNameAndSurname() {
        UserProjection userProjection=this.userRepository.findByRole(Role.ROLE_ADMIN);
        Assert.assertEquals("petar.kiselinov", userProjection.getUsername());
        Assert.assertEquals("Petar", userProjection.getName());
        Assert.assertEquals("Kiselinov", userProjection.getSurname());
    }

    @Test
    public void testOptimisticLock() {
        User user1=this.userRepository.findByUsername("petar.kiselinov")
                .orElseThrow(() -> new UserNotFoundException("petar.kiselinov"));
        User user2=this.userRepository.findByUsername("petar.kiselinov")
                .orElseThrow(() -> new UserNotFoundException("petar.kiselinov"));

        user1.setName("Kristina");
        user2.setName("Ivan");

        this.userRepository.save(user1);
        this.userRepository.save(user2);
    }
}
