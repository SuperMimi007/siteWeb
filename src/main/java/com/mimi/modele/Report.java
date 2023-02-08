package com.mimi.modele;


import lombok.*;

import javax.persistence.*;
import java.sql.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@ToString
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reportId;

    @Column(length = 100, nullable = false, unique = true)
    private String reportName;

    private Date uploadTime;

    private Date dateOfReport;

    private long size;

    @Column(length = 45)
    private byte[] content;


    @ManyToOne
    @JoinColumn(name = "dog_id")
    private Dog dog;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
