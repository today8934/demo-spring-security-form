package me.today8934.demospringsecurityform.account;

import org.springframework.security.test.context.support.WithMockUser;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@WithMockUser(username = "wooksang", roles = "USER")
public @interface WithUser {
}
