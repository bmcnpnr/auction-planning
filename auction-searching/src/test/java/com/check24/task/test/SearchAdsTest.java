package com.check24.task.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SearchAdsTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testSearchAdsApiWithOneResult() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(get("/searchAds").param("searchKeyword", "flower"))
                .andDo(print()).andExpect(status().isOk()).andReturn();
        Assert.assertEquals("advertisement1<br/>", mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void testSearchAdsApiWithThreeResults() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(get("/searchAds").param("searchKeyword", "car"))
                .andDo(print()).andExpect(status().isOk()).andReturn();
        Assert.assertEquals("advertisement2<br/>advertisement3<br/>advertisement1<br/>", mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void testSearchAdsApiWithNoResult() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(get("/searchAds").param("searchKeyword", "money"))
                .andDo(print()).andExpect(status().isOk()).andReturn();
        Assert.assertEquals("No result is found", mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void testTheChangingBidAlgorithm() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(get("/changeBidAlgorithm")).andDo(print()).andExpect(status().isOk()).andReturn();
        Assert.assertEquals("Algorithm is changed!", mvcResult.getResponse().getContentAsString());
    }
}
