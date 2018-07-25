package br.edu.tasima.aw.talg.instaritter.model;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Scope(value="session", proxyMode= ScopedProxyMode.TARGET_CLASS)
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
    private String content;

    @NotNull
    @Column(name = "PICTURE_DATE")
    private LocalDateTime pictureDate;
}