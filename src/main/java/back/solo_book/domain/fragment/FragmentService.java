package back.solo_book.domain.fragment;

import back.solo_book.dto.FragmentResponseDTO;
import back.solo_book.repositories.FragmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class FragmentService {

    private final FragmentRepository fragmentRepository;

    @Autowired
    public FragmentService(FragmentRepository fragmentRepository) {
        this.fragmentRepository = fragmentRepository;
    }

    public List<Fragment> getFragmentsBySceneId(Long sceneId) {
        return fragmentRepository.findBySceneIdOrderByIdAsc(sceneId);
    }

    public List<String> getLinksByFragmentId(Long id) {
        Optional<Fragment> fragmentOptional = fragmentRepository.findById(id);
        if (fragmentOptional.isPresent()) {
            Fragment fragment = fragmentOptional.get();
            return fragment.getLinks();
        } else {
            return Collections.emptyList();
        }
    }

    private FragmentResponseDTO mapToResponseDTO(Fragment fragment) {
        if (fragment == null) {
            return null;
        }
        return new FragmentResponseDTO(fragment.getId(), fragment.getText(), fragment.getScene().getId());
    }
}