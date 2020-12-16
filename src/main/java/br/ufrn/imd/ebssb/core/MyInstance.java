package br.ufrn.imd.ebssb.core;

import br.ufrn.imd.ebssb.results.InstanceResult;
import weka.core.Instance;

public class MyInstance {

	private Instance instance;
	private Double weight;
	private Double instanceClass;
	private InstanceResult result;
	
	public MyInstance(Instance instance) {
		this.instance = instance;
		this.instanceClass = -1.0;
	}
	
	public MyInstance(Instance instance, Double weight) {
		this.instance = instance;
		this.instanceClass = -1.0;
		this.weight = weight;
	}

	public void increaseWeight(Double value) {
		this.weight += value;
	}
	
	public void decreaseWeight(Double value) {
		this.weight -= value;
	}
	
	public Instance getInstance() {
		return instance;
	}

	public void setInstance(Instance instance) {
		this.instance = instance;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Double getInstanceClass() {
		return instanceClass;
	}

	public void setInstanceClass(Double instanceClass) {
		this.instanceClass = instanceClass;
	}

	public InstanceResult getResult() {
		return result;
	}

	public void setResult(InstanceResult result) {
		this.result = result;
	}
	
}
