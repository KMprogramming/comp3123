import React, { Component, memo } from 'react'

class UseCallBackExample extends Component {
  render() {
    return (
        <>
            {console.log("I am child component")}
            <h2>UseCallBack() Example</h2>
            <button onClick={this.props.myCallback}>Make a Callback: {this.props.y}</button>
        </>
    )
  }
}

export default memo(UseCallBackExample);
