package br.edu.tasima.aw.talg.instaritter.business;

import br.edu.tasima.aw.talg.instaritter.model.Picture;
import br.edu.tasima.aw.talg.instaritter.repository.PictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.List;

@Component
public class PictureBO {

    private final PictureRepository pictureRepository;

    @Autowired
    public PictureBO(PictureRepository pictureRepository) {
        this.pictureRepository = pictureRepository;
    }

    public byte[] validatePictureFile(MultipartFile pictureFile) throws IOException {
        String filename = StringUtils.cleanPath(pictureFile.getOriginalFilename());
        try {
            if (pictureFile.isEmpty()) {
                throw new IOException("System cannot save empty picture " + filename);
            }
            return pictureFile.getBytes();
        } catch (IOException e) {
            throw new IOException("Failed to process picture file " + filename, e);
        }
    }

    public Picture getById(Long pictureId) {
        return this.pictureRepository.findById(pictureId).get();
    }

    public List<Picture> getAllPictures() {
        return this.pictureRepository.findAll();
    }

    public void save(byte[] pictureFileByteArray, String description) {

        Picture picture = new Picture();

        picture.setDescription(description);
        picture.setPictureDate(LocalDateTime.now());
        picture.setContent(Base64.getEncoder().encodeToString(pictureFileByteArray));

        this.pictureRepository.save(picture);
    }
}
