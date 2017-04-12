package gov.va.jbpm.tasksservice.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import gov.va.jbpm.tasksservice.bean.*;
import gov.va.jbpm.tasksservice.exception.TaskServiceException;

public class TaskUtils {
	/*
	 * Transform Tasks structure to output structure.
	 * */
	public static TasksResponse transformToTasksResponse(Task task) {
		try {
			TaskLogging.debug("Entering transformToTasksResponse");
			if (task == null)
				throw new TaskServiceException("TaskUtils.transformToTasksResponse: task cannot be null");
			
			TasksResponse response = new TasksResponse();
			TasksDataResponse tasksData = new TasksDataResponse();
			List<TaskSummary> taskSummaryItems = new ArrayList<TaskSummary>();  
			tasksData.setItems(taskSummaryItems);
			response.setData(tasksData);
			
			List<TaskInfo> taskInfoList = task.getTaskInfoList();
			if (taskInfoList != null && !taskInfoList.isEmpty()) {
				for(TaskInfo taskInfo : taskInfoList){
					List<TaskSummary> taskSummaries = taskInfo.getTaskSummaries();
					if (taskSummaries != null && !taskSummaries.isEmpty()) {
						//if a task has more than 1 summary, take the last summary
						TaskSummary taskSummary = taskSummaries.get(taskSummaries.size() - 1);
						List<Variable> variables = taskInfo.getVariables();
						if (variables != null && !variables.isEmpty()) {
							taskSummary.setVariables(variables);
						}

						//assign the parent's process instance id if it isn't included in the task summary
						if (taskSummary.getProcessInstanceId() <= 0) {
							taskSummary.setProcessInstanceId(taskInfo.getProcessInstanceId());
						}
						taskSummaryItems.add(taskSummary);
					}
				}
			}
			
			return response;
		} catch (TaskServiceException e) {
			//Error was already logged
		} catch (Exception e) {
			TaskLogging.error("TaskUtils.transformToTasksResponse: An unexpected condition has happened: " + e.getMessage());
		}
		return null;
	}

	/*
	 * Filter out variable old history and return only latest values
	 * */
	public static List<Variable> filterVariablesForRecency(List<Variable> variables) {
		List<Variable> newVariablesList = new ArrayList<Variable>();
		
		if (variables == null)
			return newVariablesList;
		
		try {
			Map<String, Integer> indexMap = new HashMap<String, Integer>();
			for(Variable variable : variables) {			
				int location = indexMap.getOrDefault(variable.getName(), -1);
				if (location != -1) {				
					Variable variableAtLocation = newVariablesList.get(location);
					if (variableAtLocation == null)
						throw new TaskServiceException("TaskUtils.filterVariablesForRecency: task cannot be null");
					long existingModDate = variableAtLocation.getModificationDate();
					long newModDate = variable.getModificationDate();
					if (existingModDate > 0) {
						if (newModDate > 0 && (newModDate >= existingModDate)) { //the current element is newer, replace old element with current element
							newVariablesList.set(location, variable);
						}
					} else if (newModDate > 0) {
						newVariablesList.set(location, variable);
					} else {
						newVariablesList.add(variable);
						indexMap.put(variable.getName(), newVariablesList.size() - 1);
					}
				} else {
					newVariablesList.add(variable);
					indexMap.put(variable.getName(), newVariablesList.size() - 1);
				}
			}
			
			return newVariablesList;
		} catch (TaskServiceException e) {
			//Error was already logged
		} catch (Exception e) {
			TaskLogging.error("TaskUtils.filterVariablesForRecency: An unexpected condition has happened: " + e.getMessage());
		}
		
		return newVariablesList;
	}
	
	/*
	 * Check whether given type name is primitive
	 * */
	public static boolean isPrimitiveType(String typeName) {
		if (typeName == null)
			return false;
		
		if (typeName == "String" ||
				typeName == "Integer" ||
				typeName == "Boolean" ||
				typeName == "Float") {
			return true;
		}
		
		return false;
	}
}