package com.infotrapichao.micro_servico_imagem.src.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public record UploadPhotoRequest(

        @Schema(
                description = "Nome da foto",
                example = "gasto_123.png"
        )
        String photoName,

        @Schema(
                description = "Imagem em Base64",
                example = "iVBORw0KGgoAAAANSUhEUgAA..."
        )
        String imagemBase64
) {
}
