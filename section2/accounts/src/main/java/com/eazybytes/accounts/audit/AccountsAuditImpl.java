package com.eazybytes.accounts.audit;

import org.springframework.boot.actuate.audit.AuditEventRepository;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("accountsAuditImpl")
public class AccountsAuditImpl implements AuditorAware<String> {


    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("Akash");
    }
}
