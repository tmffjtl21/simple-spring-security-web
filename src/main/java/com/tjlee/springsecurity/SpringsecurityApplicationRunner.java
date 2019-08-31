package com.tjlee.springsecurity;

import com.tjlee.springsecurity.form.domain.Account;
import com.tjlee.springsecurity.form.domain.Study;
import com.tjlee.springsecurity.form.service.AccountService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
@Transactional
@Order(0)
public class SpringsecurityApplicationRunner implements ApplicationRunner {

    AccountService accountService;

    @PersistenceContext
    EntityManager entityManager;

    public SpringsecurityApplicationRunner(AccountService accountService){
        super();
        this.accountService = accountService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        // 처음 New를 하면 Transient 상태 ( JPA가 전혀 모르는 상태 )
        Account account = new Account();
        account.setUsername("tjlee");
        account.setPassword("tjlee");

//        // persistent상태로 변화됨 바로 DB에 들어가는건 아님
//        // 하이버네이트가 관리하는 객체로 변경되는 시점
        entityManager.persist(account);

        Study study = new Study();
        study.setName("Sping Data JPA");
        study.setAccountId(account.getId());
        // convenient method : 연관관계를 설정하는 메소드
//        account.getStudies().add(study);
        study.setAccount(account);
        entityManager.persist(study);

        // 이 한줄만 추가하면 관계의 주인이 아니기 때문에 저장이 안됨
//        account.getStudies().add(study);
//        account.getStudies().remove(1);
    }
}
