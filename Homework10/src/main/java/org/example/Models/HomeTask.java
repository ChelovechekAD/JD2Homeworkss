package org.example.Models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Date;



@Data
@Entity
@NoArgsConstructor
@DiscriminatorValue("H")
@EqualsAndHashCode(callSuper = true, exclude = "endDate")
@PrimaryKeyJoinColumn(name = "task_id")
@ToString(callSuper = true)
@Table(name = "hometask")
public class HomeTask extends Task {
    @CreationTimestamp
    @Column(name = "start_date", updatable = false)
    private Date startDate;
    @Column(name = "end_date", insertable = false)
    private Date endDate;
    @Column
    @Embedded
    private Address address;


}
