package rovpp.standalone2.hijacks_api;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import rovpp.standalone2.hijacks_api.API.DeploymentController;
import rovpp.standalone2.hijacks_api.Model.ModelDeployment;
import rovpp.standalone2.hijacks_api.Service.DeploymentService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(value = DeploymentController.class)
@WithMockUser
@SpringBootTest
public class DeploymentControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DeploymentService deploymentService;
    Long[] helper = { (long) 123, (long) 456, (long) 789 };
    ModelDeployment modelDeploymentTester = new ModelDeployment(1, "USA", helper, 6, "INNFLOW-CH-001, CH", 4567, null, null, 43, "Subprefix Hijack", "Arizona", 26, "pref", "pref2", "https://bgpstream.com/event/238036");
    ModelDeployment modelDeploymentTester2 = new ModelDeployment(2, "USF", helper, 6, "INNFLOW-CH-001, CH", 4567, null, null, 43, "Subprefix Hijack", "Arizona", 26, "pref", "pref2", "https://bgpstream.com/event/238036");
    List<ModelDeployment> mdlL = new ArrayList<ModelDeployment>();
    @Test
    public void getHijacksTester() throws Exception{
        mdlL.add(modelDeploymentTester);
        mdlL.add(modelDeploymentTester2);
        Mockito.when(deploymentService.getHijacks()).thenReturn(mdlL);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/api/ApiDeployment/get_hijacks").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		
		String expected = "{id:1,country:USA,url:https://bgpstream.com/event/238036,donu:4567,dbbp:6,en:43,dap:[123,456,789],eop:26,eon:Arizona,et:Subprefix Hijack,ep:pref,msp:pref2,dona:INNFLOW-CH-001, CH,end:null,start:null},{id:2,country:USF,url:https://bgpstream.com/event/238036,donu:4567,dbbp:6,en:43,dap:[123,456,789],eop:26,eon:Arizona,et:Subprefix Hijack,ep:pref,msp:pref2,dona:INNFLOW-CH-001, CH,end:null,start:null} ";

		// {"id":"Course1","name":"Spring","description":"10 Steps, 25 Examples and 10K Students","steps":["Learn Maven","Import Project","First Example","Second Example"]}

		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), true);
    }

    
}
