package com.example.questionnaire.Service.ifs;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import com.example.questionnaire.entity.User;
import com.example.questionnaire.entity.UserAnswer;
import com.example.questionnaire.vo.QuestionRes;
import com.example.questionnaire.vo.QuestionnaireRes;
import com.example.questionnaire.vo.QuizReq;
import com.example.questionnaire.vo.QuizRes;
import com.example.questionnaire.vo.QuizVo;
import com.example.questionnaire.vo.UserReq;

public interface QuizService {
	
	public QuizRes create(QuizReq req);

	public QuizRes create1(QuizReq req);
	
	public QuizRes createOrUpdate(QuizReq req);
	
	public QuizRes deleQuestionnaire(List<Integer> qnIdList);

	public QuizRes deleQuestion(int qnid, List<Integer> quIdList);
	


	public QuizRes createUserInfo(UserReq userReq);
	
	public QuizRes showInfo(int id);
	public List<UserAnswer>showAnswer(int quizId);

	
	

	// ��O�j�M
	public QuizRes searchParam(String title, LocalDate startDate,LocalDate endDate);

	// �e�x���j�M�A�u���w�o�����~�j����
	public QuestionnaireRes searchQuestionnaireList(String title, LocalDate startDate,LocalDate endDate,boolean isPublished);

	
	public QuestionRes searchQuestionList(int qnId);

	//
	public QuizRes search(String title, LocalDate startDate, LocalDate endDate);







	
	
}
