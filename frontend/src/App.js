import { useEffect } from 'react';
import './App.css';
import logo from './logo.svg';

function App() {
  useEffect(() => {
    printThem();
  }, []);

  function printThem() {
    console.log("we printed!!");
    fetch("http://localhost:8080/api/content")
    .then(result => result.json())
    .then(data => console.log(data));
  }

  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>
    </div>
  );
}

export default App;
