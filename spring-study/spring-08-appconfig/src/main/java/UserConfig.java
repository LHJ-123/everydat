import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(UserConfig2.class) //将两个配置类弄为一个整体
public class UserConfig {

    @Bean
    public User getUser() {
        return new User();
    }
}
