package back.solo_book.domain.combat;

import back.solo_book.domain.enemy.Enemy;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "combats")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Combat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @OneToMany(mappedBy = "combat", cascade = CascadeType.ALL)
    private List<Enemy> enemies;

}
