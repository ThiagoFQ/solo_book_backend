package back.solo_book.controllers;

import back.solo_book.domain.fragment.Fragment;
import back.solo_book.domain.fragment.FragmentService;
import back.solo_book.dto.FragmentResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/fragments")
public class FragmentController {
    private final FragmentService fragmentService;
    @Autowired
    public FragmentController(FragmentService fragmentService) {
        this.fragmentService = fragmentService;
    }

    @GetMapping("/scene/{sceneId}")
    public ResponseEntity<List<FragmentResponseDTO>> getFragmentsBySceneId(@PathVariable Long sceneId) {
        List<Fragment> fragments = fragmentService.getFragmentsBySceneId(sceneId);
        List<FragmentResponseDTO> responseDTOs = fragments.stream()
                .map(fragment -> new FragmentResponseDTO(fragment.getId(), fragment.getText(), fragment.getScene().getId()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(responseDTOs);
    }

    @GetMapping("/{id}/links")
    public ResponseEntity<List<String>> getLinksByFragmentId(@PathVariable Long id) {
        List<String> links = fragmentService.getLinksByFragmentId(id);
        return ResponseEntity.ok(links);
    }
}
