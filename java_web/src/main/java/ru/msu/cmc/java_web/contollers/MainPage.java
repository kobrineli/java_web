package ru.msu.cmc.java_web.contollers;

import org.springframework.web.bind.annotation.RequestMapping;

public class MainPage {
    @RequestMapping(value = { "/", "/index"})
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/signIn")
    public String signIn() {
        return "signIn";
    }
}
