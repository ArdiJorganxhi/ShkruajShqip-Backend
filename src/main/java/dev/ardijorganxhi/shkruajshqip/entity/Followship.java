package dev.ardijorganxhi.shkruajshqip.entity;

import dev.ardijorganxhi.shkruajshqip.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "followships")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Followship extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "follower_id", nullable = false)
    private Integer follower;

    @Column(name = "following_id", nullable = false)
    private Integer following;

    @ManyToOne
    @JoinColumn(name = "follower_id", insertable = false, updatable = false)
    private User followerUser;

    @ManyToOne
    @JoinColumn(name = "following_id", insertable = false, updatable = false)
    private User followingUser;
}
