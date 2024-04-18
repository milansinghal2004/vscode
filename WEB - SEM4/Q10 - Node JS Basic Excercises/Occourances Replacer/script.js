// Function to replace 2 or more occurrences of a letter with a single letter in a given string

function f1(a) {
    // Use a regular expression to replace 2 or more occurrences of a letter with a single letter
    let b = a.replace(/(.)\1+/g, '$1');
    return b;
}


let a = 'aabbc ddddaa';
let result = f1(a);
console.log(result);
