package com.example.questionnaire.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.questionnaire.Service.ifs.QuizService;
import com.example.questionnaire.vo.QuizReq;
import com.example.questionnaire.vo.QuizRes;

@RestController
@CrossOrigin
public class QuizController {

	@Autowired
	private QuizService quizService;

	// 請求的方法
	// ResquestBody 把外部傳進來的 JSON 格式 轉成class ??
	// PostMapping 新增 post 提供 http methods
	@PostMapping(value = "api/quiz/create")
	public QuizRes create(@RequestBody QuizReq req) {
		return quizService.create(req);
	}

	@GetMapping(value = "api/quiz/searchParam")
	public QuizRes searchParam(@RequestParam(value = "title", required = false) String title,
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam(name = "startDate", required = false) LocalDate startDate,
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam(name = "endDate", required = false) LocalDate endDate) {

		return quizService.searchParam(title, startDate, endDate);
	}

	@PostMapping(value = "api/quiz/createOrUpdate")
	public QuizRes update(@RequestBody QuizReq req) {
		return quizService.createOrUpdate(req);
	}

	@DeleteMapping(value = "api/quiz/deleteAll")
	public QuizRes delete(@RequestBody List<Integer> qnIdList) {
		return quizService.deleQuestionnaire(qnIdList);
	}
	//做統計用
	@GetMapping(value = "api/quiz/userget")
	public QuizRes userget(@RequestParam int id) {
		return quizService.quizGetInfo(id);
	}
	//使用者寫填寫個人資料還有填寫問卷的回答問題
	
	@GetMapping(value = "api/quiz/user/answer")
	public QuizRes getQuizAns(@RequestParam int id) {
		return quizService.getQuizAns(id);
	}
	
	
	
	
	
	@PostMapping(value = "api/quiz/usercreate")
	public QuizRes usercreate(@RequestBody QuizReq req) {
		return quizService.createUser(req);
		
}
	
	
}