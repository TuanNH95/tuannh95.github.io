package nal.test.planning.enity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity for work
 * @author TuanNH
 */
@Entity
@Table(name = "work")
public class Work implements Comparable<Work>{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_work")
    private int id;
    
    @Column(name = "work_name")
    private String workName;

    @Column(name = "starting_date")
    private String startingDate;

    @Column(name = "ending_date")
    private String endingDate;

    @Column(name = "status")
    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWorkName() {
        return workName;
    }

    public void setWorkName(String workName) {
        this.workName = workName;
    }

    public String getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(String startingDate) {
        this.startingDate = startingDate;
    }

    public String getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(String endingDate) {
        this.endingDate = endingDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int compareTo(Work work) {
        return this.workName.compareTo(work.workName);
    }
}
