package com.example.intern.business.concretes;

import com.example.intern.business.abstracts.LlamaAiService;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LlamaAiManager implements LlamaAiService {

    private final OllamaChatModel ollamaChatModel;
    @Override
    public String generateMessage(String promptMessage) {
        return ollamaChatModel.call(promptMessage);
    }
}
