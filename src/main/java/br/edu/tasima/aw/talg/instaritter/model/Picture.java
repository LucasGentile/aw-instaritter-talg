package br.edu.tasima.aw.talg.instaritter.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "PICTURE")
public class Picture {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long pictureId;

    @NotNull
    @Column(name = "DESCRIPTION")
    private String description;

    @NotNull
    @Column(name = "CONTENT", columnDefinition = "CLOB")
    private byte[] content;

    @NotNull
    @Column(name = "PICTURE_DATE")
    private LocalDateTime pictureDate;

    public Long getPictureId() {
        return pictureId;
    }

    public void setPictureId(Long pictureId) {
        this.pictureId = pictureId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public LocalDateTime getPictureDate() {
        return pictureDate;
    }

    public void setPictureDate(LocalDateTime pictureDate) {
        this.pictureDate = pictureDate;
    }
}