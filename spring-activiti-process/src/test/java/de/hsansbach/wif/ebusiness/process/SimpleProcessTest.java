package de.hsansbach.wif.ebusiness.process;

import javax.inject.Inject;

import org.activiti.engine.RuntimeService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.hsansbach.wif.ebusiness.process.service.ActivitiProcessService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:process-context.xml")
public class SimpleProcessTest {

	@Inject
	private RuntimeService runtimeService;

	@Inject
	private ActivitiProcessService processRuntimeService;

	@Test
	public void testProcess() {
		processRuntimeService.startProcess(ProcessKey.SIMPLE_TEST);

		Assert.assertEquals(0, runtimeService.createProcessInstanceQuery().count());
	}

}