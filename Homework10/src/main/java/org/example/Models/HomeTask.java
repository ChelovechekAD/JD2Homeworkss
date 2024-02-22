package org.example.Models;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@NoArgsConstructor
@DiscriminatorValue("H")
@PrimaryKeyJoinColumn(name = "task_id")
@ToString(callSuper = true)
@Table(name = "hometask")
public class HomeTask extends Task{
    @CreationTimestamp
    @Column(name = "start_date", updatable = false)
    private Date startDate;
    @Column(name = "end_date", insertable = false)
    private Date endDate;
    @Embedded
    private Address address;

}
