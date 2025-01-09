import React, {useState} from 'react'

export default function TextForm(props) {
    const [text, setText] = useState("Enter text here");

    const handleUpClick = () => {
        console.log("Uppercase was Clicked" + text);
        let newText = text.toUpperCase();
        setText(newText);
        props.showAlert("Converted to Upper Case!", "success");
    }

    const handleDownClick = () => {
        console.log("Downcase was Clicked" + text);
        let newText = text.toLowerCase();
        setText(newText);
        props.showAlert("Converted to Lower Case!", "success");
    }

    const handleClrClick = () => {
        console.log("Clear was Clicked" + text);
        let newText = "";
        setText(newText);
        props.showAlert("Message Box Cleared!", "success");
    }

    const handleDuplicateClick = () => {
        console.log("Duplicate was Clicked" + text);
        let newText = text + text;
        setText(newText);
        props.showAlert("Text Duplicated!", "success");
    }

    const handleOnChange = (event) => {
        console.log("On Change");
        setText(event.target.value);
    }

    return (
        <>
            <div>
                <div className="container" style={{color: props.mode === 'dark' ? 'white' : '#000919'}}>
                    <h1>{props.heading}</h1>
                    <textarea className="form-control" style={{backgroundColor: props.mode === 'dark' ? '#000919' : 'white', color: props.mode === 'dark' ? 'white' : '#042743'}} value={text} onChange={handleOnChange} id="myBox" rows="8"></textarea>
                </div>

                <button className="btn btn-primary mx-2 my-3" style={{backgroundColor: props.mode ==='dark' ? '#212529' : 'white', color: props.mode === 'dark' ? 'white' : '#042743'}} onClick={handleUpClick}>Convert to Upper Case</button>
                <button className="btn btn-primary mx-2 my-3" style={{backgroundColor: props.mode ==='dark' ? '#212529' : 'white', color: props.mode === 'dark' ? 'white' : '#042743'}} onClick={handleDownClick}>Convert to Lower Case</button>
                <button className="btn btn-primary mx-2 my-3" style={{backgroundColor: props.mode ==='dark' ? '#212529' : 'white', color: props.mode === 'dark' ? 'white' : '#042743'}} onClick={handleClrClick}>Clear Text</button>
                <button className="btn btn-primary mx-2 my-3" style={{backgroundColor: props.mode ==='dark' ? '#212529' : 'white', color: props.mode === 'dark' ? 'white' : '#042743'}} onClick={handleDuplicateClick}>Duplicate text</button>
            </div>

            <div className="container my-3" style={{color: props.mode === 'dark' ? 'white' : '#000919'}}>
                <h1>Your text summary</h1>
                <p>{text.split(" ").length} words and {text.length} characters</p>
                <p>{0.008 * text.split(" ").length} minutes read</p>
                <h2>Preview</h2>
                <p>{text .length>0 ? text : "Enter something in the textbox above to preview it here"}</p>
            </div>

        </>
  )
}
