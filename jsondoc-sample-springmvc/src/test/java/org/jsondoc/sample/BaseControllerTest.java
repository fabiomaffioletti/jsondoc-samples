package org.jsondoc.sample;

import static org.springframework.test.web.server.setup.MockMvcBuilders.xmlConfigSetup;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.server.MockMvc;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@ContextConfiguration(locations = {"classpath:test-applicationContext.xml"})
public class BaseControllerTest {

    protected String contextLoc = "classpath:test-applicationContext.xml";
    protected String warDir = "src/main/webapp";
    protected MockMvc mockMvc = null;
    protected ObjectMapper objectMapper = new ObjectMapper();

    @Before
    public void setUp() throws Exception {
        mockMvc = xmlConfigSetup(contextLoc).configureWebAppRootDir(warDir, false).build();
        Assert.assertNotNull(mockMvc);
    }

    protected void printBodyJSON(Object json) throws JsonGenerationException, JsonMappingException, IOException {
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("#################################################################");
        System.out.println("#################### JSON BODY OBJECT ###########################");
        System.out.println(objectMapper.writeValueAsString(json));
        System.out.println("#################################################################");
        System.out.println("#################################################################");
        System.out.println("\n");
        System.out.println("\n");
    }
}