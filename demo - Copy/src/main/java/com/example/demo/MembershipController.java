package com.example.demo;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.HashSet;
import java.util.Set;
@RestController
public class MembershipController {
    Set<String> set = new HashSet<>();
    @GetMapping("/new")
    public String new_key(@RequestParam(name="key") String key) {
        if (key.isEmpty())
            return "Missing key";
        else if (set.contains(key))
            return key + " already in the set";
        else {
            set.add(key);
            return key + " added to the set";
        }
    }
    @GetMapping("/check")
    public String check_key(@RequestParam(name="key") String key) {
        return set.contains(key)?"yes":"no";
    }






    @GetMapping("/hello")
    public String hello () {
        return "Hello, World!";
    }

    @GetMapping("/howdy")
    public String howdy () {
        return "Grand! How are you?";
    }
}