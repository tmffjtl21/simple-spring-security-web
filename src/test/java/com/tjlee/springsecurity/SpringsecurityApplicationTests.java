package com.tjlee.springsecurity;

import com.tjlee.springsecurity.form.domain.Account;
import com.tjlee.springsecurity.form.repository.AccountRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)        // 실제 디비를 사용하는 설정 (조심)
public class SpringsecurityApplicationTests {

    @Autowired
    AccountRepository accountRepository;

    @Test
    public void crud() {
        Account account = accountRepository.findByUsername("tjlee");
        assertThat(account).isNull();
    }
}
