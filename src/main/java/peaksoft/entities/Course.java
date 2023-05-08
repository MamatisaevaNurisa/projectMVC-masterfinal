package peaksoft.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "courses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "course_name")
    private String courseName;
    @Column(name = "duration_month")
    private String durationMonth;

    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name = "company_id")
    protected Company company;
    @Transient
    private Long companyId;
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, mappedBy = "courses")
    private List<Group> groups;
    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, mappedBy = "course")
    private Teacher teacher;
}
