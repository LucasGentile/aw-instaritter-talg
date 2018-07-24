package br.edu.tasima.aw.talg.instaritter.controller;

import br.edu.tasima.aw.talg.instaritter.business.PictureBO;
import br.edu.tasima.aw.talg.instaritter.model.Picture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

@Controller
public class PictureController {

    private PictureBO pictureBO;

    @Autowired
    public PictureController(PictureBO pictureBO) {
        this.pictureBO = pictureBO;
    }
    @GetMapping("/")
    public String showUploadForm(Model model) throws IOException {

 model.addAttribute("picture", null);
 model.addAttribute("message", "test");

        return "uploadPictureForm";
    }

    @GetMapping("/picture/{pictureId}")
    @ResponseBody
    public ResponseEntity<Picture> getPicture(@PathVariable Long pictureId, RedirectAttributes redirectAttributes) {

        Picture picture = pictureBO.getById(pictureId);
        //        model.addAttribute("message", "Instaritter");
        redirectAttributes.addFlashAttribute("picture",
                picture);
        return ResponseEntity.ok().body(picture);
    }

    @PostMapping("/uploadPicture")
    public String handlePictureUpload(@RequestParam("pictureFile") MultipartFile pictureFile,
                                      RedirectAttributes redirectAttributes) {

        try {
            byte[] pictureFileByteArray = pictureBO.validatePictureFile(pictureFile);
            pictureBO.save(pictureFileByteArray, "Test IMAGE");

            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded " + pictureFile.getOriginalFilename() + "!");
        } catch (IOException e) {
            redirectAttributes.addFlashAttribute("message",
                    "Error while uploading " + pictureFile.getOriginalFilename() + "!");
        }

        return "redirect:/";
    }
}
