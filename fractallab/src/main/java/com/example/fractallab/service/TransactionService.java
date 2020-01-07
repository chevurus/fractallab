package com.example.fractallab.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.fractallab.model.Results;
import com.example.fractallab.model.ResultsList;

@Service
public class TransactionService {

	@Autowired
	RestTemplate restTemplate;

	@Value("${fractal.transaction.api.url}")
	private String transactionApiUrl;

	@Value("${fractal.category.api.url}")
	private String categoryApiUrl;

	public String getTransactionApiUrl() {
		return transactionApiUrl;
	}

	public void setTransactionApiUrl(String transactionApiUrl) {
		this.transactionApiUrl = transactionApiUrl;
	}

	public List<Results> getTransactions() {

		List<Results> transactions = getCompanyTransactions();
		return transactions;

	}

	public List<Results> getTransactionsForCategoryList(List<String> categories) {

		List<Results> transactions = getCompanyTransactions();

		transactions.forEach(System.out::println);

		transactions.removeIf(transaction -> !categories.contains(transaction.getCategory()));

		return transactions;

	}

	public List<Results> getTransactionsForCategory(String category) {

		List<Results> transactions = getCompanyTransactions();

		transactions.removeIf(transaction -> !category.equals(transaction.getCategory()));

		return transactions;

	}

	private List<Results> getCompanyTransactions() {

		ResultsList response = restTemplate.getForObject(transactionApiUrl, ResultsList.class);

		List<Results> trasactions = response.getResults();

		return trasactions;
	}

	public List<Results> updateTransactionCategory(String companyId, String categoryId, String transactionId) {
		
	       Map<String, String> vars = new HashMap<String, String>();
	        vars.put("companyId", companyId);
	        vars.put("categoryId", categoryId);
	        vars.put("transactionId", transactionId);
	        
		//User returns = rt.postForObject(uri, u, User.class, vars);
	        Results transaction = new Results();
		
		restTemplate.put(categoryApiUrl, transaction, vars);
		

		return null;
	}

}
