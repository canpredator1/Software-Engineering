package com.example.demo;


import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.TreeMap;

@RestController
public class ColorregistryController {

    private Map<String, String> colorRegistry = new TreeMap<>();

    // GET /reset
    @GetMapping("/reset")
    public String resetRegistry() {
        colorRegistry.clear();
        return "Registry has been reset.";
    }

    // POST /colors
    @PostMapping("/colors")
    public String addOrUpdateColor(@RequestBody ColorDto colorDto) {
        if (colorDto.getName() == null || colorDto.getName().isEmpty()) {
            return "Empty names are not allowed.";  // No explicit status control here
        }
        if (colorDto.getHex() == null || colorDto.getHex().isEmpty()) {
            return "Colors without hex value are not allowed.";  // No explicit status control here
        }
        colorRegistry.put(colorDto.getName(), colorDto.getHex());
        return "Color added or updated.";
    }

    // GET /colors/{name}
    @GetMapping("/colors/{name}")
    public String getColorByName(@PathVariable String name) {
        if (colorRegistry.containsKey(name)) {
            return colorRegistry.get(name);
        }
        return "Color not found.";  // Will still return 200 OK by default
    }

    // GET /colors
    @GetMapping("/colors")
    public Object getAllColors() {
        if (colorRegistry.isEmpty()) {
            return "Registry is empty.";
        }
        return colorRegistry;
    }
}