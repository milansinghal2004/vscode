const quizzes = [
    {
        title: "Sample Quiz",
        questions: [
            {
                text: "What is the capital of France?",
                options: ["Paris", "London", "Rome", "Berlin"],
                correctAnswer: "Paris"
            },
            {
                text: "What is 2 + 2?",
                options: ["3", "4", "5", "6"],
                correctAnswer: "4"
            },
            {
                text: "Which planet is known as the Red Planet?",
                options: ["Earth", "Mars", "Jupiter", "Saturn"],
                correctAnswer: "Mars"
            }
        ]
    }
];

let currentQuizIndex = 0;
let score = 0;
let currentUser = null;

const userContainer = document.getElementById('user-container');
const loginContainer = document.getElementById('login-container');
const usernameDisplay = document.getElementById('username-display');
const usernameInput = document.getElementById('username');
const loginButton = document.getElementById('login-button');
const logoutButton = document.getElementById('logout-button');
const quizContainer = document.getElementById('quiz-container');
const scoreContainer = document.getElementById('score-container');
const scoreElement = document.getElementById('score');
const retryButton = document.getElementById('retry');

loginButton.addEventListener('click', loginUser);
logoutButton.addEventListener('click', logoutUser);
retryButton.addEventListener('click', resetQuiz);
usernameInput.addEventListener('keyup', function(event) {
    if (event.key === 'Enter') {
        loginUser();
    }
});

function loginUser() {
    const username = usernameInput.value.trim();
    if (username) {
        currentUser = username;
        localStorage.setItem('currentUser', currentUser);
        usernameDisplay.textContent = currentUser;
        showUserInterface();
    }
}

function logoutUser() {
    currentUser = null;
    localStorage.removeItem('currentUser');
    showLoginInterface();
}

function showUserInterface() {
    loginContainer.classList.add('hidden');
    userContainer.classList.remove('hidden');
    quizContainer.classList.remove('hidden');
    loadQuiz();
}

function showLoginInterface() {
    loginContainer.classList.remove('hidden');
    userContainer.classList.add('hidden');
    quizContainer.classList.add('hidden');
    scoreContainer.classList.add('hidden');
}

function loadQuiz() {
    quizContainer.innerHTML = '';
    const quiz = quizzes[currentQuizIndex];
    quiz.questions.forEach((question, index) => {
        const questionElement = document.createElement('div');
        questionElement.className = 'question';

        const questionText = document.createElement('p');
        questionText.textContent = question.text;
        questionElement.appendChild(questionText);

        question.options.forEach(option => {
            const label = document.createElement('label');
            const input = document.createElement('input');
            input.type = 'radio';
            input.name = `question-${index}`;
            input.value = option;
            label.appendChild(input);
            label.appendChild(document.createTextNode(option));
            questionElement.appendChild(label);
        });

        quizContainer.appendChild(questionElement);
    });

    const submitButton = document.createElement('button');
    submitButton.textContent = 'Submit';
    submitButton.onclick = submitQuiz;
    quizContainer.appendChild(submitButton);
}

function submitQuiz() {
    let correctAnswers = 0;
    const quiz = quizzes[currentQuizIndex];
    quiz.questions.forEach((question, index) => {
        const selectedOption = document.querySelector(`input[name="question-${index}"]:checked`);
        if (selectedOption && selectedOption.value === question.correctAnswer) {
            correctAnswers++;
        }
    });

    score = correctAnswers;
    saveScore(currentUser, score);
    showScore();
}

function saveScore(username, score) {
    const scores = JSON.parse(localStorage.getItem('scores')) || {};
    scores[username] = score;
    localStorage.setItem('scores', JSON.stringify(scores));
}

function showScore() {
    quizContainer.classList.add('hidden');
    scoreContainer.classList.remove('hidden');
    scoreElement.textContent = `${score} / ${quizzes[currentQuizIndex].questions.length}`;
}

function resetQuiz() {
    quizContainer.classList.remove('hidden');
    scoreContainer.classList.add('hidden');
    score = 0;
    loadQuiz();
}

// Initialize the app
document.addEventListener('DOMContentLoaded', () => {
    currentUser = localStorage.getItem('currentUser');
    if (currentUser) {
        usernameDisplay.textContent = currentUser;
        showUserInterface();
    } else {
        showLoginInterface();
    }
});
