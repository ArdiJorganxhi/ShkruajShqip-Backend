package dev.ardijorganxhi.shkruajshqip.entity;

import dev.ardijorganxhi.shkruajshqip.entity.base.BaseEntity;
import dev.ardijorganxhi.shkruajshqip.model.enums.VoteType;
import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "votes")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Vote extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private VoteType vote;

    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "entry_id", nullable = false)
    private Integer entryId;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "entry_id", insertable = false, updatable = false)
    private Entry entry;
}
