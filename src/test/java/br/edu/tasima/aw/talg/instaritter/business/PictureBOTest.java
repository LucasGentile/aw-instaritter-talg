package br.edu.tasima.aw.talg.instaritter.business;

import br.edu.tasima.aw.talg.instaritter.model.Picture;
import br.edu.tasima.aw.talg.instaritter.repository.PictureRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class PictureBOTest {

    @Autowired
    private PictureBO pictureBO;

    @MockBean
    private PictureRepository repository;

    @Test
    public void Should_Save_Picture_When_Exists(){
        Picture pictureOne = new Picture();
        pictureOne.setDescription("picture_1");
        pictureOne.setPictureDate(LocalDateTime.MIN);
        pictureOne.setContent("0x10238102381028301239810238102830128301238012");
        pictureOne.setPictureId(1L);

        given(repository.save(any(Picture.class))).willReturn(pictureOne);

        pictureBO.save(new byte[100], "picture_1");
    }

    public void Should_Validate_Picture_File_When_Have_Valid() throws IOException {

        MultipartFile multipartFile = new MockMultipartFile("test.xlsx", new FileInputStream(new File("/home/admin/test.xlsx")));

        pictureBO.validatePictureFile(multipartFile);
    }
}
