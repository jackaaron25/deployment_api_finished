package rovpp.standalone2.hijacks_api.API;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rovpp.standalone2.hijacks_api.Model.ModelActive;
import rovpp.standalone2.hijacks_api.Model.ModelDeployment;
import rovpp.standalone2.hijacks_api.Service.DeploymentService;
import java.util.*;
@RequestMapping(path = "/api/ApiDeployment")
@RestController
public class DeploymentController {
    private final DeploymentService deploymentService;
    @Autowired
    public DeploymentController(DeploymentService deploymentService){
        this.deploymentService = deploymentService;
    }
    @GetMapping(path = "/get_hijacks")
    public List<ModelDeployment> getHijacks(){
        return deploymentService.getHijacks();
    }
    @GetMapping(path = "/hijack_time_summary")
    public ModelActive hijackTimeSummary(){
        return deploymentService.hijackTimeSummary();
    }
}