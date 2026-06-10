package com.infotrapichao.micro_servico_imagem.src.service;

import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

@Service
public class PhotoService {

    public void save(String photoName, String imagemBase64) {

        try {

            if (photoName == null || imagemBase64 == null) {
                throw new RuntimeException("Dados inválidos");
            }

            if (imagemBase64.contains(",")) {
                imagemBase64 = imagemBase64.split(",")[1];
            }

            byte[] imagemBytes =
                    Base64.getDecoder().decode(imagemBase64);

            Path uploadsDir = Paths.get("uploads");

            Files.createDirectories(uploadsDir);

            if (!photoName.toLowerCase().endsWith(".png")
                    && !photoName.toLowerCase().endsWith(".jpg")
                    && !photoName.toLowerCase().endsWith(".jpeg")) {

                photoName += ".png";
            }

            Path filePath = uploadsDir.resolve(photoName);

            Files.write(filePath, imagemBytes);

        } catch (Exception ex) {
            throw new RuntimeException(
                    "Erro ao salvar imagem",
                    ex
            );
        }
    }
}