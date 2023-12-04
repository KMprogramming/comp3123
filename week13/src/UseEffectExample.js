import React, {useEffect, useState, useMemo, useCallback} from 'react'
import UseCallBackExample from './UseCallBackExample'

export default function UseEffectExample() {
  
    var [a, setA] = useState(100)
    var [b, setB] = useState(200)

    console.log("---- Rendered ----")

    //Every time calls when render
    const myUseEffectFunction = () => {
        console.log("useEffect() - 1")
    }
    useEffect(myUseEffectFunction)

    //calls  First time when render - componentDidMount
    useEffect(()=>{
        console.log("useEffect() - 2")
    }, [])

    //calls  First time when render AND again ONLY when a updates
    //componentDidUpdate
    useEffect(()=>{
        console.log("useEffect() - 3")
    }, [a])

     //calls  First time when render AND again ONLY when a/b updates
    //componentDidUpdate
    useEffect(()=>{
        console.log("useEffect() - 4")
    }, [a, b])

    //componentWillUnmount
    useEffect(() => {
        console.log("-- useEffect() - Start --")
    
    //The return function is the cleanup function, 
    //or when the user leaves the page 
    //and the component will unmount. 
    //componentWillUnmount
      return () => {
        console.log("-- useEffect() Cleanup -- End --")
      }
    }, [a])
    
    const complexFunction = () => {
        console.log("useMemo() - Complex task procesing fucntions : " + a)
    }

    useMemo(() => complexFunction(),[a])

    const handler = useCallback(() => {
        console.log("I am from callBack Hooks")
    }, [a])
    
    return (
        <>
            { console.log("Inside the Return") }
            <h2>UseEffect() Example</h2>
            A: {a}
            <button onClick={()=> setA(a = a + 1)}>Update A</button>
            <br/>
            B: {b}
            <button onClick={()=> setB(b = b + 1)}>Update B</button>
            <UseCallBackExample myCallback = {handler}/>
        </>
    )
}
