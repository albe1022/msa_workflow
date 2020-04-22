package workflow.external;

public class ProcessedData {

    private Long id;
    private Long rawDataId;
    private String dataType;


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

