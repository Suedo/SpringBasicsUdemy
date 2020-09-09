package compscan;

import com.in28minutes.spring.basics.springin5steps.JdbcConnection;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Getter
@Component
public class SomeDao {

    @Autowired
    JdbcConnection jdbcConnection;

    public SomeDao() {
        System.out.println("SomeDao is born");
    }

}
