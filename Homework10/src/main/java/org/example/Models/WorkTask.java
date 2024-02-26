package org.example.Models;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue("W")
@PrimaryKeyJoinColumn(name = "task_id")
@Table(name = "worktask")
public class WorkTask extends Task {
    @Column
    private Double cost;

}
