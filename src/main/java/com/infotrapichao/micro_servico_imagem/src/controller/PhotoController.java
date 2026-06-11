package com.infotrapichao.micro_servico_imagem.src.controller;

import com.infotrapichao.micro_servico_imagem.src.dto.UploadPhotoRequest;
import com.infotrapichao.micro_servico_imagem.src.exception.BusinessException;
import com.infotrapichao.micro_servico_imagem.src.service.PhotoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/photos")
@RequiredArgsConstructor
@Tag(name = "Photos", description = "Endpoints para gerenciamento de imagens")
public class PhotoController {

    private final PhotoService photoService;

    @PostMapping
    public ResponseEntity<Void> upload(@RequestBody UploadPhotoRequest request) {

        if (request.photoName().isEmpty() || request.imagemBase64().isEmpty()) {
            throw new BusinessException("Nome da foto e imagem não podem ser vazios");
        }

        photoService.save(
                request.photoName(),
                request.imagemBase64());

        return ResponseEntity
                .ok()
                .build();
    }
}