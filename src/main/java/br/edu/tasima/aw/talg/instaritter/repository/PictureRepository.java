package br.edu.tasima.aw.talg.instaritter.repository;

import br.edu.tasima.aw.talg.instaritter.model.Picture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PictureRepository extends JpaRepository<Picture, Long> {
}
