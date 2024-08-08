package com.example.intern.api.controllers;

import com.example.intern.business.abstracts.LlamaAiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/ai")
public class LlamaRestController {

    private final LlamaAiService llamaAiService;

    @GetMapping("api/v1/ai/generate")
    public String generate(@RequestParam(value = "promptMessage") String promptMessage) {
        return llamaAiService.generateMessage(promptMessage);
    }
}
