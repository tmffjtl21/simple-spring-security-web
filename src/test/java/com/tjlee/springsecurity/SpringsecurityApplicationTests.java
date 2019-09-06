package com.tjlee.springsecurity;

import com.tjlee.springsecurity.domain.Account;
import com.tjlee.springsecurity.form.repository.AccountRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
// 실제 디비를 사용하는 설정, test는 기본이 롤백, 롤백을 원하지 않을 경우 @Rollback(false)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SpringsecurityApplicationTests {

    @Autowired
    AccountRepository accountRepository;

    @Test
//    @Rollback(false)
    public void crud() {

        Account account = new Account();
        account.setUsername("tjlee1");
        account.setPassword("1111");
        accountRepository.save(account);

        Account account1 = accountRepository.findByUsername("tjlee1");
        assertThat(Optional.ofNullable(account1).map(Account::getUsername).orElse(null)).isEqualTo("tjlee1");
    }
}
