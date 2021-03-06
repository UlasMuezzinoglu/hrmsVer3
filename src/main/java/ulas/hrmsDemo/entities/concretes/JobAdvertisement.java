package ulas.hrmsDemo.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "job_advertisements")

public class JobAdvertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "job_description")
    private String jobDescription;

    @Column(name = "min_salary")
    private String minSalary;

    @Column(name = "max_salary")
    private String maxSalary;

    @Column(name = "job_of_number_position")
    private String jobOfNumberPosition;

    @Column(name = "end_of_job_date")
    private LocalDate endOfJobDate;

    @Column(name = "status")
    private boolean status;


    @Column(name = "publish_date")
    @Temporal(TemporalType.DATE)
    private Date publishDate;

    @ManyToOne()
    @JoinColumn(name = "city_id")
    private City city;

    @ManyToOne()
    @JoinColumn(name = "employer_id")
    private Employer employer;


    @ManyToOne()
    @JoinColumn(name = "job_title_id")
    private JobTitle jobTitle;






}
