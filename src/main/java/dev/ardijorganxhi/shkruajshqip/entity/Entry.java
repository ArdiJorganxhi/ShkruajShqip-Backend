package dev.ardijorganxhi.shkruajshqip.entity;

import dev.ardijorganxhi.shkruajshqip.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "entries")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Entry extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String content;

    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "topic_id", nullable = false)
    private Integer topicId;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "topic_id", insertable = false, updatable = false)
    private Topic topic;
}
