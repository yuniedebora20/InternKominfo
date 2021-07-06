package intern.kominfo.webprofile.repository;

import intern.kominfo.webprofile.model.SejarahModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SejarahDb extends JpaRepository<SejarahModel, Long> {
    Optional<SejarahModel> findById(Long id);
}
