import logo from './logo.svg';
import './App.css';
import EmployeeContext from './EmployeeContext'
import Home from './Home';

const employee = {
  eid: 1,
  efnm: "Pritesh",
  elnm: "Patel",
  salary: 5000,

  display: () => {
    console.log("I am from Employee Context State Object")
  },

  updateFirstName(name) {
    console.log('First Name Updated')
    this.efnm = name
  }
}

//<UserContext.Provider value={{e1:employee, e2:employee}}>
function App() {
  return (
    <>
      <h1>ReactJS Context API Example</h1>
      <EmployeeContext.Provider value={employee}>
          <Home/>
      </EmployeeContext.Provider>
    </>
  );
}

export default App;
