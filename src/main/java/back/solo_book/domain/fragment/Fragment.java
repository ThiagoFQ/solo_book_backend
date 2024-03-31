package back.solo_book.domain.fragment;

import back.solo_book.domain.item.Item;
import back.solo_book.domain.scene.Scene;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "fragments")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Fragment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String text;

    @ElementCollection
    private List<String> links;

    @OneToMany(mappedBy = "fragment", cascade = CascadeType.ALL)
    private List<Item> items;

    @ElementCollection
    private List<String> rolls;

    @ManyToOne
    private Scene scene;

}
