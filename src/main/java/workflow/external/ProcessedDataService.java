
package workflow.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

/**
 * Created by uengine on 2018. 11. 21..
 */

@FeignClient(name="Preprocess", url="${api.url.preprocess}")
public interface ProcessedDataService {

    @RequestMapping(method= RequestMethod.POST, path="/processedDatas")
    public void preProcess(@RequestBody ProcessedData processedData);

}