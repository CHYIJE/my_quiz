package com.tenco.quiz.ver2;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class QuizRepositoryTest1 {

	public static void main(String[] args) {
		QuizRepositoryImpl impl = new QuizRepositoryImpl();
		// 메서드 호출해서 실행 확인 디버깅 확인 테스트
		// QuizRepository 구현 클래스 테스트
		try {
			Scanner sc = new Scanner(System.in);

			while (true) {
				printMenu();

				int choice = sc.nextInt();

				if (choice == 1) {
					
						System.out.println("문제를 입력하시오");
						String question = sc.next();
						System.out.println("정답을 입력하시오.");
						String answer = sc.next();
						
						impl.addQuizQuestion(question, answer);
						
					

				} else if (choice == 2) {
					List<QuizDTO> answerList = impl.viewQuizQuestion();
					for (QuizDTO quizDTO : answerList) {
						System.out.println(quizDTO);
					}

				} else if (choice == 3) {
					QuizDTO dto = impl.playQuezGame();
					System.out.println(dto);

					System.out.println("정답을 맞춰주세요");
					System.out.println(dto.getQuestion());
					String userInput = sc.next();
					if (dto.getAnswer().equalsIgnoreCase(userInput)) {
						System.out.println("정답입니다.");
					} else {
						System.out.println("오답입니다! 공부하세요 (ง ͠° ͟ʖ ͡°)ง ");
					}

				} else if (choice == 4) {
					System.out.println("할만큼 했으면 꺼져라");
					return;
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 주말 과제
		// 실행의 흐름 직접 만들어보기

	} // end of main

	private static void printMenu() {
		System.out.println();
		System.out.println("----------------------");
		System.out.println("1. 퀴즈 문제 추가");
		System.out.println("2. 퀴즈 문제 조회");
		System.out.println("3. 퀴즈 게임 시작");
		System.out.println("4. 종료");
		System.out.print("옵션을 선택하세요!");
	}

} // end of class
