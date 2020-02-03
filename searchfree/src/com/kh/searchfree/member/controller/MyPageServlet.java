package com.kh.searchfree.member.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.searchfree.admin.model.vo.Category1;
import com.kh.searchfree.admin.model.vo.Category2;
import com.kh.searchfree.common.ExceptionForward;
import com.kh.searchfree.common.MyFileRenamePolicy;
import com.kh.searchfree.member.model.service.MemberService;
import com.kh.searchfree.member.model.vo.Member;
import com.kh.searchfree.member.model.vo.MyProject;
import com.kh.searchfree.member.model.vo.ProfileResource;
import com.oreilly.servlet.MultipartRequest;

@WebServlet("/member/*")
public class MyPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MyPageServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = uri.substring((contextPath + "/member").length());

		String msg = null;
		String path = null;
		RequestDispatcher view = null;

		HttpSession session = request.getSession();
		Member loginMember = (Member) session.getAttribute("loginMember");

		System.out.println("login first " + loginMember);

		if (loginMember != null) {

			if (command.equals("/mypage")) {
				// 마이페이지 첫 화면 == 회원정보

				try {
					// 완료된 프로젝트 수
					int memberNo = loginMember.getMemberNo();

					int completeProject = new MemberService().completeProject(memberNo);
					request.setAttribute("completeProject", completeProject);

					// 진행중인 프로젝트 수
					int goingProject = new MemberService().goingProject(memberNo);
					request.setAttribute("goingProject", goingProject);

					// 새로운 쪽지
					int messageCount = new MemberService().messageCount(memberNo);
					request.setAttribute("messageCount", messageCount);

					// 받은 리뷰
					int reviewCount = new MemberService().reviewCount(memberNo);
					request.setAttribute("reviewCount", reviewCount);

					// 평균 별점
					int avgSrating = new MemberService().avgSrating(memberNo);
					request.setAttribute("avgSrating", avgSrating);

					// 프로젝트 완료울
					int countProject = new MemberService().countProject(memberNo);
					double percentProject = ((double) completeProject / countProject) * 100;
					/*
					 * if (percentProject!=0) { request.setAttribute("percentProject",
					 * percentProject); }else if ((Double.isNaN(percentProject))){ String
					 * spercentProject = "0"; request.setAttribute("percentProject",
					 * spercentProject); }
					 */
					if (percentProject != 0) {
						request.setAttribute("percentProject", percentProject);
					} else {
						request.setAttribute("percentProject", 0.0);
					}

					// 마감일이 안지난 프로젝트 리스트 담고있는 리스트
					List<MyProject> projectSchedule = new MemberService().projectSchedule(memberNo);
					request.setAttribute("projectSchedule", projectSchedule);
					System.out.println("일정 : " + projectSchedule);

					path = "/WEB-INF/views/member/mypage.jsp";
					view = request.getRequestDispatcher(path);
					view.forward(request, response);

					System.out.println("완료된 프로젝트 수 : " + completeProject);
					System.out.println("진행 중 프로젝트 수 : " + goingProject);
					System.out.println("쪽지 갯수 : " + messageCount);
					System.out.println("등록된 리뷰 : " + reviewCount);
					System.out.println("평균 별점 : " + avgSrating);
					System.out.println("등록한 프로젝트 수 : " + countProject);
					System.out.println("완료율 : " + percentProject);
					// System.out.println(((double)completeProject/countProject)*100);

				} catch (Exception e) {
					e.printStackTrace();
				}

			}

			else if (command.equals("/mypage-update")) {
				// 업데이트 뷰
				// 마이페이지 회원정보 수정

				try {

					request.setAttribute("memberId", loginMember.getMemberId());
					request.setAttribute("memberPwd", loginMember.getMemberPwd());
					request.setAttribute("memberNm", loginMember.getMemberNm());
					request.setAttribute("memberPwd", loginMember.getMemberPwd());
					request.setAttribute("memberNick", loginMember.getMemberNick());
					request.setAttribute("memberPhone", loginMember.getMemberPhone());
					request.setAttribute("memberEmail", loginMember.getMemberEmail());
					request.setAttribute("memberAddr", loginMember.getMemberAddr());
					request.setAttribute("category1CodeInt", loginMember.getCategory1Code());
					request.setAttribute("category2CodeInt", loginMember.getCategory2Code());
					request.setAttribute("memberAccount", loginMember.getMemberAccount());

					List<Category1> category1List = new MemberService().getCategory1List();
					System.out.println(category1List);
					List<Category2> category2List = new MemberService().getCategory2List();
					System.out.println(category2List);
					request.setAttribute("category1List", category1List);
					request.setAttribute("category2List", category2List);
					request.setAttribute("category1Code", "1");

				} catch (Exception e) {
					e.printStackTrace();
				}
				path = "/WEB-INF/views/member/mypage-update.jsp";
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
			}

			else if (command.equals("/updateMember")) {
				// 업데이트를 수행하는 서블릿
				String memberNick = request.getParameter("inputNick");
				String memberEmail = request.getParameter("inputEmail");

				// 사용자가 입력한 새 비밀번호
				String memberPwd = request.getParameter("inputPwd");

				String memberPhone = request.getParameter("inputPhone");
				String memberAddr = request.getParameter("inputAddr1") + "," + request.getParameter("inputAddr2");
				int category1Code = Integer.parseInt(request.getParameter("inputCategory1"));
				int category2Code = Integer.parseInt(request.getParameter("inputCategory2"));

				String memberId = loginMember.getMemberId();
				System.out.println("update login = " + loginMember);

				Member updateMember = new Member(memberPwd, memberNick, memberPhone, memberEmail, memberAddr,
						category1Code, category2Code);
				updateMember.setMemberNo(loginMember.getMemberNo());
				try {

					int result = new MemberService().updateMember(updateMember, memberId, memberPwd);

					if (result > 0) {
						System.out.println("수정 성공");
						request.setAttribute("msg", "회원 정보 수정이 정상적으로 처리되었습니다.");
						path = request.getHeader("REFERER");

					} else {
						System.out.println("수정 실패");
						request.setAttribute("msg", "수정 실패, 비밀번호를 재확인 하세요.");
						path = request.getHeader("REFERER");
					}

					response.sendRedirect(path);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			else if (command.equals("/mypage-delete")) {
				// 마이페이지 회원 탈퇴 뷰
				path = "/WEB-INF/views/member/mypage-delete.jsp";
				view = request.getRequestDispatcher(path);
				view.forward(request, response);

			} else if (command.equals("/deleteMember")) {
				// 마이페이지 회원 탈퇴 처리

				String inputPwd = request.getParameter("inputPwd");

				System.out.println("파라미터 inputPwd : " + inputPwd);

				try {
					int result = new MemberService().deleteMember(inputPwd);

					if (result > 0) {
						System.out.println("회원탈퇴 성공");
						request.setAttribute("msg", "회원 탈퇴가 정상적으로 처리되었습니다.");
						path = request.getContextPath();

					} else {
						System.out.println("회원탈퇴 실패");
						request.setAttribute("msg", "회원 탈퇴 실패, 비밀번호를 재확인 하세요.");
						path = "mypage-delete.do";
					}

					response.sendRedirect(path);

				} catch (Exception e) {
					e.printStackTrace();
				}

			}

			else if (command.equals("/mypage-profile")) {
				// 마이페이지 회원정보 프로필 뷰
				try {
					// Member selectMember = new MemberService().selectMember();

					// 닉네임
					request.setAttribute("memberNick", loginMember.getMemberNick());

					// 프로젝트 리스트 가져오기
					List<MyProject> projectList1 = new MemberService().selectProject1(loginMember.getMemberNo());
					List<MyProject> projectList2 = new MemberService().selectProject2(loginMember.getMemberNo());
					System.out.println("프로젝트 리스트" + projectList1);
					request.setAttribute("projectList1", projectList1);
					request.setAttribute("projectList2", projectList2);
					System.out.println("리스트출력 : " + projectList1);

					// 등록한 프로필 사진 select해서 가져오기
					List<ProfileResource> files = new MemberService().selectFiles(loginMember.getMemberNo());

					if (!files.isEmpty()) {
						request.setAttribute("files", files);
						System.out.println("셀렉트한 파일의 0번 인덱스 :" + files.get(0));
					}

					path = "/WEB-INF/views/member/mypage-profile.jsp";
					view = request.getRequestDispatcher(path);
					view.forward(request, response);

				} catch (Exception e) {
					e.printStackTrace();
				}

			}

			// 이미지 등록용 Controller
			else if (command.equals("/insert")) {
				// form 전송 시 mutipart/form-data로 전송하는 경우
				// 기존처럼 request.getParameter()를 이용하여
				// 입력값을 전달받을 수 없음
				// ->MutipartRequest를 사용해야 함
				// -> cos.jar 라이브러리 추가 필요
				// ->(https://www.servlets.com/)

				try {
					// 요청(request)가 mutipart/form-data가 포함되어 있 냐?
					if (ServletFileUpload.isMultipartContent(request)) {

						// 1_1. 전송 파일의 용량 제한
						// B -> KB -> MB -> GB -> TB
						// 1024
						int maxSize = 10 * 1024 * 1024;

						// 1_2. 웹 서버 컨테이너 경로 추출
						// -> WebContent 경로 추출 (내컴퓨터에서)
						String root = request.getSession().getServletContext().getRealPath("/");

						// 1_3. 업로드 된 파일이 저장될 경로 지정
						String savePath = root + "resources/uploadImages/";

						// 2. 파일명 변환 작업
						// 파일명 중복으로 인한 데이터 손실 예방
						// + 파일명이 한글 또는 특수문자가 포함되면 서버 종류에 따라 문제가 발생할 수 있어서

						// cos.jar -> DefaultFileRenamePolicy 를 제공해 주지만
						// 나만의 파일명 규칙을 적용하기 위해서
						// 별도의 MyFileRenamePolicy를 작성한다.

						// 3. MultipartRequest 객체를 생성
						// -> 객체가 생성 되는 순간에
						// -> request, 파일경로 지정, 최대 파일 크기 지정, 문자인코딩 지정
						// -> * 변경된 파일명으로 파일이 저장된다.
						MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8",
								new MyFileRenamePolicy());

						// 4. 서버에 저장된 파일의 원래 파일명, 이전 파일명을
						// DB에 전달하기 위한 ArrayList를 생성
						ArrayList<String> saveFiles = new ArrayList<String>();

						// 원본 파일명
						ArrayList<String> originFiles = new ArrayList<String>();

						// 전달된 요청(multipartRequest)에서 파일 리스트 정보를 얻어와
						// 저장된 파일명, 원래 파일명을 각 ArrayList에 추가함.

						Enumeration<String> files = multiRequest.getFileNames();

						while (files.hasMoreElements()) {

							// 업로드된 파일은 역순으로 전달된다.
							String name = files.nextElement();

							if (multiRequest.getFilesystemName(name) != null) {
								// getFilesystemName(key) : rename된 파일명 얻어오기
								saveFiles.add(multiRequest.getFilesystemName(name));

								originFiles.add(multiRequest.getOriginalFileName(name));
							}

						}

						// 5. 파일 외에 나머지 게시글 입력값 얻어오기
//					String boardTitle = multiRequest.getParameter("title");
//					String boardContent = multiRequest.getParameter("content");
//					String boardCategory = multiRequest.getParameter("category");
//					
//					Board board = new Board(boardTitle, boardContent, boardCategory);
//					

						// 회원 번호를 session에서 얻어옴
						// session은 request에서만 얻어 올 수 있다.
						// Member loginMember =
						// (Member)request.getSession().getAttribute("loginMember");

						int memberNo = loginMember.getMemberNo();

						// 6. Attachment Vo를 생성한 후
						// Attachment들을 저자아할 List를 생성하여
						// 파일 경로, 파일 원본명, 변경된 파일명을 세팅

						ProfileResource file = new ProfileResource();

						// 파일정보는 역순으로 전달되므로, 반복문을 역으로 수행하여 원래 순서대로 저장
						for (int i = originFiles.size() - 1; i >= 0; i--) {
							file = new ProfileResource(); // 파일정보 저장
							file.setProfileResourcePath(savePath); // 경로
							file.setFileOriginName(originFiles.get(i));
							file.setFileChangeName(saveFiles.get(i));

							// 썸네일 이미지는 fileLevel 0으로
							// 나머지 이미지에는 fileLevle 1 부여
							/*
							 * if( (i == originFiles.size()-1) && multiRequest.getFilesystemName("img1")
							 * !=null ) { //마지막 인덱스를 0으로 하겠다?? file.setFileLevel(0); }else {
							 * file.setFileLevel(1); }
							 */

						}

						int result = new MemberService().insertProfile(memberNo, file);

						// 트랜잭션 처리결과에 따라
						if (result > 0)
							msg = "이미지 등록 성공";
						else
							msg = "이미지 등록 실패";

						request.getSession().setAttribute("msg", msg);
						path = request.getHeader("REFERER");
						response.sendRedirect(path);
						// 이미지 등록후 프로필페이지 그대로 유지
						// - >등록한 이미지를 영역에 보여주기 ?

						// 이미지 경로, 바뀐 파일명, 멤버넘버,

					}
				} catch (Exception e) {
					ExceptionForward.errorPage(request, response, "게시글 등록", e);
				}

			}

			// 프로필사진 수정동작
			else if (command.equals("/mypage-update")) {
				try {
					if (ServletFileUpload.isMultipartContent(request)) {

						int maxSize = 10 * 1024 * 1024;
						String root = request.getSession().getServletContext().getRealPath("/");
						String savePath = root + "resources/uploadImages/";

						MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8",
								new MyFileRenamePolicy());

						ArrayList<String> saveFiles = new ArrayList<String>();
						ArrayList<String> originFiles = new ArrayList<String>();

						Enumeration<String> files = multiRequest.getFileNames();

						while (files.hasMoreElements()) {
							String name = files.nextElement();

							if (multiRequest.getFilesystemName(name) != null) {
								saveFiles.add(multiRequest.getFilesystemName(name));
								originFiles.add(multiRequest.getOriginalFileName(name));
							}
						}
						int memberNo = loginMember.getMemberNo();

						ProfileResource file = new ProfileResource();

						for (int i = originFiles.size() - 1; i >= 0; i--) {
							file = new ProfileResource(); // 파일정보 저장
							file.setProfileResourcePath(savePath); // 경로
							file.setFileOriginName(originFiles.get(i));
							file.setFileChangeName(saveFiles.get(i));
						}

						int result = new MemberService().updateProfile(memberNo, file);

						if (result > 0)
							msg = "이미지 수정 성공";
						else
							msg = "이미지 수정 실패";

						request.getSession().setAttribute("msg", msg);
						path = request.getHeader("REFERER");
						response.sendRedirect(path);
						// 이미지 등록후 프로필페이지 그대로 유지
						// - >등록한 이미지를 영역에 보여주기 ?
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			else if (command.equals("/mypage-summernote")) {
				// 포트폴리오 - 썸머노트있는 페이지로 연결
				path = "/WEB-INF/views/member/mypage-summernote.jsp";
				view = request.getRequestDispatcher(path);
				view.forward(request, response);

			}
			// 썸머노트 - 프로필리소스콘텐트에 입력하는 동작
			else if (command.equals("/insertPortpolio")) {

				int memberNo = loginMember.getMemberNo();
				String upContent = request.getParameter("content");
				String upTitle = request.getParameter("subject");

				System.out.println(upContent);
				System.out.println(upTitle);

				try {

					// 요청(request)가 mutipart/form-data가 포함되어 있 냐?
					if (ServletFileUpload.isMultipartContent(request)) {

						int maxSize = 10 * 1024 * 1024;

						// 1_2. 웹 서버 컨테이너 경로 추출
						// -> WebContent 경로 추출 (내컴퓨터에서)
						String root = request.getSession().getServletContext().getRealPath("/");

						// 1_3. 업로드 된 파일이 저장될 경로 지정
						String savePath = root + "resources/uploadImages/";

						// 2. 파일명 변환 작업
						MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8",
								new MyFileRenamePolicy());

						ArrayList<String> saveFiles = new ArrayList<String>();

						ArrayList<String> originFiles = new ArrayList<String>();

						// 전달된 요청(multipartRequest)에서 파일 리스트 정보를 얻어와
						// 저장된 파일명, 원래 파일명을 각 ArrayList에 추가함.

						Enumeration<String> files = multiRequest.getFileNames();

						while (files.hasMoreElements()) {

							// 업로드된 파일은 역순으로 전달된다.
							String name = files.nextElement();

							if (multiRequest.getFilesystemName(name) != null) {
								// getFilesystemName(key) : rename된 파일명 얻어오기
								saveFiles.add(multiRequest.getFilesystemName(name));

								originFiles.add(multiRequest.getOriginalFileName(name));
							}

						}

						ProfileResource file = new ProfileResource();

						// 파일정보는 역순으로 전달되므로, 반복문을 역으로 수행하여 원래 순서대로 저장
						for (int i = originFiles.size() - 1; i >= 0; i--) {
							file = new ProfileResource(); // 파일정보 저장
							file.setProfileResourcePath(savePath); // 경로
							file.setFileOriginName(originFiles.get(i));
							file.setFileChangeName(saveFiles.get(i));

						}

						int result = new MemberService().upPortfolio(memberNo, upContent, upTitle, savePath);

						if (result > 0) {
							path = "/WEB-INF/views/member/mypage-summernote.jsp";
							view = request.getRequestDispatcher(path);
							view.forward(request, response);
						} else {
						}

					}

				} catch (Exception e) {
					e.printStackTrace();
				}

			} else {
				// 로그아웃 하고 화면 전환
				response.sendRedirect(request.getContextPath());
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
