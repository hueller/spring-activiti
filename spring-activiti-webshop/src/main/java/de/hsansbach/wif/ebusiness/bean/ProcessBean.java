package de.hsansbach.wif.ebusiness.bean;

import javax.faces.bean.RequestScoped;
import javax.inject.Named;

import org.activiti.engine.TaskService;
import org.springframework.beans.factory.annotation.Autowired;

import de.hsansbach.wif.ebusiness.bean.NavigationBean.NavigationKey;
import de.hsansbach.wif.ebusiness.process.service.ProcessRuntimeService;

@Named
@RequestScoped
public class ProcessBean {
	
	private String processInstanceId;
	
	@Autowired
	private NavigationBean navigationBean;

	@Autowired
	private ProcessRuntimeService processRuntimeService;
	
	@Autowired
	private TaskService taskService;
	
	public String startPurchaseProcess() {
		this.processInstanceId = processRuntimeService.startPurchaseProcess(1L, 1L);
		return navigationBean.get(NavigationKey.PROCESS_RESULT);
	}
	
	public String startUserConfirmationProcess() {
		this.processInstanceId = processRuntimeService.startUserConfirmationProcess();
		return navigationBean.get(NavigationKey.PROCESS_RESULT);
	}

	public String getProcessInstanceId() {
		return this.processInstanceId;
	}

}