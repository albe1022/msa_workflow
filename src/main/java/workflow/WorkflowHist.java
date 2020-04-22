package workflow;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="WorkflowHist_table")
public class WorkflowHist {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long rawDataId;
    private String dataType;

    @PostPersist
    public void onPostPersist(){
        WorkflowStarted workflowStarted = new WorkflowStarted();
        BeanUtils.copyProperties(this, workflowStarted);
        workflowStarted.publish();

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        workflow.external.ProcessedData processedData = new workflow.external.ProcessedData();
        // mappings goes here
        processedData.setRawDataId(workflowStarted.getRawDataId());
        processedData.setDataType(workflowStarted.getDataType());
        Application.applicationContext.getBean(workflow.external.ProcessedDataService.class)
            .preProcess(processedData);


    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getRawDataId() {
        return rawDataId;
    }

    public void setRawDataId(Long rawDataId) {
        this.rawDataId = rawDataId;
    }
    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }




}
