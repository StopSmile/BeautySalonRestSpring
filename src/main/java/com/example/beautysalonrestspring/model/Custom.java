package com.example.beautysalonrestspring.model;

import com.example.beautysalonrestspring.model.enums.TimeSlotType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.beautysalonrestspring.model.enums.CustomStatus;

import javax.persistence.*;


@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Custom {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long clientId;
    private long masterId;
    private java.sql.Date date;
    private long serviceId;

    @Enumerated(EnumType.STRING)
    private TimeSlotType timeSlotType;

    @Enumerated(EnumType.STRING)
    private CustomStatus customStatus;


}
