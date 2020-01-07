package com.example.fractallab.model;

import java.util.ArrayList;
import java.util.List;

public class ResultsList {
    private List<Results> results;
 
    public ResultsList() {
    	results = new ArrayList<>();
    }

	public List<Results> getResults() {
		return results;
	}

	public void setResults(List<Results> results) {
		this.results = results;
	}

}