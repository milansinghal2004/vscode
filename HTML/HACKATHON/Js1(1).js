/*const colorButton = document.getElementById('Mic');
let isClicked = false;

colorButton.addEventListener('click', () => {
  if (isClicked) {
    colorButton.classList.remove('clicked');
  } else {
    colorButton.classList.add('clicked');
  }
  isClicked = !isClicked;
});*/
const element = document.querySelector("Mic")
    let taskDone = false
   
    // function for show button
    const elementShow = () => {
      element.innerHTML = `
      document.getElementById('Mic'): ${!taskDone 
          ? "#4dd432" : "#fd67ad"};" onclick=doneTask()>
          ${!taskDone ? "Done" : "not done yet"}
        `
    }
    elementShow()

    // click Done button
    const doneTask = () => {
      taskDone = (taskDone ? false : true)
      elementShow()
    }
