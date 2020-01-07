package com.example.fractallab.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.fractallab.model.Results;
import com.example.fractallab.model.ResultsList;
import com.example.fractallab.service.TransactionService;

@RestController
public class CategoryController {

	@Autowired
	TransactionService transactionService;

	@GetMapping(path = "/transactions")
	public List<Results> getTrasactions() {
		return transactionService.getTransactions();

	}

	@GetMapping(path = "/transactions/{category}")
	public List<Results> getTransactionsForCategory(@PathVariable String category) {
		return transactionService.getTransactionsForCategory(category);

	}

	@GetMapping(path = "/{categoriesList}/transactions")
	@ResponseBody
	public List<Results> getCategorisedTransactions(@PathVariable List<String> categoriesList) {
		return transactionService.getTransactionsForCategoryList(categoriesList);
	}

	
//	@PutMapping(path = "/transactions/{companyId}/{categoryId}/{transactionId}}")
//	public List<Results> updateTransactionCategory(@PathVariable String companyId,
//			@PathVariable String categoryId, @PathVariable String transactionId) {
//		return transactionService.updateTransactionCategory(companyId, categoryId, transactionId);
//
//	}
	
	@PutMapping(path = "/transactions/{transactionId}/{categoryId}/{companyId}")
	public List<Results> updateTransactionCategory(@PathVariable String transactionId, @PathVariable String categoryId,@PathVariable String companyId ) {
		return transactionService.updateTransactionCategory(companyId, categoryId, transactionId);

	}
	
	@PutMapping(path = "/transactions/{id}/{categoryName}")
	public List<Results> updateTransactionCategory(@PathVariable String id, @PathVariable String category) {
		return transactionService.getTransactionsForCategory(category);
	}


}
