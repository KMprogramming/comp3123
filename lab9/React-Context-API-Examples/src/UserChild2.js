import React from 'react'
import EmployeeContext from './EmployeeContext'
import UserChild3 from './UserChild3'
import UserContext from './UserContext'

const user = {
    user_name: "Omar Nabi",
    college: "George Brown College, Toronto"
}

export default function UserChild2() {
  return (
    <>
        <h2>User Child - 2 Function (UserContext.Consumer)</h2>
        <EmployeeContext.Consumer>
            {(emp) => {
                    return(
                      <>
                        <p>Employee ID  : {emp.eid}</p>
                        <p>First Name   : {emp.efnm}</p>
                        <p>Last Name    : {emp.elnm}</p>
                        <p>Salary       : ${emp.salary}</p>
                        <button onClick={() => emp.updateFirstName('New First Name')}>Update First Name</button>
                        <UserContext.Provider value={user}>
                            <UserChild3/>
                        </UserContext.Provider>
                      </>
                    )
                }    
            }
        </EmployeeContext.Consumer>
    </>
  )
}
