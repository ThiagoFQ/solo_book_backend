package back.solo_book.domain.enemy;

import back.solo_book.domain.combat.Combat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "enemies")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Enemy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String size;
    private String type;
    private String secondType;
    private String alignment;
    private Integer initiative;
    private Integer hp;
    private Integer ac;
    private Integer speed;
    private Integer str;
    private Integer dex;
    private Integer con;
    private Integer intel;
    private Integer wis;
    private Integer cha;
    private String savingThrows;
    private String skills;
    private String senses;

    @OneToMany(mappedBy = "enemy", cascade = CascadeType.ALL)
    private List<back.solo_book.domain.enemy.PAction> pActions;

    @OneToMany(mappedBy = "enemy", cascade = CascadeType.ALL)
    private List<back.solo_book.domain.enemy.BonusAction> bonusActions;

    @OneToMany(mappedBy = "enemy", cascade = CascadeType.ALL)
    private List<back.solo_book.domain.enemy.Reaction> reactions;

    @ManyToOne
    private Combat combat;


}
