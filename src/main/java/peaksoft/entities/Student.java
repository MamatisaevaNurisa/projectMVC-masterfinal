package peaksoft.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "students")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "study_formation")
    @Enumerated
    private StudyFormation studyFormation;
    private String email;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH,CascadeType.PERSIST})
    @JoinColumn(name = "group_id")
    protected Group group;
    @Transient
    private Long groupId;

}
