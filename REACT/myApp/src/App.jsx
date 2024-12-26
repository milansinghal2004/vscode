// import About from "./components/About"
import Navbar from "./components/Navbar"
import TextForm from "./components/TextForm"
import React, { useState } from 'react';

function App() {
  const[mode, setmode] = useState('light'); // Whether dark mode is enabled or not

  const toggleMode = () => {
    if(mode ==='light') {
      setmode('dark');
      document.body.style.backgroundColor = '#000919';
    }
    else {
      setmode('light');
      document.body.style.backgroundColor = 'white';
    }
  }

  return (
    <>
      <Navbar title="myApp" aboutText="About" mode={mode} toggleMode={toggleMode}/>
      <div className="container my-3"> 
        <TextForm heading = "Enter the text to analyse" mode={mode}/>
        {/* <About /> */}
      </div>
    </>
  )
}

export default App
