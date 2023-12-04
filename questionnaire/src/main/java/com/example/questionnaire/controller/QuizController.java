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

	// �ШD����k
	// ResquestBody ��~���Ƕi�Ӫ� JSON �榡 �নclass ??
	// PostMapping �s�W post ���� http methods
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
	//���έp��
	@GetMapping(value = "api/quiz/userget")
	public QuizRes userget(@RequestParam int id) {
		return quizService.quizGetInfo(id);
	}
	//�ϥΪ̼g��g�ӤH����٦���g�ݨ����^�����D
	
	@GetMapping(value = "api/quiz/user/answer")
	public QuizRes getQuizAns(@RequestParam int id) {
		return quizService.getQuizAns(id);
	}
	
	
	
	
	
	@PostMapping(value = "api/quiz/usercreate")
	public QuizRes usercreate(@RequestBody QuizReq req) {
		return quizService.createUser(req);
		
}
	
	
}