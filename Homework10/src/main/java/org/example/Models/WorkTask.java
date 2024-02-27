package org.example.Models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode
@DiscriminatorValue("W")
@PrimaryKeyJoinColumn(name = "task_id")
@Table(name = "worktask")
public class WorkTask extends Task {
    @Column
    private Double cost;

}
