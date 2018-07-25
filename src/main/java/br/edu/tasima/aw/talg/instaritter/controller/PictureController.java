package br.edu.tasima.aw.talg.instaritter.controller;

import br.edu.tasima.aw.talg.instaritter.business.PictureBO;
import br.edu.tasima.aw.talg.instaritter.model.Picture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

@Controller
public class PictureController {

    @Autowired
    private PictureBO pictureBO;

    @GetMapping("/")
    public String showUploadForm(Model model) {
        List<Picture> pictureList = pictureBO.getAllPictures();
        model.addAttribute("pictureList", pictureList);
        return "uploadPictureForm";
    }

    @GetMapping("/picture")
    public String getPicture(@RequestParam Long pictureId, RedirectAttributes redirectAttributes) {
        try {
            Picture picture = pictureBO.getById(pictureId);
            redirectAttributes.addFlashAttribute("picture", picture);

        } catch (NoSuchElementException ex) {
            redirectAttributes.addFlashAttribute("message", "No images found with id: " + pictureId);
        }
        return "redirect:/";
    }

    @PostMapping("/uploadPicture")
    public String handlePictureUpload(@RequestParam("pictureFile") MultipartFile pictureFile,
                                      @RequestParam("description") String description,
                                      RedirectAttributes redirectAttributes) {

        try {
            byte[] pictureFileByteArray = pictureBO.validatePictureFile(pictureFile);
            pictureBO.save(pictureFileByteArray, description);

            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded " + pictureFile.getOriginalFilename() + "!");
        } catch (IOException e) {
            redirectAttributes.addFlashAttribute("message",
                    "Error while uploading " + pictureFile.getOriginalFilename() + "!");
        }

        return "redirect:/";
    }
}
