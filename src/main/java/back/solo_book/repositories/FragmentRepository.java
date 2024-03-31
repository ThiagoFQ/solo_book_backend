package back.solo_book.repositories;

import back.solo_book.domain.fragment.Fragment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FragmentRepository extends JpaRepository<Fragment, Long> {
    List<Fragment> findBySceneIdOrderByIdAsc(Long sceneId);
    Optional<Fragment> findById(Long id);
}
