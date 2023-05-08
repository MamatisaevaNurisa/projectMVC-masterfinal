package peaksoft.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "groups")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "group_name")
    private String groupName;
    @Column(name = "data_of_start")
    private String dataOfStart;
    @Column(name = "data_of_finish")
    private String dataOfFinish;
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(name = "groups_courses",
            joinColumns = @JoinColumn(name = "groups_id"),
            inverseJoinColumns = @JoinColumn(name = "courses_id"))
    private List<Course> courses;
    @Transient
    private Long courseId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "group")
    private List<Student> students;
}
