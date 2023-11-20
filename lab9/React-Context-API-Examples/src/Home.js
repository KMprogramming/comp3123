import React, { Component } from 'react'
import UserChild1 from './UserChild1'
import UserChild2 from './UserChild2'
import EmployeeContext from './EmployeeContext'

export default class Home extends Component {
  static contextType = EmployeeContext

  componentDidMount = () =>{
    const user = this.context
    console.log(user)
    user.display() 
  }

  render() {
    return (
      <>
        <h2>Home (contextType)</h2>
        <p>Employee ID  : {this.context.eid}</p>
        <p>First Name   : {this.context.efnm}</p>
        <p>Last Name    : {this.context.elnm}</p>
        <p>Salary       : ${this.context.salary}</p>
        <UserChild1/>
        <UserChild2/>
      </>
      
    )
  }
}
