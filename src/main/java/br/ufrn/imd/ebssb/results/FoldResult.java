package br.ufrn.imd.ebssb.results;

import java.util.ArrayList;

public class FoldResult {

	private int labelledSetSize;
	private int unlabelledSetSize;
	private int validationSetSize;

	private double accuracy;
	private double error;
	private double fMeasure;
	private double precision;
	private double recall;

	private ArrayList<IterationInfo> iterationInfos;

	public FoldResult() {
		this.iterationInfos = new ArrayList<IterationInfo>();
	}

	public void addIterationInfo(IterationInfo info) {
		this.iterationInfos.add(info);
	}

	public String getIterationsDatasetHistory() {
		StringBuilder sb = new StringBuilder();
		
		for (IterationInfo i : this.iterationInfos) {
			sb.append(i.getTestSetSummary());
			sb.append(i.getBoostSubsetSummary());
		}
		return sb.toString();
	}

	protected String onlyValuesToString() {

		StringBuilder sb = new StringBuilder();
		sb.append(formatValue(accuracy) + "%\t");
		sb.append(formatValue(error) + "%\t");
		sb.append(formatValue(fMeasure) + "\t\t");
		sb.append(formatValue(precision) + "\t\t");
		sb.append(formatValue(recall) + "\t\t");

		return sb.toString();
	}

	public String foldResultSummry() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n");
		sb.append("Initial Labelled set size: " + this.labelledSetSize + "\n");
		sb.append("Initial Unlabelled set size: " + this.unlabelledSetSize + "\n");
		sb.append("Initial Validation set size: " + this.validationSetSize + "\n");
		sb.append("===========================\n");
		for (IterationInfo info : this.iterationInfos) {
			sb.append(info.getIterationInfoSummary());
		}
		return sb.toString();
	}

	public static String getTableInfoMeans() {
		StringBuilder sb = new StringBuilder();
		sb.append("------------------------------------------------------------------------\n");
		sb.append("In each iteration, info means: \n");
		sb.append("info1: labelled instances amount; \n");
		sb.append("info2: unlabelled instances amount; \n");
		sb.append("info3: instances sampled and with high agreement; \n");
		sb.append("info4: boost subset size; \n");
		sb.append("info5: Boost ensemble hits; \n");
		sb.append("info6: Boost ensemble errors. \n");
		sb.append("------------------------------------------------------------------------");
		return sb.toString();
	}

	public String foldResultSummarytable() {
		StringBuilder sb = new StringBuilder();
		sb.append("------------------------------------------------------------------------\n");
		sb.append("Initial Labelled set size: " + this.labelledSetSize + "\n");
		sb.append("Initial Unlabelled set size: " + this.unlabelledSetSize + "\n");
		sb.append("Initial Validation set size: " + this.validationSetSize + "\n");
		sb.append("------------------------------------------------------------------------\n");
		sb.append("\t\t\t\t");
		sb.append("info1" + "\t");
		sb.append("info2 " + "\t");
		sb.append("info3" + "\t");
		sb.append("info4" + "\t");
		sb.append("info5" + "\t");
		sb.append("info6" + "\t\n");
		sb.append("------------------------------------------------------------------------\n");
		for (int i = 0; i < this.iterationInfos.size(); i++) {
			if (i < 9) {
				sb.append("Boost Iter 0" + (i + 1) + ":\t");
			} else {
				sb.append("Boost Iter " + (i + 1) + ":\t");
			}

			sb.append(this.iterationInfos.get(i).onlyValuesToString() + "\n");
		}
		sb.append("------------------------------------------------------------------------\n");
		return sb.toString();
	}

	private String formatValue(Double value) {
		String s;
		if (value < 100) {
			s = String.format("%.4f", value);
			if (value < 10) {
				s = " " + String.format("%.4f", value);
			}
		} else {
			s = String.format("%.3f", value);
		}
		return s;
	}

	public int getLabelledSetSize() {
		return labelledSetSize;
	}

	public void setLabelledSetSize(int labelledSetSize) {
		this.labelledSetSize = labelledSetSize;
	}

	public int getUnlabelledSetSize() {
		return unlabelledSetSize;
	}

	public void setUnlabelledSetSize(int unlabelledSetSize) {
		this.unlabelledSetSize = unlabelledSetSize;
	}

	public int getValidationSetSize() {
		return validationSetSize;
	}

	public void setValidationSetSize(int validationSetSize) {
		this.validationSetSize = validationSetSize;
	}

	public double getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(double accuracy) {
		this.accuracy = accuracy;
	}

	public double getError() {
		return error;
	}

	public void setError(double error) {
		this.error = error;
	}

	public double getfMeasure() {
		return fMeasure;
	}

	public void setfMeasure(double fMeasure) {
		this.fMeasure = fMeasure;
	}

	public double getPrecision() {
		return precision;
	}

	public void setPrecision(double precision) {
		this.precision = precision;
	}

	public double getRecall() {
		return recall;
	}

	public void setRecall(double recall) {
		this.recall = recall;
	}

	public ArrayList<IterationInfo> getIterationInfos() {
		return iterationInfos;
	}

	public void setIterationInfos(ArrayList<IterationInfo> iterationInfos) {
		this.iterationInfos = iterationInfos;
	}
	
}
