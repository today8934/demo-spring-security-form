package me.today8934.demospringsecurityform.form;

import me.today8934.demospringsecurityform.account.AccountContext;
import me.today8934.demospringsecurityform.account.AccountRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class SampleController {

    private final SampleService sampleService;

    private final AccountRepository accountRepository;

    public SampleController(SampleService sampleService, AccountRepository accountRepository) {
        this.sampleService = sampleService;
        this.accountRepository = accountRepository;
    }

    @GetMapping("/")
    public String index(Model model, Principal principal) {
        if (principal == null) {
            model.addAttribute("message", "Hello Spring Security");
        } else {
            model.addAttribute("message", "Hello, " + principal.getName());
        }

        return "index";
    }

    @GetMapping("/info")
    public String info(Model model) {
        model.addAttribute("message", "info");
        return "info";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model, Principal principal) {
        model.addAttribute("message", "Hello" + principal.getName());
        AccountContext.setAccount(accountRepository.findByUsername(principal.getName()));
        sampleService.dashboard();
        return "dashboard";
    }

    @GetMapping("/admin")
    public String admin(Model model, Principal principal) {
        model.addAttribute("message", "Hello Admin, " + principal.getName());
        return "admin";
    }
}

