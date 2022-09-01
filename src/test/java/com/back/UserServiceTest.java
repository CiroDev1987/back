package com.back;

import com.back.domain.entity.Usuario;
import com.back.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.hamcrest.MatcherAssert.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
@RequiredArgsConstructor
public class UserServiceTest {

    private final UsuarioRepository userRepository;

    @Test
    public Usuario UserTest() {
        Usuario user = new Usuario();
        user.setNome("Ciro");
        user.setEmail("cirodev.junior@gmail.com");
        user.setSenha("123456");

        return userRepository.save(user);
    }
}
