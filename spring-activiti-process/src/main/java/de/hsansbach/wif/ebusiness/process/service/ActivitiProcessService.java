package de.hsansbach.wif.ebusiness.process.service;

import java.util.List;
import java.util.Map;

import org.activiti.engine.task.Task;

import de.hsansbach.wif.ebusiness.process.ProcessKey;

public interface ActivitiProcessService {
	
	String startProcess(ProcessKey key);
	
	String startProcess(ProcessKey key, Map<String, Object> variables);

	String startProcess(String key, Map<String, Object> variables);

	List<Task> getTasksForAssigne(String assigne);

	void completeTask(String taskId);

}