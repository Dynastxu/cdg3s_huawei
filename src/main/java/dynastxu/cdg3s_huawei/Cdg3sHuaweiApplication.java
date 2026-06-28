package dynastxu.cdg3s_huawei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@SpringBootApplication
@EnableMethodSecurity()
public class Cdg3sHuaweiApplication {

    public static void main(String[] args) {
        SpringApplication.run(Cdg3sHuaweiApplication.class, args);
    }

}
