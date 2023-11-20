import React, { Component } from 'react'
import EmployeeContext from './EmployeeContext'

export default class UserChild1 extends Component {
  render() {
    return (
        <>
            <h2>User Child - 1 (UserContext.Consumer)</h2>
            <EmployeeContext.Consumer>
            {(emp) => {
                    return(
                      <>
                        <p>Employee ID  : {emp.eid}</p>
                        <p>First Name   : {emp.efnm}</p>
                        <p>Last Name    : {emp.elnm}</p>
                        <p>Salary       : ${emp.salary}</p>
                      </>
                    )
                }    
            }
            </EmployeeContext.Consumer>
        </>
    )
  }
}
