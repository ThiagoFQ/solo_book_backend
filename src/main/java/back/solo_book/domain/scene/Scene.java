package back.solo_book.domain.scene;

import back.solo_book.domain.chapter.Chapter;
import back.solo_book.domain.combat.Combat;
import back.solo_book.domain.effect.Effect;
import back.solo_book.domain.fragment.Fragment;
import back.solo_book.domain.painting.Painting;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "scenes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Scene {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Chapter chapter;

    @OneToMany(mappedBy = "scene", cascade = CascadeType.ALL)
    private List<Fragment> fragments;

    @OneToOne
    private Painting painting;

    @OneToOne
    private Effect effect;

    @OneToOne
    private Combat combat;
}
