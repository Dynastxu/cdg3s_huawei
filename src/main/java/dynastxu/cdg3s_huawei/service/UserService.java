package dynastxu.cdg3s_huawei.service;

import dynastxu.cdg3s_huawei.entity.User;
import dynastxu.cdg3s_huawei.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseService<UserRepository> {
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository repository, PasswordEncoder encoder) {
        super(repository);
        this.passwordEncoder = encoder;
    }

    public User register(String username, String password) throws IllegalArgumentException {
        if (repository.existsByUsername(username)) {
            throw new IllegalArgumentException("用户名已存在");
        }

        String validPsw = password.replace(" ", "");
        if (validPsw.length() < 6 || validPsw.isBlank()) {
            throw new IllegalArgumentException("密码不能少于 6 位");
        }

        String encodedPassword = passwordEncoder.encode(validPsw);

        User user = new User(username, encodedPassword);

        return repository.save(user);
    }

    public User login(String username, String rawPassword)
            throws IllegalArgumentException, IllegalStateException {
        User user = repository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("用户名或密码错误"));

        if (user.getLocked()) {
            throw new IllegalStateException("用户已被锁定，请稍后再试");
        }

        if (!user.getEnabled()) {
            throw new IllegalStateException("用户未激活");
        }

        String validPsw = rawPassword.replace(" ", "");
        if (!passwordEncoder.matches(validPsw, user.getPassword())) {
            throw new IllegalArgumentException("用户名或密码错误");
        }

        return user;
    }

    public User findByUsername(String username) {
        return repository.findByUsername(username).orElse(null);
    }

    public User setNickname(String username, String nickname) {
        User user = repository.findByUsername(username).orElse(null);
        if (user != null) {
            user.setNickname(nickname);
            repository.save(user);
        }
        return user;
    }

    public String getNickname(String username) {
        User user = repository.findByUsername(username).orElse(null);
        if (user != null) {
            return user.getNickname();
        }
        return null;
    }
}
