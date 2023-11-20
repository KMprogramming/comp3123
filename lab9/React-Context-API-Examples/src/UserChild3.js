import React, { useContext } from 'react'
import EmployeeContext from './EmployeeContext'
import UserContext from './UserContext'

export default function UserChild3() {
  
  const emp = useContext(EmployeeContext)
  const user = useContext(UserContext)

  return (
    <>
        <h2>User Child - 3 Function (useContext Hook)</h2>
        <p>Employee ID  : {emp.eid}</p>
        <p>First Name   : {emp.efnm}</p>
        <p>Last Name    : {emp.elnm}</p>
        <p>Salary       : ${emp.salary}</p>
        <button onClick={() => emp.display()}>Call Display</button>
        <h3>User Context</h3>
        <p>User Name      : {user.user_name}</p>
        <p>Collge Name    : {user.college}</p>
    </>
  )
}
