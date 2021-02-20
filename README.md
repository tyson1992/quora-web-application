# quora
This is sample project to implement the features like popular QnA site - Quora. It uses all basic element of spring, hibernate to make API end point.
Below are feature list going to be part of this implementation. 

1. UserController<br>
        1.1 signup - "/user/signup"<br>
        1.2. signin - "/user/signin"<br>
        1.3. signout - "/user/signout"<br>
2. CommonController<br>
        2.1. userProfile - "/userprofile/{userId}"<br>
3. AdminController<br>
        3.1. userDelete - "/admin/user/{userId}"<br>
4. QuestionController<br>
        4.1. createQuestion - "/question/create"<br>
        4.2. getAllQuestions - "/question/all"<br>
        4.3. editQuestionContent - "/question/edit/{questionId}"<br>
        4.4. deleteQuestion - "/question/delete/{questionId}"<br>
        4.5. getAllQuestionsByUser - "question/all/{userId}"<br>
5. AnswerController<br>
        5.1. createAnswer - "/question/{questionId}/answer/create"<br>
        5.2. editAnswerContent - "/answer/edit/{answerId}"<br>
        5.3. deleteAnswer - "/answer/delete/{answerId}"<br>
        5.4. getAllAnswersToQuestion - "answer/all/{questionId}"<br>
Swagger will be used to test API endpoints and functions. <br>
